package com.ccshxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JdbcUtil {
	/**定义需要的变量*/
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	//连接数据库的URL串
	private String url = "jdbc:mysql://localhost:3306/cy44_system";
	private String user = "root";
	private String password = "root";
	
	
	/**1.加载驱动、写在静态代码块中，只加载一次*/
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("***   MySQL驱动注册成功！  ***");
		} catch (ClassNotFoundException e) {
			System.out.println("***   MySQL驱动注册失败！  ***" +e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**2.获得数据库连接*/
	public Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**3.更新操作*/
	public boolean executeSQL(String sql){
		//System.out.println("执行SQL为："+sql );
		try {
			conn = getConn();
			stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				return true;
			}else{
				System.out.println("\n更新SQL执行结果为0！");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally{
			release();
		}
	}
	
	/**4.查询操作 */
	public ArrayList<Map<String, String>> query(String sql) {
		System.out.println("执行SQL ： "+sql);
		ArrayList<Map<String, String>> rsList = null;
		try {
			rsList = new ArrayList<Map<String, String>>();
		    stmt = getConn().createStatement();
			rs = stmt.executeQuery(sql);
			//获取查询结果的字段信息 
			//字段名  字段类型   字段个数
			//SELECT u_name,u_pwd,u_sex FROM users
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				Map<String, String> rsMap = new HashMap<String, String>();
				//rsmd.getColumnCount()  获取字段个数
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					//rsmd.getColumnLabel(i); 获取字段名 i表示当前字段在sql中的位置,位置是从1开始计数
					String columnName = rsmd.getColumnLabel(i);
					String columnValue = rs.getString(columnName);
					rsMap.put(columnName, columnValue);
				}
				rsList.add(rsMap);	//将存储好信息的map存储到list中
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release();
		}
		return rsList;
	}
	public int execCount(String sql){
		System.out.println("执行SQL ： "+sql);
		int totalRecords = 0;
	    try {
			stmt = getConn().createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			totalRecords = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRecords;
	}

	
	/**批处理操作*/
	public int[] batch(String[] sqls){
		try {
			conn = getConn();
			conn.setAutoCommit(false);//设置自动提交为false
			stmt = conn.createStatement();
			for(String sql : sqls){
				System.out.println("批量提交的SQL："+sql);
				stmt.addBatch(sql);
			}
			return stmt.executeBatch();//执行批处理操作
		} catch (SQLException e) {
			try {
				System.out.println("批处理异常，事物回滚！");
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
		} finally{
			try {
				conn.commit();//手动提交
			} catch (SQLException e) {
				e.printStackTrace();
			}
			release();
		}
	}
	
	/**5.释放资源*/
	public void release(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

    }

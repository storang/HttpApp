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
import java.util.List;
import java.util.Map;



public class DBUtil {
	private static final String URL		="jdbc:mysql://localhost:3306/cy44_system";	//mysql数据库连接
	private static final String USER	="root";								//数据库用户名
	private static final String PASSWORD="root";								//数据库密码
	private static Connection   conn	=null;
	private static Statement    stmt	=null;
	private static ResultSet    rs		=null;
	private static PreparedStatement pstm=null;
	
	private static DBUtil db = null;
	
	private DBUtil(){
	}
	
	public static DBUtil getDB(){
		if(db==null){
			db = new DBUtil();
		}
		return db;
	}
	
	/**
	 * @return 数据库连接
	 */
	private static Connection getConn(){
		System.out.println("-------------------------------");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败，可能是没有引入数据库驱动包！");
			e.printStackTrace();
		}					
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("【open 1】打开数据库连接成功！");
		} catch (SQLException e) {
			System.out.println("打开连接失败，可能是数据库服务没有开启，或者用户名密码不正确！");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * @param sql 一条sql语句
	 * @return 执行添加、删除、修改之后影响的行数
	 */
	public int executeUpdate(String sql){
		int rows=0;
		try{
			stmt=getConn().createStatement();	//生成语句对象
			System.out.println("【open 2】生成语句对象");
			rows=stmt.executeUpdate(sql);
		}catch (Exception e){
			
			e.printStackTrace();
		}finally{
			close();
		}
		return rows;
	}
	
	/**
	 * @param sql
	 * @return 结果集对象
	 */
	public ResultSet executeQuery(String sql){
		try{
			stmt=getConn().createStatement();	//生成语句对象
			System.out.println("【open 2】生成语句对象");
			rs=stmt.executeQuery(sql);
			System.out.println("【open 3】生成结果集对象");
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * @param sql
	 * @return 返回查询结果封装对象list
	 */
	public List<Map<String,Object>> list(String sql){
		ResultSetMetaData rsmd=null;
		List<Map<String,Object>> alist=new ArrayList<Map<String,Object>>();
		try {
			pstm=getConn().prepareStatement(sql);		//生成预编译语句对象
			rsmd=pstm.getMetaData();				//获取MetaData对象，内含字段个数，类型，名称
			int count=rsmd.getColumnCount();		//获取查询结果字段个数
			rs=pstm.executeQuery(sql);				//获取结果集对象
			System.out.println("【open 3】生成结果集对象");
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=count;i++){
					String k=rsmd.getColumnLabel(i);
					String v=rs.getString(i);
					map.put(k, v);
				}
				alist.add(map);
			}
			return alist;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ssssss");
			return null;
		}finally{
			close();
		}
	}
	
	
	
	/**
	 * 关闭结果集对象、语句对象、连接对象
	 */
	private void close(){
		try{
			if(rs!=null){
				System.out.println("【close 3】关闭结果集对象");
				rs.close();
			}
			if(stmt!=null){
				System.out.println("【close 2】关闭语句对象");
				stmt.close();
			}
			if(conn!=null){
				System.out.println("【close 1】关闭数据连接");
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("-------------------------------");
	}
	
}

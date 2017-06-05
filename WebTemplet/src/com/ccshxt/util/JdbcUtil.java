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
	/**������Ҫ�ı���*/
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	//�������ݿ��URL��
	private String url = "jdbc:mysql://localhost:3306/cy44_system";
	private String user = "root";
	private String password = "root";
	
	
	/**1.����������д�ھ�̬������У�ֻ����һ��*/
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("***   MySQL����ע��ɹ���  ***");
		} catch (ClassNotFoundException e) {
			System.out.println("***   MySQL����ע��ʧ�ܣ�  ***" +e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**2.������ݿ�����*/
	public Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**3.���²���*/
	public boolean executeSQL(String sql){
		//System.out.println("ִ��SQLΪ��"+sql );
		try {
			conn = getConn();
			stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				return true;
			}else{
				System.out.println("\n����SQLִ�н��Ϊ0��");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally{
			release();
		}
	}
	
	/**4.��ѯ���� */
	public ArrayList<Map<String, String>> query(String sql) {
		System.out.println("ִ��SQL �� "+sql);
		ArrayList<Map<String, String>> rsList = null;
		try {
			rsList = new ArrayList<Map<String, String>>();
		    stmt = getConn().createStatement();
			rs = stmt.executeQuery(sql);
			//��ȡ��ѯ������ֶ���Ϣ 
			//�ֶ���  �ֶ�����   �ֶθ���
			//SELECT u_name,u_pwd,u_sex FROM users
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				Map<String, String> rsMap = new HashMap<String, String>();
				//rsmd.getColumnCount()  ��ȡ�ֶθ���
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					//rsmd.getColumnLabel(i); ��ȡ�ֶ��� i��ʾ��ǰ�ֶ���sql�е�λ��,λ���Ǵ�1��ʼ����
					String columnName = rsmd.getColumnLabel(i);
					String columnValue = rs.getString(columnName);
					rsMap.put(columnName, columnValue);
				}
				rsList.add(rsMap);	//���洢����Ϣ��map�洢��list��
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release();
		}
		return rsList;
	}
	public int execCount(String sql){
		System.out.println("ִ��SQL �� "+sql);
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

	
	/**���������*/
	public int[] batch(String[] sqls){
		try {
			conn = getConn();
			conn.setAutoCommit(false);//�����Զ��ύΪfalse
			stmt = conn.createStatement();
			for(String sql : sqls){
				System.out.println("�����ύ��SQL��"+sql);
				stmt.addBatch(sql);
			}
			return stmt.executeBatch();//ִ�����������
		} catch (SQLException e) {
			try {
				System.out.println("�������쳣������ع���");
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
		} finally{
			try {
				conn.commit();//�ֶ��ύ
			} catch (SQLException e) {
				e.printStackTrace();
			}
			release();
		}
	}
	
	/**5.�ͷ���Դ*/
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

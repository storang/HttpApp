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
	private static final String URL		="jdbc:mysql://localhost:3306/cy44_system";	//mysql���ݿ�����
	private static final String USER	="root";								//���ݿ��û���
	private static final String PASSWORD="root";								//���ݿ�����
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
	 * @return ���ݿ�����
	 */
	private static Connection getConn(){
		System.out.println("-------------------------------");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���������ɹ���");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("��������ʧ�ܣ�������û���������ݿ���������");
			e.printStackTrace();
		}					
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("��open 1�������ݿ����ӳɹ���");
		} catch (SQLException e) {
			System.out.println("������ʧ�ܣ����������ݿ����û�п����������û������벻��ȷ��");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * @param sql һ��sql���
	 * @return ִ����ӡ�ɾ�����޸�֮��Ӱ�������
	 */
	public int executeUpdate(String sql){
		int rows=0;
		try{
			stmt=getConn().createStatement();	//����������
			System.out.println("��open 2������������");
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
	 * @return ���������
	 */
	public ResultSet executeQuery(String sql){
		try{
			stmt=getConn().createStatement();	//����������
			System.out.println("��open 2������������");
			rs=stmt.executeQuery(sql);
			System.out.println("��open 3�����ɽ��������");
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * @param sql
	 * @return ���ز�ѯ�����װ����list
	 */
	public List<Map<String,Object>> list(String sql){
		ResultSetMetaData rsmd=null;
		List<Map<String,Object>> alist=new ArrayList<Map<String,Object>>();
		try {
			pstm=getConn().prepareStatement(sql);		//����Ԥ����������
			rsmd=pstm.getMetaData();				//��ȡMetaData�����ں��ֶθ��������ͣ�����
			int count=rsmd.getColumnCount();		//��ȡ��ѯ����ֶθ���
			rs=pstm.executeQuery(sql);				//��ȡ���������
			System.out.println("��open 3�����ɽ��������");
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
	 * �رս�����������������Ӷ���
	 */
	private void close(){
		try{
			if(rs!=null){
				System.out.println("��close 3���رս��������");
				rs.close();
			}
			if(stmt!=null){
				System.out.println("��close 2���ر�������");
				stmt.close();
			}
			if(conn!=null){
				System.out.println("��close 1���ر���������");
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("-------------------------------");
	}
	
}

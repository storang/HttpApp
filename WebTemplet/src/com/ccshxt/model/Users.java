package com.ccshxt.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccshxt.util.DBUtil;
import com.ccshxt.util.JdbcUtil;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

public class Users {
	private String uname;
	private String upwd;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUcname() {
		return ucname;
	}
	public void setUcname(String ucname) {
		this.ucname = ucname;
	}
	private String ucname;
	Gson gson = new Gson();
	JdbcUtil jdbc = new JdbcUtil();
	DBUtil db = DBUtil.getDB();
	/**
	 * 功能：查询工单数据
	 * 参数：String：pageNum,String:pageSize
	 * 返回值：查询到的工单数据String类型
	 * */
	public String getUserByPageNum(String pageNum,String pageSize,String acceptdate){
		int pNum = Integer.parseInt(pageNum);
		int pSize = Integer.parseInt(pageSize);
		int index = (pNum-1)*pSize;
		String sql = "SELECT wsid,serial_no,accept_date,di.dict_lable customer_ownerCity,customer_phonenum,dic.dict_lable customer_grade,dict.dict_lable customer_band,customer_content,d.dict_lable is_reapt,customerservice_advise,customerservice_solveflag,customerservice_iobno,customerservice_archiye_data,dicts.dict_lable overtime_flag,last_modify,audit_is_largearea FROM worksheets wo,dicts di,dicts dic,dicts dict,dicts d,dicts dicts WHERE dic.dict_type = 'grade' AND dic.dict_value=wo.customer_grade AND di.dict_type = 'city' AND di.dict_value=wo.customer_city AND dict.dict_type = 'band' AND dict.dict_value=wo.customer_band AND d.dict_type='reapt' AND d.dict_value=wo.is_reapt AND dicts.dict_type='overtime' AND dicts.dict_value=wo.overtime_flag AND customerService_solveflag='未解决' AND accept_date LIKE '%"+acceptdate+"%' limit "+index+","+pSize;
		String countSql = "SELECT COUNT(*) FROM worksheets WHERE  accept_date LIKE '%"+acceptdate+"%' AND customerservice_solveflag = '未解决'";
		page pageObj = new page();
		pageObj.setList(jdbc.query(sql));
		pageObj.setCount(jdbc.execCount(countSql));
		return gson.toJson(pageObj);
		
	}
	/**
	 * 功能：登录
	 * 参数：String：username,String:password
	 * 返回值：boolean
	 * */
	public static boolean login(String username,String password){
		DBUtil db = DBUtil.getDB();
		boolean b = false;
		String sql = "select * from user where uname='"+username+"' and upwd='"+password+"'" ;
		ResultSet rs = db.executeQuery(sql);
		try {
			while(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 功能：查询用户详细数据
	 * 参数：无
	 * 返回值：List集合
	 * */
	public List<Map<String,String>> getAllUser(String username,String password){
		JdbcUtil jdbc = new JdbcUtil();
		List<Map<String,String>> list = jdbc.query("select * from user where uname='"+username+"' and upwd='"+password+"'");
		return list;
	}
	public Map<String,String> getUserById(String uid){
		String sql = "select * from user where u_id = " + uid;
		JdbcUtil jdbc = new JdbcUtil();
		List<Map<String,String>> list = jdbc.query(sql);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return new HashMap<String,String>();
		}
	}
	/**
	 * 功能：修改用户密码
	 * 参数：String ： upwd,id
	 * 返回值 ：boolean类型
	 * */
	public boolean updateUser(String upwd,String id){
		String sql = "update user set upwd='"+upwd+"' where uid="+id;
		return db.executeUpdate(sql)>0?true:false;
	}
}

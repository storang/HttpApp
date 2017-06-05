package com.ccshxt.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccshxt.util.DBUtil;
import com.ccshxt.util.JdbcUtil;

public class workSheets {
	DBUtil db = DBUtil.getDB();
	JdbcUtil jdbc = new JdbcUtil();
	/**
	 * 功能：获取工单数据
	 * 参数：无
	 * 返回值：List集合
	 * */
	public List<Map<String,String>> getAllworkSheets(){
		JdbcUtil jdbc = new JdbcUtil();
		List<Map<String,String>> list = jdbc.query("select * from worksheets");
		return list;
	}
	/**
	 * 功能：添加工单
	 * 参数：String类型的工单数据
	 * 返回值：boolean
	 * */
	public boolean addWorksheets(String serialNo,String acceptDate,String customerCity,String customerPhone,String customerGrade,String customerBand,String customerContent,String isReapt,String serviseAdvise,String serviceFlag,String customerIobno,String lastTime,String largearea){
		String sql = "INSERT INTO worksheets(serial_no,accept_date,customer_city,customer_phonenum,customer_grade,customer_band,customer_content,is_reapt,customerservice_advise,customerservice_solveflag,customerservice_iobno,overtime_flag,last_modify,audit_is_largearea) VALUES('"+serialNo+"','"+acceptDate+"','"+customerCity+"','"+customerPhone+"','"+customerGrade+"','"+customerBand+"','"+customerContent+"','"+isReapt+"','"+serviseAdvise+"','"+serviceFlag+"','"+customerIobno+"','4','"+lastTime+"','"+largearea+"')";
		return db.executeUpdate(sql)>0?true:false;
		 
	}
	/**
	 * 功能：修改工单数据
	 * 参数：String类型的工单数据
	 * 返回值：boolean
	 * */
	public boolean updateWorksheets(String wsid,String serialNo,String acceptDate,String customerCity,String customerPhone,String customerGrade,String customerBand,String customerContent,String isReapt,String serviseAdvise,String serviceFlag,String customerIobno,String archiyeDate,String overTime,String lastTime,String largearea){
		String sql = "update worksheets set wsid='"+wsid+"',serial_no='"+serialNo+"',accept_date='"+acceptDate+"',customer_city='"+customerCity+"',customer_phonenum='"+customerPhone+"',customer_grade='"+customerGrade+"',customer_band='"+customerBand+"',customer_content=CONCAT(customer_content,'"+customerContent+"'),is_reapt='"+isReapt+"',customerservice_advise=CONCAT(customerservice_advise,'"+serviseAdvise+"'),customerservice_solveflag='"+serviceFlag+"',customerservice_iobno='"+customerIobno+"',customerservice_archiye_data='"+archiyeDate+"',overtime_flag='"+overTime+"',last_modify='"+lastTime+"',audit_is_largearea='"+largearea+"' where wsid="+wsid;
		return db.executeUpdate(sql)>0?true:false;
	}
	/**
	 * 功能：点击工单号查询工单数据
	 * 参数：String：wsid
	 * 返回值：List集合
	 * */
	public List<Map<String, String>> getworkSheetsById(String wsid){
		String sql = "SELECT wsid,d.dict_value as reaptValue,di.dict_value as cityValue,dic.dict_value as gradeValue,dict.dict_value as bandValue,dicts.dict_value as overTimevalue,serial_no,accept_date,di.dict_lable customer_city,customer_phonenum,dic.dict_lable customer_grade,dict.dict_lable customer_band,customer_content,d.dict_lable is_reapt,customerservice_advise,customerservice_solveflag,customerservice_iobno,customerservice_archiye_data,dicts.dict_lable overtime_flag,last_modify,audit_is_largearea FROM worksheets wo,dicts di,dicts dic,dicts dict,dicts d,dicts dicts WHERE dic.dict_type = 'grade' AND dic.dict_value=wo.customer_grade AND di.dict_type = 'city' AND di.dict_value=wo.customer_city AND dict.dict_type = 'band' AND dict.dict_value=wo.customer_band AND d.dict_type='reapt' AND d.dict_value=wo.is_reapt AND dicts.dict_type='overtime' AND dicts.dict_value=wo.overtime_flag AND wsid="+wsid;
		List<Map<String,String>> list = jdbc.query(sql);
		return list;
	}
	/**
	 * 功能：修改超时工单
	 * 参数：String：wsid,String:archiyeTime
	 * 返回值：boolean
	 * */
	public boolean fileWorksheets(String wsid,String archiyeTime){
		String sql = "update worksheets set customerservice_solveflag='已解决',customerservice_archiye_data='"+archiyeTime+"' where wsid="+wsid;
		return db.executeUpdate(sql)>0?true:false;
	}
}

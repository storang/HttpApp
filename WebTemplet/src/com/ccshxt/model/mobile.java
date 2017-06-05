package com.ccshxt.model;

import com.ccshxt.util.DBUtil;
import com.ccshxt.util.JdbcUtil;
import com.google.gson.Gson;

public class mobile {
	private String mirid;
	private String mm_code;
	private String country;
	private String operation;
	private String gsm_roaming;
	private String data_roaming;
	private String open_date;
	private String modify_date;
	public String getMirid() {
		return mirid;
	}
	public void setMirid(String mirid) {
		this.mirid = mirid;
	}
	public String getMm_code() {
		return mm_code;
	}
	public void setMm_code(String mm_code) {
		this.mm_code = mm_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getGsm_roaming() {
		return gsm_roaming;
	}
	public void setGsm_roaming(String gsm_roaming) {
		this.gsm_roaming = gsm_roaming;
	}
	public String getData_roaming() {
		return data_roaming;
	}
	public void setData_roaming(String data_roaming) {
		this.data_roaming = data_roaming;
	}
	public String getOpen_date() {
		return open_date;
	}
	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	DBUtil db = DBUtil.getDB();
	JdbcUtil jdbc = new JdbcUtil();
	Gson gson = new Gson();
	/**
	 * ���ܣ�ʵ�ֹ����Զ���ȫ
	 * ������String country
	 * ����ֵ:json
	 * */
	public String getCountry(String country){
		String sql = "select country from mobile_inter_roaming where country like '%"+country+"%'";
		return gson.toJson(jdbc.query(sql));
	}
	/**
	 * ���ܣ���ѯ��ǰ�����Ƿ�ͨ����
	 * ������String��phone��country
	 * ����ֵ��json
	 * */
	public String getState(String phone,String country){
		String sql = "SELECT data_roaming FROM mobile_inter_roaming m,mm mm WHERE mm.pre_pnum='"+phone+"' AND mm.mm_code=m.mm_code AND country='"+country+"'"; 
		page pageObj = new page();
		pageObj.setList(jdbc.query(sql));
		return gson.toJson(pageObj);
	}
	/**
	 * ���ܣ���ѯ��ǰ���ҿɿ�ͨ���е�������
	 * ������String:country
	 * ����ֵ��json
	 * */
	public String getDialing(String country){
		String sql = "SELECT operation FROM mobile_inter_roaming WHERE country='"+country+"'";
		page pageObj = new page();
		pageObj.setList(jdbc.query(sql));
		return gson.toJson(pageObj);
	}
	/**
	 * ���ܣ���ѯ��������
	 * ������String��pageNum,pageSize
	 * ����ֵ��json
	 * */
	public String getMobileByPageNum(String pageNum,String pageSize){
		int pNum = Integer.parseInt(pageNum);
		int pSize = Integer.parseInt(pageSize);
		int index = (pNum-1)*pSize;
		String sql = "SELECT mirid,mm_code,operation,country,di.dict_lable gsm_roaming,dic.dict_lable data_roaming,open_date FROM mobile_inter_roaming m,dicts di,dicts dic WHERE dic.dict_type = 'reapt' AND dic.dict_value=m.gsm_roaming AND di.dict_type = 'reapt' AND di.dict_value=m.data_roaming   limit "+index+","+pSize;
		String countSql = "SELECT COUNT(*) FROM mobile_inter_roaming";
		page pageObj = new page();
		pageObj.setList(jdbc.query(sql));
		pageObj.setCount(jdbc.execCount(countSql));
		return gson.toJson(pageObj);
		
	}
	/**
	 * ���ܣ�ͨ��ʱ���ѯ��������
	 * ������String �� pageNum,pageSize,opendate
	 * ����ֵ��json
	 * */
	public String selectMobileByPageNum(String pageNum,String pageSize,String opendate){
		int pNum = Integer.parseInt(pageNum);
		int pSize = Integer.parseInt(pageSize);
		int index = (pNum-1)*pSize;
		String sql = "SELECT mirid,mm_code,operation,country,di.dict_lable gsm_roaming,dic.dict_lable data_roaming,open_date FROM mobile_inter_roaming m,dicts di,dicts dic WHERE dic.dict_type = 'reapt' AND dic.dict_value=m.gsm_roaming AND di.dict_type = 'reapt' AND di.dict_value=m.data_roaming AND open_date like '%"+opendate+"%'  limit "+index+","+pSize;
		String countSql = "SELECT COUNT(*) FROM mobile_inter_roaming";
		page pageObj = new page();
		pageObj.setList(jdbc.query(sql));
		pageObj.setCount(jdbc.execCount(countSql));
		return gson.toJson(pageObj);
		
	}
	/**
	 * ���ܣ���ӹ�������
	 * ������String���͵�����
	 * ����ֵ��boolean����
	 * */
	public boolean addMobile(String country,String data,String operation,String mmCode,String gsm,String opendate,String nowTime){
		String sql = "INSERT INTO mobile_inter_roaming(mm_code,country,gsm_roaming,data_roaming,operation,open_date,modify_time) VALUES('"+mmCode+"','"+country+"','"+gsm+"','"+data+"','"+operation+"','"+opendate+"','"+nowTime+"')";
		return db.executeUpdate(sql)>0?true:false;
	}
	/**
	 * ���ܣ��޸Ĺ�������
	 * ������String���͵�Ҫ�޸ĵ�����
	 * ����ֵ��boolean����
	 * */
	public boolean fileMobile(String id,String nowTime,String gsm,String data){
		String sql = "update mobile_inter_roaming set gsm_roaming='"+gsm+"',data_roaming='"+data+"',modify_time='"+nowTime+"' where mirid="+id;
		return db.executeUpdate(sql)>0?true:false;
	}
	/**
	 * ���ܣ�ɾ����������
	 * ������String ��id
	 * ����ֵ��boolean
	 * */
	public boolean deleteMobile(String id){
		String sql = "delete from mobile_inter_roaming where mirid="+id;
		return db.executeUpdate(sql)>0?true:false;
	}
	/**
	 * ���ܣ�ɾ����������
	 * ������String:id
	 * ����ֵ��boolean
	 * */
	public boolean deleteALL(String mirid){
		String sql = "delete from mobile_inter_roaming where mirid="+mirid;
		return db.executeUpdate(sql)>0?true:false;
	}
}


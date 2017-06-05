package com.ccshxt.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ccshxt.util.DBUtil;
import com.ccshxt.util.JdbcUtil;
import com.google.gson.Gson;

public class usernum {
	private String uid;
	private String city_id;
	private String account_user;
	private String gprs_user;
	private String wlan_user;
	private String data_year;
	private String data_month;
	private String insert_time;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public String getAccount_user() {
		return account_user;
	}
	public void setAccount_user(String account_user) {
		this.account_user = account_user;
	}
	public String getGprs_user() {
		return gprs_user;
	}
	public void setGprs_user(String gprs_user) {
		this.gprs_user = gprs_user;
	}
	public String getWlan_user() {
		return wlan_user;
	}
	public void setWlan_user(String wlan_user) {
		this.wlan_user = wlan_user;
	}
	public String getData_year() {
		return data_year;
	}
	public void setData_year(String data_year) {
		this.data_year = data_year;
	}
	public String getData_month() {
		return data_month;
	}
	public void setData_month(String data_month) {
		this.data_month = data_month;
	}
	public String getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(String insert_time) {
		this.insert_time = insert_time;
	}
	DBUtil db = DBUtil.getDB();
	JdbcUtil jdbc = new JdbcUtil();
	Gson gson = new Gson();
	 public usernum(){
		
	    }
	 /**
	  * 功能：访问所要读取文件的路径
	  * 参数：无
	  * 返回值：无
	  * */
	public void insert() throws IOException {
		SimpleDateFormat sim = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat m = new SimpleDateFormat("MM");
		Date date = new Date();
		String archiyeTime = sim.format(date);
		String judTime = m.format(date);
		int arTime = Integer.parseInt(judTime);
		int month;
		if(arTime==1){
			month=Integer.parseInt(archiyeTime)-89;
		}else{
			month = Integer.parseInt(archiyeTime)-1;	
		}
		String content=new usernum().str_content("E:/fileInf/data/user_count_sum_"+month+".data");
        new usernum().writeFile(content);
}
		/**
		 * 功能：将读取的数据存入数据库中
		 * 参数：String：content
		 * 返回值：boolean类型
		 * */
	public boolean writeFile(String content){
		boolean b = false;
		SimpleDateFormat insert_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat yy = new SimpleDateFormat("yyyy");
		SimpleDateFormat m = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("ddhh");
		Date date = new Date();
		String iTime = insert_time.format(date);//插入时间
		String year = yy.format(date); //插入年份
		String data_month = m.format(date); //插入月份
		String time = day.format(date);	//判断是否满足插入的时间
		String sql="";
		int dayTime = Integer.parseInt(time);
		System.out.println("这是dayTime="+dayTime);
		String[] s = content.split("X");
			if(dayTime==106){
				for(int i = 0;i<s.length/4;i++){
					sql="INSERT INTO usernum(city_id,account_user,gprs_user,wlan_user,data_year,data_month,insert_time) VALUES('"+s[i*4]+"','"+s[i*4+1]+"','"+s[i*4+2]+"','"+s[i*4+3]+"','"+year+"','"+data_month+"','"+iTime+"')";
					db.executeUpdate(sql);
					b=true;
				}
			}else{
				System.out.println("当前日期不能取值");
		}
		return b;
}	
	/**
	 * 功能：读取文件中的数据
	 * 参数:String类型的 file
	 * 返回值：String类型数据
	 * */
	public String str_content(String file){
		String content = ""; 
		 try{   
             BufferedReader bufRead=new BufferedReader(new InputStreamReader(new FileInputStream(file)));   
             String  str;   
             while((str=bufRead.readLine())!=null){   
                   content+=str;   
             }
         }catch(IOException ioe){
              ioe.printStackTrace();
         }
        return  content;
    }
     
	/**
	 *功能： 实现对用户统计数表的分页查询
	 * 参数：String类型
	 * 返回值：gson集合
	 * */
public String getusernumByPageNum(String pageNum,String pageSize,String year,String month){
	int pNum = Integer.parseInt(pageNum);
	int pSize = Integer.parseInt(pageSize);
	int index = (pNum-1)*pSize;
	StringBuffer sb = new StringBuffer("SELECT unid,dict_lable AS city_id ,account_user,gprs_user,wlan_user,data_year,data_month,insert_time FROM usernum LEFT JOIN dicts ON dict_value =city_id WHERE 1=1");
	if(year!=null&&!year.equals("")){
		sb.append(" and data_year='"+year+"'");
	}
	if(month!=null&&!month.equals("")){
		sb.append(" and data_month='"+month+"'");
	}
	sb.append(" limit "+index+","+pSize);
	String sql=sb.toString();
	//String sql = "SELECT unid,dict_lable AS city_id ,account_user,gprs_user,wlan_user,data_year,data_month,insert_time FROM usernum LEFT JOIN dicts ON dict_value =city_id WHERE data_year LIKE '%"+year+"%' AND data_month  LIKE '%"+month+"%' AND 1=1  limit "+index+","+pSize;
	StringBuffer csb = new StringBuffer("SELECT COUNT(*) FROM usernum WHERE 1=1");
	if(year!=null&&!year.equals("")){
		csb.append(" and data_year='"+year+"'");
	}
	if(month!=null&&!month.equals("")){
		csb.append(" and data_month='"+month+"'");
	}
	String countSql = csb.toString();
	//String countSql = "SELECT COUNT(*) FROM usernum WHERE data_year LIKE '%"+year+"%' AND data_month  LIKE '%"+month+"%' AND 1=1";
	page pageObj = new page();	
	pageObj.setList(jdbc.query(sql));
	pageObj.setCount(jdbc.execCount(countSql));
	return gson.toJson(pageObj);
	}
 }

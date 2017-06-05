package com.ccshxt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ccshxt.util.JdbcUtil;

public class DateTimeUtil {
	
	/*
	 * 功能：获取当前系统时间<br>
	 * 参数：无<br>
	 * 返回值：当前系统时间String类型<br>
	 */
	public static String getDt(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	
	/**
	 * 功能：小时差计算（第一个时间减去第二个时间），判断是否为超时工单
	 * @param 第一个时间
	 * @param 第二个时间
	 * @return 小时差
	 */
	@SuppressWarnings("unused")
	public static long diffDays(String date1){
		JdbcUtil jdbc = new JdbcUtil();
		String timesql = "SELECT wsid,customer_grade,accept_date FROM worksheets";
		List<Map<String,String>> list = jdbc.query(timesql);
		long days=0,hours=0;
		for(int i = 0;i<list.size();i++){
			int cug=Integer.parseInt(list.get(i).get("customer_grade"));
			int wsid = Integer.parseInt(list.get(i).get("wsid"));
			String accepTime = list.get(i).get("accept_date");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = null,d2=null;
			try {
				d1 = df.parse(date1);
				d2 = df.parse(accepTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		long diff = d1.getTime() - d2.getTime();
		days = diff / (1000 * 60 * 60 * 24);
		hours = (diff/(60*60*1000));
		if(cug==1&&hours>4){
			System.out.println("这是金卡超时"+accepTime);
			String sql = "update worksheets set overtime_flag='4' where wsid="+wsid;
			jdbc.executeSQL(sql);
		}else if(cug==2&&hours>8){
			System.out.println("这是银卡超时"+accepTime);
			String sql = "update worksheets set overtime_flag='4' where wsid="+wsid;
			jdbc.executeSQL(sql);
		}else if(cug==3&&hours>24){
			System.out.println("这是普通卡超时"+accepTime);
			String sql = "update worksheets set overtime_flag='4' where wsid="+wsid;
			jdbc.executeSQL(sql);
		}
		}
		return hours;
	}
}
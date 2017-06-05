package com.ccshxt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ccshxt.util.JdbcUtil;

public class DateTimeUtil {
	
	/*
	 * ���ܣ���ȡ��ǰϵͳʱ��<br>
	 * ��������<br>
	 * ����ֵ����ǰϵͳʱ��String����<br>
	 */
	public static String getDt(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	
	/**
	 * ���ܣ�Сʱ����㣨��һ��ʱ���ȥ�ڶ���ʱ�䣩���ж��Ƿ�Ϊ��ʱ����
	 * @param ��һ��ʱ��
	 * @param �ڶ���ʱ��
	 * @return Сʱ��
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
			System.out.println("���ǽ𿨳�ʱ"+accepTime);
			String sql = "update worksheets set overtime_flag='4' where wsid="+wsid;
			jdbc.executeSQL(sql);
		}else if(cug==2&&hours>8){
			System.out.println("����������ʱ"+accepTime);
			String sql = "update worksheets set overtime_flag='4' where wsid="+wsid;
			jdbc.executeSQL(sql);
		}else if(cug==3&&hours>24){
			System.out.println("������ͨ����ʱ"+accepTime);
			String sql = "update worksheets set overtime_flag='4' where wsid="+wsid;
			jdbc.executeSQL(sql);
		}
		}
		return hours;
	}
}
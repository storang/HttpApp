package com.ccshxt.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccshxt.model.workSheets;

/** 
 * @作者:肖钊
 * @版本: 1.0
 * @版权所有:  
 * @时间 2016年11月11日 上午11:02:50
 * @描述:归档
 */
@WebServlet("/servlet/wr_tableFile")
public class wr_tableFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wr_tableFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String archiyeTime = sim.format(date);
		String wsid = request.getParameter("id");
		workSheets w = new workSheets();
		System.out.println("这是wsid:"+wsid);
		System.out.println("这是归档时间:"+archiyeTime);
		if(w.fileWorksheets(wsid,archiyeTime)){
			System.out.println("这是checked789");
			request.getRequestDispatcher("../workorder/wr_tables.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

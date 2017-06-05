package com.ccshxt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
 * @描述:点击工单号查询详细信息
 **/
@WebServlet("/servlet/wr_table")
public class wr_table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wr_table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String wsid = request.getParameter("id");
		workSheets w = new workSheets();
		List<Map<String,String>> list = w.getworkSheetsById(wsid);
		request.setAttribute("workList",list);
		System.out.println("这是List"+list);
		request.getRequestDispatcher("../workorder/wr_tableSelect.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

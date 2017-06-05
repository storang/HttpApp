package com.ccshxt.controller;

import java.io.IOException;

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
 * @描述:修改工单
 */
@WebServlet("/servlet/wr_tableUpdate")
public class wr_tableUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wr_tableUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String wsid = request.getParameter("wsid");
		String serialNo = request.getParameter("serialNo");
		String acceptDate = request.getParameter("acceptDate");
		String customerCity = request.getParameter("customerCity");
		String customerPhone = request.getParameter("customerPhoneNum");
		String customerGrade = request.getParameter("customerGrade");
		String customerBand = request.getParameter("customerBand");
		String customerContent = request.getParameter("customerContent");
		String isReapt = request.getParameter("isReapt");
		String serviseAdvise = request.getParameter("serviseAdvise");
		String serviceFlag = request.getParameter("serviceFlag");
		String customerIobno = request.getParameter("customerIobno");
		String archiyeDate = request.getParameter("archiyeDate");
		String overTime = request.getParameter("overTime");
		String lastTime = request.getParameter("lastTime");
		String largearea = request.getParameter("largearea");
		workSheets w = new workSheets();
		if(w.updateWorksheets(wsid,serialNo, acceptDate, customerCity, customerPhone, customerGrade, customerBand, customerContent, isReapt, serviseAdvise, serviceFlag, customerIobno, archiyeDate, overTime, lastTime, largearea)){
			request.getRequestDispatcher("../workorder/wr_tables.jsp").forward(request, response);
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

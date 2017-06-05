package com.ccshxt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccshxt.model.Users;
import com.google.gson.Gson;

/** 
 * @作者:肖钊
 * @版本: 1.0
 * @版权所有:  
 * @时间 2016年11月11日 上午11:02:50
 * @描述:工单分页
 */
@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users u = new Users();
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		String acceptdate = request.getParameter("acceptdate");
		response.setCharacterEncoding("utf8");
		System.out.println(u.getUserByPageNum(pageNum, pageSize,acceptdate));
		response.getWriter().append(u.getUserByPageNum(pageNum, pageSize,acceptdate));
		/*String str = u.getUserByPageNum(pageNum, pageSize);
		List map = new ArrayList();
		List<Map<String,String>> list = (List<Map<String, String>>) gson.fromJson(str, map.getClass());
		System.out.println(list);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

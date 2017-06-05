package com.ccshxt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccshxt.model.Users;
import com.ccshxt.util.DateTimeUtil;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

/** 
 * @作者:肖钊
 * @版本: 1.0
 * @版权所有:  
 * @时间 2016年11月11日 上午11:02:50
 * @描述:登录
 */
@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Users user = new Users();
		String date1 = request.getParameter("date1");
		DateTimeUtil u = new DateTimeUtil();//开始时将超时工单状态修改为已超时
		//int time = (int)u.diffDays(date1);
		//System.out.println("这是时间"+time);
		//连接数据库判断用户名密码是否准确
		List<Map<String,String>> list = user.getAllUser(username, password);
		request.getSession().setAttribute("user", list);
		if(Users.login(username, password)){
			request.getRequestDispatcher("../workorder/wr_tables.jsp").forward(request, response);
		}else{
			request.setAttribute("isError", true);
			request.setAttribute("errorMsg", "用户名或密码错误");
			request.getSession().setAttribute("AerrorMsg", "session说不对");
			request.getRequestDispatcher("../workorder/login.jsp").forward(request, response);
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

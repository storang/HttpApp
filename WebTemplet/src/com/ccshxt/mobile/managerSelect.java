package com.ccshxt.mobile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccshxt.model.mobile;

/**
 * Servlet implementation class managerSelect
 */
@WebServlet("/servlet/managerSelect")
public class managerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		mobile m = new mobile();
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		String opendate = request.getParameter("opendate");
		response.setCharacterEncoding("utf8");
		System.out.println(m.selectMobileByPageNum(pageNum, pageSize, opendate));
		response.getWriter().append(m.selectMobileByPageNum(pageNum, pageSize, opendate));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

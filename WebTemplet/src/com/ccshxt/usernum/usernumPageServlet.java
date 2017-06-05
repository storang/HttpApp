package com.ccshxt.usernum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccshxt.model.Users;
import com.ccshxt.model.usernum;

/**
 * Servlet implementation class usernumPageServlet
 */
@WebServlet("/usernumPageServlet")
public class usernumPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usernumPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		usernum u = new usernum();
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		System.out.println("’‚ «year:"+year);
		response.setCharacterEncoding("utf8");
		if(u.writeFile(month)){
			u.insert();
		}
		response.getWriter().append(u.getusernumByPageNum(pageNum, pageSize,year,month));
		System.out.println(u.getusernumByPageNum(pageNum, pageSize,year,month));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

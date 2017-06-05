package com.ccshxt.userController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccshxt.model.Users;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/servlet/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String upwd = request.getParameter("upwd");
		List<Map<String,String>> user = (List<Map<String, String>>) request.getSession().getAttribute("user");
		String id = null;
		for(Map<String, String> list :user){
			id = list.get("uid");
			System.out.println("这是name:"+list.get("ucname"));
		}
		Users u = new Users();
		if(u.updateUser(upwd,id)){
			System.out.println("这是id:"+id);
			request.getRequestDispatcher("../user/user.jsp").forward(request, response);
		}else{
			System.out.println("修改出错");
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

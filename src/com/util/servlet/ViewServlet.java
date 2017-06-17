package com.util.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.util.DAO.*;
import com.util.bean.StudentOne;
import com.util.conn.DbConnection;
@WebServlet("/stud")
public class ViewServlet extends HttpServlet{
@Override
public void init(ServletConfig config) throws ServletException {
	
	super.init(config);
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("stu servlet ...");
		List<StudentOne> b1 = null;
		try {
			b1= new BussinessLogic().getList();
			req.setAttribute("list",b1);
			 req.getRequestDispatcher("/view.jsp").include(req,resp);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}

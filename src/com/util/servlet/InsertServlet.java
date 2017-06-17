package com.util.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DAO.BussinessLogic;
import com.util.bean.StudentOne;

@WebServlet("/insert")
public class InsertServlet  extends HttpServlet{

public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("second servlet ... doget ");
	StudentOne stu=new StudentOne();
		stu.setStu_id(Integer.parseInt(req.getParameter("stu_id")));
		stu.setStu_name(req.getParameter("stu_name"));
		stu.setSal(Integer.parseInt(req.getParameter("sal")));
	
		try {
			BussinessLogic.inserting(stu);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		System.out.println("second servlet ...");
		RequestDispatcher re=req.getRequestDispatcher("/stud");
		re.forward(req,resp);
	}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

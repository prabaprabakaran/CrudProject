package com.util.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DAO.BussinessLogic;
import com.util.bean.StudentOne;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
}

	
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	StudentOne stu=new StudentOne();
	BussinessLogic bc=new BussinessLogic();
	PrintWriter out=resp.getWriter();
	String id=req.getParameter("stu_id");
	int stu_id=Integer.parseInt(id);
	String stu_ids=req.getParameter("stu_id");
	String stu_name=req.getParameter("stu_name");
	int sal=Integer.parseInt(req.getParameter("sal"));
	stu.setStu_id(stu_id);
	stu.setStu_name(stu_name);
	stu.setSal(sal);
	try{
		int update=BussinessLogic.update(stu);
		System.out.println(update);
		if(update>0)
		
		resp.sendRedirect("stud");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	}
}

package com.util.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DAO.BussinessLogic;
import com.util.bean.StudentOne;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	StudentOne stu=new StudentOne();
	stu.setStu_id(Integer.parseInt(req.getParameter("stu_id")));
	try{
		BussinessLogic.delete(stu);
	}catch(Exception e){
		e.printStackTrace();
	}
	System.out.println("Delete servlet ...");
	RequestDispatcher re=req.getRequestDispatcher("/stud");
	re.forward(req,resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

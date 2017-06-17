package com.util.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DAO.BussinessLogic;
import com.util.bean.StudentOne;


@WebServlet("/UpdateServletToo")
public class UpdateServletToo extends HttpServlet {
	@Override
	public void init() throws ServletException {
	
		super.init();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stu_id=Integer.parseInt(request.getParameter("stu_id"));
		BussinessLogic stu=new BussinessLogic();
		try{
			
			List<StudentOne> list=stu.updateDatabase(stu_id);
			request.setAttribute("list",list);
			System.out.println(list);
			RequestDispatcher re=request.getRequestDispatcher("/update.jsp");
			re.forward(request,response);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

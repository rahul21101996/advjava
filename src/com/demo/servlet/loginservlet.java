package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
@WebServlet("/login")
public class loginservlet extends HttpServlet {
	private LoginService lservice;
	public void init()
	{
		lservice= new LoginServiceImpl();
	}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	String uname=request.getParameter("uname");
	String pass=request.getParameter("pass");
	//validate user with the help of loginservice
	boolean flag=lservice.validateUser(uname,pass);
	if(flag)
	{
		HttpSession sess=request.getSession();
		sess.setAttribute("user", uname);
		RequestDispatcher rd=request.getRequestDispatcher("Product");
		rd.forward(request, response);
	}
	else
	{
		out.println("please re-enter your credential");
		RequestDispatcher rd1=request.getRequestDispatcher("login.html");
		rd1.include(request, response);
	}
	
}
}

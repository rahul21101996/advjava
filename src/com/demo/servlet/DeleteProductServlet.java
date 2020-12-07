package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
	private ProductService pservice;

	public void init()
	{
		pservice= new ProductServiceImpl();
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		
		int pid=Integer.parseInt(request.getParameter("Pid"));
		
		
		int n=pservice.deleteProduct(pid);
		if(n>0)
		{
		RequestDispatcher rd=request.getRequestDispatcher("Product");
		rd.forward(request, response);
		}
	}
}


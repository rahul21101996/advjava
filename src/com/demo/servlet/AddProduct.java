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

@WebServlet("/addproduct")
public class AddProduct extends HttpServlet{
	
	private ProductService pservice;

	public void init()
	{
		pservice= new ProductServiceImpl();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		double price=Double.parseDouble(request.getParameter("price"));
		Product p=new Product(pid,pname,price);
		int n=pservice.addProduct(p);
		RequestDispatcher rd=request.getRequestDispatcher("Product");
		rd.forward(request, response);
	}
}

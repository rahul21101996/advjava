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
@WebServlet("/UpdateProduct")
public class UpdateProductServlet extends HttpServlet{

	private ProductService pservice;

	public void init()
	{
		pservice= new ProductServiceImpl();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		double price=Double.parseDouble(request.getParameter("price"));
		Product p=new Product(pid,pname,price);
		int n=pservice.updateProduct(p);
		if(n>0)
		{
			out.println("updated");
		RequestDispatcher rd=request.getRequestDispatcher("Product");
		rd.forward(request, response);
		}
		else
		{
			out.println("not updated");
		}
		
		
	}
}
 
package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private ProductService pservice;
	public void init()
	{
		pservice= new ProductServiceImpl();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		doPost(request,response);
	}
	
	
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	ArrayList<Product> plist=pservice.getAllProduct();
	out.println("<table border=1><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Modify Product</th></tr>");
	for(Product p:plist)
	{
		out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getPrice()+"</td>");
		out.println("<td><a href='editproduct?Pid="+p.getPid()+"'>Edit/</a><a href='deleteproduct?Pid="+p.getPid()+"'>Delete</a></td></tr>");
	
	}
	out.println("</table>");
	out.println("<a href=AddProduct.html>add product</a>");
}
}

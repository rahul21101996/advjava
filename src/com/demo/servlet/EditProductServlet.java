package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/editproduct")
public class EditProductServlet extends HttpServlet {
	private ProductService pservice;

	public void init()
	{
		pservice= new ProductServiceImpl();
	}
	
		public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			int pid=Integer.parseInt(request.getParameter("Pid"));
			Product p=pservice.getById(pid);
			out.println("<form action='UpdateProduct'>");
			out.println("Product Id :<input type='text' name='pid' value='"+p.getPid()+"'readonly>");
			out.println("Product name:<input type='text' name='pname' value='"+p.getPname()+"'>");
			out.println("Product Price :<input type='text' name='price' value='"+p.getPrice()+"'>");
			
			out.println("<button type='submit'>Update Product</button>");
			out.println("</form>");
		}
}

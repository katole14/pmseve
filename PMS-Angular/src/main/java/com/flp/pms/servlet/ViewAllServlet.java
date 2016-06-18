package com.flp.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.pms.domain.Product;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;
import com.google.gson.Gson;


public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductService iProductService = new ProductServiceImpl();
		List<Product> products=iProductService.viewAllProductList();
	
        PrintWriter out=response.getWriter();
		Gson myJson=new Gson();
		

		String empjson=myJson.toJson(products);
		
	
		out.println(empjson);
	}

	}



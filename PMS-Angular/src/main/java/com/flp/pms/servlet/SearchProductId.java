package com.flp.pms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchProductId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ProductService productService=new ProductServiceImplements();
					String jsondisp=productService.getJson();
					PrintWriter out=response.getWriter();
					out.println(jsondisp);
					

	}

}

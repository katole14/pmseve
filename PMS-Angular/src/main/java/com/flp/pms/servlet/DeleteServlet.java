package com.flp.pms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	IProductService productServiceImplements=new ProductServiceImpl();	
		String pid=request.getParameter("pid");
		
		int proid=Integer.parseInt(pid);
		
		productServiceImplements.deleteProduct(proid);
	}

}

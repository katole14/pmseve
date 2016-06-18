package com.flp.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;
import com.google.gson.Gson;

public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductService iproductservice = new ProductServiceImpl();

		PrintWriter out = response.getWriter();
		Gson myjson = new Gson();
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("category")) {
			response.setContentType("application/json");
			List<Category> categories = iproductservice.getAllCategory();

			String categoryjson = myjson.toJson(categories);
			out.println(categoryjson);
		} else if (action.equalsIgnoreCase("subcategory")) {
			//String catIs=request.getParameter("catId");
			
			response.setContentType("application/json");

			List<SubCategory> subcategory = iproductservice.getAllSubCategory();
			String subcategoryjson = myjson.toJson(subcategory);
			out.print(subcategoryjson);

		} else if (action.equalsIgnoreCase("supplier")) {
			response.setContentType("application/json");

			List<Supplier> supplier = iproductservice.getAllSuppliers();
			String supplierjson = myjson.toJson(supplier);
			out.print(supplierjson);

		} else if (action.equalsIgnoreCase("discount")) {
			response.setContentType("application/json");

			List<Discount> discount = iproductservice.getAllDiscounts();
			String discountjson = myjson.toJson(discount);
			out.print(discountjson);

		}
	}

	

}

package com.flp.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.pms.dao.IProductDao;
import com.flp.pms.dao.ProductDaoImplForJdbc;
import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;
import com.google.gson.Gson;

public class CreatProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		IProductDao iproduct_dao = new ProductDaoImplForJdbc();
		IProductService iProductService= new ProductServiceImpl();
		boolean flag=false;
		//setting quantity
		String quantity=request.getParameter("qty");
		product.setQuantity(Integer.parseInt(quantity));
		
		//setting price
		String maxPcrice=request.getParameter("maxprice");
		product.setMaximum_Retail_Price(Double.parseDouble(maxPcrice));
		
		//setting rating
		String rating=request.getParameter("rating");
		product.setRating(Float.parseFloat(rating));
		
        //setting product name
		String productName = request.getParameter("pname");
		product.setProduct_Name(productName);
		
        //setting product description
		String Description = request.getParameter("pdes");
		product.setDescription(Description);
		
        //setting manufacuring date
		String manufacturing_date = request.getParameter("pmafdate");
		try {
			product.setManufacturing_Date(sdf.parse(manufacturing_date));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
        //setting expiry date
		String expiryDate = request.getParameter("pexdate");
		try {
			product.setExpiry_Date(sdf.parse(expiryDate));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
        //setting category
		String category_name = request.getParameter("pcategory_name");
		List<Category> categories = iProductService.getAllCategory();
		Category category = new Category();
		for (Category cat : categories) {
			if (cat.getCategory_Name().equalsIgnoreCase(category_name)) {
				category = cat;
			}

		}
		
		product.setCategory(category);
        //setting sub category
		String sub_category_name = request.getParameter("psubcategory");
		List<SubCategory> subcategories = iProductService.getAllSubCategory();
		SubCategory subcategory = new SubCategory();
		for (SubCategory subcat : subcategories) {
			if (subcat.getSubCategory_Name().equalsIgnoreCase(sub_category_name)) {
				subcategory = subcat;
			}
		}
		
		product.setSubCategory(subcategory);
        //setting supplier
		String psupplier = request.getParameter("psupplier");
		List<Supplier> suppliers = iProductService.getAllSuppliers();
		Supplier supplier = new Supplier();
		for (Supplier supply : suppliers) {
			if (supply.getFirst_Name().equalsIgnoreCase(psupplier)) {
				supplier = supply;
			}
		}
		
		product.setSupplier(supplier);
        //setting discount
		String DisName[] = request.getParameterValues("pdiscount");
		List<Discount> discounts = iProductService.getAllDiscounts();
		List<Discount> discount = new ArrayList<Discount>();
		int len = DisName.length;
		int i = 0;

		for (Discount dis : discounts) {
			if (i < len) {
				if (dis.getDiscount_Name().equalsIgnoreCase(DisName[i])) {
					discount.add(dis);
					i++;
				}
			}
		}
		
		product.setDiscounts(discount);
		System.out.println(product);
		 flag=iProductService.addProduct(product);
		 if(flag){
			 response.sendRedirect("pages/Mainpage.html");
		 }else
			 response.sendRedirect("pages/error.html");

	}
	
	
	
	
	
	
}
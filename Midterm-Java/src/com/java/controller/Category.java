package com.java.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.model.CategoryModel;
import com.java.model.ConnectDB;
import com.java.model.User;

@WebServlet("/Category")
public class Category extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectDB conn = new ConnectDB();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql=String.format("Select * from categories");
		ArrayList<CategoryModel> arrCate = new ArrayList<CategoryModel>();
		ResultSet rs = conn.getData(sql);
			try {
					
					while(rs.next()){
						CategoryModel cate = new CategoryModel();
						cate.categoryID = rs.getInt(1);
						cate.name = rs.getString(2);
						cate.quantity = rs.getInt(3);
						cate.status = rs.getBoolean(4);
						arrCate.add(cate);
						
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		req.setAttribute("data", arrCate);
		req.getRequestDispatcher("view/category.jsp").forward(req, resp);
	}
}

package com.java.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.ConnectDB;

@WebServlet("/Dashboard")
public class Home extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html;charset=UTF-8");
//		req.setCharacterEncoding("utf-8");
//		ConnectDB connect = new ConnectDB();
//		String s="";
//		ResultSet rs = connect.getData("select * from product");
//		try {
//			while(rs.next()){
//				s+= rs.getString(2);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
////		
////		if (connect!=null) {
////			s="123";
////		}
////		else s="1";
//		req.setAttribute("rs", s);
		
		req.getRequestDispatcher("view/dashboard.jsp").forward(req, resp);
	}

}

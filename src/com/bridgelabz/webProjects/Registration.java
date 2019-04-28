package com.bridgelabz.webProjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "root", "tiger");

			pstmt = con.prepareStatement(("insert into MYTABLE(ID,NAME,EMAIL,PASSWORD) values(?,?,?,?)"));

			pstmt.setInt(1, Integer.valueOf(request.getParameter("ID")));
			pstmt.setString(2, request.getParameter("NAME"));
			pstmt.setString(3, request.getParameter("EMAIL"));
			pstmt.setString(4, request.getParameter("PASSWORD"));

			int i = pstmt.executeUpdate();

			if (i > 0)
				out.println("Successfully Inserted");
			else
				out.println("please enter details");

			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
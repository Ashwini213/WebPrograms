package com.bridgelabz.webProjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWrite = response.getWriter();

		String NAME = request.getParameter("NAME");
		String PASSWORD = request.getParameter("PASSWORD");

		if (Validate.checkUser(NAME, PASSWORD)) {
			// RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			// rs.forward(request, response);
			printWrite.print("Welcome");

		} else {
			// out.println("Username or Password incorrect");
			// String name = request.getParameter("NAME");
			// String password = request.getParameter("PASSWORD");

			// Creating two cookies
			Cookie c1 = new Cookie("NAME", NAME);
//			Cookie c2 = new Cookie("PASSWORD", PASSWORD);

			// Adding the cookies to response header
		response.addCookie(c1);
//			response.addCookie(c2);

			// Reading cookies
			Cookie c[] = request.getCookies();

			// Displaying User name value from cookie
//			printWrite.print("NAME: " + c[0].getValue());
			// Displaying user password value from cookie

			printWrite.print(" HELLO YOUR NAME IS: " + c[0].getValue());

			printWrite.close();

			RequestDispatcher rs = request.getRequestDispatcher("/Register.html");
			rs.include(request, response);
		}
	}
}
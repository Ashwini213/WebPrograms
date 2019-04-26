/**
 * 
 */
package com.bridgelabz.webProjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;

/**
 * @author all
 *
 */
public class Validate {
	public static boolean checkUser(String NAME, String PASSWORD) {
		boolean st = false;
		try {

			// loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");

			// creating connection with the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "root", "tiger");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM MYTABLE WHERE NAME=? and PASSWORD=?");
			ps.setString(1, NAME);
			ps.setString(2, PASSWORD);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
			
			
	          
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
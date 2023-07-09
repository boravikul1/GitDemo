package com.seleniumautomation.mavenproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBConnectionTest {
	
	@BeforeTest
	public void connectToDatabase() throws SQLException, ClassNotFoundException
	{
		String username = "sa"; 
		String password= "Password1";
		String host = "QA-W2K19-234.dev.local\\DRAGONSTONE";
		String port = "1433";
		String dburl = "jdbc:sqlserver://"+host+":"+port;
		//Class.forName("com.sqlserver.jdbc.Driver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(dburl, username, password);
		System.out.println("Database Connection is successful");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Use WinOasis ; select * from TieredRank");
		while (rs.next()) {
		System.out.print(rs.getString(1)+" | ");
		System.out.print(rs.getString(2)+" | ");
		System.out.print(rs.getString(3)+" | ");
		System.out.print(rs.getString(4)+" | ");
		System.out.print(rs.getString(5)+" | ");
		System.out.print(rs.getString(6)+" | ");
		System.out.println();
		}
		
	}
	
	@Test
	public void executeDBQuery()
	{
		System.out.println("Test");
	}

}

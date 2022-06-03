package com.bridgelabz.Day_34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;

public class ConnectToDatabaseUC1 {
	public static void main(String[] args) {
	String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	String userName = "root";
	String passWord = "Softramesh27";
	Connection con;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver Loaded");
	}catch (ClassNotFoundException e) {
		throw new IllegalStateException("Cannot Fine the driver in the class path", e);
	}
	
	listDrivers();
	
	try {
		System.out.println("Connecting to database :"+jdbcURL);
		con = DriverManager.getConnection(jdbcURL, userName, passWord);
		System.out.println("Connection is successfull"+con);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver)driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
		}
	}
}

package com.bridgelabz.Day_34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class FindFunctionUC6 {
	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String passWord = "Softramesh27";
		Connection con;
		con = DriverManager.getConnection(jdbcURL, userName, passWord);
		return con;		
	}
	
	public static void main(String [] args) {
		String sql [] = {"SELECT AVG(SALARY) AS SALARY FROM EMPLOYEE_PAYROLL WHERE GENDER = 'M' GROUP BY GENDER",
						"SELECT SUM(SALARY) AS SALARY FROM EMPLOYEE_PAYROLL WHERE GENDER = 'M' GROUP BY GENDER",
						"SELECT MIN(SALARY) AS SALARY FROM EMPLOYEE_PAYROLL WHERE GENDER = 'M' GROUP BY GENDER",
						"SELECT MAX(SALARY) AS SALARY FROM EMPLOYEE_PAYROLL WHERE GENDER = 'M' GROUP BY GENDER",
						"SELECT COUNT(SALARY) AS SALARY FROM EMPLOYEE_PAYROLL WHERE GENDER = 'M' GROUP BY GENDER"
						};
		try {
			Connection connection = getConnection();
			java.sql.Statement statement = connection.createStatement();
			for(String query : sql) {
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				double salary = resultSet.getDouble("salary");
				System.out.println(salary);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		  }
	}
}

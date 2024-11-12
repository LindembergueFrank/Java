package com.repojava.javacoursebasico.intro.JDBC.jdbc6.src.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.repojava.javacoursebasico.intro.JDBC.jdbc1.src.db.DB;
import com.repojava.javacoursebasico.intro.JDBC.jdbc1.src.db.DbException;


public class Program {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DB.getConnection();
			
			// Transaction intit
			connection.setAutoCommit(false);
			
			statement = connection.createStatement();
			
			int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 1800 WHERE DepartmentId = 1");
			
			/*
			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error");
			}
			*/
			
			int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3600 WHERE DepartmentId = 2");
			
			// Transaction finally
			connection.commit();
			
			System.out.println("Rows1: " + rows1);
			System.out.println("Rows2: " + rows2);
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			DB.closedStatement(statement);
			DB.closedConnection();
		}
	}
}

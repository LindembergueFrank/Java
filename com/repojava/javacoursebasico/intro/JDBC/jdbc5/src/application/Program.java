package com.repojava.javacoursebasico.intro.JDBC.jdbc5.src.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.repojava.javacoursebasico.intro.JDBC.jdbc1.src.db.DB;
import com.repojava.javacoursebasico.intro.JDBC.jdbc5.src.db.DbIntegrityException;


public class Program {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = DB.getConnection();
			
			pStatement = connection.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "(Id = ?)"
					);
			
			pStatement.setInt(1, 5);
			
			int rowsAffected = pStatement.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closedStatement(pStatement);
			DB.closedConnection();
		}
	}
}

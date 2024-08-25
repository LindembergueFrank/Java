package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;


public class Program {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = DB.getConnection();
			
			pStatement = connection.prepareStatement(
					"UPDATE seller "  
					+ "SET BaseSalary = BaseSalary + ?" 
					+ "WHERE "
					+ "(DepartmentId = ?)"
					);
			
			pStatement.setDouble(1, 375);
			pStatement.setInt(2, 3);
			
			int rowsAffected = pStatement.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedStatement(pStatement);
			DB.closedConnection();
		}
	}
}

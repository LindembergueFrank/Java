package com.repojava.javacoursebasico.intro.JDBC.jdbc3.src.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.repojava.javacoursebasico.intro.JDBC.jdbc1.src.db.DB;
import com.repojava.javacoursebasico.intro.JDBC.jdbc1.src.db.DbException;


public class Program {
	public static void main(String[] args) {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YY");
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = DB.getConnection();
			pStatement = connection.prepareStatement(
						"INSERT INTO seller" + "(Name, Email, Birthdate, BaseSalary, DepartmentId)"
						+ "VALUES "
						+ "(?, ?, ?, ?, ?)", 
						+ Statement.RETURN_GENERATED_KEYS);
			
			pStatement.setString(1, "Alex Brown");
			pStatement.setString(2, "alexbrown@gmail.com");
			pStatement.setDate(3, new java.sql.Date(formatDate.parse("22/04/1980").getTime()));
			pStatement.setDouble(4, 5000);
			pStatement.setInt(5, 3);
			
			int rowAffecteds = pStatement.executeUpdate();
			
			if (rowAffecteds > 0) {
				ResultSet resultSet = pStatement.getGeneratedKeys();
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					System.out.println("Done! New Seller Id = " + id);
					System.out.println("Rows affectds: " + rowAffecteds);

				}
			} else {
				System.out.println("No rown affectds!");
			}
			

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} catch (ParseException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedStatement(pStatement);
			DB.closedConnection();
		}
	}
}

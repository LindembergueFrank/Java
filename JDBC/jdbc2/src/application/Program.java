package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;


public class Program {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DB.getConnection();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM DEPARTMENT");
			
			while(resultSet.next()) {
				System.out.println("[ " + resultSet.getInt("Id") + ", " + resultSet.getString("Name") + " ]");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closedResultSet(resultSet);
			DB.closedStatement(statement);
			DB.closedConnection();
		}
		
		
	}

}

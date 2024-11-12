package com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.repojava.javacoursebasico.intro.JDBC.jdbc1.src.db.DB;
import com.repojava.javacoursebasico.intro.JDBC.jdbc1.src.db.DbException;
import com.repojava.javacoursebasico.intro.JDBC.jdbc5.src.db.DbIntegrityException;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao.DepartmentDao;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	private Connection connection;

	public DepartmentDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(
					"INSERT INTO department "
					+ "(Name) "
					+ "VALUES "
					+ "(?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			pStatement.setString(1, obj.getName());

			
			int rowsAffected = pStatement.executeUpdate();
			
			if (rowsAffected != 0) {
				ResultSet resultSet = pStatement.getGeneratedKeys();
				if (resultSet.next()) {
					int id = resultSet.getInt(1);
					obj.setId(id);
				}
				DB.closedResultSet(resultSet);
			} else {
				throw new DbException("Unexpeccted error! No rows affected!");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedStatement(pStatement);;
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(
					"UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ?");
			
			pStatement.setString(1, obj.getName());
			pStatement.setInt(2, obj.getId());
			
			pStatement.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedStatement(pStatement);;
		}
		
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(
					"DELETE FROM department WHERE Id = ?"
					);
			
			pStatement.setInt(1, id);
			int rowsAffected = pStatement.executeUpdate();
			
			if (rowsAffected == 0) {
				throw new DbException("Id not exist!");
			}
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closedStatement(pStatement);
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(
					"SELECT * FROM department WHERE department.Id = ?"
					);
			
			pStatement.setInt(1, id);
			resultSet = pStatement.executeQuery();
			
			if (resultSet.next()) {
				Department objDepartment = new Department();
				objDepartment.setId(resultSet.getInt("Id"));
				objDepartment.setName(resultSet.getString("Name"));
				return objDepartment;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedResultSet(resultSet);
			DB.closedStatement(pStatement);
		}
	}
	
	@Override
	public List<Department> findAll() {
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(
					"SELECT * FROM department ORDER BY Name"
					);
			
			resultSet = pStatement.executeQuery();
			
			List<Department> departmentList = new ArrayList<Department>();		
			
			while (resultSet.next()) {
				Department objDepartment = new Department();
				objDepartment.setId(resultSet.getInt("Id"));
				objDepartment.setName(resultSet.getString("Name"));
				departmentList.add(objDepartment);
			}
			return departmentList;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedResultSet(resultSet);
			DB.closedStatement(pStatement);
		}
	}

}

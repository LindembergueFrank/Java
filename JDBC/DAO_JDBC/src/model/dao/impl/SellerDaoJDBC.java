package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection connection;
	
	// Injecao de dependecia por meio do construtor
	public SellerDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?"
					);
			
			pStatement.setInt(1, id);
			resultSet = pStatement.executeQuery();
			
			if (resultSet.next()) {
				Department department = instatiateDepartment(resultSet);
				Seller objSeller = instatiateSeller(resultSet, department);
				return objSeller;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedResultSet(resultSet);
			DB.closedStatement(pStatement);
		}
	}

	private Seller instatiateSeller(ResultSet resultSet, Department department) throws SQLException {
		Seller objSeller = new Seller();
		objSeller.setId(resultSet.getInt("Id"));
		objSeller.setName(resultSet.getString("Name"));
		objSeller.setEmail(resultSet.getString("Email"));
		objSeller.setBirthDate(resultSet.getDate("BirthDate"));
		objSeller.setBaseSalary(resultSet.getDouble("BaseSalary"));
		objSeller.setDepartment(department);
		return objSeller;
	}

	private Department instatiateDepartment(ResultSet resultSet) throws SQLException {
		Department department =new Department();
		department.setId(resultSet.getInt("DepartmentId"));
		department.setName(resultSet.getString("DepName"));
		return department;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

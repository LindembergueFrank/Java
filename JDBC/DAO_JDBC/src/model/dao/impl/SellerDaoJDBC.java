package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			pStatement.setString(1, obj.getName());
			pStatement.setString(2, obj.getEmail());
			pStatement.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			pStatement.setDouble(4, obj.getBaseSalary());
			pStatement.setInt(5, obj.getDepartment().getId());
			
			int rowsAffected = pStatement.executeUpdate();
			
			if (rowsAffected > 0) {
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
	public void update(Seller obj) {
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(
					"UPDATE seller "
					+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
					+ "WHERE Id = ?");
			
			pStatement.setString(1, obj.getName());
			pStatement.setString(2, obj.getEmail());
			pStatement.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			pStatement.setDouble(4, obj.getBaseSalary());
			pStatement.setInt(5, obj.getDepartment().getId());
			pStatement.setInt(6, obj.getId());
			
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
					"DELETE FROM seller "
					+ "WHERE Id = ?");
			
			pStatement.setInt(1, id);
			int rowsAffected = pStatement.executeUpdate();
			
			if (rowsAffected == 0) {
				throw new DbException("Id not exist!");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedStatement(pStatement);
		}
		
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
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name"
					);
			
			resultSet = pStatement.executeQuery();
			
			List<Seller> sellerList = new ArrayList<Seller>();		
			Map<Integer, Department> map = new HashMap<>();
			
			while (resultSet.next()) {
				
				Department dep = map.get(resultSet.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instatiateDepartment(resultSet);
					map.put(resultSet.getInt("DepartmentId"), dep);
				}
				
				Seller objSeller = instatiateSeller(resultSet, dep);
				sellerList.add(objSeller);
			}
			return sellerList;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedResultSet(resultSet);
			DB.closedStatement(pStatement);
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name"
					);
			
			pStatement.setInt(1, department.getId());
			resultSet = pStatement.executeQuery();
			
			List<Seller> sellerList = new ArrayList<Seller>();		
			Map<Integer, Department> map = new HashMap<>();
			
			while (resultSet.next()) {
				
				Department dep = map.get(resultSet.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instatiateDepartment(resultSet);
					map.put(resultSet.getInt("DepartmentId"), dep);
				}
				
				Seller objSeller = instatiateSeller(resultSet, dep);
				sellerList.add(objSeller);
			}
			return sellerList;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closedResultSet(resultSet);
			DB.closedStatement(pStatement);
		}
	}

}

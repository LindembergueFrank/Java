package com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao;

import java.util.List;

import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.entities.Department;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.entities.Seller;

public interface SellerDao {
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}

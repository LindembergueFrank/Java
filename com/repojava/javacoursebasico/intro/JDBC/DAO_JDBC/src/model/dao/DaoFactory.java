package com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao;

import com.repojava.javacoursebasico.intro.JDBC.jdbc1.src.db.DB;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao.impl.DepartmentDaoJDBC;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}

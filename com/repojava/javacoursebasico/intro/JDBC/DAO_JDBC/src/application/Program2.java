package com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.application;

import java.util.List;
import java.util.Scanner;

import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao.DaoFactory;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao.DepartmentDao;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TESTE 1: Department findById ====");
		Department department = departmentDao.findById(1); 
		System.out.println(department);
		
		
		System.out.println("\n==== TESTE 2: Department findByAll ====");
		List<Department> departmentList = departmentDao.findAll();
		for (Department dep : departmentList) {
			System.out.println(dep);
		}
		
		System.out.println("\n==== TESTE 3: Department insert ===="); 
		Department dep = new Department(null, "Music");
		departmentDao.insert(dep);
		System.out.println("Insert completed!");
		
		System.out.println("\n==== TESTE 4: Department update ====");
		Department department2 = departmentDao.findById(3);
		department2.setName("Food");
		departmentDao.update(department2);
		System.out.println("Update completed!");
		
		System.out.println("\n==== TESTE 5: Department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = scanner.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		scanner.close();
		
	}

}

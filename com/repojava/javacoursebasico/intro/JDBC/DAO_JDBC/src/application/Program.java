package com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao.DaoFactory;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.dao.SellerDao;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.entities.Department;
import com.repojava.javacoursebasico.intro.JDBC.DAO_JDBC.src.model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("==== TESTE 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TESTE 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		
		for (Seller seller2 : sellerList) {
			System.out.println(seller2);
		}
		
		System.out.println("\n==== TESTE 3: Seller findByAll ====");
		sellerList = sellerDao.findAll();
		
		for (Seller seller2 : sellerList) {
			System.out.println(seller2);
		}
		
		System.out.println("\n==== TESTE 4: Seller insert ====");
		Seller seller2 = new Seller(null, "Chris Rock", "ChrisROck@gmail.com", new Date() ,5000.0, department);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id = " + seller2.getId());
		
		System.out.println("\n==== TESTE 5: Seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Bruce Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n==== TESTE 5: Seller delete ====");
		System.out.println("Enter id for delete test: ");
		int id = scanner.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		scanner.close();
	}
}

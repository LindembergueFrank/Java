package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		Department department = new Department(1, "Eletronics");
		
		Seller seller = new Seller(10, "Alex Bob", "alexbobx@gmail.com", new Date(), 2800.0, department);
		
		System.out.println(seller);
	}
}
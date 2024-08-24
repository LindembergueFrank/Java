package application;

import java.sql.Connection;
import java.sql.SQLException;

import db.DB;


public class Program {
	public static void main(String[] args) {
		
		try (Connection connection = DB.getConnection()) {
			System.out.println("Conexão realizada com sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro: " + e.getMessage());
		} finally {
			System.out.println("-------------------------------");
			DB.closedConnection();
			System.out.println("Conexão fechada com sucesso!");
		}
	
	}

}

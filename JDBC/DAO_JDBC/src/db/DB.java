package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    
    private static Connection connect = null;
    
    // Abrir conexão
    public static Connection getConnection() {
        if (connect == null) {
            try {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                connect = DriverManager.getConnection(url, properties);               
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return connect;
    }

    
    // Fechando a conexão
    public static void closedConnection() {
        if (connect != null) {
            try {
                connect.close();
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    
    private static Properties loadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
    
    public static void closedStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
    
    public static void closedResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
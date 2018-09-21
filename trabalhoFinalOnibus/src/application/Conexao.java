package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private final static String USER  = "root";
	private final static String PASS = "91602097";
	private final static String URL = "jdbc:mysql://localhost/frotaOnibus" + "?useSSL=false&useTimezone=true&serverTimezone=UTC";

//	private static Connection connection;
//	
//	//padrao Singleton
//	public Connection getConn() {
//		if(connection == null);
//		try {
//			 connection = DriverManager.getConnection(URL, USER, PASS);
//			System.out.println("conectado: " + connection.toString());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return connection;
//	}
	
	private static Connection connection;
	//Funciona somente uma vez 
	static { 
		try {
			 connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		return connection;
	}

}

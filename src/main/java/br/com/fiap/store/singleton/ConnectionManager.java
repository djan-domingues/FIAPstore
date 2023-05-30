package br.com.fiap.store.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	private static ConnectionManager coonectionManager;
	
	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		if (coonectionManager == null) {
			coonectionManager = new ConnectionManager();
		}
		return coonectionManager;
	}
	
	public Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:ORCL", "sys as sysdba", "Tel43966451@");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}
}

package info.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {
	private static JdbcTemplate instance;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "springuser";
	private String password = "1234";

	private JdbcTemplate() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 클래스 로딩 성공");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static JdbcTemplate getInstance() {
		synchronized(JdbcTemplate.class) {
			if(instance == null) {
				instance = new JdbcTemplate();
			}
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
}

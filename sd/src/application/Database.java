package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost::3306/tutorial","root","082100");
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결오류: "+e.getMessage());
		}
	}
}

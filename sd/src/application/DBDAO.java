package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBDAO {
//	public static void main (String[] args) {
	Connection conn;  
	Statement stmt; 
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public DBDAO() {
//		Connection conn;  
		stmt = null;  
		try {   			
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			System.out.println("MySQL JDBC 드라이버 로딩 성공...");
			conn = DriverManager.getConnection(  "jdbc:mysql://127.0.0.1:3306/fooddb?serverTimezone=UTC", "root","s8511730"); // JDBC 연결, password는 root 계정 패스워드 입력
			System.out.println("DB 연결 완료");   
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성

//			ResultSet srs = stmt.executeQuery("select * from foodtable"); // 테이블의 모든 데이터 검색			
//			printData(srs, "food_id", "recipe_id", "recipe_name","recipe_ingredient","recipe_sequence");
//			
		} 
		catch (ClassNotFoundException e) {   
			System.out.println("JDBC 드라이버 로드 에러");  } 
		catch (SQLException e) {   
			System.out.println("SQL 실행 에러");  
		} 
	} // 레코드의 각 열의 값 화면에 출력  
//	private static void printData(  ResultSet srs, String col1, String col2, String col3,String col4,String col5) 
//			throws SQLException {  
//		while (srs.next()) {   
//				if (col1 != "")    
//					System.out.println(new String(srs.getString("food_id")));   
//				if (col2 != "")    
//					System.out.println(srs.getString("recipe_id"));   
//				if (col3 != "")    
//					System.out.println(new String(srs.getString("recipe_name"))); 
//				if (col4 != "")    
//					System.out.println(new String(srs.getString("recipe_ingredient"))); 
//				if (col5 != "")    
//					System.out.println(new String(srs.getString("recipe_sequence"))); 
//				else     System.out.println();  
//			} 
//	}
	public void exitDB() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public DBDTO search(int type,int cook){
		
		DBDTO dto = new DBDTO();
		
		String query;
		try {			
//			conn = DriverManager.getConnection(url,id,pass);
			switch(type) {
			case 0:
			if(cook==0)
				query = "select * from foodtable where food_id=0 AND recipe_id=0";
			else if(cook==1)
				query = "select * from foodtable where food_id=0 AND recipe_id=1";
			else if(cook==2)
				query = "select * from foodtable where food_id=0 AND recipe_id=2";
			else 
				query = "select * from foodtable where food_id=0 AND recipe_id=3";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setFood_id(rs.getInt("food_id"));
				dto.setRecipe_id(rs.getInt("recipe_id"));
				dto.setRecipe_name(rs.getString("recipe_name"));
				dto.setRecipe_ingredient(rs.getString("recipe_ingredient"));
				dto.setRecipe_sequence(rs.getString("recipe_sequence"));
				dto.setRecipe_image(rs.getString("recipe_image"));
			}
			break;
			case 1:
				if(cook==0)
					query = "select * from foodtable where food_id=1 AND recipe_id=0";
				else if(cook==1)
					query = "select * from foodtable where food_id=1 AND recipe_id=1";
				else if(cook==2)
					query = "select * from foodtable where food_id=1 AND recipe_id=2";
				else if(cook==3)
					query = "select * from foodtable where food_id=1 AND recipe_id=3";
				else
					query = "select * from foodtable where food_id=1 AND recipe_id=4";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					dto.setFood_id(rs.getInt("food_id"));
					dto.setRecipe_id(rs.getInt("recipe_id"));
					dto.setRecipe_name(rs.getString("recipe_name"));
					dto.setRecipe_ingredient(rs.getString("recipe_ingredient"));
					dto.setRecipe_sequence(rs.getString("recipe_sequence"));
					dto.setRecipe_image(rs.getString("recipe_image"));
				}
				break;
			case 2:
				if(cook==0)
					query = "select * from foodtable where food_id=2 AND recipe_id=0";
				else if(cook==1)
					query = "select * from foodtable where food_id=2 AND recipe_id=1";
				else if(cook==2)
					query = "select * from foodtable where food_id=2 AND recipe_id=2";
				else if(cook==3)
					query = "select * from foodtable where food_id=2 AND recipe_id=3";
				else
					query = "select * from foodtable where food_id=2 AND recipe_id=4";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					dto.setFood_id(rs.getInt("food_id"));
					dto.setRecipe_id(rs.getInt("recipe_id"));
					dto.setRecipe_name(rs.getString("recipe_name"));
					dto.setRecipe_ingredient(rs.getString("recipe_ingredient"));
					dto.setRecipe_sequence(rs.getString("recipe_sequence"));
					dto.setRecipe_image(rs.getString("recipe_image"));
				}
				break;
			case 3:
				if(cook==0)
					query = "select * from foodtable where food_id=3 AND recipe_id=0";
				else if(cook==1)
					query = "select * from foodtable where food_id=3 AND recipe_id=1";
				else if(cook==2)
					query = "select * from foodtable where food_id=3 AND recipe_id=2";
				else if(cook==3)
					query = "select * from foodtable where food_id=3 AND recipe_id=3";
				else
					query = "select * from foodtable where food_id=3 AND recipe_id=4";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					dto.setFood_id(rs.getInt("food_id"));
					dto.setRecipe_id(rs.getInt("recipe_id"));
					dto.setRecipe_name(rs.getString("recipe_name"));
					dto.setRecipe_ingredient(rs.getString("recipe_ingredient"));
					dto.setRecipe_sequence(rs.getString("recipe_sequence"));
					dto.setRecipe_image(rs.getString("recipe_image"));
				}
				break;
			case 4:
				if(cook==0)
					query = "select * from foodtable where food_id=4 AND recipe_id=0";
				else if(cook==1)
					query = "select * from foodtable where food_id=4 AND recipe_id=1";
				else if(cook==2)
					query = "select * from foodtable where food_id=4 AND recipe_id=2";
				else if(cook==3)
					query = "select * from foodtable where food_id=4 AND recipe_id=3";
				else
					query = "select * from foodtable where food_id=4 AND recipe_id=4";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					dto.setFood_id(rs.getInt("food_id"));
					dto.setRecipe_id(rs.getInt("recipe_id"));
					dto.setRecipe_name(rs.getString("recipe_name"));
					dto.setRecipe_ingredient(rs.getString("recipe_ingredient"));
					dto.setRecipe_sequence(rs.getString("recipe_sequence"));
					dto.setRecipe_image(rs.getString("recipe_image"));
				}
				break;
			case 5:
				if(cook==0)
					query = "select * from foodtable where food_id=5 AND recipe_id=0";
				else if(cook==1)
					query = "select * from foodtable where food_id=5 AND recipe_id=1";
				else if(cook==2)
					query = "select * from foodtable where food_id=5 AND recipe_id=2";
				else if(cook==3)
					query = "select * from foodtable where food_id=5 AND recipe_id=3";
				else
					query = "select * from foodtable where food_id=5 AND recipe_id=4";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					dto.setFood_id(rs.getInt("food_id"));
					dto.setRecipe_id(rs.getInt("recipe_id"));
					dto.setRecipe_name(rs.getString("recipe_name"));
					dto.setRecipe_ingredient(rs.getString("recipe_ingredient"));
					dto.setRecipe_sequence(rs.getString("recipe_sequence"));
					dto.setRecipe_image(rs.getString("recipe_image"));
				}
				break;
				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return dto;
	}
}
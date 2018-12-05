package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import application.MemberController;

public class MemberController {

	
    @FXML private Button cancelBtn;
    @FXML private TextField name;
    @FXML private TextField id;
    @FXML private PasswordField pwd;
    @FXML private Button saveBtn;

    public void initialize(URL location, ResourceBundle resources) {
		cancelBtn.setOnAction(e->cancelAction(e));
		//membersBtn.setOnAction(e->membersAction(e));
	}
	 @FXML
	 public void cancelAction(ActionEvent event) {
	    try{
	    		Parent login = FXMLLoader.load(getClass().getResource("Mypage_login.fxml"));
	    		Scene scene=new Scene(login);
	    		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	    		stage.setScene(scene);
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    }
	@FXML
	public void saveAction(ActionEvent event){
	
		String tId = id.getText();
		String tName = name.getText();	    
	    String tPwd = pwd.getText(); 
	    
	    System.out.println(tId);//
	    System.out.println(tName);//
	    System.out.println(tPwd);//
	 // MySQL 접속 경로, 기본 포트는 3306, DB명 
		  String jdbcUrl = "jdbc:mysql://localhost:3306/java";/////
		  // MySQL 계정
		  //String dbId = "root";
		  // MySQL 계정 비밀번호
		  //String dbPw = "082100";	  
		  Connection con = null;
		  PreparedStatement pst = null;
		  
		  String sql = "";
		  //int num = 0;
		  new MemberController();
		 
		  String id = tId;
		  String name = tName;
		  String pwd = tPwd;
		  
		  try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   // 디비 연결
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java?serverTimezone=UTC&useSSL=false","root","082100");//비번추가해야됨
           //jdbc:mysql://localhost:3306/java?serverTimezone=UTC&useSSL=false
        	   //jdbc:mysql://54.180.119.81:3306/myimages?serverTimezone=UTC&useSSL=false
		     sql = "insert into member2 values(?,?,?)";
		     pst = con.prepareStatement(sql);
	
		     pst.setString(1, id);
		     pst.setString(2, name);
		     pst.setString(3, pwd);
		     pst.executeUpdate();	
		     //try{
		 		Parent main = FXMLLoader.load(getClass().getResource("Mypage_login.fxml"));
		 		Scene mainscene=new Scene(main);
		 		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		 		stage.setScene(mainscene);
		 		
		 		//}
		  //catch(Exception e){
		 			//e.printStackTrace();
		 		//}
		 		
		       
		     }
	 catch (Exception e) {
		   e.printStackTrace();
		  } finally{
		   if(pst!=null) try{pst.close();}catch(SQLException ex){}
		   if(con!=null) try{con.close();}catch(SQLException ex){}
		  }
		  //StackPane root = (StackPane) cancelBtn.getScene().getRoot();
			//root.getChildren().remove(login);
			
	
	}
}

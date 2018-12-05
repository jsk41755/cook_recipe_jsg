package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
	Connection con;
	 PreparedStatement pst;
	 ResultSet rs;
	 @FXML
		Button loginBtn;
		@FXML
		Button membersBtn;
		@FXML
		Button cancelBtn;
		@FXML
		TextField id;
		@FXML
	    PasswordField pwd; 
		@FXML
	    public void cancelAction(ActionEvent event) {
	    	try{
	    		Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));
	    		Scene mainscene=new Scene(main);
	    		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	    		stage.setScene(mainscene);
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    }
		@FXML
		public void membersAction(ActionEvent event){
			try{
			Parent members = FXMLLoader.load(getClass().getResource("Member.fxml"));
//			StackPane root = (StackPane) membersBtn.getScene().getRoot();
//			root.getChildren().add(members);
			Scene scene=new Scene(members);
			Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		@FXML
		 public void Login(ActionEvent event){
			 //public Boolean checkLogin(String ID,String Pwd)
			  //  {
			        try {
			        	//Integer i;
			        	//i = new Integer(0);
			        	
			        	String uId = id.getText();    
			    	    String uPwd = pwd.getText(); 
			    	    
			    	    System.out.println(uId);//
			    	    System.out.println(uPwd);//
			    	    
			    	   // System.out.println(i);//
			    	    
			    	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java?serverTimezone=UTC&useSSL=false","root","082100");//비번추가해야됨
			            pst=con.prepareStatement("select * from member2 where ID=? and Password=?");   
			            //System.out.println(i);//
			            pst.setString(1, uId); //this replaces the 1st  "?" in the query for username
			            //System.out.println(i);//
			            pst.setString(2, uPwd);    //this replaces the 2st  "?" in the query for password
			            //executes the prepared statement
			            //System.out.println(i);//
			            
			       
			            rs=pst.executeQuery();
			            
			            //System.out.println(i);//
			            if(rs.next())
			            {
			            	Parent members = FXMLLoader.load(getClass().getResource("Main.fxml"));
			        		Scene scene=new Scene(members);
			        		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			        		stage.setScene(scene);
			                //TRUE iff the query founds any corresponding data
			                //return true;
			            }
			            else
			            {
			            	Parent members = FXMLLoader.load(getClass().getResource("Mypage_login.fxml"));
			        		Scene scene=new Scene(members);
			        		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			        		stage.setScene(scene);
			                //return false;
			            }
			        } catch (Exception e) {
			            // TODO Auto-generated catch block
			            //System.out.println("error while validating"+e);
			            //return false;
			        	e.printStackTrace();
			        }
			    //}
		}
}

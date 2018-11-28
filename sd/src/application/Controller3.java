package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller3 {
	@FXML
	private Label recipe;
	@FXML
	private GridPane grid;
	void initData(int row,int column) {
		System.out.println(row+" and "+column);

		if(row==0) {
			switch(column) {
			case 0:
				recipe.setText("한식");
				break;
			case 1:
				recipe.setText("중식");
				System.out.println("z");
				break;
			case 2:
				recipe.setText("일식");
				break;
			case 3:
				recipe.setText("양식");
				break;      
			}
		}
		else if(row==1) {
			switch(column) {
			case 0:
				recipe.setText("분식");
				break;
			case 1:
				recipe.setText("야식");
				break;
			case 2:
				recipe.setText("랜덤");
				break;
			case 3:
				recipe.setText("ㅋ");
				break;      
			}
		}           
	}
	@FXML
    private void clickBackFood(MouseEvent event) {
        try {
            Parent mainmenu = FXMLLoader.load(getClass().getResource("Food.fxml"));
            Scene scene = new Scene(mainmenu);

            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

            primaryStage.setScene(scene);
            primaryStage.setTitle("recipe");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

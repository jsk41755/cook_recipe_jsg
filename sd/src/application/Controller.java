package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
	@FXML
	private void clickmainmenu(MouseEvent event) {
		
			try {
				Parent koreanfood = FXMLLoader.load(getClass().getResource("koreanfood.fxml"));
			    Scene scene = new Scene(koreanfood);

			    Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

			    primaryStage.setScene(scene);
			    primaryStage.setTitle("recipe");
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	@FXML
	private void clickfoodmenu(MouseEvent event) {
		try {
			Parent cookingrecipe = FXMLLoader.load(getClass().getResource("cookingrecipe.fxml"));
		    Scene scene = new Scene(cookingrecipe);

		    Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

		    primaryStage.setScene(scene);
		    primaryStage.setTitle("recipe");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

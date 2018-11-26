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

public class Controller {
	private static int toIndex(Integer value) {
	    return value == null ? 0 : value;
	}
    @FXML
    private Label food;
    @FXML
    private GridPane grid;
    @FXML
    private void clickmainmenu(MouseEvent event) {

        try {
            Parent koreanfood = FXMLLoader.load(getClass().getResource("koreanfood.fxml"));
            Scene scene = new Scene(koreanfood);
            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

            Node node = (Node) event.getSource();
            Parent p = node.getParent();

            while (p != grid) {
                node = p;
                p = p.getParent();
            }

            int row = toIndex(GridPane.getRowIndex(node));
            int column = toIndex(GridPane.getColumnIndex(node));
            System.out.println("r : "+row+" c : "+column);
            primaryStage.setScene(scene);
            primaryStage.setTitle("recipe");
            if(row==0) {
                switch(column) {
                case 0:
                    food.setText("한식");
                    break;
                case 1:
                    food.setText("중식");
                    break;
                case 2:
                    food.setText("일식");
                    break;
                case 3:
                    food.setText("양식");
                    break;      
                }
            }
            else if(row==1) {
                switch(column) {
                case 0:
                    food.setText("분식");
                    break;
                case 1:
                    food.setText("야식");
                    break;
                case 2:
                    food.setText("랜덤");
                    break;
                case 3:
                    food.setText("ㅋ");
                    break;      
                }
            }           
            
            
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
    @FXML
    private void clickBackMain(MouseEvent event) {
        try {
            Parent koreanfood = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
            Scene scene = new Scene(koreanfood);

            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

            primaryStage.setScene(scene);
            primaryStage.setTitle("recipe");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void clickBackKor(MouseEvent event) {
        try {
            Parent mainmenu = FXMLLoader.load(getClass().getResource("koreanfood.fxml"));
            Scene scene = new Scene(mainmenu);

            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

            primaryStage.setScene(scene);
            primaryStage.setTitle("recipe");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
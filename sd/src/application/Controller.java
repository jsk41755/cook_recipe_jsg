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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Food.fxml"));
			Parent food=loader.load();
			Scene scene = new Scene(food);
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

			Controller2 controller2 = 
					loader.getController();
			
			DBDAO dao = new DBDAO();
			DBDTO dto[]=new DBDTO[4];
			for(int i=0;i<4;i++)
				dto[i]=dao.search(row+column, i);//type,cook

			dao.exitDB();
			if(row==1&&column==2)
				System.out.println("랜덤");
			else if(row==1&&column==3)
				System.out.println("나만의 레시피");
			else
				controller2.initData(row,column,dto);           

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	//    @FXML
	//    private void clickfoodmenu(MouseEvent event) {
	//        try {
	//            Parent cookingrecipe = FXMLLoader.load(getClass().getResource("cookingrecipe.fxml"));
	//            Scene scene = new Scene(cookingrecipe);
	//
	//            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
	//
	//            primaryStage.setScene(scene);
	//            primaryStage.setTitle("recipe");
	//        } catch(Exception e) {
	//            e.printStackTrace();
	//        }
	//    }
	//    @FXML
	//    private void clickBackMain(MouseEvent event) {
	//        try {
	//            Parent koreanfood = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
	//            Scene scene = new Scene(koreanfood);
	//
	//            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
	//
	//            primaryStage.setScene(scene);
	//            primaryStage.setTitle("recipe");
	//        } catch(Exception e) {
	//            e.printStackTrace();
	//        }
	//    }
	//    @FXML
	//    private void clickBackKor(MouseEvent event) {
	//        try {
	//            Parent mainmenu = FXMLLoader.load(getClass().getResource("koreanfood.fxml"));
	//            Scene scene = new Scene(mainmenu);
	//
	//            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
	//
	//            primaryStage.setScene(scene);
	//            primaryStage.setTitle("recipe");
	//        } catch(Exception e) {
	//            e.printStackTrace();
	//        }
	//    }
}
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
			Node node = (Node) event.getSource();
			Parent p = node.getParent();

			while (p != grid) {
				node = p;
				p = p.getParent();
			}

			int row = toIndex(GridPane.getRowIndex(node));
			int column = toIndex(GridPane.getColumnIndex(node));
			System.out.println("r : "+row+" c : "+column);

			if(row*2+column<6) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Food.fxml"));
				Parent food=loader.load();
				Scene scene = new Scene(food);
				Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
				DBDAO dao = new DBDAO();
				DBDTO dto[]=new DBDTO[4];
				for(int i=0;i<4;i++)
					dto[i]=dao.search(row*2+column, i);//type,cook
				for(int i=0;i<4;i++)
					System.out.println(dto[i].getRecipe_name());
				primaryStage.setScene(scene);
				primaryStage.setTitle("recipe");

				Controller2 controller2 = 
						loader.getController();
				dao.exitDB();
				controller2.initData(row,column,dto);

			}				

			else if(row==3&&column==0) {
				System.out.println("����");
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Random.fxml"));
				Parent Random=loader.load();
				Scene scene = new Scene(Random);
				Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
				
				primaryStage.setScene(scene);
				primaryStage.setTitle("recipe");

			}
			else if(row==3&&column==1)
				System.out.println("������ ������");



		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void clickmypage(MouseEvent event) {
		try {
			Parent members = FXMLLoader.load(getClass().getResource("Mypage_login.fxml"));
			Scene scene=new Scene(members);
			Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class Rand_Controller implements Initializable{
	@FXML
	private Button rand_button;
	@FXML 
	private TextArea ingredient;
	@FXML
	private TextArea order;
	@FXML
	private ImageView recipeimage;
	@FXML
	private Label recipename;
	
	private int rand_food_id = 0;
	private int rand_recipe_id = 0;

	public void rand_button(ActionEvent event) throws Exception{
		double randomValue = Math.random();
		rand_food_id = (int)(randomValue * 5);
		rand_recipe_id = (int)(randomValue * 4);
		DBDAO dao = new DBDAO();
		DBDTO dto = new DBDTO();
		dto=dao.search(rand_food_id,rand_recipe_id);
		initData(rand_food_id,rand_recipe_id,dto);
		//DBDTO dto[]=new DBDTO[4];
	}
        
	/*void initData(DBDTO dto[]) {
		Statement stmt; 
		String query;
		query = "select * from foodtable where food_id= rand_food_id AND recipe_id=rand_recipe_id";
		
	}*/
	void initData(int foodid,int recipeid,DBDTO dto) {
				
		Image img;
		img = new Image(getClass().getResourceAsStream(dto.getRecipe_image()));
		recipeimage.setImage(img);
		recipename.setWrapText(true);
		recipename.setText(dto.getRecipe_name());
		recipename.setAlignment(Pos.CENTER);
		img = new Image(getClass().getResourceAsStream(dto.getRecipe_image()));
		ingredient.setWrapText(true);
		ingredient.setText(dto.getRecipe_ingredient());
		order.setWrapText(true);
		order.setText(dto.getRecipe_sequence());	
	
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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}

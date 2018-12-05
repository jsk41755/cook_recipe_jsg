package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller3 {
	@FXML
	private Label recipe;
	@FXML
	private TextArea ingredient;
	@FXML
	private TextArea order;
	@FXML
	private ImageView recipeimage;
	int n;
	
	void initRecipe(DBDTO dto,int n) {
//	void initRecipe(int type,int cook) {
//		System.out.println(type+" and "+cook);
//		if(type==1) {
//			switch(cook) {
//			case 0:
		this.n=n;
				recipe.setWrapText(true);
				ingredient.setWrapText(true); 
				order.setWrapText(true);
				recipe.setText(dto.getRecipe_name());
				ingredient.setText(dto.getRecipe_ingredient());
				order.setText(dto.getRecipe_sequence());
				Image img = new Image(getClass().getResourceAsStream(dto.getRecipe_image()));
				recipeimage.setImage(img);
//				recipe.setText("¸Å¿î»ï°ã»ì µ·ÄÚÃ÷¶ó¸à");
//				ingredient.setText("´ëÆÄ 10cm, ¼÷ÁÖ 1ÁÜ, »îÀº´Þ°¿ 1/2°³, »ï°ã»ì 1ÁÙ, µ·ÄÚÃ÷¶ó¸à 1ºÀ,°£Àå 1¼ù°¡¶ô, ¿Ã¸®°í´ç 1/2¼ù°¡¶ô, ¸À¼ú 1¼ù°¡¶ô, ¹° 1¼ù°¡¶ô,´ëÆÄ 10cm, ¼÷ÁÖ 1ÁÜ, »îÀº´Þ°¿ 1/2°³");
//				order.setText("1. »ï°ã»ìÀº ¿¹¿­µÈ ÆÒ¿¡ ³ë¸©ÇÏ°Ô ±Á´Â´Ù.\n"+
//						"2. ±¸¿î »ï°ã¿¡ ¼Ò½º Àç·á¸¦ ³Ö¾î Á¶¸°´Ù.\n"+
//						"3. ²ú´Â ¹°¿¡ ¶ó¸éÀ» ³Ö¾î ¸éÀ» 3ºÐ 30ÃÊ°£ ²úÀÎ´Ù.\n"+
//						"4. ¸éÀÌ »î¾ÆÁö¸é ºÒÀ» ²ô°í ¾×»ó½ºÇÁ¸¦ ³Ö°í ÆÄ°Ç´õ±âµµ °°ÀÌ ³Ö´Â´Ù.\n"+
//						"5. ¶ó¸é À§¿¡ ¼÷ÁÖ, ´ëÆÄ, »ï°ã»ì, »îÀº ´Þ°¿À»¿Ã·Á ¿Ï¼ºÇÑ´Ù.");
//			}
		}

	@FXML
    private void clickBackFood(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Food.fxml"));
			Parent food=loader.load();
			Scene scene = new Scene(food);
			Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

			primaryStage.setScene(scene);
			primaryStage.setTitle("recipe");

			Controller2 controller2 = 
					loader.getController();
			
			DBDAO dao = new DBDAO();
			DBDTO dto[]=new DBDTO[4];
			for(int i=0;i<4;i++)
				dto[i]=dao.search(n, i);//type,cook
			int row=n/2;
			int column=n%2;
			dao.exitDB();
			if(row==0&&column==3)
				System.out.println("·£´ý");
			else if(row==1&&column==3)
				System.out.println("³ª¸¸ÀÇ ·¹½ÃÇÇ");
			else
				controller2.initData(row,column,dto);           

		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}

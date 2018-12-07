package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.stage.WindowEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller3 {
	@FXML
	private Label recipe;
	@FXML
	private TextArea ingredient;
	@FXML
	private TextArea order;
	@FXML
	private ImageView recipeimage;
	@FXML
    private Label text;
	
	@FXML
	private Button timerset;
	
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
//				recipe.setText("�ſ���� ���������");
//				ingredient.setText("���� 10cm, ���� 1��, �����ް� 1/2��, ���� 1��, ��������� 1��,���� 1������, �ø���� 1/2������, ���� 1������, �� 1������,���� 10cm, ���� 1��, �����ް� 1/2��");
//				order.setText("1. ������ ������ �ҿ� �븩�ϰ� ���´�.\n"+
//						"2. ���� ��㿡 �ҽ� ��Ḧ �־� ������.\n"+
//						"3. ���� ���� ����� �־� ���� 3�� 30�ʰ� ���δ�.\n"+
//						"4. ���� ������� ���� ���� �׻����� �ְ� �İǴ��⵵ ���� �ִ´�.\n"+
//						"5. ��� ���� ����, ����, ����, ���� �ް����÷� �ϼ��Ѵ�.");
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
				System.out.println("����");
			else if(row==1&&column==3)
				System.out.println("������ ������");
			else
				controller2.initData(row,column,dto);           

		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	public void timerset(ActionEvent event) throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/application/timer.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
             public void handle(WindowEvent event) {
                 CountDownTimer.getTimer().stop();
             }
          });
  	
  		text = (Label) root.lookup("#text");
  	       text.setText("00:00");
  	      CountDownTimer.getTimer().setLabel(text);
}
}

package view;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	
	private double minWidth = 1000;
	private double minHeight = 500;

	@Override
	public void start(Stage primaryStage) {
		
		// login page
		primaryStage.setTitle("BE-WEAVE");
		BorderPane border = new BorderPane();
		//GridPane grid = new GridPane();
		LoginPane login = new LoginPane();
		EventsPane events = new EventsPane();
//		//grid.setMinHeight(minHeight);
//		grid.setAlignment(Pos.CENTER);
//		grid.setHgap(10);
//		//grid.setPadding(new Insets(25, 25, 25, 25));
//		
//		// homepage
//		GridPane homePage = new GridPane();
//		homePage.setMinHeight(minHeight);
//		homePage.setAlignment(Pos.TOP_CENTER);
//		homePage.setHgap(10);
//		//homePage.setPadding(new Insets(25, 25, 25, 25));
//		
//		// log in text
//		Text scenetitle = new Text("BE WE-ave");
//		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//		grid.add(scenetitle, 0, 0, 2, 1);
//		
//		// temporary homepage text
//		Text scenetitle2 = new Text("Under Construction");
//		scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//		homePage.add(scenetitle2, 0, 0, 2, 1);
//
//		// user name text field
//		Label userName = new Label("User Name:");
//		grid.add(userName, 0, 1);
//
//		TextField userTextField = new TextField();
//		grid.add(userTextField, 1, 1);
//
//		// password text field
//		Label pw = new Label("Password:");
//		grid.add(pw, 0, 2);
//
//		PasswordField pwBox = new PasswordField();
//		grid.add(pwBox, 1, 2);
//		
//		Button btn = new Button("Sign in");
//		HBox hbBtn = new HBox(10);
//		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//		hbBtn.getChildren().add(btn);
//		grid.add(hbBtn, 1, 4);
//		
//		// action for sign in button
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//        	 
//            @Override
//            public void handle(ActionEvent e) {
//            	
//            	primaryStage.setMinHeight(minHeight);
//            	primaryStage.setMinWidth(minWidth);
//            	primaryStage.centerOnScreen();
// 
//                border.setCenter(events);
//                border.setRight(login);
//            }
//        });
		
		//border.setCenter(login);
        border.setCenter(events);
        border.setRight(login);
        //border.setPadding(new Insets(25, 25, 25, 25));
    	//border.setMargin(login, new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(border, 1000, 500);
		
    	//primaryStage.setMinHeight(minHeight);
    	//primaryStage.setMinWidth(minWidth);
    	primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
    	primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

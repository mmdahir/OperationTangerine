package view;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


public class Main extends Application {
	
	private double minWidth = 1000;
	private double minHeight = 500;

	@Override
	public void start(Stage primaryStage) {
		
		// login page
		primaryStage.setTitle("BE-WEAVE");
		
		BorderPane border = new BorderPane();
		LoginPane login = new LoginPane();
		EventsPane events = new EventsPane();
		
		login.myUserProp.addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

	            events.setUser(login.getCurrUser());
			}});
			
		Label titleLabel = new Label("BE-WEAVE");
		
		titleLabel.setFont(new Font("Tahoma", 40));
		titleLabel.setTextAlignment(TextAlignment.CENTER);
		
        border.setRight(login);
        border.setCenter(events);
        
        Scene scene = new Scene(border, minWidth, minHeight);
		
    	primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
    	primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

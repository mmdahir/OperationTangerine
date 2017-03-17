package view;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import model.User;
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
	            System.out.println("fired " + arg0.getValue());
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

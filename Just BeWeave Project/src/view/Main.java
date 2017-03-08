package view;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
		primaryStage.setTitle("BE WE-ave");
		BorderPane border = new BorderPane();
		
		GridPane grid = new LoginPane();
		GridPane events = new EventsPane();
		
		// Application name
		GridPane homePage = new GridPane();
		homePage.setAlignment(Pos.CENTER);
		homePage.setHgap(10);
		homePage.setPadding(new Insets(25, 25, 25, 25));
		
		
		// temporary homepage text
		Text scenetitle2 = new Text("BE WE-ave Home Page");
		scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		homePage.add(scenetitle2, 0, 0, 2, 1);

        
        
        
      
        border.setLeft(events);
		border.setTop(homePage);
		border.setRight(grid);
		Scene scene = new Scene(border, 500, 275);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

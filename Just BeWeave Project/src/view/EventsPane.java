package view;

import java.io.IOException;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.DataBase;
import model.Event;

public class EventsPane extends VBox { 
	
private double minWidth = 750;
private double minHeight = 500;

{
	Label title = new Label("Upcoming Events");
	
	title.setFont(new Font("Cooper Black", 30));
	//title.setTextFill(Color.BLACK);
	
	this.setAlignment(Pos.TOP_CENTER);
	this.setMinSize(minWidth, minHeight);
	this.setPadding(new Insets(25, 25, 25, 25));
	this.getChildren().addAll(title, addScrollBox());
}

public ScrollPane addScrollBox() {
	
    final VBox vbox = new VBox();
    final DropShadow shadow = new DropShadow();
    final ScrollPane scrollPane = new ScrollPane();
    
    scrollPane.setContent(vbox);
    scrollPane.setMinSize(715, 400);
    scrollPane.setStyle("-fx-background-insets:3;");

    fillBox(vbox);

    shadow.setColor(Color.BLUE);
    shadow.setOffsetX(10);
    shadow.setOffsetY(8);
    
    vbox.setLayoutX(5);
    vbox.setSpacing(10);
    vbox.setMinWidth(700);
    vbox.setMinHeight(1000);
    vbox.setAlignment(Pos.TOP_LEFT);
	vbox.setStyle("-fx-padding: 10;" + 
                  "-fx-border-width: 3;" +
                  "-fx-border-insets: 5;" + 
                  "-fx-border-radius: 20;" + 
                  "-fx-border-color: blue;");
    
    //LIGHT GREY #CCCCCC
    //LIGHT BLUE #B0C4DE
    //DARK BLUE #003366
    //ORANGE #EB5A11

    return scrollPane;
}

public void fillBox(VBox box) {
	
    List<Event> eventList = null;
    
	try {
		eventList = DataBase.getEvents();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    for(Event event: eventList) {
    	
    	Label eventLabel = new Label(event.getTitle());
    	eventLabel.setFont(new Font("Arial Bold", 20));
    	//eventLabel.setTextFill(Color.BLACK);
    	box.getChildren().add(eventLabel);
    	//box.setBorder(arg0);
    }
}
}

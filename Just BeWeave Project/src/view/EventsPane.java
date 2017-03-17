package view;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import model.DataBase;
import model.Event;

public class EventsPane extends VBox { 
	
//Width of the Pane.
private double minWidth = 750;

//Height if the Pane.
private double minHeight = 500;

//Color of the Text in this Pane.
private Paint textColor = Color.BLACK;

//Color of the background on this pane.
private Paint backgroundColor = Color.WHITE;

{
	setup();
}
	
public void setup() {
	
	Label title = new Label("Upcoming Events");
	
	title.setTextFill(textColor);
	title.setFont(new Font("Cooper Black", 30));
	
	this.setStyle(null);
	this.getChildren().clear();
	this.setAlignment(Pos.TOP_CENTER);
	this.setMinSize(minWidth, minHeight);
	this.setPadding(new Insets(25, 25, 25, 25));
	this.getChildren().addAll(title, addScrollBox());
	this.setBackground(new Background(new BackgroundFill(backgroundColor, null, null)));
}

public ScrollPane addScrollBox() {
	
    final VBox vbox = new VBox();
    final ScrollPane scrollPane = new ScrollPane();
 
    fillScrollBox(vbox);
    
    scrollPane.setContent(vbox);
    scrollPane.setMinSize(715, 400);
    scrollPane.setStyle("-fx-background-insets:3;" +
    		            "-fx-background: white;");
    
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

public void fillScrollBox(VBox box) {
	
    List<Event> eventList = null;
    
	try {
		eventList = DataBase.getEvents();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    for(Event event: eventList) {
    	
    	Hyperlink eventLabel = new Hyperlink(event.getTitle());
    	
    	eventLabel.setTextFill(textColor);
    	eventLabel.setFont(new Font("Arial Bold", 20));
    	
    	eventLabel.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent e) {
    	        displayEvent(event);
    	    }
    	});
    	
    	box.getChildren().add(eventLabel);
    }
}

public void displayEvent(Event event) {
	
    final Button back = new Button("Back");
	final Label eventTitle = new Label(event.getTitle());
	final Label eventDate = new Label(event.getDate().toString());
	final Label eventDescript = new Label(event.getDescription());

	eventTitle.setTextFill(textColor);
	eventTitle.setFont(new Font("Cooper Black", 30));
	
	eventDate.setTextFill(textColor);
	eventDate.setFont(new Font("Arial Bold", 20));
	
	eventDescript.setTextFill(textColor);
	eventDescript.setFont(new Font("Arial Bold", 20));
    
	back.setOnAction(new EventHandler<ActionEvent>() {
   	 
        @Override
        public void handle(ActionEvent e) {
        	setup();
        }
	});    
	
    this.setSpacing(10);
	this.getChildren().clear();
	this.getChildren().addAll(eventTitle, eventDate, eventDescript, back);
	this.setStyle("-fx-padding: 15;" + 
                  "-fx-border-width: 3;" +
                  "-fx-border-insets: 25;" + 
                  "-fx-border-radius: 20;" + 
                  "-fx-border-color: blue;");
}
}

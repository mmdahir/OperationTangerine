package view;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import model.AbstractUser;
import model.DataBase;
import model.Event;
import model.NonAdmin;
import model.User;

public class EventsPane extends VBox { 
	
	private User myUser;
	
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
	
	public void setUser(User theUser) {
		
		this.myUser = theUser;
	}
	
	public ScrollPane addScrollBox() {
		
	    final VBox eventsBox = new VBox();
	    final ScrollPane scrollPane = new ScrollPane();
	 
	    fillScrollBox(eventsBox);
	    
	    scrollPane.setContent(eventsBox);
	    scrollPane.setMinSize(715, 400);
	    scrollPane.setStyle("-fx-background-insets:3;" +
	    		            "-fx-background: white;");
	    
	    eventsBox.setLayoutX(5);
	    eventsBox.setSpacing(10);
	    eventsBox.setMinWidth(700);
	    eventsBox.setMinHeight(1000);
	    eventsBox.setAlignment(Pos.TOP_LEFT);
		eventsBox.setStyle("-fx-padding: 10;" + 
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
		
		final Label eventTitle = new Label(event.getTitle());
		final Label eventDate = new Label(event.getDate().toString());
		final Label eventDescript = new Label(event.getDescription());
	
		eventDate.setTextFill(textColor);
		eventDate.setFont(new Font("Arial Bold", 20));
		
		eventTitle.setTextFill(textColor);
		eventTitle.setFont(new Font("Cooper Black", 30));
		
		eventDescript.setTextFill(textColor);
		eventDescript.setFont(new Font("Arial Bold", 20));
		
	    this.setSpacing(10);
		this.getChildren().clear();
		this.getChildren().addAll(eventTitle, eventDate, eventDescript, buttonBox(event));
		this.setStyle("-fx-padding: 15;" + 
	                  "-fx-border-width: 3;" +
	                  "-fx-border-insets: 25;" + 
	                  "-fx-border-radius: 20;" + 
	                  "-fx-border-color: blue;");
	}
	
	public HBox buttonBox(Event event) {
		
		final HBox box = new HBox();
	    final Button back = new Button("Back");
	    final Button register = new Button("Register");
		
	    
	    back.setMinWidth(75);    
		back.setOnAction(new EventHandler<ActionEvent>() {
		   	 
	        @Override
	        public void handle(ActionEvent e) {
	        	setup();
	        }
		});
		
	    register.setMinWidth(75);
		register.setOnAction(new EventHandler<ActionEvent>() {
		   	 
	        @Override
	        public void handle(ActionEvent e) {
	        	
	        	event.addUser(myUser);
	            ((NonAdmin) myUser).addEvent(event);
	        	//LoginPane.
	        	setup();
	        }
		});
		
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(register, back);
		
		return box;
	}
	
}

package view;

import java.awt.ScrollPane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.event.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
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
//	title.setTextFill(Color.GREY);
//	title.setBackground(new Background(new BackgroundFill(Color.ORANGERED, 
//			                           new CornerRadii(10), 
//			                           new Insets(0, -235, 0, -235))));
	
	System.out.println(title.getFont().getName());
	
	this.setAlignment(Pos.TOP_CENTER);
	this.setMinSize(minWidth, minHeight);
	this.setPadding(new Insets(25, 25, 25, 25));
	this.getChildren().addAll(title, addScrollBox());
	//this.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
}

public Group addScrollBox() {
	
	Group root = new Group();
    final VBox vbox = new VBox();
    final ScrollBar scroll = new ScrollBar();
    final DropShadow shadow = new DropShadow();
    final Scene scene = new Scene(vbox, 180, 180);
    
    root.getChildren().addAll(vbox);

    fillBox(vbox);
    //this.getChildren().add(scroll);

    vbox.setAlignment(Pos.TOP_LEFT);
    vbox.setMinHeight(400);
    //vbox.getChildren().add(scroll);
    //vbox.setStyle("-fx-background-color: #EB5A11;");
	vbox.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 2;" +
                  "-fx-border-insets: 5;" + 
                  "-fx-border-radius: 5;" + 
                  "-fx-border-color: blue;");
    
    //LIGHT GREY #CCCCCC
    //LIGHT BLUE #B0C4DE
    //DARK BLUE #003366
    //ORANGE #EB5A11

    shadow.setColor(Color.ORANGERED);
    shadow.setOffsetX(2);
    shadow.setOffsetY(2);

    vbox.setLayoutX(5);
    vbox.setSpacing(10);
    vbox.setMinWidth(700);

    scroll.setLayoutX(this.getWidth()-scroll.getWidth());
    scroll.setOrientation(Orientation.VERTICAL);
    scroll.setPrefHeight(425);
    scroll.setEffect(shadow);
    scroll.setMax(500);
    scroll.setMin(0);
    
//    scroll.valueProperty().addListener(new ChangeListener<Number>() {
//        public void changed(ObservableValue<? extends Number> ov,
//            Number old_val, Number new_val) {
//                vbox.setLayoutY(-new_val.doubleValue());
//            }
//    });

    return root;
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
    	eventLabel.setFont(new Font("Tahoma", 20));
    	box.getChildren().add(eventLabel);
    	//box.setBorder(arg0);
    }
}
}

package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
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

public class EventsPane extends VBox { 
	
private double minWidth = 750;
private double minHeight = 500;

{
	Label title = new Label("Upcoming Events");
	
	title.setFont(new Font("Arial", 30));
	//title.setTextFill(Color.GREY);
	//title.setBackground(new Background(new BackgroundFill(Color.ORANGERED, 
	//		                           new CornerRadii(10), 
	//		                           new Insets(0, -235, 0, -235))));
	
	System.out.println(title.getFont().getName());
	
	this.setAlignment(Pos.TOP_CENTER);
	this.setMinSize(minWidth, minHeight);
	this.setPadding(new Insets(25, 25, 25, 25));
	this.getChildren().addAll(title, addScrollBox());
	//this.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
}

public VBox addScrollBox() {
	
    final VBox vbox = new VBox();
    final ScrollBar scroll = new ScrollBar();
    final DropShadow shadow = new DropShadow();
    final Scene scene = new Scene(vbox, 180, 180);

    vbox.getChildren().add(scroll);
    vbox.setAlignment(Pos.BASELINE_RIGHT);
    vbox.setStyle("-fx-background-color: #EB5A11;");
    
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
    
    return vbox;
}
}

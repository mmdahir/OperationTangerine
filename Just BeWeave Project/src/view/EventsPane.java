package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EventsPane extends BorderPane { 
	
private double minWidth = 750;
private double minHeight = 500;

{
	this.setMinSize(minWidth, minHeight);
	//this.setAlignment(Pos.TOP_CENTER);
	//this.setHgap(10);
	this.setPadding(new Insets(25, 25, 25, 25));
	Text scenetitle = new Text("Upcoming Events");
	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
	this.setTop(scenetitle); //(scenetitle, 0, 0, 2, 1);
	this.setCenter(addScrollBox());

}

public VBox addVBox() {
    
	VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(8);

    Text title = new Text("Data");
    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    vbox.getChildren().add(title);

    Hyperlink options[] = new Hyperlink[] {
        new Hyperlink("Sales"),
        new Hyperlink("Marketing"),
        new Hyperlink("Distribution"),
        new Hyperlink("Costs")};

    for (int i=0; i<4; i++) {
        VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
        vbox.getChildren().add(options[i]);
    }

    return vbox;
}

public VBox addScrollBox() {
	
    final VBox vbox = new VBox();
    DropShadow shadow = new DropShadow();
    final ScrollBar scroll = new ScrollBar();
    
    //Group root = new Group();
    Scene scene = new Scene(vbox, 180, 180);
    //this.set(scene);

    vbox.setStyle("-fx-background-color: #B0C4DE;");
    vbox.getChildren().add(scroll);

    shadow.setColor(Color.GREY);
    shadow.setOffsetX(2);
    shadow.setOffsetY(2);

    vbox.setLayoutX(5);
    vbox.setSpacing(10);

    scroll.setLayoutX(this.getWidth()-scroll.getWidth());
    scroll.setMin(0);
    scroll.setOrientation(Orientation.VERTICAL);
    scroll.setPrefHeight(425);
    scroll.setMax(360);
    
    return vbox;
}
}

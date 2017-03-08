package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EventsPane extends GridPane { {
	this.setAlignment(Pos.TOP_CENTER);
	this.setHgap(10);
	this.setPadding(new Insets(25, 25, 25, 25));
	Text scenetitle = new Text("Upcoming Events");
	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	this.add(scenetitle, 0, 0, 2, 1);
	
}
}

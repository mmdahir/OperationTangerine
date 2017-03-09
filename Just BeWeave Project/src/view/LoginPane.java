package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginPane extends GridPane { {

	this.setAlignment(Pos.TOP_CENTER);
	this.setHgap(10);
	this.setPadding(new Insets(20, 0, 0, 0));
	this.setMinSize(250, 500);
	
	

	// user name text field
	Label userName = new Label("User Name:");
	this.add(userName, 0, 1);

	TextField userTextField = new TextField();
	this.add(userTextField, 1, 1);

	// password text field
	Label pw = new Label("Password:");
	this.add(pw, 0, 2);

	PasswordField pwBox = new PasswordField();
	this.add(pwBox, 1, 2);
	
	Button btn = new Button("Sign in");
	HBox hbBtn = new HBox(10);
	hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	hbBtn.getChildren().add(btn);
	this.add(hbBtn, 1, 4);
	
	// action for sign in button
    btn.setOnAction(new EventHandler<ActionEvent>() {
    	 
        @Override
        public void handle(ActionEvent e) {
        	
        	System.out.println("your user name: " + userTextField.getText());
        	System.out.println("your password: " + pwBox.getText());
        	getChildren().clear();
        	if(userTextField.getText().equals("john")) {
        		update(userTextField.getText(), true);
        	}else{
        		update(userTextField.getText(), false);
        	}
        		
        }
    });
}
    public void update(String theName, Boolean admin) {
    	
    	Text scenetitle = new Text(theName);
    	
    	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
    	
    	this.add(scenetitle, 1, 1, 1, 1);
    	
    	if (admin) {
    		
	    	Button btn2 = new Button("Edit events");
	    	HBox hbBtn2 = new HBox(10);
	    	hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
	    	hbBtn2.getChildren().add(btn2);
	    	this.add(hbBtn2, 1, 4);
	    	
	    	// action for sign in button
	        btn2.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	            	
	            	
	            }
	        });
    	
    	}
    	
    	else {
    		
    		Button btn2 = new Button("View your events");
	    	HBox hbBtn2 = new HBox(10);
	    	hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
	    	hbBtn2.getChildren().add(btn2);
	    	this.add(hbBtn2, 1, 4);
	    	
	    	// action for sign in button
	        btn2.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	            	
	            	
	            }
	        });
    	}
    
    
    }
}

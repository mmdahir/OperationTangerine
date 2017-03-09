package view;

import java.io.FileNotFoundException;
import java.io.IOException;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text; 

import model.AbstractUser;
import model.Admin;
import model.Date;
import model.DataBase;
import model.Event;
import model.NonAdmin;
import model.User;

/**
 * 
 * @author John
 *
 */
public class LoginPane extends GridPane {
	
	/** Data base used to access csv file. */
	private DataBase myDataBase = new DataBase();
	
	/** Current User. */
	private User myUser;
	
	/** Current User name. */
	private String myName;
	
	/** Current User passowrd. */
	private String myPass;
	
	{

	this.setAlignment(Pos.TOP_CENTER);
	this.setHgap(10);
	this.setPadding(new Insets(20, 0, 0, 0));
	this.setMinSize(250, 500);
	
	Text scenetitle = new Text("Login");
	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
	this.add(scenetitle, 0, 0, 2, 1);
	
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
	hbBtn.setAlignment(Pos.BOTTOM_LEFT);
	hbBtn.getChildren().add(btn);
	this.add(hbBtn, 1, 4);
	
	// user name/password invalid
	final Text actiontarget = new Text();
    this.add(actiontarget, 1, 6);
	
	// action for sign in button
    btn.setOnAction(new EventHandler<ActionEvent>() {
    	 
        @Override
        public void handle(ActionEvent e) {
        	
        	System.out.println("WORK");
        	myName = userTextField.getText();
        	myPass = pwBox.getText();
        	
        	// creates current user
        	try {
				myUser = myDataBase.verifyUser(myName, myPass);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	// checks if user is valid and if admin
        	if(myUser == null) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Incorrect login information");
        	}else{
        		getChildren().clear();
        		if(myUser.isAdmin()) {
        			update(userTextField.getText(), true);
        		}else {
        			update(userTextField.getText(), false);
        		}
       		}
        		
        }
    });
    
    Button reg = new Button("Register");
	hbBtn.getChildren().add(reg);
    
	reg.setOnAction(new EventHandler<ActionEvent>() {
   	 
        @Override
        public void handle(ActionEvent e) {
        	getChildren().clear();
        	register();
        }
	});
	
    
}
	/**
	 * Opens account window for admin and user.
	 * @param theName the user name
	 * @param admin whether or not user is admin
	 */
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
	            	getChildren().clear();
	            	
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
	            	getChildren().clear();
	            	
	            }
	        });
    	}
    }
    
    /**
     * Creates register window.
     */
    public void register() {
    	Text scenetitle = new Text("Register");
    	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
    	this.add(scenetitle, 0, 0, 2, 1);
    	
    	// user name text field
    	Label userName = new Label("User Name:");
    	this.add(userName, 0, 1);

    	TextField userTextField = new TextField();
    	this.add(userTextField, 1, 1);
    	
    	// user name text field
    	Label password = new Label("Password:");
    	this.add(password, 0, 2);

    	TextField passTextField = new TextField();
    	this.add(passTextField, 1, 2);
    	
    	final Text actiontarget = new Text();
        this.add(actiontarget, 1, 6);
    	
    	Button save = new Button("Submit");
    	HBox hbSave = new HBox(10);
    	hbSave.setAlignment(Pos.BOTTOM_RIGHT);
    	hbSave.getChildren().add(save);
    	this.add(hbSave, 1, 4);
    	
    	// action for sign in button
        save.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	getChildren().clear();
            	if(passTextField.getText() == "" || userTextField.getText() == "") {
            		actiontarget.setFill(Color.FIREBRICK);
            		actiontarget.setText("Invalid input");
            	}else {
            		myName = userTextField.getText();
            		myPass = passTextField.getText();
            		User newUser = new NonAdmin(userTextField.getText(), passTextField.getText(), false);
            		try {
						myDataBase.saveUser(newUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	update(myName, false);
               
            }
        });
    	
    }
}

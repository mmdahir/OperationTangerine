package view;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
		
	/** Current User. */
	private User myUser;
	
	/** Current User name. */
	private String myName;
	
	/** Current User passowrd. */
	private String myPass;

	/** Color of the Text in this Pane. */
	private Paint textColor = Color.BLACK;

	/** Color of the background on this pane. */
	private Paint backgroundColor = Color.WHITE;
	
	{


	this.setVgap(5);
	this.setHgap(10);
	this.setMinSize(250, 500);
	this.setAlignment(Pos.TOP_CENTER);
	this.setPadding(new Insets(60, 0, 0, 0));
	this.setBackground(new Background(new BackgroundFill(backgroundColor ,null, null)));

	login();
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
    	VBox hbBtn2 = new VBox();
    	
    	hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
    	hbBtn2.setSpacing(5);
    	
    	if (admin) {
    		
    		Button btn1 = new Button("Create Event");
	    	Button btn = new Button("Delete events");
	    	
	    	hbBtn2.getChildren().addAll(btn1, btn);
	
	    	// action for create events
	        btn1.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	            	getChildren().clear();
	            	create();
	            }
	        });
	    	
	    	// action for edit events
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	            	getChildren().clear();
	            	deleteEvents();
	            }
	        });
    	}
    	
    	else {
    		
    		Button btn2 = new Button("View your events");
	    	hbBtn2.getChildren().add(btn2);
	    	
	    	// action for view your events
	        btn2.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	            	getChildren().clear();
	            	viewEvents();
	            }
	        });
    	}
    	
    	Button sign = new Button("Sign Out");
    	hbBtn2.getChildren().add(sign);
    	this.add(hbBtn2, 1, 4);
    	
    	// action for view your events
        sign.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	
            	getChildren().clear();
            	
            	myName = null;
            	myPass = null;
            	myUser = null;
            	
            	login();
            }
        });
    }
    
    /**
     * Creates log in window.
     */
    public void login() {
    	
    	Text scenetitle = new Text("LOGIN:");
    	scenetitle.setFill(textColor);
    	scenetitle.setFont(Font.font("Cooper Black", FontWeight.NORMAL, 20));
    	this.add(scenetitle, 0, 0, 2, 1);
    	
    	// user name text field
    	Label userName = new Label("User Name:");
    	userName.setTextFill(textColor);
    	this.add(userName, 0, 1);

    	TextField userTextField = new TextField();
    	this.add(userTextField, 1, 1);

    	// password text field
    	Label pw = new Label("Password:");
    	pw.setTextFill(textColor);
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
            	
            	myName = userTextField.getText();
            	myPass = pwBox.getText();
            	
            	// creates current user
            	try {
    				myUser = DataBase.verifyUser(myName, myPass);
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
     * Creates register window.
     */
    public void register() {
    	
    	Text scenetitle = new Text("REGISTER:");
    	scenetitle.setFill(textColor);
    	scenetitle.setFont(Font.font("Cooper Black", FontWeight.NORMAL, 20));
    	this.add(scenetitle, 0, 0, 2, 1);
    	
    	// user name text field
    	Label userName = new Label("User Name:");
    	userName.setTextFill(textColor);
    	this.add(userName, 0, 1);
    	
    	TextField userTextField = new TextField();
    	this.add(userTextField, 1, 1);
    	
    	// password text field
    	Label password = new Label("Password:");
    	password.setTextFill(textColor);
    	this.add(password, 0, 2);

    	TextField passTextField = new TextField();
    	this.add(passTextField, 1, 2);
    	
    	final Text actiontarget = new Text();
        this.add(actiontarget, 1, 6);
    	
    	Button save = new Button("Submit");
    	HBox hbSave = new HBox(10);
    	hbSave.setAlignment(Pos.BOTTOM_LEFT);
    	hbSave.getChildren().add(save);
    	
    	Button back = new Button("Cancel");
        hbSave.getChildren().add(back);
        
    	back.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
            	getChildren().clear();
            	login();
            }
    	});
    	
    	this.add(hbSave, 1, 4);
    	
    	// action for submit button
        save.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	
            	myName = userTextField.getText();
        		myPass = passTextField.getText();
        		User newUser = null;
				try {
					newUser = DataBase.verifyUser(myName, myPass);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
        		
            	if(myName.length() == 0 
            			|| myPass.length() == 0) {
            		actiontarget.setFill(Color.FIREBRICK);
            		actiontarget.setText("Invalid input");
            	}else if(newUser != null) {
            		actiontarget.setFill(Color.FIREBRICK);
            		actiontarget.setText("Invalid input");
            	}else if(myName.indexOf(',') != -1 || 
            			myPass.indexOf(',') != -1) {
            		actiontarget.setFill(Color.FIREBRICK);
            		actiontarget.setText("Input cannot contain commas.");
            	}else {
            		newUser = new NonAdmin(userTextField.getText(), 
							passTextField.getText(), false);
            		try {
    					DataBase.saveUser(newUser);
    				} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
            		getChildren().clear();
            		update(myName, false);
            	}  
            }
        });
    }
    
    /**
     * Creates an event.
     */
    private void create() {
    	Text scenetitle = new Text("Create Event");
    	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
    	this.add(scenetitle, 0, 0, 2, 1);
    	
    	// event title text field
    	Label eName = new Label("Event Title:");
    	this.add(eName, 0, 1);

    	TextField eNameTF = new TextField();
    	this.add(eNameTF, 1, 1);
    	
    	// event location text field
    	Label loc = new Label("Location:");
    	this.add(loc, 0, 2);

    	TextField locTF = new TextField();
    	this.add(locTF, 1, 2);
    	
    	// event description text field
    	Label desc = new Label("Description:");
    	this.add(desc, 0, 3);

    	TextArea descTF = new TextArea();
    	this.add(descTF, 1, 3);
    	descTF.setPrefSize(150, 200);
    	descTF.setPrefRowCount(10);
    	descTF.setWrapText(true);
    	
    	// event date
    	Label dateT = new Label("Date:");
    	this.add(dateT, 0, 4);
    	VBox dateBox = new VBox(20);
    	DatePicker date = new DatePicker();
    	date.setValue(LocalDate.now());
        dateBox.getChildren().add(date);
        this.add(dateBox, 1, 4);
    	
        // submit button
        Button save = new Button("Submit");
    	HBox hbSave = new HBox(10);
    	hbSave.setAlignment(Pos.BOTTOM_RIGHT);
    	hbSave.getChildren().add(save);
    	
    	Button back = new Button("Cancel");
        hbSave.getChildren().add(back);
        
    	back.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
            	getChildren().clear();
            	update(myName, true);
            }
    	});
    	
    	
    	this.add(hbSave, 1, 5);
    	
    	final Text actiontarget = new Text();
        this.add(actiontarget, 1, 6);
    	
    	// action for submit button
        save.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	
            	if(eNameTF.getText().length() == 0 
            			|| locTF.getText().length() == 0) {
            		actiontarget.setFill(Color.FIREBRICK);
            		actiontarget.setText("One or more spaces are left blank.");
            	} else if(eNameTF.getText().indexOf(',') != -1 || 
            			locTF.getText().indexOf(',') != -1 ||
            			descTF.getText().indexOf(',') != -1) {
            		actiontarget.setFill(Color.FIREBRICK);
            		actiontarget.setText("Input cannot contain commas.");
            	} else {
	            	Date date1 = new Date(date.getValue().getMonthValue(), 
	            			date.getValue().getDayOfMonth(), date.getValue().getYear());
	            	Event event = new Event(eNameTF.getText(), locTF.getText(),descTF.getText(),date1);
            	
	            	try {
						DataBase.saveEvent(event);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	
	            	getChildren().clear();
	            	update(myName, true);
            	}
            }
        });
    }
    
    
   
    /**
     * Opens window to view user events.
     */
    public void viewEvents() {
    	
    	VBox events = new VBox();
    	
    	events.setAlignment(Pos.BOTTOM_LEFT);
    	
        List<Event> eventList = ((NonAdmin) myUser).getEvents();
        
        for(Event event: eventList) {
        	
        	Label eventLabel = new Label(event.getTitle());
        	eventLabel.setFont(new Font("Arial Bold", 12));
        	events.getChildren().add(eventLabel);
        }
        
        Button back = new Button("Back");
        
        events.setSpacing(20);
        events.getChildren().add(back);
    	
        this.add(events, 0, 1);
        
    	back.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
            	getChildren().clear();
            	update(myName, false);
            }
    	});      
    }
    
    /**
     * Can delete events.
     */
    public void deleteEvents() {
    	VBox events = new VBox();
    	events.setAlignment(Pos.BOTTOM_LEFT);
    	
        List<Event> eventList = null;
        
    	try {
    		eventList = DataBase.getEvents();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        
        for(Event event: eventList) {
        	
        	Button eventLabel = new Button(event.getTitle());
        	eventLabel.setFont(new Font("Tahoma", 10));
        	events.getChildren().add(eventLabel);
        	eventLabel.setOnAction(new EventHandler<ActionEvent>() {
              	 
                @Override
                public void handle(ActionEvent e) {
                	
                	try {
						DataBase.deleteEvent(event.getTitle());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	getChildren().clear();
                	deleteEvents();
                }
        	});
        }
        
        Button back = new Button("Back");
        events.getChildren().add(back);
    	this.add(events, 0, 1);
        
    	back.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
            	getChildren().clear();
            	update(myName, true);
            }
    	}); 
    }
    
    /**
     * Can delete user events.
     */
    public void deleteUserEvents() {
    	VBox events = new VBox();
    	events.setAlignment(Pos.BOTTOM_LEFT);
    	
        List<Event> eventList = ((NonAdmin) myUser).getEvents();
        
        for(Event event: eventList) {
        	
        	Button eventLabel = new Button(event.getTitle());
        	eventLabel.setFont(new Font("Tahoma", 10));
        	events.getChildren().add(eventLabel);
        	eventLabel.setOnAction(new EventHandler<ActionEvent>() {
              	 
                @Override
                public void handle(ActionEvent e) {
                	
                	try {
						DataBase.deleteEvent(event.getTitle());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	getChildren().clear();
                	deleteEvents();
                }
        	});
        }
        
        Button back = new Button("Back");
        events.getChildren().add(back);
    	this.add(events, 0, 1);
        
    	back.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
            	getChildren().clear();
            	update(myName, true);
            }
    	}); 
    }
    
    /**
     * Returns current user.
     * @return the user that is logged in
     */
    public User getCurrUser() {
    	return myUser;
    }
    
}

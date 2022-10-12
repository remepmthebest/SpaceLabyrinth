package view;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class GameLostDialog extends Dialog<ButtonType> {
	public GameLostDialog() {
	    ButtonType yes = new ButtonType("Yes");
	    ButtonType no = new ButtonType("No");
	    
	    this.setTitle("Game Lost");
	    this.setContentText("Try again?");
	    this.getDialogPane().getButtonTypes().add(yes);	
	    this.getDialogPane().getButtonTypes().add(no);
	}
}

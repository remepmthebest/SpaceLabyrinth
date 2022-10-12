package view;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class GameWonDialog extends Dialog<ButtonType> {

	public GameWonDialog(String time, int stars) {
	    this.setTitle("Restart");
	    
	    ButtonType yes = new ButtonType("->");
	    this.setHeaderText("You made it!");
	    this.setContentText(String.format("Time: %s\nStars collected: %s", time, stars));
	    this.getDialogPane().getButtonTypes().add(yes);	   
	}
	
}
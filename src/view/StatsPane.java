package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class StatsPane extends BorderPane {
	
	private Label timerLabel;
	private Label stars;
	
	public StatsPane() {
		super();
		HBox hbox = new HBox(20);
		this.timerLabel = new Label("00:00:00");
		timerLabel.setFont(new Font(20));
		this.stars = new Label("Stars collected: 0");
		stars.setFont(new Font(20));
		hbox.getChildren().addAll(timerLabel, stars);
	    hbox.setAlignment(Pos.CENTER);
		BorderPane.setMargin(hbox, new Insets(50));
	    this.setCenter(hbox);
	}
	
	public void updateTime(String time) {
		timerLabel.setText(time);
	}
	
	public void updateStars(int stars) {
		this.stars.setText(String.format("Stars collected: %s", stars));
	}
	
}

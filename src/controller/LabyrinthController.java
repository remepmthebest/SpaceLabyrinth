package controller;

import application.LabyrinthGame;
import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import listener.CollectStarListener;
import view.GameLostDialog;
import view.GameWonDialog;
import view.Labyrinth;
import view.StatsPane;
import view.Tile;
import view.Timer;

public class LabyrinthController {
	
	public Labyrinth lab;
	public StatsPane stats;
	public Timer timer;
	
	private boolean firstMove = true;
	
	public LabyrinthController(Labyrinth lab, StatsPane stats) {
		super();
		this.lab = lab;
		this.stats = stats;
		this.timer = new Timer(this);
		this.lab.cells.stream().filter(Tile::hasStar).forEach(star -> star.setOnMouseClicked(new CollectStarListener(this)));
	}

	public void changePlayerPosition(int newRow, int newCol) {
		// if it's first move start the timer
		if (firstMove) {
			timer.start();
			firstMove = false;
		}
		
		Tile newPlayerTile = lab.findByRowAndCol(newRow, newCol);
		Tile playerTile = lab.findCurrentPlayerPosition();
		
		// if is out of bounds is wall or is star block the movement
		if (newPlayerTile == null || newPlayerTile.isWall() || newPlayerTile.hasStar()) {
			return;
		}
		
		// if stepped on asteroid show explosion stop the timer and show the dialog
		if (newPlayerTile.hasAsteroid()) {
			playerTile.removePlayer();
			newPlayerTile.addPlayer();
			newPlayerTile.setBoom();
			timer.stop();
			showGameLostDialog();
		}
		
		// if arrived to first row that means player won, show game won dialog
		if (newPlayerTile.getRow() == 0) {
			newPlayerTile.addPlayer();
			playerTile.removePlayer();
			showGameWonDialog();
		}
		
		// normal move performed, change position of the player
		playerTile.removePlayer();		
		newPlayerTile.addPlayer();
		lab.changCurrentPlayerPosition(newRow, newCol);
	}
	
	public void setTime(String time) {
		stats.updateTime(time);
	}
	
	public void showGameWonDialog() {
		timer.stop();
		new GameWonDialog(timer.getTime(), timer.numOfStars).showAndWait();
		LabyrinthGame.startGame();
	}
	
	public void showGameLostDialog() {
		ButtonType result = new GameLostDialog().showAndWait().get();
	    if (result.getText().equals("Yes")) {
	    	LabyrinthGame.startGame();
	    }else {
	    	Platform.exit();
	    }
	}
}

package view;

import java.io.File;
import java.util.Objects;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import listener.AsteroidClickEventHandler;

public class Tile extends Rectangle {

	private boolean isWall;
	private boolean isCooridor;
	private boolean isPlayerHere;
	private int column;
	private int row;
	private boolean hasStar;
	private boolean hasAsteroid;

	public Tile(boolean isWall, boolean isCooridor, boolean isPlayerHere, int column, int row) {
		super();
		this.isWall = isWall;
		this.isCooridor = isCooridor;
		this.isPlayerHere = isPlayerHere;
		this.column = column;
		this.row = row;
	}

	public static Tile createWall(int col, int row) {
		Tile wall = new Tile(true, false, false, col, row);
		wall.setHeight(25);
		wall.setWidth(25);
		wall.setFill(Color.BLACK);
		return wall;
	}

	public static Tile createCooridor(int col, int row) {
		Tile cooridor = new Tile(false, true, false, col, row);
		cooridor.setHeight(25);
		cooridor.setWidth(25);
		cooridor.setFill(Color.WHITE);
		return cooridor;
	}

	public void removePlayer() {
		this.setFill(Color.WHITE);
		this.isPlayerHere = false;
	}

	public void addPlayer() {
		this.setFill(Color.RED);
		this.isPlayerHere = true;
	}

	public void addAsteroid() {
		this.setFill(Color.GREY);
		this.hasAsteroid = true;
		addPressAndHoldHandler(this, Duration.seconds(2), new AsteroidClickEventHandler());
	}

	public void removeAsteroid() {
		this.setFill(Color.WHITE);
		this.hasAsteroid = false;
	}

	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	public boolean isCooridor() {
		return isCooridor;
	}

	public void setCooridor(boolean isCooridor) {
		this.isCooridor = isCooridor;
	}

	public boolean isPlayerHere() {
		return isPlayerHere;
	}

	public void setPlayerHere(boolean isPlayerHere) {
		this.isPlayerHere = isPlayerHere;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean hasStar() {
		return hasStar;
	}

	public void addStar() {
		this.setFill(Color.YELLOW);
		hasStar = true;
	}

	public void removeStar() {
		this.hasStar = false;
		this.setFill(Color.WHITE);
	}

	public boolean hasAsteroid() {
		return hasAsteroid;
	}

	public void setBoom() {
		Image explosion = new Image(
				new File("images/explosion.png").toURI()
						.toString());
		this.setFill(new ImagePattern(explosion));
	}

	private void addPressAndHoldHandler(Node node, Duration holdTime, EventHandler<MouseEvent> handler) {

		class Wrapper<T> {
			T content;
		}
		Wrapper<MouseEvent> eventWrapper = new Wrapper<>();

		PauseTransition holdTimer = new PauseTransition(holdTime);
		holdTimer.setOnFinished(event -> handler.handle(eventWrapper.content));

		node.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			eventWrapper.content = event;
			holdTimer.playFromStart();
		});
		node.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> holdTimer.stop());
		node.addEventHandler(MouseEvent.DRAG_DETECTED, event -> holdTimer.stop());
	}

	@Override
	public int hashCode() {
		return Objects.hash(column, isCooridor, isPlayerHere, isWall, row);
	}

	@Override
	public String toString() {
		return "Tile [isWall=" + isWall + ", isCooridor=" + isCooridor + ", isPlayerHere=" + isPlayerHere + ", column="
				+ column + ", row=" + row + "]";
	}

}

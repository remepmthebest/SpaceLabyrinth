package listener;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.Tile;

public class AsteroidClickEventHandler implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent asteroidHoldClick) {
		Tile asteroid = (Tile)asteroidHoldClick.getSource();
		asteroid.removeAsteroid();
	}

}

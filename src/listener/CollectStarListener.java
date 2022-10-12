package listener;

import controller.LabyrinthController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.Tile;

public class CollectStarListener implements EventHandler<MouseEvent> {
    
	private LabyrinthController controller;
	
	public CollectStarListener(LabyrinthController controller) {
		this.controller = controller;
	}
	
	@Override
	public void handle(MouseEvent mouseClickOnStar) {
		Tile playerTile = controller.lab.findCurrentPlayerPosition();
		if (controller.lab.isFrontingAStar(playerTile)) {
			controller.timer.numOfStars += 1;
			controller.stats.updateStars((int) controller.timer.numOfStars);
			Tile star = (Tile)mouseClickOnStar.getSource();
			star.removeStar();
		}
	}

}

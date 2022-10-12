package listener;


import controller.LabyrinthController;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MovementListener implements EventHandler<KeyEvent> {
	
	private LabyrinthController controller;
	
	public MovementListener(LabyrinthController controller) {
		super();
		this.controller = controller;
	}

	
	@Override
	public void handle(KeyEvent e) {
		
		int newRow = controller.lab.findCurrentPlayerPosition().getRow();
		int newCol = controller.lab.findCurrentPlayerPosition().getColumn();
		
		if (e.getCode() == KeyCode.UP) {
            int updated = newRow - 1;
			controller.changePlayerPosition(updated, newCol);
		}
		
		if (e.getCode() == KeyCode.LEFT) {
			int updated = newCol - 1;
			controller.changePlayerPosition(newRow, updated);
		}
		
		if (e.getCode() == KeyCode.RIGHT) {
			int updated = newCol + 1;
			controller.changePlayerPosition(newRow, updated);
		}
		
		if (e.getCode() == KeyCode.DOWN) {
			int updated = newRow + 1;
			controller.changePlayerPosition(updated, newCol);
		}
		
	}

}

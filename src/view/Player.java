package view;

import javafx.scene.shape.Rectangle;

public class Player extends Rectangle {
	
	
	private int col;
	private int row;
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}

}

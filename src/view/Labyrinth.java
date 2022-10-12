package view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Labyrinth extends GridPane {

	private static final int col = 15;
	private static final int row = 15;

	public List<Tile> cells;

	public Labyrinth() {
		super();
		this.setAlignment(Pos.CENTER);
		cells = new ArrayList<Tile>();
		createWalls();
		createCorridors();
		createStars();
		createAsteroids();
	}
	
	public boolean isFrontingAStar(Tile player) {
		int row = player.getRow();
		int column = player.getColumn();
		
		Tile down = findByRowAndCol(row+1, column);
		Tile up = findByRowAndCol(row-1, column);
		Tile left = findByRowAndCol(row, column-1);
		Tile right = findByRowAndCol(row, column+1);
		
		if ((down != null && down.hasStar()) || 
				(up!=null && up.hasStar()) ||
				(right!=null && right.hasStar()) ||
				(left!=null && left.hasStar())) {
			return true;
		}
		
		return false;
	}
	
	private void createAsteroids() {
		Tile asteroid1 = findByRowAndCol(11, 12);	
		asteroid1.addAsteroid();
		Tile asteroid2 = findByRowAndCol(13, 1);
		asteroid2.addAsteroid();
		Tile asteroid3 = findByRowAndCol(10, 5);
		asteroid3.addAsteroid();
		Tile asteroid4 = findByRowAndCol(2, 6);		
	    asteroid4.addAsteroid();
	}

	private void createStars() {
		Tile firstStarPositioni = findByRowAndCol(13, 2);
		firstStarPositioni.addStar();
		Tile secondStar = findByRowAndCol(13, 12);
		secondStar.addStar();
		Tile thirdStar = findByRowAndCol(1, 13);
		thirdStar.addStar();
	}

	private void createWalls() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				Tile wall = Tile.createWall(i, j);
				cells.add(wall);
				this.add(wall, i, j);
				wall.getStyleClass().add("wall");
			}
		}
	}
	
	private void createCorridors() {

		createHorizontalCooridor(3, 14);

		for (int i = 12; i < 14; i++) {
			for (int j = 4; j < 14; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}

		for (int i = 12; i < 14; i++) {
			for (int j = 1; j < 3; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}

		for (int i = 1; i < 12; i++) {
			for (int j = 1; j <= 2; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}

		for (int i = 4; i < 11; i++) {
			for (int j = 12; j <= 13; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}

		for (int i = 4; i < 12; i++) {
			for (int j = 9; j <= 10; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}

		for (int i = 4; i < 8; i++) {
			for (int j = 4; j <= 5; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}

		for (int i = 9; i < 12; i++) {
			for (int j = 4; j <= 5; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}

		for (int i = 9; i < 11; i++) {
			for (int j = 6; j <= 7; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}
		
		for(int i = 6; i< 9;i++) {
			for (int j = 6; j<=7; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}
		
		for(int i = 3; i<5;i++) {
			for (int j = 6; j<=7; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}
		
		Tile cooridor = Tile.createCooridor(4, 11);
		Tile cooridor1 = Tile.createCooridor(5, 11);
		Tile cooridor2 = Tile.createCooridor(4, 14);
		Tile cooridor3 = Tile.createCooridor(5, 14);
		Tile cooridor4 = Tile.createCooridor(9, 0);
		Tile cooridor5 = Tile.createCooridor(10, 0);
		
		cooridor2.addPlayer();
		
		this.cells.add(cooridor);
		this.cells.add(cooridor1);
		this.cells.add(cooridor2);
		this.cells.add(cooridor3);
		this.cells.add(cooridor4);
		this.cells.add(cooridor5);
		
		this.add(cooridor, 4, 11);
		this.add(cooridor1, 5, 11);
		this.add(cooridor2, 4, 14);
		this.add(cooridor3, 5, 14);
		this.add(cooridor4, 9, 0);
		this.add(cooridor5, 10, 0);
	}

	private void createHorizontalCooridor(int from, int too) {
		for (int i = 1; i <= 2; i++) {
			for (int j = from; j < too; j++) {
				Tile cooridor = Tile.createCooridor(i, j);
				this.cells.add(cooridor);
				this.add(cooridor, i, j);
			}
		}
	}
    
	public Tile findCurrentPlayerPosition() {
		return this.cells.stream().filter((it) -> it.isPlayerHere())
				.collect(Collectors.toList()).get(0);
	}

	public Tile findByRowAndCol(int newRow, int newCol) {
		return this.cells.stream()
				.filter(it ->it.getColumn() == newCol && it.getRow() == newRow)
				.filter(g -> g.isCooridor())
				.findFirst()
				.orElse(null);	
	}

	public void changCurrentPlayerPosition(int newRow, int newCol) {
		Tile player = findCurrentPlayerPosition();
		player.setRow(newRow);
		player.setColumn(newCol);
		
	}
}
		

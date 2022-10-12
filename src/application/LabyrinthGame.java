package application;
	
import java.io.File;
import java.net.MalformedURLException;

import controller.LabyrinthController;
import javafx.application.Application;
import javafx.stage.Stage;
import listener.MovementListener;
import view.Labyrinth;
import view.StatsPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class LabyrinthGame extends Application {
	
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		LabyrinthGame.stage = primaryStage;
		startGame();
	}
	
	public static void startGame() {
		BorderPane root = initRoot();
		stage.setTitle("Labyrinth");
		Scene scene = new Scene(root, 600, 600);
		String path;
		try {
			path = new File("application.css").toURI().toURL().toString();
			scene.getStylesheets().add(path);
			stage.setScene(scene);
			stage.show();
			root.requestFocus();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static BorderPane initRoot() {
		BorderPane root = new BorderPane();
		Labyrinth labyrinth = new Labyrinth();
		StatsPane statsPane = new StatsPane();
		LabyrinthController controller = new LabyrinthController(labyrinth, statsPane);
		root.setTop(statsPane);
		root.setCenter(labyrinth);
		root.setOnKeyPressed(new MovementListener(controller));
		return root;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

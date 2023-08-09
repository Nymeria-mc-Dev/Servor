package fr.nymeria.servor.helpers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Loading {

	private static Pane pane = new Pane();
	private static Scene scene = new Scene(pane, 420, 297);
	private static Text loadingMessage = new Text("Loading...");
	private static Stage stage;
	
	public static Scene get(Stage loadingStage) {
		pane.setStyle("-fx-background-color: #272727;");
		stage = loadingStage;
		
		loadingMessage.setFill(Color.WHITE);
		
		HBox box = new HBox();
		box.setTranslateY(250);
		box.setPrefHeight(47);
		box.setPrefWidth(420);
		box.setAlignment(Pos.CENTER);
		
		box.getChildren().add(loadingMessage);
		pane.getChildren().add(box);
		
		return scene;
	}
	
	public static void close() {
		//stage.close();
	}
	
	public static void setLoadingMessage(String message) {
		loadingMessage.setText(message);
	}
	
}

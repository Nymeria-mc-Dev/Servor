package fr.nymeria.servor.ui;


import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class ChooseVersion {

	public ChooseVersion(Pane pane) {
		
		VBox server = new VBox();
		
		server.setPrefSize(206, 720);
		server.getStyleClass().add("server");
		
		HBox allButton = new HBox();
		
		allButton.setPrefSize(206, 66);
		allButton.setTranslateY(35);
		allButton.getStyleClass().add("all");
		
		Rectangle blueBar = new Rectangle();
		
		blueBar.setWidth(3);
		blueBar.setHeight(66);
		blueBar.setTranslateX(203);
		blueBar.getStyleClass().add("blueBar");
		
		allButton.getChildren().add(blueBar);
		
		server.getChildren().addAll(allButton);
		
		pane.getChildren().add(server);
	}
	
}

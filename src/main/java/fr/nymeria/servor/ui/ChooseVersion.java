package fr.nymeria.servor.ui;


import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class ChooseVersion {

	public ChooseVersion(Pane pane) {
		
		Pane server = new Pane();
		
		server.setPrefSize(206, 720);
		server.getStyleClass().add("server");
		
		HBox switcher = new HBox();
		
		switcher.setPrefSize(206, 66);
		switcher.setTranslateY(35);
		switcher.getStyleClass().add("all");
		
		Rectangle blueBar = new Rectangle();
		
		blueBar.setWidth(3);
		blueBar.setHeight(66);
		blueBar.setTranslateX(203);
		blueBar.getStyleClass().add("blueBar");
		
		switcher.getChildren().add(blueBar);
		
		server.getChildren().addAll(switcher);
		
		pane.getChildren().add(server);
	}
	
}

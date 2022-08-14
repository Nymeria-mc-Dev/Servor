package fr.nymeria.servor.ui.elements;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class VersionCard {
	
	public VersionCard(Pane pane, double x, double y, String str) {
		
		Rectangle card = new Rectangle();

		card.setTranslateX(x);
		card.setTranslateY(y);
		card.setWidth(318);
		card.setHeight(83);
		card.setArcHeight(15);
		card.setArcWidth(15);
		card.getStyleClass().add("serverCard");
		
		HBox box = new HBox();
		
		box.setPrefSize(318, 83);
		box.setTranslateX(x);
		box.setTranslateY(y + 25);
		box.setAlignment(Pos.BASELINE_CENTER);
		
		Text version = new Text(str);
		version.setStyle("-fx-font-size: 24px; -fx-font-familly: regular;");
		version.setFill(Color.WHITE);
		
		box.getChildren().add(version);
		
		pane.getChildren().addAll(card, box);
	}

}

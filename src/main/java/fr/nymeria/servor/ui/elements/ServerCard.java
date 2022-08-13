package fr.nymeria.servor.ui.elements;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ServerCard {

	public ServerCard(Pane pane, double x, double y) {
		
		if(y < 40) y = 40;
		
		Rectangle card = new Rectangle();

		card.setTranslateX(x);
		card.setTranslateY(y);
		card.setWidth(309);
		card.setHeight(170);
		card.setArcHeight(15);
		card.setArcWidth(15);
		card.getStyleClass().add("serverCard");

		Region button = new Region();
		
		button.setPrefSize(309, 39);
		button.setTranslateX(x);
		button.setTranslateY(y + 131);
		button.getStyleClass().add("gestionButton");

		HBox box = new HBox();
		
		box.setPrefSize(309, 39);
		box.setTranslateX(x);
		box.setTranslateY(y + 131);
		box.setAlignment(Pos.BASELINE_CENTER);
		
		Text gestion = new Text("Gestion");
		gestion.setStyle("-fx-font-size: 24px; -fx-font-familly: regular;");
		gestion.setFill(Color.WHITE);
		
		box.getChildren().add(gestion);
		
		pane.getChildren().addAll(card, button, box);
	}

}

package fr.nymeria.servor.ui.elements;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class VersionCard {

	protected static String VERSION;
	public HBox box;
	
	public Boolean clicked;

	public VersionCard(Pane pane, double x, double y, String str) {

		VERSION = str;
		clicked = false;

		Rectangle card = new Rectangle();

		card.setTranslateX(x);
		card.setTranslateY(y);
		card.setWidth(318);
		card.setHeight(83);
		card.setArcHeight(15);
		card.setArcWidth(15);
		card.getStyleClass().add("serverCard");

		HBox box = new HBox();

		box.setPrefSize(328, 93);
		box.setTranslateX(x - 5);
		box.setTranslateY(y - 5);
		box.setAlignment(Pos.CENTER);

		Text version = new Text(str);
		version.setStyle("-fx-font-size: 24px; -fx-font-familly: regular;");
		version.setFill(Color.WHITE);

		box.getChildren().add(version);

		pane.getChildren().addAll(card, box);
	}

	public String getVersionValue() {
		return VERSION;
	}

	public void setHBoxStyle() {
		Boolean clicked = false;
		if (clicked) {
			box.setStyle("");
			clicked = false;
		} else {
			box.setStyle("-fx-border-style: solid inside;" + "-fx-padding: 10;"
					+ "-fx-border-width: 4;" + "-fx-border-insets: 5;"
					+ "-fx-border-radius: 15;" + "-fx-border-color: #0066FF;");
			clicked = true;
		}
	}

	public void removeSelected() {
		box.setStyle("");
	}

	public HBox getHBox() {
		return box;
	}
	
	public Boolean isClicked() {
		return clicked;
	}

}

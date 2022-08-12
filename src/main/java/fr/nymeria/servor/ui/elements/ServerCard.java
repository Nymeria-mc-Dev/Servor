package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.App;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ServerCard {

	public ServerCard(double x, double y) {
		
		if(y < 40) y = 40;
		
		Rectangle card = new Rectangle();
		
		card.setTranslateX(x);
		card.setTranslateY(y);
		card.setWidth(309);
		card.setHeight(170);
		card.setArcHeight(15);
		card.setArcWidth(15);
		card.getStyleClass().add("serverCard");
		
		
		Rectangle button = new Rectangle();
		
		button.setTranslateX(x);
		button.setTranslateY(y + 131);
		button.setWidth(309);
		button.setHeight(39);
		button.getStyleClass().add("gestionButton");
		
		Text gestion = new Text("Gestion");
		gestion.setTranslateX(x);
		gestion.setTranslateY(y + 157);
		gestion.setStyle("-fx-font-size: 24px; -fx-font-familly: regular;");
		gestion.setFill(Color.WHITE);
		
		App.addItem(card, button, gestion);
	}
	
}

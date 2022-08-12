package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.App;
import javafx.scene.shape.Rectangle;

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
		
		
		App.addItem(card, button);
	}
	
}

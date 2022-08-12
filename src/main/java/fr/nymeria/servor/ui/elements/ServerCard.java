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
		card.setArcHeight(12);
		card.setArcWidth(12);
		card.getStyleClass().add("card");
		
		App.addItem(card);
	}
	
}

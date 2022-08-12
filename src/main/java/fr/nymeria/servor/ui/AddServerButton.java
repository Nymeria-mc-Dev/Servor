package fr.nymeria.servor.ui;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddServerButton {

	public AddServerButton(Stage stage) {
		
		Circle rect = new Circle(25);
		rect.setFill(Color.BLUE);
		rect.setTranslateX(1020);
		rect.setTranslateY(650);
		
		Text button = GlyphsDude.createIcon(FontAwesomeIcon.PLUS, "50px");
		button.setTranslateX(1026);
		button.setTranslateY(653.25);
		button.setFill(Color.WHITE);
		
		
		App.addItem(rect, button);
	}

}

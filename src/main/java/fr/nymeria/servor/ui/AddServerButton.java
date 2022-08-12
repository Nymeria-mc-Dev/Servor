package fr.nymeria.servor.ui;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddServerButton {

	public AddServerButton(Stage stage) {
		
		Text button = GlyphsDude.createIcon(FontAwesomeIcon.PLUS);
		
		
		App.addItem(button);
	}

}

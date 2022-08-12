package fr.nymeria.servor.ui;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TopBar {

	double y = 0;
	double x = 0;
	
	public TopBar(Stage stage) {
		
		Rectangle bar = new Rectangle();
		
		bar.setWidth(1080);
		bar.setHeight(35);
		bar.setStyle("-fx-fill: #3E3E3E;");
		
		bar.setOnMousePressed(event -> {
			y = event.getSceneY();
			x = event.getSceneX();
		});
		
		bar.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - x);
			stage.setY(event.getScreenY() - y);
		});
		
		Text close = GlyphsDude.createIcon(FontAwesomeIcon.CLOSE, "25px");
		close.setTranslateX(1040);
		
		close.setOnMouseClicked(event -> {
			stage.close();
		});
		
		Text reduce = GlyphsDude.createIcon(FontAwesomeIcon.MINUS, "25px");
		reduce.setTranslateX(1000);
		reduce.setTranslateY(2);
		
		reduce.setOnMouseClicked(event -> {
			stage.setIconified(true);
		});
		
		App.addItem(bar, close, reduce);
	}
	
}

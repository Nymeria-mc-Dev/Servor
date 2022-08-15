package fr.nymeria.servor.ui;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TopBar {

	double y = 0;
	double x = 0;
	
	public TopBar(Pane pane, Stage stage) {
		
		Rectangle bar = new Rectangle();
		
		bar.setWidth(1080);
		bar.setHeight(35);
		bar.setTranslateX(0);
		bar.setTranslateY(0);
		bar.setStyle("-fx-fill: #363636;");
		
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
		close.setTranslateY(25);
		close.setFill(Color.WHITE);
		
		close.setOnMouseClicked(event -> {
			stage.close();
		});
		
		Text reduce = GlyphsDude.createIcon(FontAwesomeIcon.MINUS, "25px");
		reduce.setTranslateX(1000);
		reduce.setTranslateY(27);
		reduce.setFill(Color.WHITE);
		
		reduce.setOnMouseClicked(event -> {
			stage.setIconified(true);
		});
		
		Text name = new Text("Servor [ BETA ]");
		name.setFill(Color.WHITE);
		name.setFont(Font.font("Poppins", FontWeight.BOLD, 20));
		name.setTranslateX(1080 / 2 - (name.getLayoutBounds().getWidth() / 2));
		name.setTranslateY(25);
		
		Text icon = GlyphsDude.createIcon(FontAwesomeIcon.ADN, "25px");
		icon.setFill(Color.WHITE);
		icon.setTranslateY(25);
		icon.setTranslateX(5);
		
		pane.getChildren().addAll(bar, close, reduce, name, icon);
	}
	
}

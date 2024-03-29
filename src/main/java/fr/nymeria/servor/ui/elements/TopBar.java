package fr.nymeria.servor.ui.elements;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import fr.nymeria.servor.helpers.Discord;
import fr.nymeria.servor.helpers.FileHelper;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TopBar {

	double y = 0;
	double x = 0;
	
	public TopBar(Pane pane, Stage stage) {
		
		Pane bar = new Pane();
		
		bar.setPrefSize(1080, 35);
		bar.setTranslateX(0);
		bar.setTranslateY(0);
		bar.setStyle("-fx-background-color: #363636;");
		
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
		
		close.hoverProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue) {
				close.setFill(Color.RED);
				App.setCursor(Cursor.HAND);
			}else {
				close.setFill(Color.WHITE);
				App.setCursor(Cursor.DEFAULT);
			}
		});
		
		close.setOnMouseClicked(event -> {
			double x = App.getStage().getX();
			double y = App.getStage().getY();
			FileHelper.setAppLoc(x, y);
	        Discord.close();
			stage.close();
			System.exit(0);
		});
		
		Text reduce = GlyphsDude.createIcon(FontAwesomeIcon.MINUS, "25px");
		reduce.setTranslateX(1000);
		reduce.setTranslateY(27);
		reduce.setFill(Color.WHITE);
		
		reduce.hoverProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue) {
				reduce.setFill(Color.GREY);
				App.setCursor(Cursor.HAND);
			}else {
				reduce.setFill(Color.WHITE);
				App.setCursor(Cursor.DEFAULT);
			}
		});
		
		reduce.setOnMouseClicked(event -> {
			stage.setIconified(true);
		});
		
		Text name = new Text("Servor [ BETA ]");
		name.setFill(Color.WHITE);
		name.setFont(Font.font("Poppins", FontWeight.BOLD, 20));
		name.setTranslateX((double) 1080 / 2 - (name.getLayoutBounds().getWidth() / 2));
		name.setTranslateY(25);
		
		ImageView icon = new ImageView(new Image(App.getResource("/icons/logo.png").toExternalForm(), 25, 25, false, true));
		icon.setTranslateY(5);
		icon.setTranslateX(5);
		
		bar.getChildren().addAll(close, reduce, name, icon);
		
		pane.getChildren().addAll(bar);
	}
	
}

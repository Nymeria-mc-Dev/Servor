package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.App;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class VersionCard {

	protected static String VERSION;
	public Pane box;
	
	public Boolean clicked;

	public VersionCard(Pane pane, double x, double y, String str, String imagePath) {

		VERSION = str;
		clicked = false;

		ImageView logo = new ImageView(new Image(App.class.getResource(imagePath).toExternalForm(), 51, 51, false, false));
		
		logo.setLayoutX(29);
		logo.setLayoutY(16);
		
		
		box = new Pane();

		box.setPrefSize(318, 83);
		box.setTranslateX(x);
		box.setTranslateY(y);
		box.getStyleClass().add("versionCard");

		Text version = new Text(str);
		version.setStyle("-fx-font-size: 32px; -fx-font-familly: regular;");
		version.setFill(Color.WHITE);

		VBox textBox = new VBox();
		
		textBox.setPrefSize(318, 83);
		textBox.getChildren().add(version);
		textBox.setAlignment(Pos.CENTER);
		
		box.getChildren().addAll(logo, textBox);

		pane.getChildren().addAll(box);
	}

	public String getVersionValue() {
		return VERSION;
	}

	public void setClicked(boolean value) {
		if(value) {
			box.getStyleClass().add("versionCardBorder");
		}else {
			box.getStyleClass().remove("versionCardBorder");
		}
	}

	public void removeSelected() {
		box.setStyle("");
	}

	public Pane get() {
		return box;
	}
	
	public Boolean isClicked() {
		return clicked;
	}

}

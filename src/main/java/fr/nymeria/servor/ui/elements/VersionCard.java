package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.App;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class VersionCard {

	protected static String VERSION;
	public HBox box;
	
	public Boolean clicked;

	public VersionCard(Pane pane, double x, double y, String str, String imagePath) {

		VERSION = str;
		clicked = false;

		ImageView logo = new ImageView(new Image(App.class.getResource(imagePath).toExternalForm(), 51, 51, false, false));
		
		logo.setLayoutX(29);
		logo.setLayoutY(16);
		
		
		Pane box = new Pane();

		box.setPrefSize(318, 83);
		box.setTranslateX(x);
		box.setTranslateY(y);
		//box.setAlignment(Pos.BASELINE_CENTER);
		box.getStyleClass().add("versionCard");

		Text version = new Text(str);
		//version.setLayoutX(145);
		//version.setLayoutY(46);
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

	public Pane getPane() {
		return box;
	}
	
	public Boolean isClicked() {
		return clicked;
	}

}

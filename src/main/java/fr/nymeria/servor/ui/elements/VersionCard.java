package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.App;
import fr.nymeria.servor.enums.ServerExecutor;
import fr.nymeria.servor.enums.ServerVersion;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class VersionCard {

	private ServerExecutor serverExecutor;
	private ServerVersion serverVersion;
	
	public Pane box;
	
	public Boolean clicked;

	public VersionCard(Pane pane, double x, double y, String str, String imagePath, ServerExecutor serverExecutor, ServerVersion serverVersion) {

		this.serverExecutor = serverExecutor;
		this.serverVersion = serverVersion;
		
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

	public ServerVersion getServerVersion() {
		return serverVersion;
	}
	
	public ServerExecutor getServerExecutor() {
		return serverExecutor;
	}
	
	public void setClicked(boolean value) {
		if(value) {
			box.getStyleClass().add("versionCardBorder");
		}else {
			box.getStyleClass().remove("versionCardBorder");
		}
	}

	public Pane get() {
		return box;
	}

}

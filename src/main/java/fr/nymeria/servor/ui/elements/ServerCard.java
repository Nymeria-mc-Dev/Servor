package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.ManageServerScene;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ServerCard {

	public ServerCard(Pane pane, double x, double y) {
		
		if(y < 40) y = 40;
		if(x < 40) x = 40;
		
		Rectangle card = new Rectangle();
		card.setTranslateX(x);
		card.setTranslateY(y);
		card.setWidth(309);
		card.setHeight(170);
		card.setArcHeight(15);
		card.setArcWidth(15);
		card.getStyleClass().add("serverCard");

		// Card content
		VBox cardContent = new VBox();
		cardContent.setTranslateX(card.getTranslateX() + 15);
		cardContent.setTranslateY(card.getTranslateY() + 15);
		cardContent.setMinHeight(50.0d);
		cardContent.setMinWidth(50.0d);

		Text serverName = new Text("Server Name");
		serverName.setFill(Color.WHITE);
		serverName.setFont(Font.font("Poppins", FontWeight.BOLD, 25));

		Text serverVersion = new Text("Server Version");
		serverVersion.setTranslateY(10);
		serverVersion.setFill(Color.WHITE);
		serverVersion.setFont(Font.font("Poppins", FontWeight.BOLD, 18));

		cardContent.getChildren().addAll(serverName, serverVersion);

		// Button
		Region button = new Region();
		button.setPrefSize(309, 39);
		button.setTranslateX(x);
		button.setTranslateY(y + 131);
		button.getStyleClass().add("gestionButton");

		HBox box = new HBox();
		box.setPrefSize(309, 39);
		box.setTranslateX(x);
		box.setTranslateY(y + 131);
		box.setAlignment(Pos.BASELINE_CENTER);
		
		Text gestion = new Text("Manage");
		gestion.setStyle("-fx-font-size: 24px; -fx-font-familly: regular;");
		gestion.setFill(Color.WHITE);
		
		box.getChildren().add(gestion);

		gestion.hoverProperty().addListener((observable, oldValue, newValue) -> {
			TranslateTransition buttonTrans = new TranslateTransition(Duration.millis(200), gestion);
			TranslateTransition boxTrans = new TranslateTransition(Duration.millis(200), box);

			if (newValue) {
                buttonTrans.setToX(5);
                buttonTrans.setToY(5);
			} else {
				buttonTrans.setToX(0);
				buttonTrans.setToY(0);
			}

			buttonTrans.play();
		});

		gestion.setOnMouseClicked((e) -> App.setScene(ManageServerScene.get())); //.onMouseClickedProperty().addListener((obs, oldv, newv) -> App.setScene(ManageServerScene.get()));

		pane.getChildren().addAll(card, cardContent, button, box);
	}
}

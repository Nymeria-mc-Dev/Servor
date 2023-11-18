package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.ManageServerScene;
import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ServerCard {

	public ServerCard(Pane pane, double x, double y) {
		
		if(y < 40) y = 40;
		if(x < 40) x = 40;
		
		Pane card = new Pane();
		card.setTranslateX(x);
		card.setTranslateY(y);
		card.setPrefWidth(309);
		card.setPrefHeight(170);
		card.getStyleClass().add("serverCard");

		// Card content
		VBox cardContent = new VBox();
		cardContent.setTranslateX(15);
		cardContent.setTranslateY(15);
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
		button.setTranslateY(131);
		button.getStyleClass().add("gestionButton");

		HBox box = new HBox();
		box.setPrefSize(309, 39);
		box.setTranslateY(131);
		box.setAlignment(Pos.BASELINE_CENTER);
		
		Text gestion = new Text("Manage");
		gestion.setStyle("-fx-font-size: 24px; -fx-font-familly: regular;");
		gestion.setFill(Color.WHITE);
		
		box.getChildren().add(gestion);

		box.hoverProperty().addListener((observable, oldValue, newValue) -> {
			ScaleTransition buttonScale = new ScaleTransition(Duration.millis(200), gestion);

			if (newValue) {
                buttonScale.setToX(1.2);
                buttonScale.setToY(1.2);
			} else {
				buttonScale.setToX(1);
				buttonScale.setToY(1);
			}

			buttonScale.play();
		});
		
		card.hoverProperty().addListener((observable, oldValue, newValue) -> {
			ScaleTransition cardScale = new ScaleTransition(Duration.millis(100), card);

			if (newValue) {
                cardScale.setToX(1.1);
                cardScale.setToY(1.1);
			} else {
				cardScale.setToX(1);
				cardScale.setToY(1);
			}

			cardScale.play();
		});

		gestion.setOnMouseClicked((e) -> App.setScene(ManageServerScene.get())); //.onMouseClickedProperty().addListener((obs, oldv, newv) -> App.setScene(ManageServerScene.get()));

		card.getChildren().addAll(cardContent, button, box);
		
		pane.getChildren().addAll(card);
	}
}

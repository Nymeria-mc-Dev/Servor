package fr.nymeria.servor.ui.elements;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
		
		Text gestion = new Text("Gestion");
		gestion.setStyle("-fx-font-size: 24px; -fx-font-familly: regular;");
		gestion.setFill(Color.WHITE);
		
		box.getChildren().add(gestion);
		
		
		pane.getChildren().addAll(card, cardContent, button, box);
	}

}

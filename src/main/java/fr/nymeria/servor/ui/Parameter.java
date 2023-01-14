package fr.nymeria.servor.ui;

import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.ChooseVersionScene;
import fr.nymeria.servor.scenes.MainScene;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Parameter {

	public Parameter(Pane pane) {
		Pane leftShutter = new Pane();
		leftShutter.setTranslateX(0);
		leftShutter.setTranslateY(35);
		leftShutter.setPrefSize(275, 685);
		leftShutter.setStyle("-fx-background-color: #363636;");
		
		Pane choiseBar = new Pane();

		choiseBar.setPrefSize(874, 44);
		choiseBar.setTranslateX(206);
		choiseBar.setTranslateY(676);
		choiseBar.getStyleClass().add("menu");

		HBox nextButton = new HBox();

		nextButton.setPrefSize(109, 28);
		nextButton.setTranslateX(740);
		nextButton.setTranslateY(8);
		nextButton.setAlignment(Pos.CENTER);
		nextButton.getStyleClass().add("nextButton");

		Text nextText = new Text("Next");

		nextText.setStyle("-fx-font-size: 20; -fx-font-family: regular;");
		nextText.setFill(Color.WHITE);

		nextButton.getChildren().add(nextText);

		HBox cancelButton = new HBox();

		cancelButton.setPrefSize(109, 28);
		cancelButton.setTranslateX(620);
		cancelButton.setTranslateY(8);
		cancelButton.setAlignment(Pos.CENTER);
		cancelButton.getStyleClass().add("cancelButton");

		Text cancelText = new Text("Cancel");

		cancelText.setStyle("-fx-font-size: 20; -fx-font-family: regular;");
		cancelText.setFill(Color.WHITE);

		cancelButton.getChildren().add(cancelText);

		HBox returnButton = new HBox();

		returnButton.setPrefSize(109, 28);
		returnButton.setTranslateX(500);
		returnButton.setTranslateY(8);
		returnButton.setAlignment(Pos.CENTER);
		returnButton.getStyleClass().add("returnButton");

		Text customText = new Text("Back");

		customText.setStyle("-fx-font-size: 20; -fx-font-family: regular;");
		customText.setFill(Color.WHITE);

		returnButton.getChildren().add(customText);
		
		returnButton.setOnMouseClicked(event -> {App.setScene(ChooseVersionScene.get());});
		cancelButton.setOnMouseClicked(event -> {App.setScene(MainScene.get());});
		
		
		choiseBar.getChildren().addAll(nextButton, cancelButton, returnButton);
		
		pane.getChildren().addAll(leftShutter, choiseBar);
	}
	
}

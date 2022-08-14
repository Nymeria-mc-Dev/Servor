package fr.nymeria.servor.ui;


import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.MainScene;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ChooseVersion {

	public ChooseVersion(Pane pane) {

		Pane server = new Pane();

		server.setPrefSize(206, 720);
		server.getStyleClass().add("menu");

		HBox switcher = new HBox();

		switcher.setPrefSize(206, 66);
		switcher.setTranslateY(35);
		switcher.getStyleClass().add("all");

		Rectangle blueBar = new Rectangle();

		blueBar.setWidth(4);
		blueBar.setHeight(66);
		blueBar.setTranslateX(202);
		blueBar.getStyleClass().add("blueBar");

		switcher.getChildren().add(blueBar);

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

		HBox customButton = new HBox();

		customButton.setPrefSize(109, 28);
		customButton.setTranslateX(468);
		customButton.setTranslateY(8);
		customButton.setAlignment(Pos.CENTER);
		customButton.getStyleClass().add("customButton");

		Text customText = new Text("Custom");

		customText.setStyle("-fx-font-size: 20; -fx-font-family: regular;");
		customText.setFill(Color.WHITE);

		customButton.getChildren().add(customText);

		choiseBar.getChildren().addAll(nextButton, cancelButton, customButton);


		HBox paper = addButton("Paper", 35);

		HBox spigot = addButton("Spigot", 101);

		HBox bukkit = addButton("Bukkit", 167);

		HBox mohist = addButton("Mohist", 233);

		HBox forge = addButton("Forge", 299);

		HBox magma = addButton("Magma", 365);

		paper.setOnMouseClicked(event -> {
			moveSwitcher(switcher, 35);
			ServerSelector.setPaperVisible(true);
		});

		spigot.setOnMouseClicked(event -> {
			moveSwitcher(switcher, 101);
			ServerSelector.setSpigotVisible(true);
		});

		bukkit.setOnMouseClicked(event -> {
			moveSwitcher(switcher, 167);
			ServerSelector.setBukkitVisible(true);
		});

		mohist.setOnMouseClicked(event -> {
			moveSwitcher(switcher, 233);
			ServerSelector.setMohistVisible(true);
		});

		forge.setOnMouseClicked(event -> {
			moveSwitcher(switcher, 299);
			ServerSelector.setForgeVisible(true);
		});

		magma.setOnMouseClicked(event -> {
			moveSwitcher(switcher, 365);
			ServerSelector.setMagmaVisible(true);
		});


		cancelButton.setOnMouseClicked(event -> {App.setScene(MainScene.get());});


		server.getChildren().addAll(switcher, paper, spigot, bukkit, mohist, forge, magma);

		pane.getChildren().addAll(server, choiseBar);
	}


	private static void moveSwitcher(HBox switcher, double posY) {
		TranslateTransition transition = new TranslateTransition(Duration.millis(500), switcher);
		transition.setByY(posY - switcher.getTranslateY());

		transition.play();
	}


	private static HBox addButton(String buttonName, double posY) {
		HBox button = new HBox();

		button.setPrefSize(206, 66);
		button.setTranslateY(posY);
		button.setAlignment(Pos.CENTER);

		Text text = new Text(buttonName);

		text.setFont(Font.font("regular", FontWeight.BOLD, 32));
		text.setFill(Color.WHITE);

		button.getChildren().add(text);
		return button;
	}

}

package fr.nymeria.servor.ui;

import fr.nymeria.servor.App;
import fr.nymeria.servor.helpers.Settings;
import fr.nymeria.servor.scenes.MainScene;
import fr.nymeria.servor.scenes.ParametreScene;
import fr.nymeria.servor.ui.elements.CustomJarBox;
import fr.nymeria.servor.ui.elements.ServerSelector;
import javafx.animation.ScaleTransition;
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

	public static HBox nextButton;

	private Boolean customClicked = false;

	private static Text versionText;

	public ChooseVersion(Pane pane) {

		Pane server = new Pane();

		server.setPrefSize(206, 720);
		server.getStyleClass().add("menu");

		Text minecraftVersionText = new Text("Minecraft Version :");

		minecraftVersionText.setFill(Color.WHITE);
		minecraftVersionText.setStyle("-fx-font-size: 20px;");

		versionText = new Text(" Paper 1.19.2");
		Settings.ServerVersion = " Paper 1.19.2";

		versionText.setFill(Color.WHITE);
		versionText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

		HBox versionTextBox = new HBox();

		versionTextBox.setTranslateX(42);
		versionTextBox.setAlignment(Pos.CENTER);
		versionTextBox.setPrefSize(383, 44);

		versionTextBox.getChildren().addAll(minecraftVersionText, versionText);

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

		nextButton = new HBox();

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

		CustomJarBox customPane = new CustomJarBox();

		choiseBar.getChildren().addAll(nextButton, cancelButton, customButton, versionTextBox);


		HBox paper = addButton("Paper", 35);

		HBox spigot = addButton("Spigot", 101);

		HBox bukkit = addButton("Bukkit", 167);

		HBox mohist = addButton("Mohist", 233);

		HBox forge = addButton("Forge", 299);

		HBox magma = addButton("Magma", 365);

		paper.setOnMouseClicked(event -> {
			changeServer(switcher, blueBar, 35, ServerSelector.getPaper());
		});

		spigot.setOnMouseClicked(event -> {
			changeServer(switcher, blueBar, 101, ServerSelector.getSpigot());
		});

		bukkit.setOnMouseClicked(event -> {
			changeServer(switcher, blueBar, 167, ServerSelector.getBukkit());
		});

		mohist.setOnMouseClicked(event -> {
			changeServer(switcher, blueBar, 233, ServerSelector.getMohist());
		});

		forge.setOnMouseClicked(event -> {
			changeServer(switcher, blueBar, 299, ServerSelector.getForge());
		});

		magma.setOnMouseClicked(event -> {
			changeServer(switcher, blueBar, 365, ServerSelector.getMagma());
		});

		customButton.setOnMouseClicked(e -> {
			if (customClicked) {
				customPane.setVisible(false);
				customClicked = false;
			} else {
				customPane.setVisible(true);
				customClicked = true;
			}				
		});
		nextButton.setOnMouseClicked(e -> {
			App.setScene(ParametreScene.get());				
		});


		cancelButton.setOnMouseClicked(event -> {App.setScene(MainScene.get());});


		server.getChildren().addAll(switcher, paper, spigot, bukkit, mohist, forge, magma);

		pane.getChildren().addAll(server, customPane.get(), choiseBar);
	}

	public static void setVersionText(String text) {
		versionText.setText(text);
		Settings.ServerVersion = text;
	}

	private void changeServer(HBox switcher, Rectangle blueBar, double posY, Pane newServer) {

		Pane holdServer = ServerSelector.getVisibleServer();
		
		newServer.setVisible(true);
		
		double initialSwitcherY = switcher.getTranslateY();
		
		TranslateTransition translationHold = new TranslateTransition(Duration.millis(1000), holdServer);
		TranslateTransition translationNew = new TranslateTransition(Duration.millis(1000), newServer);

		if(initialSwitcherY - posY > 0) { //le switcher monte
			newServer.setTranslateX(-1080);
			translationHold.setByX(1080);
			translationNew.setToX(0);
		}else if(initialSwitcherY - posY < 0) { //le switcher dessend
			newServer.setTranslateX(1080);
			translationHold.setByX(-1080);
			translationNew.setToX(0);
		}

		translationHold.setOnFinished(event -> {
            holdServer.setVisible(false);
        });
		
		translationHold.setCycleCount(1);
		translationNew.setCycleCount(1);
		
		translationHold.play();
		translationNew.play();

		ScaleTransition st = new ScaleTransition(Duration.millis(200), blueBar);
		st.setFromX(0);
		st.setToX(1);

		TranslateTransition transition = new TranslateTransition(Duration.millis(500), switcher);
		transition.setToY(posY);
		transition.setOnFinished(e -> {
			st.play();
		});

		ScaleTransition blueBarT = new ScaleTransition(Duration.millis(200), blueBar);
		blueBarT.setFromX(1);
		blueBarT.setToX(0);
		blueBarT.setOnFinished(e -> {
			transition.play();
		});

		blueBarT.play();
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

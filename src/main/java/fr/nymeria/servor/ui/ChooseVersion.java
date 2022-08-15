package fr.nymeria.servor.ui;


import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.MainScene;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ChooseVersion {
	
	private Boolean customClicked = false;
	
	private static Text versionText;

	public ChooseVersion(Pane pane) {

		Pane server = new Pane();

		server.setPrefSize(206, 720);
		server.getStyleClass().add("menu");

		Text minecraftVersionText = new Text("minecraft version :");
		
		minecraftVersionText.setFill(Color.WHITE);
		minecraftVersionText.setStyle("-fx-font-size: 20px;");
		
		versionText = new Text(" Paper 1.19.2");
		
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
		
		Pane customPane = new Pane();
		customPane.setVisible(false);
		customPane.setPrefSize(227, 261);
		customPane.getStyleClass().add("customCard");
		customPane.setTranslateX(615);
		customPane.setTranslateY(400);
		
		VBox customJarBox = new VBox();
		customJarBox.setAlignment(Pos.CENTER);
		
		HBox customJarButton = new HBox();
		customJarButton.setPrefSize(226, 40);
		customJarBox.setAlignment(Pos.BASELINE_CENTER);
		
		Text customJarText = new Text("Custom JAR : ");
		customJarText.setFill(Color.WHITE);
		
		Text customJarButtonText = new Text("Choose");
		customJarButtonText.setFill(Color.WHITE);
		
		Rectangle rect = new Rectangle();
		rect.setFill(Color.GRAY);
		rect.setWidth(226);
		rect.setHeight(20);
		
		customJarButton.getChildren().addAll(customJarText, customJarButtonText, rect);
		
		// JDK 17
		
		VBox jdk17Box = new VBox();
		jdk17Box.setPrefSize(226, 40);
		jdk17Box.setAlignment(Pos.CENTER);
		
		Text jdk17 = new Text("JDK 17");
		jdk17.setFill(Color.WHITE);
		
		jdk17Box.getChildren().add(jdk17);
		
		// JDK 16
		
		VBox jdk16Box = new VBox();
		jdk16Box.setPrefSize(226, 40);
		jdk16Box.setAlignment(Pos.CENTER);
		
		Text jdk16 = new Text("JDK 16");
		jdk16.setFill(Color.WHITE);
		
		jdk16Box.getChildren().add(jdk16);
		
		// JDK 11
		
		VBox jdk11Box = new VBox();
		jdk11Box.setPrefSize(226, 40);
		jdk11Box.setAlignment(Pos.CENTER);
		
		Text jdk11 = new Text("JDK 11");
		jdk11.setFill(Color.WHITE);
		
		jdk11Box.getChildren().add(jdk11);
		
		// JDK 8
		
		VBox jdk8Box = new VBox();
		jdk8Box.setPrefSize(226, 40);
		jdk8Box.setAlignment(Pos.CENTER);
		
		Text jdk8 = new Text("JDK 8");
		jdk8.setFill(Color.WHITE);
		
		jdk8Box.getChildren().add(jdk8);
		
		// JDK 7
		
		VBox jdk7Box = new VBox();
		jdk7Box.setPrefSize(226, 40);
		jdk7Box.setAlignment(Pos.CENTER);
		
		Text jdk7 = new Text("JDK 7");
		jdk7.setFill(Color.WHITE);
		
		jdk7Box.getChildren().add(jdk7);
		
		// Adding all to custom bar
		
		customJarBox.getChildren().addAll(customJarButtonText, jdk17Box, jdk16Box, jdk11Box, jdk8Box, jdk7Box);
		
		customPane.getChildren().addAll(customJarText, customJarBox);

		choiseBar.getChildren().addAll(nextButton, cancelButton, customButton, versionTextBox);


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
		
		customButton.setOnMouseClicked(e -> {
			if (customClicked) {
				customPane.setVisible(false);
				customClicked = false;
			} else {
				customPane.setVisible(true);
				customClicked = true;
			}				
		});


		cancelButton.setOnMouseClicked(event -> {App.setScene(MainScene.get());});


		server.getChildren().addAll(switcher, paper, spigot, bukkit, mohist, forge, magma);

		pane.getChildren().addAll(server, choiseBar, customPane);
	}

	public static void setVersionText(String text) {
		versionText.setText(text);
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

package fr.nymeria.servor.ui;


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
		server.getStyleClass().add("server");
		
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
		
		
		HBox all = addButton("All", 35);
		
		HBox paper = addButton("Paper", 101);
		
		HBox spigot = addButton("Spigot", 167);
		
		HBox bukkit = addButton("Bukkit", 233);
		
		HBox mohist = addButton("Mohist", 299);
		
		HBox forge = addButton("Forge", 365);
		
		HBox magma = addButton("Magma", 431);
		
		all.setOnMouseClicked(event -> {moveSwitcher(switcher, 35);});
		
		paper.setOnMouseClicked(event -> {moveSwitcher(switcher, 101);});
		
		spigot.setOnMouseClicked(event -> {moveSwitcher(switcher, 167);});
		
		bukkit.setOnMouseClicked(event -> {moveSwitcher(switcher, 233);});
		
		mohist.setOnMouseClicked(event -> {moveSwitcher(switcher, 299);});
		
		forge.setOnMouseClicked(event -> {moveSwitcher(switcher, 365);});
		
		magma.setOnMouseClicked(event -> {moveSwitcher(switcher, 431);});
		
		server.getChildren().addAll(switcher, all, paper, spigot, bukkit, mohist, forge, magma);
		
		pane.getChildren().add(server);
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

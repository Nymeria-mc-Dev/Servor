package fr.nymeria.servor.ui;


import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
		
		server.getChildren().addAll(switcher, all, paper, spigot, bukkit);
		
		pane.getChildren().add(server);
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

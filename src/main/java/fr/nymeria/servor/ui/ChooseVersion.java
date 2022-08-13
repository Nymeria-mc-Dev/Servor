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
		
		
		HBox all = new HBox();
		
		all.setPrefSize(206, 66);
		all.setTranslateY(35);
		all.setAlignment(Pos.CENTER);
		
		Text allText = new Text("All");
		
		allText.setFont(Font.font("regular", FontWeight.BOLD, 32));
		allText.setFill(Color.WHITE);
		
		all.getChildren().add(allText);
		
		
		HBox paper = new HBox();
		
		paper.setPrefSize(206, 66);
		paper.setTranslateY(101);
		paper.setAlignment(Pos.CENTER);
		
		Text paperText = new Text("Paper");
		
		paperText.setFont(Font.font("regular", FontWeight.BOLD, 32));
		paperText.setFill(Color.WHITE);
		
		paper.getChildren().add(paperText);
		
		
		HBox spigot = new HBox();
		
		spigot.setPrefSize(206, 66);
		spigot.setTranslateY(167);
		spigot.setAlignment(Pos.CENTER);
		
		Text spigotText = new Text("Spigot");
		
		spigotText.setFont(Font.font("regular", FontWeight.BOLD, 32));
		spigotText.setFill(Color.WHITE);
		
		spigot.getChildren().add(spigotText);
		
		
		HBox bukkit = new HBox();
		
		bukkit.setPrefSize(206, 66);
		bukkit.setTranslateY(233);
		bukkit.setAlignment(Pos.CENTER);
		
		Text bukkitText = new Text("Bukkit");
		
		bukkitText.setFont(Font.font("regular", FontWeight.BOLD, 32));
		bukkitText.setFill(Color.WHITE);
		
		bukkit.getChildren().add(bukkitText);
		
		server.getChildren().addAll(switcher, all, paper, spigot, bukkit);
		
		pane.getChildren().add(server);
	}
	
}

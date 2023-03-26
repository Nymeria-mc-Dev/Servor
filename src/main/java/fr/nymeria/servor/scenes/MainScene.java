package fr.nymeria.servor.scenes;

import fr.nymeria.servor.App;
import fr.nymeria.servor.helpers.Discord;
import fr.nymeria.servor.ui.elements.AddServerButton;
import fr.nymeria.servor.ui.elements.ServerCard;
import fr.nymeria.servor.ui.elements.TopBar;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainScene {

	private static Stage stage;
	private static Pane pane = new Pane();
	private static Scene scene = new Scene(pane, 1080, 720);
	
	private static boolean loaded = false;
	
	public static Scene get() {
		
		stage = App.getStage();
        
        pane.setStyle("-fx-background-color: #272727;");
        
        if(!loaded) {
        	addElements();
        	addStyleSheets();
        }
        
        Discord.setDetail("Tout est calme pour le moment");
        Discord.setState("Home");
        Discord.setSmallImage("home");
        
        loaded = true;
    
        /*ProgressBar bar = new ProgressBar();
        bar.setPrefSize(1080, 2);
        bar.setProgress(0.62);
        
        pane.getChildren().add(bar);*/
        
		return scene;
	}
	
	private static void addStyleSheets() {
    	pane.getStylesheets().add(App.class.getResource("/css/ServerCard.css").toExternalForm());
    	pane.getStylesheets().add(App.class.getResource("/css/test.css").toExternalForm());
    }
    
    private static void addElements() {
    	new AddServerButton(pane, stage);
    	new ServerCard(pane, 178, 56);
    	new ServerCard(pane, 594, 56);
    	new ServerCard(pane, 178, 286);
    	new ServerCard(pane, 594, 286);
    	new ServerCard(pane, 178, 520);
    	new ServerCard(pane, 594, 520);
    	new TopBar(pane, stage);
    }
}

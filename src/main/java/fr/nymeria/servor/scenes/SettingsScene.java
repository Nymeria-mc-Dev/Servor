package fr.nymeria.servor.scenes;

import fr.nymeria.servor.App;
import fr.nymeria.servor.helpers.Discord;
import fr.nymeria.servor.ui.elements.TopBar;
import fr.nymeria.servor.ui.elements.Settings.BackButton;
import fr.nymeria.servor.ui.elements.Settings.DockerPath;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingsScene {

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
        
        Discord.setDetail("Dans les parametres");
        Discord.setState("Settings");
        Discord.setSmallImage("settings");
        
        loaded = true;
        
		return scene;
	}
	
	private static void addStyleSheets() {
		
    }
    
    private static void addElements() {
    	new TopBar(pane, stage);
    	new BackButton(pane, stage);
    	new DockerPath(pane);
    }
}

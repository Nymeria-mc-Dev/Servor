package fr.nymeria.servor.scenes;

import fr.nymeria.servor.App;
import fr.nymeria.servor.ui.AddServerButton;
import fr.nymeria.servor.ui.TopBar;
import fr.nymeria.servor.ui.elements.ServerCard;
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
        
        loaded = true;
        
		return scene;
	}
	
	private static void addStyleSheets() {
    	pane.getStylesheets().add(App.class.getResource("/css/ServerCard.css").toExternalForm());
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

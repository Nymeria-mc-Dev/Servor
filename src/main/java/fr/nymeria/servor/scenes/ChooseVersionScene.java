package fr.nymeria.servor.scenes;

import fr.nymeria.servor.App;
import fr.nymeria.servor.helpers.Discord;
import fr.nymeria.servor.ui.ChooseVersion;
import fr.nymeria.servor.ui.elements.ServerSelector;
import fr.nymeria.servor.ui.elements.TopBar;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChooseVersionScene {

	private static Stage stage;
	private static Pane pane = new Pane();
	private static Scene scene = new Scene(pane, 1080, 720);

	private static boolean loaded = false;

	public static Scene get() {

		stage = App.getStage();

		pane.setStyle("-fx-background-color: #272727;");

		Discord.setDetail("Créer un nouveau serveur");
        Discord.setState("Create serveur");
        Discord.setSmallImage("plus");
		
        if(!loaded) {
			addElements();
			addStyleSheets();
		}
        
		loaded = true;

		return scene;
	}

	private static void addStyleSheets() {
		pane.getStylesheets().add(App.class.getResource("/css/ChooseVersion.css").toExternalForm());
	}

	private static void addElements() {
		ServerSelector.setPane(pane);
		new ChooseVersion(pane);
		new TopBar(pane, stage);
	}

}

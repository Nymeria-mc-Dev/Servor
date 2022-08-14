package fr.nymeria.servor.scenes;

import fr.nymeria.servor.App;
import fr.nymeria.servor.ui.ChooseVersion;
import fr.nymeria.servor.ui.TopBar;
import fr.nymeria.servor.ui.elements.VersionCard;
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
		new ChooseVersion(pane);
		new TopBar(pane, stage);
		new VersionCard(pane, 276, 85, "1.19.1");
	}

}

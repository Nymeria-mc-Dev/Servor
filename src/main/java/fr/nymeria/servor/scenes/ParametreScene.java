package fr.nymeria.servor.scenes;

import fr.nymeria.servor.App;
import fr.nymeria.servor.helpers.Discord;
import fr.nymeria.servor.ui.Parameter;
import fr.nymeria.servor.ui.elements.ParameterContentPage;
import fr.nymeria.servor.ui.elements.SideParameterPanel;
import fr.nymeria.servor.ui.elements.TopBar;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class ParametreScene {

	private static Stage stage;
	private static Pane pane = new Pane();
	private static Scene scene = new Scene(pane, 1080, 720);

	private static SideParameterPanel spp;
	
	private static boolean loaded = false;

	public static Scene get() {

		stage = App.getStage();

		pane.setStyle("-fx-background-color: #272727;");

		if(!loaded) {
			addElements();
			addStyleSheets();
		}else {
			spp.updateServerVersion();
		}

		Discord.setDetail("En configuration d'un serveur");
        Discord.setState("Settings");
        Discord.setSmallImage("settings");
		
		loaded = true;

		return scene;
	}

	private static void addStyleSheets() {
		pane.getStylesheets().add(Objects.requireNonNull(App.class.getResource("/css/Parameters.css")).toExternalForm());
	}

	private static void addElements() {
		new Parameter(pane);
		spp = new SideParameterPanel(pane);
		new TopBar(pane, stage);
		new ParameterContentPage(pane, spp);
	}

}

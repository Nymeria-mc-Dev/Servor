package fr.nymeria.servor.scenes;

import fr.nymeria.servor.App;
import fr.nymeria.servor.ui.ChooseVersion;
import fr.nymeria.servor.ui.TopBar;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChooseVersionScene {

	private static Stage stage;
	private static Pane pane = new Pane();

	public static Scene get() {

		stage = App.getStage();

		Scene scene = new Scene(pane, 1080, 720);

		pane.setStyle("-fx-background-color: #272727;");

		addElements();

		addStyleSheets();
		return scene;
	}

	private static void addStyleSheets() {
		pane.getStylesheets().add(App.class.getResource("/css/ChooseVersion.css").toExternalForm());
	}

	private static void addElements() {
		new ChooseVersion(pane);
		new TopBar(pane, stage);
	}

}

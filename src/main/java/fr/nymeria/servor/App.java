package fr.nymeria.servor;

import java.io.IOException;

import fr.nymeria.servor.helpers.Servor;
import fr.nymeria.servor.scenes.ChooseVersionScene;
import fr.nymeria.servor.scenes.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

	private static Stage stage;

	@Override
	public void start(Stage stage) throws IOException {

		this.stage = stage;

		Servor.init(stage);

		/*Stage loading = new Stage();
		loading.getIcons().add(new Image(this.getClass().getResource("/icons/logo.png").toExternalForm()));
		loading.initStyle(StageStyle.UNDECORATED);
		loading.setResizable(false);
		loading.setTitle("Servor");
		loading.setScene(ChooseVersionScene.get());
		loading.show();*/

		stage.getIcons().add(new Image(this.getClass().getResource("/icons/logo.png").toExternalForm()));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.setTitle("Servor");
		setScene(MainScene.get());
		stage.show();

	}

	public static Stage getStage() {
		return stage;
	}

	public static void setScene(Scene scene) {
		stage.setScene(scene);
	}

	public static void main(String[] args) {
		launch();
	}

}
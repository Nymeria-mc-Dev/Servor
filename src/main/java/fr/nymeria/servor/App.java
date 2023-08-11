package fr.nymeria.servor;

import java.io.IOException;
import java.net.URL;

import fr.nymeria.servor.helpers.Loading;
import fr.nymeria.servor.helpers.Servor;
import fr.nymeria.servor.scenes.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

	private static Stage stage;
	private static final Image appLogo = new Image(getResource("/icons/logo.png").toExternalForm());

	@Override
	public void start(Stage stage) throws IOException {

		App.stage = stage;

		Stage loading = new Stage();
		loading.getIcons().add(appLogo);
		loading.initStyle(StageStyle.UNDECORATED);
		loading.setResizable(false);
		loading.setTitle("Servor - Loading");
		loading.setScene(Loading.get(loading));
		loading.show();

		Servor.init(stage);

		stage.getIcons().add(appLogo);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.setTitle("Servor");
		setScene(MainScene.get());
		stage.show();

		Loading.close();


	}

	public static URL getResource(String ressource) {
		return App.class.getResource(ressource);
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
package fr.nymeria.servor.scenes;

import fr.nymeria.servor.App;
import fr.nymeria.servor.helpers.Discord;
import fr.nymeria.servor.ui.elements.Manage.ManageOptionSidePanel;
import fr.nymeria.servor.ui.elements.Settings.BackButton;
import fr.nymeria.servor.ui.elements.TopBar;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class ManageServerScene {
    private static Stage stage;
    private static Pane pane = new Pane();
    private static Scene scene = new Scene(pane, 1080, 720);
    private static boolean loaded = false;


    private static String managedServer = "Server Test";

    public static Scene get() {
        stage = App.getStage();

        pane.setStyle("-fx-background-color: #272727;");

        if(!loaded) {
            addElements();
            addStyleSheets();
        }

        Discord.setDetail("Gestion de son serveur " + managedServer);
        Discord.setState("Manage server");
        Discord.setSmallImage("settings");

        loaded = true;

        return scene;
    }

    private static void addStyleSheets() {
        pane.getStylesheets().add(Objects.requireNonNull(App.class.getResource("/css/ManageServer.css")).toExternalForm());
    }

    private static void addElements() {
        new ManageOptionSidePanel(pane);
        new BackButton(pane, stage);
        new TopBar(pane, stage);
    }
}

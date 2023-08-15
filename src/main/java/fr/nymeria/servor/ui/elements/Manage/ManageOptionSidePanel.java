package fr.nymeria.servor.ui.elements.Manage;

import fr.nymeria.servor.ui.elements.ServerSelector;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ManageOptionSidePanel {
    private static final Pane console = new ConsolePane().get();
    private static final Pane config = new ConfigPane().get();
    private static final Pane files = new FilesPane().get();
    private static final Pane explorer = new ExplorerPane().get();

    private static Pane selectedServer = console;

    public ManageOptionSidePanel(Pane pane) {
        this.createSideChoiceButtons(pane);
    }

    private void createSideChoiceButtons(Pane pane) {
        Pane server = new Pane();

        server.setPrefSize(206, 720);
        server.getStyleClass().add("menu");

        HBox switcher = new HBox();

        switcher.setPrefSize(206, 66);
        switcher.setTranslateY(35);
        switcher.getStyleClass().add("all");

        Rectangle blueBar = new Rectangle();

        blueBar.setWidth(4);
        blueBar.setHeight(66);
        blueBar.setTranslateX(202);
        blueBar.getStyleClass().add("blueBar");

        switcher.getChildren().add(blueBar);

        HBox consoleButton = addButton("Console", 35);

        HBox configButton = addButton("Config", 101);

        HBox filesButton = addButton("Files", 167);

        HBox explorerButton = addButton("Explorer", 233);

        consoleButton.setOnMouseClicked(event -> {
            changeServer(switcher, blueBar, 35, console);
        });

        configButton.setOnMouseClicked(event -> {
            changeServer(switcher, blueBar, 101, config);
        });

        filesButton.setOnMouseClicked(event -> {
            changeServer(switcher, blueBar, 167, files);
        });

        explorerButton.setOnMouseClicked(event -> {
            changeServer(switcher, blueBar, 233, explorer);
        });

        server.getChildren().addAll(switcher, consoleButton, configButton, filesButton, explorerButton);

        pane.getChildren().addAll(server);
    }

    private void changeServer(HBox switcher, Rectangle blueBar, double posY, Pane newServer) {
        Pane holdServer = selectedServer;
        selectedServer = newServer;

        newServer.setVisible(true);

        double initialSwitcherY = switcher.getTranslateY();

        TranslateTransition translationHold = new TranslateTransition(Duration.millis(1000), holdServer);
        TranslateTransition translationNew = new TranslateTransition(Duration.millis(1000), newServer);

        if (initialSwitcherY - posY > 0) { //le switcher monte
            newServer.setTranslateX(-1080);
            translationHold.setByX(1080);
            translationNew.setToX(0);
        } else if (initialSwitcherY - posY < 0) { //le switcher dessend
            newServer.setTranslateX(1080);
            translationHold.setByX(-1080);
            translationNew.setToX(0);
        }

        translationHold.setOnFinished(event -> {
            holdServer.setVisible(false);
        });

        translationHold.setCycleCount(1);
        translationNew.setCycleCount(1);

        translationHold.play();
        translationNew.play();

        ScaleTransition blueBarT = getScaleTransition(switcher, blueBar, posY);

        blueBarT.play();
    }

    private static ScaleTransition getScaleTransition(HBox switcher, Rectangle blueBar, double posY) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), blueBar);
        st.setFromX(0);
        st.setToX(1);

        TranslateTransition transition = new TranslateTransition(Duration.millis(500), switcher);
        transition.setToY(posY);
        transition.setOnFinished(e -> {
            st.play();
        });

        ScaleTransition blueBarT = new ScaleTransition(Duration.millis(200), blueBar);
        blueBarT.setFromX(1);
        blueBarT.setToX(0);
        blueBarT.setOnFinished(e -> {
            transition.play();
        });
        return blueBarT;
    }


    private static HBox addButton(String buttonName, double posY) {
        HBox button = new HBox();

        button.setPrefSize(206, 66);
        button.setTranslateY(posY);
        button.setAlignment(Pos.CENTER);

        Text text = new Text(buttonName);

        text.setFont(Font.font("regular", FontWeight.BOLD, 32));
        text.setFill(Color.WHITE);

        button.getChildren().add(text);
        return button;
    }

    public void setConsoleVisible() {
        console.setVisible(true);
    }

    public void setConfigVisible() {
        config.setVisible(true);
    }

    public void setFilesVisible() {
        files.setVisible(true);
    }

    public void setExplorerVisible() {
        explorer.setVisible(true);
    }

    public void setAllInvisible() {
        console.setVisible(false);
        config.setVisible(false);
        files.setVisible(false);
        explorer.setVisible(false);
    }
}

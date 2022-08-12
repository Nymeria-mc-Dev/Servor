package fr.nymeria.servor;

import java.io.IOException;

import fr.nymeria.servor.ui.AddServerButton;
import fr.nymeria.servor.ui.TopBar;
import fr.nymeria.servor.ui.elements.ServerCard;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    private static Scene scene;
    private static Pane pane = new Pane();
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(pane, 1080, 720);
        
        pane.setStyle("-fx-background-color: #272727;");
        
        addStyleSheets();
        
        showPageOne(stage);
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("Eclipse > Intellij");
        stage.setScene(scene);
        stage.show();
    }
    
    private void showPageOne(Stage stage) {
    	new AddServerButton(stage);
    	new ServerCard(178, 56);
    	new ServerCard(594, 56);
    	new ServerCard(178, 286);
    	new ServerCard(594, 286);
    	new ServerCard(178, 520);
    	new ServerCard(594, 520);
    	new TopBar(stage);
    }
    
    private void showPageTwo(Stage stage) {
    	new AddServerButton(stage);
    	new TopBar(stage);
    }
    
    private void clearePage(Stage stage) {}
    
    private void addStyleSheets() {
    	pane.getStylesheets().add(App.class.getResource("/css/ServerCard.css").toExternalForm());
    }
    
    public static void addItem(Node... node) {
    	pane.getChildren().addAll(node);
    }

    public static void main(String[] args) {
        launch();
    }

}
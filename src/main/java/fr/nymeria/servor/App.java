package fr.nymeria.servor;

import java.io.IOException;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.ui.TopBar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    private static Scene scene;
    private static GridPane pane = new GridPane();
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(pane, 1080, 720);
        
        initialize(stage);
        
        pane.setStyle("-fx-background-color: #272727;");
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("Eclipse > Intellij");
        stage.setScene(scene);
        stage.show();
    }
    
    private void initialize(Stage stage) {
    	new TopBar(stage);
    }
    
    public static void addItem(Node... node) {
    	pane.getChildren().addAll(node);
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
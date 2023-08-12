package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.helpers.Settings;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.swing.*;

public class ParameterContentPage {
    public ParameterContentPage(Pane pane) {

        VBox root = new VBox();
        root.setTranslateY(55.0d);
        root.setTranslateX(355.0d);

        TextField serverNameField = new TextField(Settings.ServerVersion);
        serverNameField.setMinWidth(650.0d);
        serverNameField.setMinHeight(70.0d);
        serverNameField.setFont(Font.font("Poppins", FontWeight.NORMAL, 36));
        serverNameField.setStyle("-fx-background-color: #363636; -fx-background-radius: 9px; -fx-alignment: center; -fx-text-fill: #fff");

        root.getChildren().addAll(serverNameField);

        pane.getChildren().add(root);

    }

    private TextField createTextField() {
        return new TextField("Att julfit");
    }
}

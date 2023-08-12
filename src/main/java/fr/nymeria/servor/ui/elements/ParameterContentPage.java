package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.helpers.Settings;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javax.swing.*;

public class ParameterContentPage {
    public ParameterContentPage(Pane pane) {

        VBox root = new VBox();
        root.setTranslateY(55.0d);
        root.setTranslateX(355.0d);

        // Server Name Text Field
        TextField serverNameField = createTextField(Settings.ServerVersion, 650.0d, 70.0d, 36);

        // Server Port Text Field
        HBox serverPortBox = new HBox();
        serverPortBox.setTranslateY(50.0d);

        Text serverPort = new Text("Server Port : ");
        serverPort.setTranslateY(10.0d);
        serverPort.setFill(Color.WHITE);
        serverPort.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        TextField serverPortField = createTextField("25565", 170.0d, 40.0d, 24);

        serverPortBox.getChildren().addAll(serverPort, serverPortField);

        // Server Max Ram Slider

        root.getChildren().addAll(serverNameField, serverPortBox);

        pane.getChildren().add(root);

    }

    private TextField createTextField(String text, double width, double height, int fontSize) {
        TextField textField = new TextField(text);
        textField.setMinWidth(width);
        textField.setMinHeight(height);
        textField.setFont(Font.font("Poppins", FontWeight.NORMAL, fontSize));
        textField.setStyle("-fx-background-color: #363636; -fx-background-radius: 9px; -fx-alignment: center; -fx-text-fill: #fff");

        return textField;
    }
}

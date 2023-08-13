package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.helpers.Settings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
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
        serverPort.setTranslateY(4.0d);
        serverPort.setFill(Color.WHITE);
        serverPort.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        TextField serverPortField = createTextField("25565", 170.0d, 40.0d, 24);

        serverPortBox.getChildren().addAll(serverPort, serverPortField);

        // Server Max Ram Slider
        HBox serverMaxRamBox = new HBox();
        serverMaxRamBox.setTranslateY(80.0d);

        Text serverMaxRam = new Text("Max. Ram : ");
        serverMaxRam.setTranslateY(10.0d);
        serverMaxRam.setFill(Color.WHITE);
        serverMaxRam.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        Slider serverMaxRamSlider = new Slider();
        serverMaxRamSlider.setTranslateY(20.0d);
        serverMaxRamSlider.setMinWidth(410.0d);
        serverMaxRamSlider.setMin(1024);
        serverMaxRamSlider.setMax(10240);
        serverMaxRamSlider.getStyleClass().add("slider");

        TextField serverMaxRamField = createTextField("1024 Mb", 122.0d, 60.0d, 20);
        serverMaxRamField.setTranslateX(20.0d);

        serverMaxRamSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            serverMaxRamField.setText((int) serverMaxRamSlider.getValue() + " Mb");

            int percent = (int) (100 *  (serverMaxRamSlider.getValue() - serverMaxRamSlider.getMin()) / (serverMaxRamSlider.getMax() - serverMaxRamSlider.getMin()));
            System.out.println(percent);
            serverMaxRamSlider.setStyle("-fx-background-color: linear-gradient(to right, #0066FF " + percent + "%, #363636 " + percent + "%);");
        });

        serverMaxRamBox.getChildren().addAll(serverMaxRam, serverMaxRamSlider, serverMaxRamField);

        root.getChildren().addAll(serverNameField, serverPortBox, serverMaxRamBox);

        pane.getChildren().add(root);

    }

    private TextField createTextField(String text, double width, double height, int fontSize) {
        TextField textField = new TextField(text);
        textField.setMinWidth(width);
        textField.setMinHeight(height);
        textField.setMaxWidth(width);
        textField.setMaxHeight(height);
        textField.setFont(Font.font("Poppins", FontWeight.NORMAL, fontSize));
        textField.setStyle("-fx-background-color: #363636; -fx-background-radius: 9px; -fx-alignment: center; -fx-text-fill: #fff");

        return textField;
    }
}

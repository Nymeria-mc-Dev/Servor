package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.helpers.Settings;
import javafx.scene.control.CheckBox;
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
    private TextField serverJavaArgsField;
    public ParameterContentPage(Pane pane, SideParameterPanel sideParameterPanel) {

        VBox root = new VBox();
        root.setTranslateY(55.0d);
        root.setTranslateX(355.0d);

        // Server Name Text Field
        TextField serverNameField = createTextField(Settings.ServerVersion, 650.0d, 70.0d, 36);
        serverNameField.textProperty().addListener((obs, oldValue, newValue) -> sideParameterPanel.setServerName(serverNameField.getText()));

        // Server Port Text Field
        HBox serverPortBox = new HBox();
        serverPortBox.setTranslateY(50.0d);

        Text serverPort = new Text("Server Port : ");
        serverPort.setTranslateY(4.0d);
        serverPort.setFill(Color.WHITE);
        serverPort.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        TextField serverPortField = createTextField("25565", 170.0d, 40.0d, 24);
        serverPortField.textProperty().addListener((obs, oldv, newv) -> sideParameterPanel.setServerPort(serverPortField.getText()));

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

        serverMaxRamBox.getChildren().addAll(serverMaxRam, serverMaxRamSlider, serverMaxRamField);

        // Server Min Ram Slider
        HBox serverMinRamBox = new HBox();
        serverMinRamBox.setTranslateY(100.0d);

        Text serverMinRam = new Text("Min. Ram :  ");
        serverMinRam.setTranslateY(10.0d);
        serverMinRam.setFill(Color.WHITE);
        serverMinRam.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        Slider serverMinRamSlider = new Slider();
        serverMinRamSlider.setTranslateY(20.0d);
        serverMinRamSlider.setMinWidth(410.0d);
        serverMinRamSlider.setMin(1024);
        serverMinRamSlider.setMax(10240);
        serverMinRamSlider.getStyleClass().add("slider");

        TextField serverMinRamField = createTextField("1024 Mb", 122.0d, 60.0d, 20);
        serverMinRamField.setTranslateX(20.0d);

        serverMaxRamSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            serverMaxRamField.setText((int) serverMaxRamSlider.getValue() + " Mb");

            int percent = (int) (100 *  (serverMaxRamSlider.getValue() - serverMaxRamSlider.getMin()) / (serverMaxRamSlider.getMax() - serverMaxRamSlider.getMin()));
            serverMaxRamSlider.setStyle("-fx-background-color: linear-gradient(to right, #0066FF " + percent + "%, #363636 " + percent + "%);");

            if (serverMaxRamSlider.getValue() < serverMinRamSlider.getValue()) {
                serverMinRamSlider.setValue(serverMaxRamSlider.getValue());
            }

            serverJavaArgsField.setText("java -Xmx " + (int) serverMaxRamSlider.getValue() + "Mb -Xms " + (int) serverMinRamSlider.getValue() + "Mb -jar server.jar");

            sideParameterPanel.setServerMaxRamValue(String.valueOf((int) serverMaxRamSlider.getValue()));
            sideParameterPanel.setServerMinRamValue(String.valueOf((int) serverMinRamSlider.getValue()));
        });

        serverMinRamSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            serverMinRamField.setText((int) serverMinRamSlider.getValue() + " Mb");

            int percent = (int) (100 *  (serverMinRamSlider.getValue() - serverMinRamSlider.getMin()) / (serverMinRamSlider.getMax() - serverMinRamSlider.getMin()));
            serverMinRamSlider.setStyle("-fx-background-color: linear-gradient(to right, #0066FF " + percent + "%, #363636 " + percent + "%);");

            if (serverMinRamSlider.getValue() > serverMaxRamSlider.getValue()) {
                serverMaxRamSlider.setValue(serverMinRamSlider.getValue());
            }

            serverJavaArgsField.setText("java -Xmx " + (int) serverMaxRamSlider.getValue() + "Mb -Xms " + (int) serverMinRamSlider.getValue() + "Mb -jar server.jar");

            sideParameterPanel.setServerMaxRamValue(String.valueOf((int) serverMaxRamSlider.getValue()));
            sideParameterPanel.setServerMinRamValue(String.valueOf((int) serverMinRamSlider.getValue()));
        });

        /* serverMaxRamField.textProperty().addListener((obs, oldv, newv) -> {
            serverMaxRamSlider.setValue(Integer.parseInt(String.valueOf(serverMaxRamField)));

            if (serverMinRamSlider.getValue() > serverMaxRamSlider.getValue()) {
                serverMaxRamSlider.setValue(serverMinRamSlider.getValue());
            }
        });

        serverMinRamField.textProperty().addListener((obs, oldv, newv) -> {
            serverMinRamSlider.setValue(Integer.parseInt(String.valueOf(serverMinRamField)));

            if (serverMaxRamSlider.getValue() < serverMinRamSlider.getValue()) {
                serverMinRamSlider.setValue(serverMaxRamSlider.getValue());
            }
        }); */

        serverMinRamBox.getChildren().addAll(serverMinRam, serverMinRamSlider, serverMinRamField);

        // Server is docked
        HBox serverDockedBox = new HBox();
        serverDockedBox.setTranslateY(120.0d);

        Text serverDocked = new Text("Docked : ");
        serverDocked.setFill(Color.WHITE);
        serverDocked.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        CheckBox serverDockedButton = new CheckBox();
        serverDockedButton.setTranslateY(7.0d);
        serverDockedButton.selectedProperty().addListener((obs, oldv, newv) -> {
            if (serverDockedButton.isSelected()) {
                sideParameterPanel.setIsServerDocked("Yes");
            } else {
                sideParameterPanel.setIsServerDocked("No");
            }
        });

        serverDockedBox.getChildren().addAll(serverDocked, serverDockedButton);

        // Server Java Arguments
        VBox serverJavaArgsBox = new VBox();
        serverJavaArgsBox.setTranslateY(140);

        Text serverJavaArgs = new Text("Java Arguments : ");
        serverJavaArgs.setFill(Color.WHITE);
        serverJavaArgs.setFont(Font.font("Poppins", FontWeight.NORMAL, 24));

        serverJavaArgsField = createTextField("java -Xmx " + (int) serverMaxRamSlider.getValue() + "Mb -Xms " + (int) serverMinRamSlider.getValue() + "Mb -jar server.jar", 625.0d, 60.0d, 20);

        serverJavaArgsBox.getChildren().addAll(serverJavaArgs, serverJavaArgsField);

        root.getChildren().addAll(serverNameField, serverPortBox, serverMaxRamBox, serverMinRamBox, serverDockedBox, serverJavaArgsBox);

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
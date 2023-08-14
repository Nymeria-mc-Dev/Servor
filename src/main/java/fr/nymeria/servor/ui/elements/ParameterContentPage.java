package fr.nymeria.servor.ui.elements;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

import fr.nymeria.servor.helpers.CustomSliderSkin;
import fr.nymeria.servor.helpers.ParameterSceneSettings;
import fr.nymeria.servor.ui.elements.Parameters.CustomCheckBox;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ParameterContentPage {
    private TextField serverJavaArgsField;

    @SuppressWarnings("deprecation")
    public ParameterContentPage(Pane pane, SideParameterPanel sideParameterPanel) {

        VBox root = new VBox();
        root.setTranslateY(55.0d);
        root.setTranslateX(355.0d);

        // Server Name Text Field
        TextField serverNameField = createTextField(ParameterSceneSettings.ServerVersion, 650.0d, 70.0d, 36);
        sideParameterPanel.setServerName(serverNameField.getText());
        serverNameField.textProperty().addListener((obs, oldValue, newValue) -> sideParameterPanel.setServerName(serverNameField.getText()));

        // Server Port Text Field
        HBox serverPortBox = new HBox();
        serverPortBox.setTranslateY(50.0d);

        Text serverPort = new Text("Server Port : ");
        serverPort.setTranslateY(4.0d);
        serverPort.setFill(Color.WHITE);
        serverPort.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        TextField serverPortField = createTextField("25565", 170.0d, 40.0d, 24);
        sideParameterPanel.setServerPort(serverPortField.getText());
        serverPortField.textProperty().addListener((obs, oldv, newv) -> sideParameterPanel.setServerPort(serverPortField.getText()));

        serverPortBox.getChildren().addAll(serverPort, serverPortField);

        // Server Max Ram Slider
        HBox serverMaxRamBox = new HBox();
        serverMaxRamBox.setTranslateY(80.0d);

        Text serverMaxRam = new Text("Max. Ram : ");
        serverMaxRam.setTranslateY(10.0d);
        serverMaxRam.setFill(Color.WHITE);
        serverMaxRam.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        long ram = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize() / 1024 / 1024;

        Slider serverMaxRamSlider = new Slider();
        serverMaxRamSlider.setTranslateY(20.0d);
        serverMaxRamSlider.setMinWidth(410.0d);
        serverMaxRamSlider.setMin(255);
        serverMaxRamSlider.setMax(ram);
        serverMaxRamSlider.getStyleClass().add("slider");

        CustomSliderSkin sliderMaxRamSkin = new CustomSliderSkin(serverMaxRamSlider);
        serverMaxRamSlider.setSkin(sliderMaxRamSkin);

        TextField serverMaxRamField = createTextField("255 Mb", 122.0d, 60.0d, 20);
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
        serverMinRamSlider.setMin(0);
        serverMinRamSlider.setMax(ram);
        serverMinRamSlider.getStyleClass().add("slider");

        CustomSliderSkin sliderMinRamSkin = new CustomSliderSkin(serverMinRamSlider);
        serverMinRamSlider.setSkin(sliderMinRamSkin);

        TextField serverMinRamField = createTextField("0 Mb", 122.0d, 60.0d, 20);
        serverMinRamField.setTranslateX(20.0d);

        serverMaxRamSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            serverMaxRamField.setText((int) serverMaxRamSlider.getValue() + " Mb");

            if (serverMaxRamSlider.getValue() < serverMinRamSlider.getValue()) {
                serverMinRamSlider.setValue(serverMaxRamSlider.getValue());
            }

            serverJavaArgsField.setText("java -Xmx " + (int) serverMaxRamSlider.getValue() + "M -Xms " + (int) serverMinRamSlider.getValue() + "M -jar server.jar");

            sideParameterPanel.setServerMaxRamValue(String.valueOf((int) serverMaxRamSlider.getValue()));
            sideParameterPanel.setServerMinRamValue(String.valueOf((int) serverMinRamSlider.getValue()));
        });

        serverMinRamSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            serverMinRamField.setText((int) serverMinRamSlider.getValue() + " Mb");

            if (serverMinRamSlider.getValue() > serverMaxRamSlider.getValue()) {
                serverMaxRamSlider.setValue(serverMinRamSlider.getValue());
            }

            serverJavaArgsField.setText("java -Xmx " + (int) serverMaxRamSlider.getValue() + "M -Xms " + (int) serverMinRamSlider.getValue() + "M -jar server.jar");

            sideParameterPanel.setServerMaxRamValue(String.valueOf((int) serverMaxRamSlider.getValue()));
            sideParameterPanel.setServerMinRamValue(String.valueOf((int) serverMinRamSlider.getValue()));
        });

        serverMaxRamField.textProperty().addListener((obs, oldv, newv) -> {
            try {
                serverMaxRamSlider.setValue(Integer.parseInt(serverMaxRamField.getText().split(" ")[0]));

                if (serverMinRamSlider.getValue() > serverMaxRamSlider.getValue()) {
                    serverMaxRamSlider.setValue(serverMinRamSlider.getValue());
                }
            } catch (NumberFormatException e) {
                System.out.println("Error of string number formation");
            }
        });

        serverMinRamField.textProperty().addListener((obs, oldv, newv) -> {
            try {
                serverMinRamSlider.setValue(Integer.parseInt(serverMinRamField.getText().split(" ")[0]));

                if (serverMaxRamSlider.getValue() < serverMinRamSlider.getValue()) {
                    serverMinRamSlider.setValue(serverMaxRamSlider.getValue());
                }
            } catch (NumberFormatException e) {
                System.out.println("Error of string number formation");
            }
        });

        serverMinRamBox.getChildren().addAll(serverMinRam, serverMinRamSlider, serverMinRamField);

        // Server is docked
        HBox serverDockedBox = new HBox();
        serverDockedBox.setTranslateY(120.0d);

        Text serverDocked = new Text("Docked : ");
        serverDocked.setTranslateY(10.0d);
        serverDocked.setFill(Color.WHITE);
        serverDocked.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        CustomCheckBox customCheckBox = new CustomCheckBox(40.0d, 40.0d, false, "#363636");
        HBox serverDockedButton = customCheckBox.createCheckBox();
        serverDockedButton.setTranslateY(7.0d);
        serverDockedButton.setPrefSize(40.0d, 40.0d);
        serverDockedButton.setOnMouseClicked(
                (EventHandler) event -> {
                    customCheckBox.setIsSelected(!customCheckBox.isSelected());
                    if (customCheckBox.isSelected()) {
                        sideParameterPanel.setIsServerDocked("Yes");
                        customCheckBox.setChecked();
                    } else {
                        sideParameterPanel.setIsServerDocked("No");
                        customCheckBox.setUnchecked();
                    }
                }
        );

        serverDockedBox.getChildren().addAll(serverDocked, serverDockedButton);

        // Server Java Arguments
        VBox serverJavaArgsBox = new VBox();
        serverJavaArgsBox.setTranslateY(140);

        Text serverJavaArgs = new Text("Java Arguments : ");
        serverJavaArgs.setFill(Color.WHITE);
        serverJavaArgs.setFont(Font.font("Poppins", FontWeight.NORMAL, 24));

        serverJavaArgsField = createTextField("java -Xmx " + (int) serverMaxRamSlider.getValue() + "M -Xms " + (int) serverMinRamSlider.getValue() + "M -jar server.jar", 625.0d, 60.0d, 20);

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

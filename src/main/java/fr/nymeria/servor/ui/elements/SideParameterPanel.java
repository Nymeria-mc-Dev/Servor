package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.helpers.Settings;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SideParameterPanel {
    private Text serverNameValue;
    private Text serverPortValue;
    private Text serverMaxRamValue;
    private Text serverMinRamValue;
    private Text serverDockeValue;
    public SideParameterPanel(Pane pane) {
        VBox sidePanel = new VBox();
        sidePanel.setStyle("-fx-background-color: #363636; ");
        sidePanel.setMinWidth(275.0d);
        sidePanel.setMinHeight(pane.getHeight());

        // Server version
        HBox serverVersionBox = new HBox();
        serverVersionBox.setTranslateY(90.0d);
        serverVersionBox.setTranslateX(20.0d);

        Text serverVersion = new Text("Server Version : ");
        serverVersion.setFill(Color.WHITE);
        serverVersion.setFont(Font.font("Poppins", FontWeight.NORMAL, 18));

        Text serverVersionValue = new Text(Settings.ServerVersion);
        serverVersionValue.setFill(Color.WHITE);
        serverVersionValue.setFont(Font.font("Poppins", FontWeight.BOLD, 18));

        serverVersionBox.getChildren().addAll(serverVersion, serverVersionValue);

        // Server name
        HBox serverNameBox = new HBox();
        serverNameBox.setTranslateY(110.0d);
        serverNameBox.setTranslateX(20.0d);

        Text serverName = new Text("Server Name : ");
        serverName.setFill(Color.WHITE);
        serverName.setFont(Font.font("Poppins", FontWeight.NORMAL, 18));

        serverNameValue = new Text("None");
        serverNameValue.setFill(Color.WHITE);
        serverNameValue.setFont(Font.font("Poppins", FontWeight.BOLD, 18));

        serverNameBox.getChildren().addAll(serverName, serverNameValue);

        // Server Max Ram
        HBox serverMaxRamBox = new HBox();
        serverMaxRamBox.setTranslateY(130.0d);
        serverMaxRamBox.setTranslateX(20.0d);

        Text serverMaxRam = new Text("Max. Ram : ");
        serverMaxRam.setFill(Color.WHITE);
        serverMaxRam.setFont(Font.font("Poppins", FontWeight.NORMAL, 18));

        serverMaxRamValue = new Text("None");
        serverMaxRamValue.setFill(Color.WHITE);
        serverMaxRamValue.setFont(Font.font("Poppins", FontWeight.BOLD, 18));

        serverMaxRamBox.getChildren().addAll(serverMaxRam, serverMaxRamValue);

        // Server Min Ram
        HBox serverMinRamBox = new HBox();
        serverMinRamBox.setTranslateY(150.0d);
        serverMinRamBox.setTranslateX(20.0d);

        Text serverMinRam = new Text("Min. Ram : ");
        serverMinRam.setFill(Color.WHITE);
        serverMinRam.setFont(Font.font("Poppins", FontWeight.NORMAL, 18));

        serverMinRamValue = new Text("None");
        serverMinRamValue.setFill(Color.WHITE);
        serverMinRamValue.setFont(Font.font("Poppins", FontWeight.BOLD, 18));

        serverMinRamBox.getChildren().addAll(serverMinRam, serverMinRamValue);

        // Server Docké
        HBox serverDockeBox = new HBox();
        serverDockeBox.setTranslateY(170.0d);
        serverDockeBox.setTranslateX(20.0d);

        Text serverDoke = new Text("Docké : ");
        serverDoke.setFill(Color.WHITE);
        serverDoke.setFont(Font.font("Poppins", FontWeight.NORMAL, 18));

        serverDockeValue = new Text("No");
        serverDockeValue.setFill(Color.WHITE);
        serverDockeValue.setFont(Font.font("Poppins", FontWeight.BOLD, 18));

        serverDockeBox.getChildren().addAll(serverDoke, serverDockeValue);

        // Server Port
        HBox serverPortBox = new HBox();
        serverPortBox.setTranslateY(190.0d);
        serverPortBox.setTranslateX(20.0d);

        Text serverPort = new Text("Server Port : ");
        serverPort.setFill(Color.WHITE);
        serverPort.setFont(Font.font("Poppins", FontWeight.NORMAL, 18));

        serverPortValue = new Text("None");
        serverPortValue.setFill(Color.WHITE);
        serverPortValue.setFont(Font.font("Poppins", FontWeight.BOLD, 18));

        serverPortBox.getChildren().addAll(serverPort, serverPortValue);

        sidePanel.getChildren().addAll(serverVersionBox, serverNameBox, serverMaxRamBox, serverMinRamBox, serverDockeBox, serverPortBox);

        pane.getChildren().add(sidePanel);
    }

    public void setServerName(String name) {
        serverNameValue.setText(name);
    }

    public void setServerPort(String port) {
        serverPortValue.setText(port);
    }

    public void setServerMaxRamValue(String maxRamValue) {
        serverMaxRamValue.setText(maxRamValue);
    }

    public void setServerMinRamValue(String minRamValue) {
        serverMinRamValue.setText(minRamValue);
    }

    public void setIsServerDocked(String isDocked) {
        serverDockeValue.setText(isDocked);
    }
}

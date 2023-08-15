package fr.nymeria.servor.ui.elements.Manage.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ServerInteruptController {

    private static final Pane root = new Pane();
    private final double width;
    private final double height;
    private final double tX;
    private final double tY;

    private final HBox box = new HBox();
    private final HBox killBox = new HBox();
    private final HBox stopBox = new HBox();
    private final Text killText = new Text("Kill");
    private final Text stopText = new Text("Stop");


    public ServerInteruptController(double width, double height, double tX, double tY) {
        this.width = width;
        this.height = height;
        this.tX = tX;
        this.tY = tY;
    }

    public Pane get() {
        this.init();
        return root;
    }

    private void init() {
        root.setPrefSize(this.width, this.height);
        root.setMaxWidth(this.width);
        root.setTranslateX(this.tX);
        root.setTranslateY(this.tY);
        root.setStyle("-fx-background-color: #363636; -fx-background-radius: 20px;");

        killText.setFill(Color.WHITE);
        killText.setFont(Font.font("Poppins", FontWeight.NORMAL, 24));

        killBox.setStyle("-fx-background-color: #740000 ; -fx-background-radius: 30px;");
        killBox.setMinWidth(100.0d);
        killBox.setMinHeight(30.0d);
        killBox.setTranslateY(this.height / 2 - 15.0d);
        killBox.setTranslateX(-17.5d);
        killBox.setAlignment(Pos.CENTER);
        killBox.getChildren().add(killText);

        stopText.setFill(Color.WHITE);
        stopText.setFont(Font.font("Poppins", FontWeight.NORMAL, 24));

        stopBox.setStyle("-fx-background-color: #0066FF ; -fx-background-radius: 30px;");
        stopBox.setMinWidth(100.0d);
        stopBox.setMinHeight(30.0d);
        stopBox.setTranslateY(this.height / 2 - 16.5d);
        stopBox.setTranslateX(17.5d);
        stopBox.setAlignment(Pos.CENTER);
        stopBox.setPadding(new Insets(0, 25, 0, 25));
        stopBox.getChildren().add(stopText);

        box.getChildren().addAll(killBox, stopBox);
        box.setTranslateX(192.0d - 100.0d);

        root.getChildren().add(box);
    }
}

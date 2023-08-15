package fr.nymeria.servor.ui.elements.Manage.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ConsoleComponent {
    private static final Pane root = new Pane();
    private final double width;
    private final double height;
    private final double tX;
    private final double tY;

    private final VBox box = new VBox();
    private final ScrollPane logScrollPane = new ScrollPane();
    private final Text logText = new Text();
    private final HBox commandBox = new HBox();
    private final Text commandMark = new Text(">");
    private final TextField commandField = new TextField();

    public ConsoleComponent(double width, double height, double tX, double tY) {
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
        root.setTranslateX(this.tX);
        root.setTranslateY(this.tY);
        root.setStyle("-fx-background-color: #363636; -fx-background-radius: 9px;");

        logText.setText("Initialized with success !");
        logText.setFill(Color.WHITE);
        logText.setFont(Font.font("Poppins", FontWeight.NORMAL, 25));

        logScrollPane.setContent(logText);
        logScrollPane.setMinHeight(433);
        logScrollPane.setMaxHeight(433);
        logScrollPane.setMinWidth(833);
        logScrollPane.setMaxWidth(833);
        logScrollPane.getStyleClass().add("scroll-pane");

        commandMark.setTranslateX(20.0d);
        commandMark.setTranslateY(-4.0d);
        commandMark.setFill(Color.WHITE);
        commandMark.setFont(Font.font("Poppins", FontWeight.NORMAL, 32));

        commandField.setMinWidth(790.0d);
        commandField.setMaxWidth(790.0d);
        commandField.setTranslateX(32.0d);
        commandField.setFont(Font.font("Poppins", FontWeight.NORMAL, 18));
        commandField.setStyle("-fx-background-color: transparent; -fx-text-fill: #fff;");

        commandField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                logText.setText(logText.getText() + "\r" + commandField.getText());
                commandField.setText("");
            }
        });

        commandBox.getChildren().addAll(commandMark, commandField);
        commandBox.setStyle("-fx-background-color: #171717; -fx-background-radius: 0 0 9px 9px;");

        box.getChildren().addAll(logScrollPane, commandBox);

        root.getChildren().add(box);
    }
}

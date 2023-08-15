package fr.nymeria.servor.ui.elements.Manage.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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

    private final ScrollPane logScrollPane = new ScrollPane();
    private final Text logText = new Text();

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

        logText.setText("A\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA");
        logText.setFill(Color.WHITE);
        logText.setFont(Font.font("Poppins", FontWeight.NORMAL, 25));

        logScrollPane.setContent(logText);
        logScrollPane.setMinHeight(433);
        logScrollPane.setMaxHeight(433);
        logScrollPane.setMinWidth(833);
        logScrollPane.setMaxWidth(833);
        logScrollPane.getStyleClass().add("scroll-pane");

        root.getChildren().addAll(logScrollPane);
    }
}

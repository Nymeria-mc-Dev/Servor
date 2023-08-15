package fr.nymeria.servor.ui.elements.Manage.components;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ConsoleComponent {
    private static final Pane root = new Pane();
    private final double width;
    private final double height;
    private final double tX;
    private final double tY;

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
        root.setStyle("-fx-background-color: #3F3F3F;");
    }
}

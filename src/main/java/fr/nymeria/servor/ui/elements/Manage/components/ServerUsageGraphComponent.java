package fr.nymeria.servor.ui.elements.Manage.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ServerUsageGraphComponent {
    private Pane root = new Pane();
    private double width;
    private double height;
    private double tX;
    private double tY;
    private String graphName;

    private VBox box = new VBox();
    public ServerUsageGraphComponent(double width, double height, double tX, double tY, String graphName) {
        this.width = width;
        this.height = height;
        this.tX = tX;
        this.tY = tY;
        this.graphName = graphName;
    }

    public Pane get() {
        root.setMinWidth(this.width);
        root.setMaxWidth(this.width);
        root.setMinHeight(this.height);
        root.setMaxHeight(this.height);
        root.setTranslateX(this.tX);
        root.setTranslateY(this.tY);
        root.setStyle("-fx-background-color: #363636; -fx-background-radius: 12px;");

        HBox textBox = new HBox();

        Text graphNameText = new Text(this.graphName);
        graphNameText.setFill(Color.WHITE);
        graphNameText.setFont(Font.font("Poppins", FontWeight.NORMAL, 24));
        graphNameText.setTranslateX((double) root.getWidth() / 2 - graphNameText.getScaleX());

        textBox.getChildren().add(graphNameText);
        textBox.setMinWidth(this.width);
        textBox.setAlignment(Pos.CENTER);
        textBox.setStyle("-fx-background-color: #5C5C5C; -fx-background-radius: 12px 12px 0 0;");

        box.getChildren().addAll(textBox);

        root.getChildren().add(box);

        return root;
    }
}

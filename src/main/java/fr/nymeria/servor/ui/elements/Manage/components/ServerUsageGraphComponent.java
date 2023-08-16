package fr.nymeria.servor.ui.elements.Manage.components;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ServerUsageGraphComponent {
    private Pane root = new Pane();
    private double width;
    private double height;
    private double tX;
    private double tY;
    private int maxValues;
    private float[] values;
    private String graphName;

    private VBox box = new VBox();

    public ServerUsageGraphComponent(double width, double height, double tX, double tY, String graphName, int maxValues, float[] values) {
        this.width = width;
        this.height = height;
        this.tX = tX;
        this.tY = tY;
        this.graphName = graphName;
        this.maxValues = maxValues;
        this.values = values;
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

        textBox.setMinWidth(this.width);
        textBox.setAlignment(Pos.CENTER);
        textBox.setStyle("-fx-background-color: #5C5C5C; -fx-background-radius: 12px 12px 0 0;");

        textBox.getChildren().add(graphNameText);

        HBox graphBox = new HBox();

        GraphBar graphBar = new GraphBar(this.width, this.height, this.maxValues, this.values);

        graphBox.getChildren().addAll(graphBar.get());

        box.getChildren().addAll(textBox, graphBox);

        root.getChildren().add(box);

        return root;
    }

    private class GraphBar extends Node {
        private double width;
        private double height;
        private int maxValues;
        private float[] values;
        private final Pane root = new Pane();
        public GraphBar(double width, double height, int maxValues, float[] values) {
            this.width = width;
            this.height = height;
            this.maxValues = maxValues;
            this.values = values;
        }

        public Pane get() {
            this.init();
            return root;
        }

        private void init() {
            root.setMinWidth(this.width);
            root.setMaxWidth(this.width);
            root.setMinHeight(this.height);
            root.setMaxHeight(this.height);
            root.setStyle("-fx-background-color: transparent;");

            double espacement = this.width / this.maxValues;
            double margin = 17.5d;
            ArrayList<Line> lines = new ArrayList<>();

            for (int i = this.values.length; i >= this.values.length - 8; i--) {
                // Line(x1, y1, x2, y2);
                Line line = new Line(espacement*i - margin, 100 - this.values[i-1] + margin, espacement*(i-1) - margin, 100 - this.values[i-2] + margin);
                line.setStroke(Color.rgb(0, 102, 255));
                line.setStrokeWidth(4.0d);

                lines.add(line);
            }

            root.getChildren().addAll(lines);

        }
    }
}

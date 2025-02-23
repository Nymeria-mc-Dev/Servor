package fr.nymeria.servor.ui.elements.Manage.components;

import javafx.scene.layout.*;

public class ServerConfigPropertyBox {
    private final Pane root = new Pane();

    private float x;
    private float y;
    private float width;
    private float height;

    ServerConfigPropertyBox(float x,  float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public Pane get() {
        this.init();
        return root;
    }

    private void init() {
        this.root.getChildren().addAll();
    }
}

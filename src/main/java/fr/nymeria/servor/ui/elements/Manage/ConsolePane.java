package fr.nymeria.servor.ui.elements.Manage;

import fr.nymeria.servor.ui.elements.Manage.components.ConsoleComponent;
import javafx.scene.layout.Pane;

public class ConsolePane {
    private static final Pane pane = new Pane();

    public Pane get() {
        this.init();
        return pane;
    }

    private void init() {
        ConsoleComponent consoleComponent = new ConsoleComponent(833.0d, 469.0d, 220.0d, 55.0d);
        pane.getChildren().addAll(consoleComponent.get());
    }
}

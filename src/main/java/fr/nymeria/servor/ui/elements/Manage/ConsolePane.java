package fr.nymeria.servor.ui.elements.Manage;

import fr.nymeria.servor.ui.elements.Manage.components.ConsoleComponent;
import fr.nymeria.servor.ui.elements.Manage.components.ServerInteruptController;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ConsolePane {
    private static final Pane pane = new Pane();
    private final static ScrollPane container = new ScrollPane();
    private final static VBox box = new VBox();

    public Pane get() {
        this.init();
        return pane;
    }

    private void init() {
        ConsoleComponent consoleComponent = new ConsoleComponent(833.0d, 469.0d, 220.0d, 55.0d);
        ServerInteruptController serverInteruptController = new ServerInteruptController(384.0d, 50.0d, 445.0d, 95.0d);

        box.getChildren().addAll(consoleComponent.get(), serverInteruptController.get());

        container.setContent(box);
        container.getStyleClass().add("scroll-pane");
        container.setMinWidth(1100.0d);
        container.setMaxWidth(1100.0d);
        container.setMinHeight(720.0d);

        pane.getChildren().addAll(container);
    }
}

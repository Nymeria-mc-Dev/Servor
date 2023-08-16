package fr.nymeria.servor.ui.elements.Manage;

import fr.nymeria.servor.ui.elements.Manage.components.ConsoleComponent;
import fr.nymeria.servor.ui.elements.Manage.components.ServerInteruptController;
import fr.nymeria.servor.ui.elements.Manage.components.ServerUsageGraphComponent;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
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
        ServerInteruptController serverInteruptController = new ServerInteruptController(384.0d, 50.0d, 445.0d, 90.0d);

        HBox serverUsage = new HBox();
        serverUsage.setAlignment(Pos.CENTER);

        ServerUsageGraphComponent serverCPUUsageGraphComponent = new ServerUsageGraphComponent(330.0d, 175.0d, 0.0d, 0d, "CPU Usage", 10, new float[]{20, 80, 100, 90, 40, 50, 30, 50, 50, 40});
        ServerUsageGraphComponent serverRAMUsageGraphComponent = new ServerUsageGraphComponent(330.0d, 175.0d, 100.0d, 0d, "RAM Usage", 10, new float[]{20, 40, 50, 80, 90, 60, 70, 50, 70, 60});

        serverUsage.getChildren().addAll(serverCPUUsageGraphComponent.get(), serverRAMUsageGraphComponent.get());
        serverUsage.setTranslateX(165.0d);
        serverUsage.setTranslateY(115.0d);

        box.getChildren().addAll(consoleComponent.get(), serverInteruptController.get(), serverUsage);

        container.setContent(box);
        container.getStyleClass().add("scroll-pane");
        container.setMinWidth(1100.0d);
        container.setMaxWidth(1100.0d);
        container.setMinHeight(720.0d);

        pane.getChildren().addAll(container);
    }
}

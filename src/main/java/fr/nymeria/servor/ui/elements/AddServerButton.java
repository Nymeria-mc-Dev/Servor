package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.ChooseVersionScene;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AddServerButton {
	
	public AddServerButton(Pane pane, Stage stage) {
		
		BackgroundFill backgroundFill = new BackgroundFill(Color.valueOf("#0066FF"), new CornerRadii(100), null);
		Background background = new Background(backgroundFill);
		
		HBox p = new HBox();
		p.setPrefSize(50, 50);
		p.setTranslateX(1017);
		p.setTranslateY(644.25);
		p.setAlignment(Pos.CENTER);
		p.setBackground(background);
		
		
		ImageView button = new ImageView(new Image(App.class.getResource("/icons/plus.png").toExternalForm(), 40, 40, false, false));
		
		p.getChildren().add(button);
		
		p.setOnMouseClicked(event -> {
			App.setScene(ChooseVersionScene.get());
		});
		
		RotateTransition rt = new RotateTransition(Duration.millis(500), button);
		
		p.hoverProperty().addListener(event -> {
			rt.setByAngle(180);
			rt.setCycleCount(1);
			
		    rt.play();
		});
		
		pane.getChildren().addAll(p);
	}

}

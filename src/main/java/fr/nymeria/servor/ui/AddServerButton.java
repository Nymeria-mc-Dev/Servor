package fr.nymeria.servor.ui;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.ChooseVersionScene;
import javafx.animation.RotateTransition;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AddServerButton {

	public AddServerButton(Pane pane, Stage stage) {
		
		BackgroundFill backgroundFill = new BackgroundFill(Color.valueOf("#0066FF"), new CornerRadii(100), null);
		Background background = new Background(backgroundFill);
		
		Pane p = new Pane();
		p.setMinWidth(40);
		p.setMinHeight(40);
		p.setMaxWidth(40);
		p.setMaxHeight(40);
		p.setTranslateX(1017);
		p.setTranslateY(644.25);
		p.setBackground(background);
		
		Text button = GlyphsDude.createIcon(FontAwesomeIcon.PLUS, "35px");
		button.setTranslateX(6.5);
		button.setTranslateY(34.5);
		button.setFill(Color.WHITE);
		
		p.getChildren().add(button);
		
		p.setOnMouseClicked(event -> {
			App.setScene(ChooseVersionScene.get());
		});
		
		p.setOnMouseEntered(event -> {
			RotateTransition rt = new RotateTransition(Duration.millis(3000), button);
			rt.setByAngle(360);
			rt.setCycleCount(2);
		    rt.setAutoReverse(true);
		 
		    rt.play();
		});
		
		pane.getChildren().addAll(p);
	}

}

package fr.nymeria.servor.ui.elements.Settings;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.MainScene;
import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BackButton {

	public BackButton(Pane pane, Stage stage) {

		BackgroundFill backgroundFill = new BackgroundFill(Color.valueOf("#0066FF"), new CornerRadii(100), null);
		Background background = new Background(backgroundFill);

		HBox p = new HBox();
		p.setPrefSize(50, 50);
		p.setTranslateX(13);
		p.setTranslateY(644.25);
		p.setAlignment(Pos.CENTER);
		p.setBackground(background);

		Text button =  GlyphsDude.createIcon(FontAwesomeIcon.ARROW_LEFT, "25px");
		button.setFill(Color.WHITE);

		p.getChildren().add(button);

		p.setOnMouseClicked(event -> {
			App.setScene(MainScene.get());
		});

		p.hoverProperty().addListener((observable, oldValue, newValue) -> {
			ScaleTransition st = new ScaleTransition(Duration.millis(200), p);
			if(newValue) {	
				st.setToX(1.2);
				st.setToY(1.2);
			}else {
				st.setToX(1);
				st.setToY(1);
			}
			st.play();
		});

		pane.getChildren().addAll(p);
	}

}

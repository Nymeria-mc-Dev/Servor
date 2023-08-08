package fr.nymeria.servor.ui.elements;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.ChooseVersionScene;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SettingsButton {
	
	public SettingsButton(Pane pane, Stage stage) {
		
		BackgroundFill backgroundFill = new BackgroundFill(Color.valueOf("#0066FF"), new CornerRadii(100), null);
		Background background = new Background(backgroundFill);
		
		HBox p = new HBox();
		p.setPrefSize(50, 50);
		p.setTranslateX(1017);
		p.setTranslateY(574.25);
		p.setAlignment(Pos.CENTER);
		p.setBackground(background);
		
		
		Text button =  GlyphsDude.createIcon(FontAwesomeIcon.GEARS, "25px");
		button.setFill(Color.WHITE);
		
		p.getChildren().add(button);
		
		p.setOnMouseClicked(event -> {
			App.setScene(ChooseVersionScene.get());
		});
		
		pane.getChildren().addAll(p);
	}

}

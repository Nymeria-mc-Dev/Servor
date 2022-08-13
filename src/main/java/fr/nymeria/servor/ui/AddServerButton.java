package fr.nymeria.servor.ui;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import fr.nymeria.servor.scenes.ChooseVersionScene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddServerButton {

	public AddServerButton(Pane pane, Stage stage) {
		
		Circle rect = new Circle(25);
		rect.setStyle("-fx-fill: #0066FF;");
		rect.setTranslateX(1030);
		rect.setTranslateY(680);
		
		Text button = GlyphsDude.createIcon(FontAwesomeIcon.PLUS, "35px");
		button.setTranslateX(1017);
		button.setTranslateY(694.25);
		button.setFill(Color.WHITE);
		
		rect.setOnMouseClicked(event -> {
			App.setScene(ChooseVersionScene.get());
		});
		button.setOnMouseClicked(event -> {
			App.setScene(ChooseVersionScene.get());
		});
		
		pane.getChildren().addAll(rect, button);
	}

}

package fr.nymeria.servor.ui.elements.Settings;

import fr.nymeria.servor.ui.component.ToogleSwitch;
import javafx.scene.layout.Pane;

public class RPCSelector {

	public RPCSelector(Pane pane) {
		
		Pane back = new Pane();
		back.setPrefSize(87, 37);
		back.setTranslateY(100.0d);

		ToogleSwitch button = new ToogleSwitch();
		button.setParent(back);
		button.setBackgroundCss("-fx-background-color: #fff;");

		pane.getChildren().add(back);
		
	}
	
}

package fr.nymeria.servor.ui.component;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Observable;

@SuppressWarnings("unused")
public class ToogleSwitch extends Observable {

	private Pane back;
	private Pane rectangle;
	
	private boolean isAnimated = false;
	
	private boolean powered = false;
	
	public ToogleSwitch() {
		back = new Pane();
		rectangle = new Pane();
		back.getChildren().add(rectangle);
		
		TranslateTransition tt = new TranslateTransition(Duration.millis(200), rectangle);
		
		back.setOnMouseClicked(event -> {
			if(powered) {
				powered = false;
				tt.setToX(0);
			}else {
				powered = true;
				tt.setToX(back.getTranslateX() + back.getWidth());
			}
			
			if(isAnimated) {
				tt.play();
			}
			
		});
	}

	public Pane get() {
		return back;
	}
	
	public void setBackgroundCss(String css) {
		back.setStyle(css);
	}
	
	public void setRectangleCss(String css) {
		rectangle.setStyle(css);
	}
	
	public void setTranslateX(int value) {
		back.setTranslateX(value);
	}
	
	public void setTranslateY(int value) {
		back.setTranslateY(value);
	}
	
	public void setRectanglePrefSize(int x, int y) {
		rectangle.setPrefSize(x, y);
	}
	
	public void setBackgroundPrefSize(int x, int y) {
		back.setPrefSize(x, y);
	}
	
	public void setAnimated(boolean bool) {
		isAnimated = bool;
	}
	
	public void setParent(Pane pane) {
		pane.getChildren().add(back);
	}

	public boolean isPowered() {
		return powered;
	}
}

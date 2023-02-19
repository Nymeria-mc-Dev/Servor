package fr.nymeria.servor.ui.elements.progressbar;

import javafx.scene.layout.Pane;

public class ProgressBar {

	ProgressType type;

	Pane progressBar;
	Pane progress;

	public ProgressBar(final ProgressType type) {
		this.type = type;
		
		progressBar = new Pane();
		
		progress = new Pane();
		progress.setTranslateY(0);
		progress.setTranslateX(0);
		
		progressBar.getChildren().add(progress);
	}
	
	public void setWidth(final int x) {
		progressBar.setPrefWidth(x);
	}

	public void setHeight(final int y) {
		progressBar.setPrefHeight(y);
		progress.setPrefHeight(y);
	}

	public void setProgressWidth(final int x) {
		if(type == ProgressType.LOADING) {
			progress.setTranslateX(x);
		}
	}
	
	public void setBackgroundBorderRadius(int radius) {
		progressBar.setStyle(progressBar.getStyle() + "-fx-background-radius: " + Integer.toString(radius) + "px;");
	}
	
	public void setBackgroundColor(String color) {
		progressBar.setStyle(progressBar.getStyle() + "-fx-background-color: " + color + ";");
	}
	
	public void setBorderRadius(int radius) {
		progress.setStyle(progress.getStyle() + "-fx-background-radius: " + Integer.toString(radius) + "px;");
	}
	
	public void setColor(String color) {
		progress.setStyle(progress.getStyle() + "-fx-background-color: " + color + ";");
	}

	public void setProgress(final int progress) {
		if(type == ProgressType.PROGRESS) {
			float progressBarSize = (float) progressBar.getPrefWidth();
			
			System.out.println(progressBarSize);
			
			float t = (float) progress/100;
			System.out.println(t);
			float cm = (float) t + 1;
			System.out.println(cm);
			float progressSize = (float) progressBarSize-(progressBarSize/cm);
			
			System.out.println(progressSize);
			
			this.progress.setPrefWidth(progressSize);
		}
	}
	
	public Pane get() {
		return progressBar;
	}
}

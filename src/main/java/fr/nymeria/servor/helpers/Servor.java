package fr.nymeria.servor.helpers;

import fr.nymeria.servor.ui.elements.ServerSelector;
import javafx.stage.Stage;

public class Servor {

	public static void init(Stage stage) {	
		FileHelper.init();
		
		Discord.setup();
		
		ServerSelector.init();
		
		double[] loc = FileHelper.getAppLoc();
		if(loc != null) {
			stage.setX(loc[0]);
			stage.setY(loc[1]);
		}
	}
}

package fr.nymeria.servor.ui.elements.Settings;


import fr.nymeria.servor.helpers.FileHelper;
import fr.nymeria.servor.helpers.JsonHelper;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class DockerPath {

	private HBox contener;
	
	public DockerPath(Pane pane) {
		
		contener = new HBox();
		
		contener.setTranslateX(305);
		contener.setTranslateY(97);
		contener.setPrefSize(733, 76);
		contener.setStyle("-fx-background-color: #3E3E3E; -fx-background-radius: 20px;");
		contener.setAlignment(Pos.CENTER);
		
		TextField path = createTextField(JsonHelper.getStringValue(Objects.requireNonNull(FileHelper.read(FileHelper.getConfig())), "Docker Path"), 692d, 76d, 32);
		
		contener.getChildren().add(path);
		
		pane.getChildren().addAll(contener);
		
	}
	
	private TextField createTextField(String text, double width, double height, int fontSize) {
        TextField textField = new TextField(text);
        textField.setMinWidth(width);
        textField.setMinHeight(height);
        textField.setMaxWidth(width);
        textField.setMaxHeight(height);
        textField.setFont(Font.font("Poppins", FontWeight.NORMAL, fontSize));
        textField.setStyle("-fx-background-color: #3E3E3E; -fx-alignment: center; -fx-text-fill: #fff");

        return textField;
    }
	
}

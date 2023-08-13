package fr.nymeria.servor.ui.elements.Settings;


import java.io.File;

import org.json.simple.JSONObject;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import fr.nymeria.servor.App;
import fr.nymeria.servor.helpers.FileHelper;
import fr.nymeria.servor.helpers.JsonHelper;
import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class DockerPath {

	private HBox contener;
	
	public DockerPath(Pane pane) {
		
		contener = new HBox();
		
		contener.setTranslateX(305);
		contener.setTranslateY(97);
		contener.setPrefSize(619, 76);
		contener.setStyle("-fx-background-color: #3E3E3E; -fx-background-radius: 20px;");
		contener.setAlignment(Pos.CENTER_LEFT);
		
		HBox save = new HBox();
		
		save.setPrefSize(76, 76);
		save.setTranslateX(971);
		save.setTranslateY(97);
		save.setStyle("-fx-background-color: #3E3E3E; -fx-background-radius: 20px;");
		save.setAlignment(Pos.CENTER);
		
		Text saveText = GlyphsDude.createIcon(FontAwesomeIcon.SAVE, "40px");
		
		saveText.setFill(Color.WHITE);
		
		save.getChildren().add(saveText);
		
		TextField path = createTextField(JsonHelper.getStringValue(FileHelper.read(FileHelper.getConfig()), "Docker Path"), 523d, 76d, 32);
		
		HBox folder = new HBox();
		
		folder.setPrefSize(76, 76);
		folder.setTranslateX(849);
		folder.setTranslateY(98);
		folder.setAlignment(Pos.CENTER);
		
		Text folderText = GlyphsDude.createIcon(FontAwesomeIcon.FOLDER, "40px");
		
		folderText.setFill(Color.WHITE);
		
		DirectoryChooser fileChooser = new DirectoryChooser();
		
		fileChooser.setInitialDirectory(new File("C:\\Program Files\\Docker\\Docker"));
		
		folder.setOnMouseClicked(event -> {
			
			File file = fileChooser.showDialog(App.getStage());
			
			path.setText(file.getPath().toString());
			
			setPath(path.getText());
		});
		
		folder.hoverProperty().addListener((observable, oldValue, newValue) -> {
			ScaleTransition st = new ScaleTransition(Duration.millis(200), folderText);
			if(newValue) {
				st.setToX(0.8);
				st.setToY(0.8);
			}else {
				st.setToX(1);
				st.setToY(1);
			}
			st.play();
		});
		
		folder.getChildren().add(folderText);
		
		contener.getChildren().add(path);
		
		HBox textBox = new HBox();
		
		textBox.setPrefSize(218, 76);
		textBox.setTranslateX(50);
		textBox.setTranslateY(97);
		textBox.setAlignment(Pos.CENTER_LEFT);
		
		Text text = new Text("Docker Path :");
		text.setFill(Color.WHITE);
        text.setFont(Font.font("Poppins", FontWeight.BOLD, 32));
		
		textBox.getChildren().add(text);
		
		pane.getChildren().addAll(contener, textBox, save, folder);
		
		save.setOnMouseClicked(event -> {
			setPath(path.getText());
		});
		
		save.hoverProperty().addListener((observable, oldValue, newValue) -> {
			ScaleTransition st = new ScaleTransition(Duration.millis(200), save);
			if(newValue) {
				save.setStyle("-fx-background-color: #363636; -fx-background-radius: 20px;");
				st.setToX(0.8);
				st.setToY(0.8);
			}else {
				save.setStyle("-fx-background-color: #3E3E3E; -fx-background-radius: 20px;");
				st.setToX(1);
				st.setToY(1);
			}
			st.play();
		});
		
	}
	
	@SuppressWarnings("unchecked")
	private void setPath(String path) {
		File config = FileHelper.getConfig();
		
		JSONObject object = FileHelper.read(config);
		
		object.put("Docker Path", path.replace("/", "\\"));
		
		FileHelper.write(config, object);
	}
	
	private TextField createTextField(String text, double width, double height, int fontSize) {
        TextField textField = new TextField(text);
        textField.setPrefWidth(width);
        textField.setPrefHeight(height);
        textField.setFont(Font.font("Poppins", FontWeight.NORMAL, fontSize));
        textField.setStyle("-fx-background-color: #3E3E3E; -fx-text-fill: #fff; -fx-background-radius: 20px;");

        return textField;
    }
	
}

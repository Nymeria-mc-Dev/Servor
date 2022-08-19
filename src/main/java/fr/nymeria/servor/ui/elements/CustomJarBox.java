package fr.nymeria.servor.ui.elements;

import java.io.File;

import fr.nymeria.servor.enums.ServerExecutor;
import fr.nymeria.servor.enums.ServerVersion;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CustomJarBox {
	
	Pane customPane;
	
	@SuppressWarnings("unused")
	public CustomJarBox() {
		customPane = new Pane();
		customPane.setVisible(false);
		customPane.setPrefSize(227, 270);
		customPane.getStyleClass().add("customCard");
		customPane.setTranslateX(615);
		customPane.setTranslateY(400);

		VBox customJarBox = new VBox();
		customJarBox.setAlignment(Pos.CENTER);
		customJarBox.setTranslateY(62);

		HBox customJarButton = new HBox();
		customJarButton.setPrefSize(116, 32);
		customJarButton.setTranslateX(103);
		customJarButton.setTranslateY(13);
		customJarButton.setAlignment(Pos.BASELINE_CENTER);
		customJarButton.getStyleClass().add("customChooseButton");

		HBox customJarTextBox = new HBox();
		customJarTextBox.setPrefSize(103, 32);
		customJarTextBox.setTranslateY(13);
		customJarTextBox.setAlignment(Pos.CENTER);

		Text customJarText = new Text("Custom JAR : ");
		customJarText.setFill(Color.WHITE);
		customJarText.setStyle("-fx-font-size: 16px; -fx-font-family: regular;");

		Text customJarButtonText = new Text("Choose");
		customJarButtonText.setFill(Color.WHITE);
		customJarButtonText.setStyle("-fx-font-size: 20px; -fx-font-family: regular;");

		Rectangle customJarSeparator = new Rectangle(227, 3);
		customJarSeparator.setTranslateY(59);
		customJarSeparator.setStyle("-fx-fill: rgba(50, 50, 50, 75);");

		customJarButton.getChildren().add(customJarButtonText);

		customJarTextBox.getChildren().add(customJarText);

		// JDK 17

		JDKButton jdk17 = new JDKButton(customJarBox, "jdk 17", ServerExecutor.CUSTOM, ServerVersion.JDK17);

		// JDK 16

		JDKButton jdk16 = new JDKButton(customJarBox, "jdk 16", ServerExecutor.CUSTOM, ServerVersion.JDK16);

		// JDK 11

		JDKButton jdk11 = new JDKButton(customJarBox, "jdk 11", ServerExecutor.CUSTOM, ServerVersion.JDK11);

		// JDK 8

		JDKButton jdk8 = new JDKButton(customJarBox, "jdk 8", ServerExecutor.CUSTOM, ServerVersion.JDK8);

		// JDK 7

		JDKButton jdk7 = new JDKButton(customJarBox, "jdk 7", ServerExecutor.CUSTOM, ServerVersion.JDK7);
		
		
		customJarButton.setOnMouseClicked(e -> {
			FileChooser fileChooser = new FileChooser();
			
			fileChooser.setTitle("Choose custom .jar");
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JAR", "*.jar"));
			
			File file = fileChooser.showOpenDialog(new Stage());
			
			if (file != null) {
				if (isJar(file)) {
					System.out.println("Good jar file");
				} else {
					System.out.println("le fichier selectionner n'est pas un fichier .jar");
				}
			} else {
				System.out.println("Aucun fichier selectionner");
			}
		});

		// Adding all to custom bar

		customPane.getChildren().addAll(customJarTextBox, customJarButton, customJarSeparator, customJarBox);	
	}

	public void setVisible(boolean value) {
		customPane.setVisible(value);
	}
	
	public Pane get() {
		return customPane;
	}
	
	public static Boolean isJar(File f) {
		System.out.println(f.getName());
		String[] list = f.getName().split("\\.");
        String fileExtention = list[list.length - 1];
        System.out.println(fileExtention);
        
        if(fileExtention.equalsIgnoreCase("jar")) {
        	return true;
        }else {
        	return false;
		}
    }
}

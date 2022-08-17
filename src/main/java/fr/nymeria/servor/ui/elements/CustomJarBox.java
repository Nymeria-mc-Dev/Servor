package fr.nymeria.servor.ui.elements;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CustomJarBox {

	Pane customPane;
	
	public CustomJarBox() {
		customPane = new Pane();
		customPane.setVisible(false);
		customPane.setPrefSize(227, 261);
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

		VBox jdk17 = createJDK("jdk 17");

		// JDK 16

		VBox jdk16 = createJDK("jdk 16");

		// JDK 11

		VBox jdk11 = createJDK("jdk 11");

		// JDK 8

		VBox jdk8 = createJDK("jdk 8");

		// JDK 7

		VBox jdk7 = createJDK("jdk 7");

		// Adding all to custom bar

		customJarBox.getChildren().addAll(jdk17, jdk16, jdk11, jdk8, jdk7);

		customPane.getChildren().addAll(customJarTextBox, customJarButton, customJarSeparator, customJarBox);	
	}

	private VBox createJDK(String name) {
		VBox jdkBox = new VBox();
		jdkBox.setPrefSize(226, 40);
		jdkBox.setAlignment(Pos.CENTER);

		Text jdk = new Text(name);
		jdk.setFill(Color.WHITE);
		jdk.setStyle("-fx-font-size: 20px; -fx-font-family: regular;");

		jdkBox.getChildren().add(jdk);
		return jdkBox;
	}
	
	public void setVisible(boolean value) {
		customPane.setVisible(value);
	}

	public Pane get() {
		return customPane;
	}
}

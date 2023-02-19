package fr.nymeria.servor.ui.elements;

import fr.nymeria.servor.enums.ServerExecutor;
import fr.nymeria.servor.enums.ServerVersion;
import fr.nymeria.servor.ui.ChooseVersion;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JDKButton {

	VBox jdkBox;
	
	private ServerExecutor serverExecutor;
	private ServerVersion serverVersion;
	
	public JDKButton(Pane pane, String name, ServerExecutor serverExecutor, ServerVersion serverVersion) {
		
		this.serverExecutor = serverExecutor;
		this.serverVersion = serverVersion;
		
		jdkBox = new VBox();
		jdkBox.setPrefSize(227, 40);
		jdkBox.setAlignment(Pos.CENTER);

		Text jdk = new Text(name);
		jdk.setFill(Color.WHITE);
		jdk.setStyle("-fx-font-size: 20px; -fx-font-family: regular;");

		jdkBox.getChildren().add(jdk);
		
		addClickEvent(jdkBox);
		pane.getChildren().add(jdkBox);
	}
	
	public VBox get() {
		return jdkBox;
	}
	
	private void addClickEvent(VBox box) {
		box.setOnMouseClicked(event -> {
			
			if(ServerSelector.getClickedCard() != null) {
				ServerSelector.getClickedCard().setClicked(false);
				ServerSelector.setClickedCard(null);
			}else if(ServerSelector.getClickedJDK() != null) {
				ServerSelector.getClickedJDK().setClicked(false);
			}
			
			if(CustomJarBox.jarFile == null) {
				ChooseVersion.nextButton.setDisable(true);
			}
			
			String executor = getServerExecutor().toString();
			executor = " " + executor.subSequence(0, 1).toString() + executor.substring(1).toLowerCase();
			ChooseVersion.setVersionText(executor + getServerVersion().toString().replace("JDK", " jdk ").replace("_", "."));
			
			ServerSelector.setClickedJDK(this);
			setClicked(true);
		});
	}
	
	public ServerVersion getServerVersion() {
		return serverVersion;
	}
	
	public ServerExecutor getServerExecutor() {
		return serverExecutor;
	}
	
	public void setClicked(boolean value) {
		if(value) {
			jdkBox.getStyleClass().add("clickedJDK");
		}else {
			jdkBox.getStyleClass().remove("clickedJDK");
		}
	}
}

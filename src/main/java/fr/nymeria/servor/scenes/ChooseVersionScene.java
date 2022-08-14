package fr.nymeria.servor.scenes;

import java.util.Vector;

import fr.nymeria.servor.App;
import fr.nymeria.servor.ui.ChooseVersion;
import fr.nymeria.servor.ui.TopBar;
import fr.nymeria.servor.ui.elements.VersionCard;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChooseVersionScene {

	private static Stage stage;
	private static Pane pane = new Pane();
	private static Scene scene = new Scene(pane, 1080, 720);

	public static Vector<VersionCard> VCardList;
	/* public static Thread t; */

	private static boolean loaded = false;

	public static Scene get() {

		/* t = new Thread() {
			public void run() {
				while (true) {
					for (VersionCard vcard : ChooseVersionScene.VCardList) {
						vcard.getHBox().setOnMouseClicked(e -> {
							ChooseVersionScene.VCardList.forEach(t -> t.removeSelected());
							try {
								t.wait(2000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							vcard.setHBoxStyle();
						});
					}
				}
			}
		};
		t.start(); */

		stage = App.getStage();
		VCardList = new Vector<>();

		pane.setStyle("-fx-background-color: #272727;");

		if(!loaded) {
			addElements();
			addStyleSheets();
		}

		loaded = true;

		return scene;
	}

	private static void addStyleSheets() {
		pane.getStylesheets().add(App.class.getResource("/css/ChooseVersion.css").toExternalForm());
	}

	private static void addElements() {
		new ChooseVersion(pane);
		new TopBar(pane, stage);
		VersionCard VC0 = new VersionCard(pane, 276, 50, "1.19.1");
		VersionCard VC1 = new VersionCard(pane, 689, 50, "1.18.1");

		VersionCard VC2 = new VersionCard(pane, 276, 182, "1.17.1");
		VersionCard VC3 = new VersionCard(pane, 689, 182, "1.16.5");

		VersionCard VC4 = new VersionCard(pane, 276, 314, "1.15.2");
		VersionCard VC5 = new VersionCard(pane, 689, 314, "1.14.4");

		VersionCard VC6 = new VersionCard(pane, 276, 446, "1.13.2");
		VersionCard VC7 = new VersionCard(pane, 689, 446, "1.12.2");

		VersionCard VC8 = new VersionCard(pane, 276, 578, "1.11.2");
		VersionCard VC9 = new VersionCard(pane, 689, 578, "1.8.2");

		VCardList.add(VC0);
		VCardList.add(VC1);
		VCardList.add(VC2);
		VCardList.add(VC3);
		VCardList.add(VC4);
		VCardList.add(VC5);
		VCardList.add(VC6);
		VCardList.add(VC7);
		VCardList.add(VC8);
		VCardList.add(VC9);
	}

}

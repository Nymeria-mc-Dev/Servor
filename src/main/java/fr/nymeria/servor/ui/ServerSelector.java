package fr.nymeria.servor.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.nymeria.servor.enums.ServerExecutor;
import fr.nymeria.servor.enums.ServerVersion;
import fr.nymeria.servor.ui.elements.JDKButton;
import fr.nymeria.servor.ui.elements.VersionCard;
import javafx.scene.layout.Pane;

public class ServerSelector {

	private static VersionCard clickedCard;
	private static JDKButton clickedJDK;

	private static Map<String, List<VersionCard>> versionCards = new HashMap<>();
	
	private static Pane paper = new Pane();
	private static Pane spigot = new Pane();
	private static Pane bukkit = new Pane();
	private static Pane mohist = new Pane();
	private static Pane forge = new Pane();
	private static Pane magma = new Pane();

	public static void init(Pane pane) {
		
		List<VersionCard> paperCards = new ArrayList<>();
		List<VersionCard> spigotCards = new ArrayList<>();
		List<VersionCard> bukkitCards = new ArrayList<>();
		List<VersionCard> mohistCards = new ArrayList<>();
		List<VersionCard> forgeCards = new ArrayList<>();
		List<VersionCard> magmaCards = new ArrayList<>();
		
		String paperRoot = "/icons/servers/paper.png";
		String spigotRoot = "/icons/servers/spigot.png";
		String bukkitRoot = "/icons/servers/bukkit.png";
		String mohistRoot = "/icons/servers/mohist.png";
		String forgeRoot = "/icons/servers/forge.png";
		String magmaRoot = "/icons/servers/magma.png";
		
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_19_1));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_18_2));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_17_1));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_16_5));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_15_2));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_14_4));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_13_2));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_12_2));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_11_2));
		paperCards.add(new VersionCard(paper, paperRoot, ServerExecutor.PAPER, ServerVersion.VERSION_1_8_9));

		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_19_1));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_18_2));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_17_1));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_16_5));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_15_2));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_14_4));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_13_2));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_12_2));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_11_2));
		spigotCards.add(new VersionCard(spigot, spigotRoot, ServerExecutor.SPIGOT, ServerVersion.VERSION_1_8_9));

		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_19_1));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_18_2));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_17_1));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_16_5));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_15_2));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_14_4));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_13_2));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_12_2));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_11_2));
		bukkitCards.add(new VersionCard(bukkit, bukkitRoot, ServerExecutor.BUKKIT, ServerVersion.VERSION_1_8_9));

		mohistCards.add(new VersionCard(mohist, mohistRoot, ServerExecutor.MOHIST, ServerVersion.VERSION_1_18_2));
		mohistCards.add(new VersionCard(mohist, mohistRoot, ServerExecutor.MOHIST, ServerVersion.VERSION_1_16_5));
		mohistCards.add(new VersionCard(mohist, mohistRoot, ServerExecutor.MOHIST, ServerVersion.VERSION_1_12_2));

		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_19_1));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_18_2));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_17_1));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_16_5));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_15_2));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_14_4));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_13_2));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_12_2));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_11_2));
		forgeCards.add(new VersionCard(forge, forgeRoot, ServerExecutor.FORGE, ServerVersion.VERSION_1_8_9));

		magmaCards.add(new VersionCard(magma, magmaRoot, ServerExecutor.MAGMA, ServerVersion.VERSION_1_18_2));
		magmaCards.add(new VersionCard(magma, magmaRoot, ServerExecutor.MAGMA, ServerVersion.VERSION_1_16_5));
		magmaCards.add(new VersionCard(magma, magmaRoot, ServerExecutor.MAGMA, ServerVersion.VERSION_1_12_2));

		versionCards.put("paper", paperCards);
		versionCards.put("spigot", spigotCards);
		versionCards.put("bukkit", bukkitCards);
		versionCards.put("mohist", mohistCards);
		versionCards.put("forge", forgeCards);
		versionCards.put("magma", magmaCards);
		
		setAllInvisible();

		paper.setVisible(true);

		clickedCard = paperCards.get(0);
		clickedCard.setClicked(true);

		for(List<VersionCard> values : versionCards.values()) {
			autoLayout(values);
		}

		pane.getChildren().addAll(paper, spigot, bukkit, mohist, forge, magma);
		
	}
	
	private static void autoLayout(List<VersionCard> list) {
		
		int column = 0;
		int line = 0;
		
		for(VersionCard card : list) {
			if(column > 1) {
				line += 1;
				column = 0;
			}
			card.setPosition(276 + (413 * column), 50 + (132 * line));
			setClickEvent(card);
			column += 1;
		}
	}

	private static void setClickEvent(VersionCard card) {
		card.get().setOnMouseClicked(event -> {
			
			if(clickedCard != null) {
				clickedCard.setClicked(false);
			}else if (clickedJDK != null) {
				clickedJDK.setClicked(false);
				clickedJDK = null;
			}
			
			ChooseVersion.nextButton.setDisable(false);
			
			card.setClicked(true);
			clickedCard = card;
			String executor = card.getServerExecutor().toString();
			executor = " " + executor.subSequence(0, 1).toString() + executor.substring(1).toLowerCase();
			ChooseVersion.setVersionText(executor + card.getServerVersion().toString().replace("VERSION_", " ").replace("_", "."));
		});
	}

	public static void setPaperVisible(boolean value) {
		setAllInvisible();
		paper.setVisible(value);
	}

	public static void setSpigotVisible(boolean value) {
		setAllInvisible();
		spigot.setVisible(value);
	}

	public static void setBukkitVisible(boolean value) {
		setAllInvisible();
		bukkit.setVisible(value);
	}

	public static void setMohistVisible(boolean value) {
		setAllInvisible();
		mohist.setVisible(value);
	}

	public static void setForgeVisible(boolean value) {
		setAllInvisible();
		forge.setVisible(value);
	}

	public static void setMagmaVisible(boolean value) {
		setAllInvisible();
		magma.setVisible(value);
	}

	public static VersionCard getClickedCard() {
		return clickedCard;
	}
	
	public static void setClickedCard(VersionCard card) {
		clickedCard = card;
	}
	
	public static void setClickedJDK(JDKButton jdkButton) {
		clickedJDK = jdkButton;
	}
	
	public static JDKButton getClickedJDK() {
		return clickedJDK;
	}
	
	private static void setAllInvisible() {
		paper.setVisible(false);
		spigot.setVisible(false);
		bukkit.setVisible(false);
		mohist.setVisible(false);
		forge.setVisible(false);
		magma.setVisible(false);
	}
}

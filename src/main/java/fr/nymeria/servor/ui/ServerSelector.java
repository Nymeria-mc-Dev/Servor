package fr.nymeria.servor.ui;

import fr.nymeria.servor.enums.ServerExecutor;
import fr.nymeria.servor.enums.ServerVersion;
import fr.nymeria.servor.ui.elements.VersionCard;
import javafx.scene.layout.Pane;

public class ServerSelector {

	private static VersionCard clickedCard;
	
	
	private static Pane paper = new Pane();
	private static Pane spigot = new Pane();
	private static Pane bukkit = new Pane();
	private static Pane mohist = new Pane();
	private static Pane forge = new Pane();
	private static Pane magma = new Pane();
	
	private static VersionCard paper_1_19_1;
	private static VersionCard paper_1_18_2;
	private static VersionCard paper_1_17_1;
	private static VersionCard paper_1_16_5;
	private static VersionCard paper_1_15_2;
	private static VersionCard paper_1_14_4;
	private static VersionCard paper_1_13_2;
	private static VersionCard paper_1_12_2;
	private static VersionCard paper_1_11_2;
	private static VersionCard paper_1_8_9;
	
	private static VersionCard spigot_1_19_1;
	private static VersionCard spigot_1_18_2;
	private static VersionCard spigot_1_17_1;
	private static VersionCard spigot_1_16_5;
	private static VersionCard spigot_1_15_2;
	private static VersionCard spigot_1_14_4;
	private static VersionCard spigot_1_13_2;
	private static VersionCard spigot_1_12_2;
	private static VersionCard spigot_1_11_2;
	private static VersionCard spigot_1_8_9;
	
	private static VersionCard bukkit_1_19_1;
	private static VersionCard bukkit_1_18_2;
	private static VersionCard bukkit_1_17_1;
	private static VersionCard bukkit_1_16_5;
	private static VersionCard bukkit_1_15_2;
	private static VersionCard bukkit_1_14_4;
	private static VersionCard bukkit_1_13_2;
	private static VersionCard bukkit_1_12_2;
	private static VersionCard bukkit_1_11_2;
	private static VersionCard bukkit_1_8_9;
	
	private static VersionCard mohist_1_18_2;
	private static VersionCard mohist_1_16_5;
	private static VersionCard mohist_1_12_2;
	
	private static VersionCard forge_1_19_1;
	private static VersionCard forge_1_18_2;
	private static VersionCard forge_1_17_1;
	private static VersionCard forge_1_16_5;
	private static VersionCard forge_1_15_2;
	private static VersionCard forge_1_14_4;
	private static VersionCard forge_1_13_2;
	private static VersionCard forge_1_12_2;
	private static VersionCard forge_1_11_2;
	private static VersionCard forge_1_8_9;
	
	private static VersionCard magma_1_18_2;
	private static VersionCard magma_1_16_5;
	private static VersionCard magma_1_12_2;
	
	public static void init(Pane pane) {
		paper_1_19_1 = new VersionCard(paper, 276, 50, "1.19.1", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_19_1);
		paper_1_18_2 = new VersionCard(paper, 689, 50, "1.18.2", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_18_2);
		paper_1_17_1 = new VersionCard(paper, 276, 182, "1.17.1", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_17_1);
		paper_1_16_5 = new VersionCard(paper, 689, 182, "1.16.5", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_16_5);
		paper_1_15_2 = new VersionCard(paper, 276, 314, "1.15.2", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_15_2);
		paper_1_14_4 = new VersionCard(paper, 689, 314, "1.14.4", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_14_4);
		paper_1_13_2 = new VersionCard(paper, 276, 446, "1.13.2", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_13_2);
		paper_1_12_2 = new VersionCard(paper, 689, 446, "1.12.2", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_12_2);
		paper_1_11_2 = new VersionCard(paper, 276, 578, "1.11.2", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_11_2);
		paper_1_8_9 = new VersionCard(paper, 689, 578, "1.8.9", "/icons/servers/paper.png", ServerExecutor.PAPER, ServerVersion.VERSION_1_8_9);
		
		spigot_1_19_1 = new VersionCard(spigot, 276, 50, "1.19.1", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_19_1);
		spigot_1_18_2 = new VersionCard(spigot, 689, 50, "1.18.2", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_18_2);
		spigot_1_17_1 = new VersionCard(spigot, 276, 182, "1.17.1", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_17_1);
		spigot_1_16_5 = new VersionCard(spigot, 689, 182, "1.16.5", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_16_5);
		spigot_1_15_2 = new VersionCard(spigot, 276, 314, "1.15.2", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_15_2);
		spigot_1_14_4 = new VersionCard(spigot, 689, 314, "1.14.4", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_14_4);
		spigot_1_13_2 = new VersionCard(spigot, 276, 446, "1.13.2", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_13_2);
		spigot_1_12_2 = new VersionCard(spigot, 689, 446, "1.12.2", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_12_2);
		spigot_1_11_2 = new VersionCard(spigot, 276, 578, "1.11.2", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_11_2);
		spigot_1_8_9 = new VersionCard(spigot, 689, 578, "1.8.9", "/icons/servers/spigot.png", ServerExecutor.SPIGOT, ServerVersion.VERSION_1_8_9);
		
		bukkit_1_19_1 = new VersionCard(bukkit, 276, 50, "1.19.1", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_19_1);
		bukkit_1_18_2 = new VersionCard(bukkit, 689, 50, "1.18.2", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_18_2);
		bukkit_1_17_1 = new VersionCard(bukkit, 276, 182, "1.17.1", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_17_1);
		bukkit_1_16_5 = new VersionCard(bukkit, 689, 182, "1.16.5", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_16_5);
		bukkit_1_15_2 = new VersionCard(bukkit, 276, 314, "1.15.2", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_15_2);
		bukkit_1_14_4 = new VersionCard(bukkit, 689, 314, "1.14.4", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_14_4);
		bukkit_1_13_2 = new VersionCard(bukkit, 276, 446, "1.13.2", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_13_2);
		bukkit_1_12_2 = new VersionCard(bukkit, 689, 446, "1.12.2", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_12_2);
		bukkit_1_11_2 = new VersionCard(bukkit, 276, 578, "1.11.2", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_11_2);
		bukkit_1_8_9 = new VersionCard(bukkit, 689, 578, "1.8.9", "/icons/servers/bukkit.png", ServerExecutor.BUKKIT, ServerVersion.VERSION_1_8_9);
		
		mohist_1_18_2 = new VersionCard(mohist, 276, 50, "1.18.2", "/icons/servers/mohist.png", ServerExecutor.MOHIST, ServerVersion.VERSION_1_18_2);
		mohist_1_16_5 = new VersionCard(mohist, 689, 50, "1.16.5", "/icons/servers/mohist.png", ServerExecutor.MOHIST, ServerVersion.VERSION_1_16_5);
		mohist_1_12_2 = new VersionCard(mohist, 276, 182, "1.12.2", "/icons/servers/mohist.png", ServerExecutor.MOHIST, ServerVersion.VERSION_1_12_2);
		
		forge_1_19_1 = new VersionCard(forge, 276, 50, "1.19.1", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_19_1);
		forge_1_18_2 = new VersionCard(forge, 689, 50, "1.18.2", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_18_2);
		forge_1_17_1 = new VersionCard(forge, 276, 182, "1.17.1", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_17_1);
		forge_1_16_5 = new VersionCard(forge, 689, 182, "1.16.5", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_16_5);
		forge_1_15_2 = new VersionCard(forge, 276, 314, "1.15.2", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_15_2);
		forge_1_14_4 = new VersionCard(forge, 689, 314, "1.14.4", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_14_4);
		forge_1_13_2 = new VersionCard(forge, 276, 446, "1.13.2", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_13_2);
		forge_1_12_2 = new VersionCard(forge, 689, 446, "1.12.2", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_12_2);
		forge_1_11_2 = new VersionCard(forge, 276, 578, "1.11.2", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_11_2);
		forge_1_8_9 = new VersionCard(forge, 689, 578, "1.8.9", "/icons/servers/forge.png", ServerExecutor.FORGE, ServerVersion.VERSION_1_8_9);
		
		magma_1_18_2 = new VersionCard(magma, 276, 50, "1.18.2", "/icons/servers/magma.png", ServerExecutor.MAGMA, ServerVersion.VERSION_1_18_2);
		magma_1_16_5 = new VersionCard(magma, 689, 50, "1.16.5", "/icons/servers/magma.png", ServerExecutor.MAGMA, ServerVersion.VERSION_1_16_5);
		magma_1_12_2 = new VersionCard(magma, 276, 182, "1.12.2", "/icons/servers/magma.png", ServerExecutor.MAGMA, ServerVersion.VERSION_1_12_2);
		
		setAllInvisible();
		
		paper.setVisible(true);
		
		clickedCard = paper_1_19_1;
		paper_1_19_1.setClicked(true);
		
		deployClickEvent();
		
		pane.getChildren().addAll(paper, spigot, bukkit, mohist, forge, magma);
	}
	
	private static void deployClickEvent() {
		setClickEvent(paper_1_19_1);
		setClickEvent(paper_1_18_2);
		setClickEvent(paper_1_17_1);
		setClickEvent(paper_1_16_5);
		setClickEvent(paper_1_15_2);
		setClickEvent(paper_1_14_4);
		setClickEvent(paper_1_13_2);
		setClickEvent(paper_1_12_2);
		setClickEvent(paper_1_11_2);
		setClickEvent(paper_1_8_9);
		
		setClickEvent(spigot_1_19_1);
		setClickEvent(spigot_1_18_2);
		setClickEvent(spigot_1_17_1);
		setClickEvent(spigot_1_16_5);
		setClickEvent(spigot_1_15_2);
		setClickEvent(spigot_1_14_4);
		setClickEvent(spigot_1_13_2);
		setClickEvent(spigot_1_12_2);
		setClickEvent(spigot_1_11_2);
		setClickEvent(spigot_1_8_9);
		
		setClickEvent(bukkit_1_19_1);
		setClickEvent(bukkit_1_18_2);
		setClickEvent(bukkit_1_17_1);
		setClickEvent(bukkit_1_16_5);
		setClickEvent(bukkit_1_15_2);
		setClickEvent(bukkit_1_14_4);
		setClickEvent(bukkit_1_13_2);
		setClickEvent(bukkit_1_12_2);
		setClickEvent(bukkit_1_11_2);
		setClickEvent(bukkit_1_8_9);
		
		setClickEvent(mohist_1_18_2);
		setClickEvent(mohist_1_16_5);
		setClickEvent(mohist_1_12_2);
		
		setClickEvent(forge_1_19_1);
		setClickEvent(forge_1_18_2);
		setClickEvent(forge_1_17_1);
		setClickEvent(forge_1_16_5);
		setClickEvent(forge_1_15_2);
		setClickEvent(forge_1_14_4);
		setClickEvent(forge_1_13_2);
		setClickEvent(forge_1_12_2);
		setClickEvent(forge_1_11_2);
		setClickEvent(forge_1_8_9);

		setClickEvent(magma_1_18_2);
		setClickEvent(magma_1_16_5);
		setClickEvent(magma_1_12_2);
	}
	
	private static void setClickEvent(VersionCard card) {
		card.get().setOnMouseClicked(event -> {
			clickedCard.setClicked(false);
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
	
	private static void setAllInvisible() {
		paper.setVisible(false);
		spigot.setVisible(false);
		bukkit.setVisible(false);
		mohist.setVisible(false);
		forge.setVisible(false);
		magma.setVisible(false);
	}
}

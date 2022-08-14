package fr.nymeria.servor.ui;

import fr.nymeria.servor.ui.elements.VersionCard;
import javafx.scene.layout.Pane;

public class ServerSelector {

	private static Pane paper = new Pane();
	private static Pane spigot = new Pane();
	private static Pane bukkit = new Pane();
	private static Pane mohist = new Pane();
	private static Pane forge = new Pane();
	private static Pane magma = new Pane();
	
	public static void init(Pane pane) {
		VersionCard	paper_1_19_1 = new VersionCard(paper, 276, 50, "1.19.1", "/icons/servers/paper.png");
		VersionCard paper_1_18_1 = new VersionCard(paper, 689, 50, "1.18.1", "/icons/servers/paper.png");
		VersionCard paper_1_17_1 = new VersionCard(paper, 276, 182, "1.17.1", "/icons/servers/paper.png");
		VersionCard paper_1_16_5 = new VersionCard(paper, 689, 182, "1.16.5", "/icons/servers/paper.png");
		VersionCard paper_1_15_2 = new VersionCard(paper, 276, 314, "1.15.2", "/icons/servers/paper.png");
		VersionCard paper_1_14_4 = new VersionCard(paper, 689, 314, "1.14.4", "/icons/servers/paper.png");
		VersionCard paper_1_13_2 = new VersionCard(paper, 276, 446, "1.13.2", "/icons/servers/paper.png");
		VersionCard paper_1_12_2 = new VersionCard(paper, 689, 446, "1.12.2", "/icons/servers/paper.png");
		VersionCard paper_1_11_2 = new VersionCard(paper, 276, 578, "1.11.2", "/icons/servers/paper.png");
		VersionCard paper_1_8_2 = new VersionCard(paper, 689, 578, "1.8.2", "/icons/servers/paper.png");
		
		VersionCard	spigot_1_19_1 = new VersionCard(spigot, 276, 50, "1.19.1", "/icons/servers/spigot.png");
		VersionCard spigot_1_18_1 = new VersionCard(spigot, 689, 50, "1.18.1", "/icons/servers/spigot.png");
		VersionCard spigot_1_17_1 = new VersionCard(spigot, 276, 182, "1.17.1", "/icons/servers/spigot.png");
		VersionCard spigot_1_16_5 = new VersionCard(spigot, 689, 182, "1.16.5", "/icons/servers/spigot.png");
		VersionCard spigot_1_15_2 = new VersionCard(spigot, 276, 314, "1.15.2", "/icons/servers/spigot.png");
		VersionCard spigot_1_14_4 = new VersionCard(spigot, 689, 314, "1.14.4", "/icons/servers/spigot.png");
		VersionCard spigot_1_13_2 = new VersionCard(spigot, 276, 446, "1.13.2", "/icons/servers/spigot.png");
		VersionCard spigot_1_12_2 = new VersionCard(spigot, 689, 446, "1.12.2", "/icons/servers/spigot.png");
		VersionCard spigot_1_11_2 = new VersionCard(spigot, 276, 578, "1.11.2", "/icons/servers/spigot.png");
		VersionCard spigot_1_8_2 = new VersionCard(spigot, 689, 578, "1.8.2", "/icons/servers/spigot.png");
		
		VersionCard	bukkit_1_19_1 = new VersionCard(bukkit, 276, 50, "1.19.1", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_18_1 = new VersionCard(bukkit, 689, 50, "1.18.1", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_17_1 = new VersionCard(bukkit, 276, 182, "1.17.1", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_16_5 = new VersionCard(bukkit, 689, 182, "1.16.5", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_15_2 = new VersionCard(bukkit, 276, 314, "1.15.2", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_14_4 = new VersionCard(bukkit, 689, 314, "1.14.4", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_13_2 = new VersionCard(bukkit, 276, 446, "1.13.2", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_12_2 = new VersionCard(bukkit, 689, 446, "1.12.2", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_11_2 = new VersionCard(bukkit, 276, 578, "1.11.2", "/icons/servers/bukkit.png");
		VersionCard bukkit_1_8_2 = new VersionCard(bukkit, 689, 578, "1.8.2", "/icons/servers/bukkit.png");
		
		VersionCard	mohist_1_19_1 = new VersionCard(mohist, 276, 50, "1.19.1", "/icons/servers/mohist.png");
		VersionCard mohist_1_18_1 = new VersionCard(mohist, 689, 50, "1.18.1", "/icons/servers/mohist.png");
		VersionCard mohist_1_17_1 = new VersionCard(mohist, 276, 182, "1.17.1", "/icons/servers/mohist.png");
		VersionCard mohist_1_16_5 = new VersionCard(mohist, 689, 182, "1.16.5", "/icons/servers/mohist.png");
		VersionCard mohist_1_15_2 = new VersionCard(mohist, 276, 314, "1.15.2", "/icons/servers/mohist.png");
		VersionCard mohist_1_14_4 = new VersionCard(mohist, 689, 314, "1.14.4", "/icons/servers/mohist.png");
		VersionCard mohist_1_13_2 = new VersionCard(mohist, 276, 446, "1.13.2", "/icons/servers/mohist.png");
		VersionCard mohist_1_12_2 = new VersionCard(mohist, 689, 446, "1.12.2", "/icons/servers/mohist.png");
		VersionCard mohist_1_11_2 = new VersionCard(mohist, 276, 578, "1.11.2", "/icons/servers/mohist.png");
		VersionCard mohist_1_8_2 = new VersionCard(mohist, 689, 578, "1.8.2", "/icons/servers/mohist.png");
		
		VersionCard	forge_1_19_1 = new VersionCard(forge, 276, 50, "1.19.1", "/icons/servers/forge.png");
		VersionCard forge_1_18_1 = new VersionCard(forge, 689, 50, "1.18.1", "/icons/servers/forge.png");
		VersionCard forge_1_17_1 = new VersionCard(forge, 276, 182, "1.17.1", "/icons/servers/forge.png");
		VersionCard forge_1_16_5 = new VersionCard(forge, 689, 182, "1.16.5", "/icons/servers/forge.png");
		VersionCard forge_1_15_2 = new VersionCard(forge, 276, 314, "1.15.2", "/icons/servers/forge.png");
		VersionCard forge_1_14_4 = new VersionCard(forge, 689, 314, "1.14.4", "/icons/servers/forge.png");
		VersionCard forge_1_13_2 = new VersionCard(forge, 276, 446, "1.13.2", "/icons/servers/forge.png");
		VersionCard forge_1_12_2 = new VersionCard(forge, 689, 446, "1.12.2", "/icons/servers/forge.png");
		VersionCard forge_1_11_2 = new VersionCard(forge, 276, 578, "1.11.2", "/icons/servers/forge.png");
		VersionCard forge_1_8_2 = new VersionCard(forge, 689, 578, "1.8.2", "/icons/servers/forge.png");
		
		VersionCard	magma_1_19_1 = new VersionCard(magma, 276, 50, "1.19.1", "/icons/servers/magma.png");
		VersionCard magma_1_18_1 = new VersionCard(magma, 689, 50, "1.18.1", "/icons/servers/magma.png");
		VersionCard magma_1_17_1 = new VersionCard(magma, 276, 182, "1.17.1", "/icons/servers/magma.png");
		VersionCard magma_1_16_5 = new VersionCard(magma, 689, 182, "1.16.5", "/icons/servers/magma.png");
		VersionCard magma_1_15_2 = new VersionCard(magma, 276, 314, "1.15.2", "/icons/servers/magma.png");
		VersionCard magma_1_14_4 = new VersionCard(magma, 689, 314, "1.14.4", "/icons/servers/magma.png");
		VersionCard magma_1_13_2 = new VersionCard(magma, 276, 446, "1.13.2", "/icons/servers/magma.png");
		VersionCard magma_1_12_2 = new VersionCard(magma, 689, 446, "1.12.2", "/icons/servers/magma.png");
		VersionCard magma_1_11_2 = new VersionCard(magma, 276, 578, "1.11.2", "/icons/servers/magma.png");
		VersionCard magma_1_8_2 = new VersionCard(magma, 689, 578, "1.8.2", "/icons/servers/magma.png");
	}
	
}

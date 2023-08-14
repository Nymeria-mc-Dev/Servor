package fr.nymeria.servor.helpers;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

import java.util.Objects;

public class Discord {

	public static DiscordRichPresence presence;
	public static DiscordRPC lib;

	public static void setup() {

		if(JsonHelper.getBooleanValue(Objects.requireNonNull(FileHelper.read(FileHelper.getConfig())), "discordrpc")) {
			System.out.println("Loading discord Rpc");
			lib = DiscordRPC.INSTANCE;
			String applicationId = "1008831734550384730";
			String steamId = "";
			DiscordEventHandlers handlers = new DiscordEventHandlers();
			lib.Discord_Initialize(applicationId, handlers, true, steamId);
			presence = new DiscordRichPresence();
			presence.startTimestamp = System.currentTimeMillis() / 1000;
			setDetail("loading");
			setLargeImage("logo");
			setSmallImage("loading");
			lib.Discord_UpdatePresence(presence);
			new Thread(() -> {
				while (!Thread.currentThread().isInterrupted()) {
					lib.Discord_RunCallbacks();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException ignored) {}
				}
			}, "RPC-Callback-Handler").start();
		}
	}

	public static void setDetail(String detail) {
		if(JsonHelper.getBooleanValue(Objects.requireNonNull(FileHelper.read(FileHelper.getConfig())), "discordrpc")) {
			presence.details = detail;
			updatePresence();
		}
	}

	public static void setState(String state) {
		if(JsonHelper.getBooleanValue(Objects.requireNonNull(FileHelper.read(FileHelper.getConfig())), "discordrpc")) {
			presence.state = state;
			updatePresence();
		}
	}

	public static void setLargeImage(String imageName) {
		if(JsonHelper.getBooleanValue(FileHelper.read(FileHelper.getConfig()), "discordrpc")) {
			presence.largeImageKey = imageName;
			updatePresence();
		}
	}

	public static void setSmallImage(String imageName) {
		if(JsonHelper.getBooleanValue(Objects.requireNonNull(FileHelper.read(FileHelper.getConfig())), "discordrpc")) {
			presence.smallImageKey = imageName;
			updatePresence();
		}
	}

	private static void updatePresence() {
		if(JsonHelper.getBooleanValue(Objects.requireNonNull(FileHelper.read(FileHelper.getConfig())), "discordrpc")) {
			lib.Discord_UpdatePresence(presence);
		}
	}

	public static void close() {
		if(JsonHelper.getBooleanValue(Objects.requireNonNull(FileHelper.read(FileHelper.getConfig())), "discordrpc")) {
			System.out.println("closing rpc connection");
			lib.Discord_ClearPresence();
		}
	}

}

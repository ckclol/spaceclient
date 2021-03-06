package client;

import client.cmd.CommandManager;
import client.discord.DiscordRP;
import client.event.EventTarget;
import client.event.impl.ClientTickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class ClientMain {
	private static final ClientMain INSTANCE = new ClientMain();
	public static final ClientMain getInstance() { 
		return INSTANCE; 
	}

	private DiscordRP discordRP = new DiscordRP(); 

	public void init() {
		System.out.println("init");
		discordRP.start();
	}

	public void shutdown() {
		discordRP.shutdown();
	}

	public DiscordRP getDiscordRP() {
		return discordRP;
	}
}

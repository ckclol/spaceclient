package space;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import space.discord.DiscordRP;
import space.event.ClientTickEvent;
import space.event.EventTarget;
import space.hud.HUDManager;
import space.mod.ModInstances;

public class ClientMain {
	public boolean loop = true;
	private static final ClientMain INSTANCE = new ClientMain();
	public static final ClientMain getInstance() { 
		return INSTANCE; 
	}

	private DiscordRP discordRP = new DiscordRP(); 
	
	private HUDManager hudManager;

	public void init() {
		System.out.println("init");
		discordRP.start();
	}
	
	public void start() {
		hudManager = HUDManager.getInstance();
		ModInstances.register(hudManager);
		
	}
	
	public void shutdown() {
		discordRP.shutdown();
	}

	public DiscordRP getDiscordRP() {
		return discordRP;
	} 
	
	public void lateruses() {
		if(Minecraft.getMinecraft().gameSettings.keyBindClientModModule.isPressed()) {
	        hudManager.openConfigScreen();
	    }
	}
}

package space.hud;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainer;
import space.event.EventManager;
import space.event.EventTarget;
import space.event.RenderEvent;
import space.gui.HUDConfigScreen;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainer;

public class HUDManager {

	private HUDManager() {}
	
	private static HUDManager instance = null;
	
	public static HUDManager getInstance() {

		if(instance != null) {
			return instance;
		}
		
		instance = new HUDManager();
		EventManager.register(instance);
		
		return instance;

	}
	
	private Set<IRender> registeredrenders = Sets.newHashSet();
	private Minecraft mc = Minecraft.getMinecraft();
	
	public void register(IRender... renders) {
		for(IRender render : renders) {
			this.registeredrenders.add(render);
		}
	}
	
	public void unreister(IRender... renders) {
		for(IRender render : renders) {
			this.registeredrenders.remove(render);
		}
	}
	
	public Collection<IRender> getRegisteredrenders() {
		return Sets.newHashSet(registeredrenders);
	}
	
	public void openConfigScreen() {
		mc.displayGuiScreen(new HUDConfigScreen(this));
	}
	
	@EventTarget
	public void onRender(RenderEvent e) {
		if(mc.currentScreen == null || mc.currentScreen instanceof GuiContainer || mc.currentScreen instanceof GuiChat) {
			for(IRender render : registeredrenders) {
				callrender(render);
			}
		}
	}

	private void callrender(IRender render) {
		if(!render.isEnabled()) {
			return;
		}
		
		ScreenPos pos = render.load();
		
		if(pos == null) {
			pos = ScreenPos.fromRelativePosition(0.5, 0.5);
		}
		
		render.render(pos);
	}
	
}
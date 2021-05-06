package space.gui;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import space.hud.HUDManager;
import space.hud.IRender;
import space.hud.ScreenPos;
import space.util.MouseOverFinder;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Predicate;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class HUDConfigScreen extends GuiScreen {

	private final HashMap<IRender, ScreenPos> renders = new HashMap<IRender, ScreenPos>();
	
	private Optional<IRender> selectedrender = Optional.empty();
	
	private int prevX, prevY;
	
	public HUDConfigScreen(HUDManager api) {

		Collection<IRender> registeredrenders = api.getRegisteredrenders();
		
		for(IRender ren : registeredrenders) {
			if(!ren.isEnabled()) {
				continue;
			}
			
			ScreenPos pos = ren.load();
			
			if(pos == null) {
				pos = ScreenPos.fromRelativePosition(0.5, 0.5);
			}
			
			adjustBounds(ren, pos);
			this.renders.put(ren, pos);
		}
		
		this.buttonList.add(new GuiButton(0, this.width/2 - 100, this.height / 2 - 20, 100, 20, "Toggle Mods"));

	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		super.drawDefaultBackground();

		final float zBackup = this.zLevel;
		this.zLevel = 200;
		
		this.drawHollowRect(0, 0, this.width - 1, this.height - 1, 0xFFFF0000);
		
		for(IRender render : renders.keySet()) {
			
			ScreenPos pos = renders.get(render);
			
			render.renderDummy(pos);
			
			this.drawHollowRect(pos.getAbsoluteX(), pos.getAbsoluteY(), render.getWidth(), render.getHeight(), 0xFF00FFFF);
			
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.zLevel = zBackup;
		
		

	}

	private void drawHollowRect(int x, int y, int w, int h, int color) {
		this.drawHorizontalLine(x, x + w, y, color);
		this.drawHorizontalLine(x, x + w, y + h, color);
		
		this.drawVerticalLine(x, y + h, y, color);
		this.drawVerticalLine(x + w, y + h, y, color);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if(keyCode == Keyboard.KEY_ESCAPE) {
			renders.entrySet().forEach((entry) -> {
				entry.getKey().save(entry.getValue());
			});
			this.mc.displayGuiScreen(null);
		}
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	protected void mouseClickMove(int x, int y, int button, long time) {
		if(selectedrender.isPresent()) {
			moveSelectedRenderBy(x - prevX, y - prevY);
		}
		
		this.prevX = x;
		this.prevY = y;
		super.mouseClickMove(x, y, button, time);
	}

	private void moveSelectedRenderBy(int offsetX, int offsetY) {
		IRender render = selectedrender.get();
		ScreenPos pos = renders.get(render);
		
		pos.setAbsolute(pos.getAbsoluteX() + offsetX, pos.getAbsoluteY() + offsetY);
		
		adjustBounds(render, pos);
	}
	
	@Override
	public void onGuiClosed() {
		
		for(IRender render : renders.keySet()) {
			render.save(renders.get(render));
		}
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	private void adjustBounds(IRender render, ScreenPos pos) {
		
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		
		int screenWidth = res.getScaledWidth();
		int screenHeight = res.getScaledHeight();
		
		int absoluteX = Math.max(0, Math.min(pos.getAbsoluteX(), Math.max(screenWidth - render.getWidth(), 0)));
		int absoluteY = Math.max(0, Math.min(pos.getAbsoluteY(), Math.max(screenHeight - render.getHeight(), 0)));
		
		pos.setAbsolute(absoluteX, absoluteY);
	}
	
	@Override
	protected void mouseClicked(int x, int y, int mobuttonuseButton) throws IOException {
		this.prevX = x;
		this.prevY = y;
		
		loadMouseOver(x, y);
		super.mouseClicked(x, y, mobuttonuseButton);
	}

	private void loadMouseOver(int x, int y) {
		this.selectedrender = renders.keySet().stream().filter(new MouseOverFinder(x, y)).findFirst();
	}
	
	private class MouseOverFinder implements Predicate<IRender> {

		private int mouseX, mouseY;
		
		public MouseOverFinder(int x, int y) {
			this.mouseX = x;
			this.mouseY = y;
		}

		@Override
		public boolean test(IRender render) {

			ScreenPos pos = renders.get(render);
			
			int absoluteX = pos.getAbsoluteX();
			int absoluteY = pos.getAbsoluteY();
			
			if(mouseX >= absoluteX && mouseX <= absoluteX + render.getWidth()) {
				
				if(mouseY >= absoluteY && mouseY <= absoluteY + render.getHeight()) {
					
					return true;
					
				}
				
			}

			return false;
		}
		
	}
	
	
}
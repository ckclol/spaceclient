package client.mod;

import client.ClientMain;
import client.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public abstract class Mod {
		private boolean isEnabled = true;
		
		protected final Minecraft mc;
		protected final FontRenderer font;
		protected final ClientMain client;
		
		public Mod() {
			this.mc = Minecraft.getMinecraft();
			this.font = this.mc.fontRendererObj;
			this.client = ClientMain.getInstance();
			
			setEnabled(isEnabled);
		}
		
		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
			
			if(isEnabled) {
				EventManager.register(this);
			}
			else {
				EventManager.unregister(this);
			}
			
		}
		
		public boolean isEnabled() {
			return isEnabled;
		}
		
}
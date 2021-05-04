package client.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScreenPosition {
	
	private static final Minecraft mc = Minecraft.getMinecraft();
	
	private double x, y;
	
	public ScreenPosition(double x, double y) {
		setRelative(x, y);
	}
	
    public ScreenPosition (int x, int y) {
		setAbsolute(x, y);
	}
	public static ScreenPosition fromRelative(double x, double y) {
		return new ScreenPosition(x, y);
	}
	
	public int getAbsoluteX() {
		ScaledResolution res = new ScaledResolution(mc);
		return (int) (x  * res.getScaledWidth());
	}
	
	public static ScreenPosition fromAbsolute(int x, int y) {
		return new ScreenPosition(x, y);
	}
	
	private void setAbsolute(int x2, int y2) {
		// TODO Auto-generated method stub
		
	}
	private void setRelative(double x2, double y2) {
		// TODO Auto-generated method stub
		
	}
}

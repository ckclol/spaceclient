package space.util;

import space.hud.IRender;
import space.hud.ScreenPos;

public abstract class ModDraggable extends Mod implements IRender {
	
	public final int getLineOffset(ScreenPos pos, int ln) {
		return pos.getAbsoluteY() + getLineOffset(ln);
	}
	
	private int getLineOffset(int ln) {
		return (font.FONT_HEIGHT + 3) * ln;
	}
}

package space.mod;

import space.util.ModDraggable;
import space.hud.ScreenPos;

public class ModExample extends ModDraggable{

	private ScreenPos pos;
	
	@Override
	public int getWidth() {
		
		return font.getStringWidth("HEllo mama mia");
		
	}

	@Override
	public int getHeight() {	
		return font.FONT_HEIGHT;	
	}

	@Override
	public void render(ScreenPos pos) {
		font.drawString("OWO", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0xFF00FF0F);
    }
	
	@Override
	public void renderDummy(ScreenPos pos) {
		font.drawString("OWO", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0xFF00FF0F);
	}

	@Override
	public void save(ScreenPos pos) {
		this.pos = pos;
	}

	@Override
	public ScreenPos load() {
		return pos;
	}
}

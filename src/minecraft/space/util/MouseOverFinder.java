package space.util;

import java.util.HashMap;
import java.util.function.Predicate;

import space.hud.IRender;
import space.hud.ScreenPos;

public class MouseOverFinder implements Predicate<IRender> {

	private int x, y;
	private final HashMap<IRender, ScreenPos> renders = new HashMap<IRender, ScreenPos>();
	
	public MouseOverFinder(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean test(IRender render) {
		ScreenPos pos = renders.get(render);
		 int ax = pos.getAbsoluteX();
		 int ay = pos.getAbsoluteY();
		 
		 if(x >= ax && x <= ax + render.getWidth()) {
			 if (y >= ay && y <= ay + render.getHeight()) {
				 return true;
			 }
		 }
		return false;
	}
	
}

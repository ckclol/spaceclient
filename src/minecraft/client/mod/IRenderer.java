package client.mod;

import client.mod.ScreenPosition;

public interface IRenderer {


	int getHeight();

	int getWidth();

	void render(ScreenPosition position);

	void renderDummy(ScreenPosition position);

	public default boolean isEnabled(){
		return true;
	}
	public default void absolutelyuseless() {
		
	}
}

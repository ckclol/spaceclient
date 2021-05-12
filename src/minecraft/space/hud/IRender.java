package space.hud;

public interface IRender extends IRenderConfig {

	int getWidth();
	int getHeight();
	
	void render(ScreenPos pos);
	
	default void renderDummy(ScreenPos pos) {
		render(pos);
	}
	
	public default boolean isEnabled() {
		return true;
	}
}
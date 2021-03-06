package client.mod;

import java.io.File;

import client.util.FileManager;

public abstract class ModDraggable extends Mod implements IRenderer {

	protected ScreenPosition pos;
	
	public ModDraggable() {
		pos = loadPositionFromFile();
	}

	public ScreenPosition load() {
		return pos;
	}
	
	public void save(ScreenPosition pos) {
		this.pos = pos;
		savePositionToFile();
	}
	
	private File getFolder() {
		File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
		folder.mkdirs();
		return folder;
	}
	
	private void savePositionToFile() {
		FileManager.writeJsonToFile(new File(getFolder(), "pos.josn"), pos);
	}

	private ScreenPosition loadPositionFromFile() {
		
		ScreenPosition loaded = FileManager.readFromJson(new File(getFolder(), "pos.josn"), ScreenPosition.class);
		
		if(loaded == null) {
			loaded = ScreenPosition.fromRelative(0.5, 0.5);
			this.pos = loaded;
			savePositionToFile();
		}
		
		return loaded;
	}
	
	public final int getLineOffset(ScreenPosition pos, int lineNum) {
		return pos.getAbsoluteY() + getLineOffset(lineNum);
	}

	private int getLineOffset(int lineNum) {
		return (font.FONT_HEIGHT + 3) * lineNum;
	}
}

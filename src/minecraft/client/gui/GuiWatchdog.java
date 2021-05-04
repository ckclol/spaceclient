package client.gui;


import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;

public final class GuiWatchdog extends GuiScreen {
    private GuiScreen previousScreen;
    private GuiTextField username;

    public GuiWatchdog(GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
    }

    @Override
	protected void actionPerformed(GuiButton button) {
		
        if (button.id == 0)
        {
        	this.mc.displayGuiScreen(new GuiWatchdog2(this));
        }
        if (button.id == 1)
        {
        	mc.thePlayer.sendChatMessage("/" + "wdr" + " " + this.username.getText() + " " + "cheating");
        }
	}

    @Override
    public void drawScreen(int x2, int y2, float z2) {
    	
		ScaledResolution sr = new ScaledResolution(mc);
		this.username.drawTextBox();
		Gui.drawCenteredString(mc.fontRendererObj, "Watchdog Report!", (int) (this.width / 2F), sr.getScaledHeight() / 2 - 65, -1);
        super.drawScreen(x2, y2, z2);
    }

    @Override
    public void initGui() {
		ScaledResolution sr = new ScaledResolution(mc);
		this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50, this.height / 2 - 20,  98, 20, I18n.format("Everything else", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50, this.height / 2 + 5,  98, 20, I18n.format("Cheating", new Object[0])));
		this.username = new GuiTextField(100, this.fontRendererObj, this.width / 2 - 50, sr.getScaledHeight() / 2 - 50, 100, 20);
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void keyTyped(char character, int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t') {
            if (!this.username.isFocused()) {
                this.username.setFocused(true);
            } else {

            }
        }
        if (character == '\r') {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(character, key);
    }

    @Override
    protected void mouseClicked(int x2, int y2, int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.username.mouseClicked(x2, y2, button);
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
    }
}

package net.minecraft.client.gui;

import java.io.IOException;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.stream.GuiStreamOptions;
import net.minecraft.client.gui.stream.GuiStreamUnavailable;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.stream.IStream;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.EnumDifficulty;

public class GuiMods extends GuiScreen implements GuiYesNoCallback
{
    private static final GameSettings.Options[] field_146440_f = new GameSettings.Options[] {GameSettings.Options.FOV};
    private final GuiScreen field_146441_g;

    /** Reference to the GameSettings object. */
    private GuiButton field_175357_i;
    private GuiLockIconButton field_175356_r;;

    public GuiMods(GuiScreen p_i1046_1_)
    {
        this.field_146441_g = p_i1046_1_;
    }   
    
    public void initGui()
    {
        int i = 24;
        int j = this.height / 4 + 48;
        
        this.buttonList.add(new GuiButton(105, this.width / 2 - 155, this.height / 6 + 0 - 6, 150, 20, "All Mods Enable"));
        this.buttonList.add(new GuiButton(106, this.width / 2 + 5, this.height / 6 + 0 - 6, 150, 20, "All Mods Disable"));
        this.buttonList.add(new GuiButton(107, this.width / 2 - 155, this.height / 6 + 24 - 6, 150, 20, "PVP Mods Enable"));
        this.buttonList.add(new GuiButton(108, this.width / 2 + 5, this.height / 6 + 24 - 6, 150, 20, "PVP Mods Disable"));
        this.buttonList.add(new GuiButton(109, this.width / 2 - 155, this.height / 6 + 48 - 6, 150, 20, "100% Recommended"));
        this.buttonList.add(new GuiButton(110, this.width / 2 + 5, this.height / 6 + 48 - 6, 150, 20, "YT Mods"));
        this.buttonList.add(new GuiButton(111, this.width / 2 - 155, this.height / 6 + 72 - 6, 150, 20, "PVP Mods"));
        this.buttonList.add(new GuiButton(112, this.width / 2 + 5, this.height / 6 + 72 - 6, 150, 20, "SpaceMC Mods"));
        this.buttonList.add(new GuiButton(113, this.width / 2 - 155, this.height / 6 + 96 - 6, 150, 20, "Skyblock Mods"));
        this.buttonList.add(new GuiButton(114, this.width / 2 + 5, this.height / 6 + 96 - 6, 150, 20, "FPS Mods"));
        this.buttonList.add(new GuiButton(115, this.width / 2 - 155, this.height / 6 + 120 - 6, 150, 20, "Exclusive Mods"));
        this.buttonList.add(new GuiButton(116, this.width / 2 + 5, this.height / 6 + 120 - 6, 150, 20, "Hypixel Mods"));
        this.buttonList.add(new GuiButton(117, this.width / 2 - 155, this.height / 6 + 144 - 6, 150, 20, "Essentials"));
        this.buttonList.add(new GuiButton(118, this.width / 2 + 5, this.height / 6 + 144 - 6, 150, 20, "Absolutely Useless"));
        this.buttonList.add(new GuiButton(119, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.enabled)
        {
        	int btn = button.id;
          switch (btn) {
          case 111:
        	  break;
          case 112:
        	  break;
          case 113:
        	  break;
          case 114:
        	  break;
          case 115:
        	  break;
          case 116:
        	  break;
          case 117:
        	  break;
          case 118:
        	  break;
          case 119:
        	  this.mc.displayGuiScreen(new GuiMainMenu());
        	  break;
          }
        }
    }
    
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Mods", this.width / 2, 15, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
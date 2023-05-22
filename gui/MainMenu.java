package mmc.gui;

import java.awt.Color;

import mmc.Client;
import mmc.gui.auth.AltManagerGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class MainMenu extends GuiScreen {
	
	private static final Minecraft mc = Minecraft.getMinecraft();
	ScaledResolution sr = new ScaledResolution(mc);
	
	@Override
	public void initGui() {
		Client.getInstance().getDiscordRP().update("Status: Idle", "In Main Menu");
		super.initGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("minemen/splash.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		this.drawGradientRect(0, height - 100, width, height, 0x00000000, 0xff000000);
		
		String[] buttons = {"Singleplayer", "Multiplayer", "AltManager", "Settings", "Ragequit"};
		
		int count = 0;
		for(String name : buttons) {
			
			float x = width/buttons.length * count + (width/buttons.length) / 2f + 6 - mc.fontRendererObj.getStringWidth(name) / 2f;
			float y = height - 25;
			
			boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT;
			
			this.drawCenteredString(mc.fontRendererObj, name, (int) (width/buttons.length * count + (width/buttons.length) / 2f + 3), height - 25, hovered ? new Color(255, 180, 0, 255).getRGB() : -1);
			count++;
		}
		Gui.drawRect(0, 0, mc.fontRendererObj.getStringWidth("Welcome, " + mc.getSession().getUsername() + "!") + 10, mc.fontRendererObj.FONT_HEIGHT + 10, new Color(0, 0, 0, 100).getRGB());
		mc.fontRendererObj.drawString("Welcome, " + mc.getSession().getUsername() + "!", 5, 5, -1);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	public void mouseClicked(int mouseX, int mouseY, int button) {
		String[] buttons = {"Singleplayer", "Multiplayer", "AltManager", "Settings", "Ragequit"};
				
		int count = 0;
		for(String name : buttons) {
			float x = width/buttons.length * count + (width/buttons.length) / 2f + 6 - mc.fontRendererObj.getStringWidth(name) / 2f;
			float y = height - 25;
			
			if(mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT) {
				switch(name) {
				case "Singleplayer":
					mc.displayGuiScreen(new GuiSelectWorld(this));
					break;
				case "Multiplayer":
					mc.displayGuiScreen(new GuiMultiplayer(this));
					break;
				case "AltManager":
					mc.displayGuiScreen(new AltManagerGui());
					break;
				case "Settings":
					mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
					break;
				case "Ragequit":
					mc.shutdown();
					break;
				}
			}
			
			count++;
		}
	}
}

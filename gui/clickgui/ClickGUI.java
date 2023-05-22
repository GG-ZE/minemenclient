package mmc.gui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import mmc.Client;
import mmc.gui.auth.AltManagerGui;
import mmc.gui.clickgui.comp.ModButton;
import mmc.util.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ChatComponentText;

public class ClickGUI extends GuiScreen {

	ArrayList<ModButton> modButtons = new ArrayList<>();

	@Override
	public void initGui() {
		super.initGui();
		/*
		this.modButtons.add(new ModButton(100, 125, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModKeystrokes()));
		this.modButtons.add(new ModButton(255, 125, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModArmorStatus()));
		this.modButtons.add(new ModButton(410, 125, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModCPS()));
		this.modButtons.add(new ModButton(100, 170, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModFPS()));
		this.modButtons.add(new ModButton(255, 170, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModSlowSwing()));
		this.modButtons.add(new ModButton(410, 170, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModNameTag()));
		this.modButtons.add(new ModButton(100, 215, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModPotionStatus()));
		this.modButtons.add(new ModButton(255, 215, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModHurtCam()));
		this.modButtons.add(new ModButton(410, 215, mc.fontRendererObj.getStringWidth(Client.getInstance().m.getClass().getSimpleName()) + 13, mc.fontRendererObj.FONT_HEIGHT + 5, Client.getInstance().m.getModXYZ()));
		*/
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		//GlStateManager.pushMatrix();
		
		this.drawGradientRect(0, 0, this.width, this.height, new Color(255, 255, 255, 100).getRGB(), new Color(255, 180, 0, 20).getRGB());
		
		String[] buttons1 = {"Keystrokes", "ArmorStatus", "CPS Display", "FPS Display"};
		
		int count1 = 0;
		for(String name : buttons1) {
			
			float x = width/buttons1.length * count1 + (width/buttons1.length) / 2f + 6 - mc.fontRendererObj.getStringWidth(name) / 2f;
			float y = height / 4;
			
			boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT;
			
			this.drawCenteredString(mc.fontRendererObj, name, (int) (width/buttons1.length * count1 + (width/buttons1.length) / 2f + 3), height / 4, hovered ? new Color(255, 180, 0, 255).getRGB() : -1);
			count1++;
		}
		
		String[] buttons2 = {"Animations", "Nametags", "Potion Status", "Coordinates"};
		
		int count2 = 0;
		for(String name : buttons2) {
			
			float x = width/buttons2.length * count2 + (width/buttons2.length) / 2f + 6 - mc.fontRendererObj.getStringWidth(name) / 2f;
			float y = (height / 4) * 2;
			
			boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT;
			
			this.drawCenteredString(mc.fontRendererObj, name, (int) (width/buttons2.length * count2 + (width/buttons2.length) / 2f + 3), (height / 4) * 2, hovered ? new Color(255, 180, 0, 255).getRGB() : -1);
			count2++;
		}
		
		String[] buttons3 = {"Hurt Camera", "AntiCheat", "Watermark", "Truesight"};
		
		int count3 = 0;
		for(String name : buttons3) {
			
			float x = width/buttons3.length * count3 + (width/buttons3.length) / 2f + 6 - mc.fontRendererObj.getStringWidth(name) / 2f;
			float y = (height / 4) * 3;
			
			boolean hovered = mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT;
			
			this.drawCenteredString(mc.fontRendererObj, name, (int) (width/buttons3.length * count3 + (width/buttons3.length) / 2f + 3), (height / 4) * 3, hovered ? new Color(255, 180, 0, 255).getRGB() : -1);
			count3++;
		}
		
		
		//RoundedUtils.drawRoundedGradientRectCorner(80, 90, this.width - 80, this.height - 120, 0, new Color(0, 0, 0, 120).getRGB(), new Color(0, 0, 0, 30).getRGB(), new Color(0, 0, 0, 30).getRGB(), new Color(0, 0, 0, 120).getRGB());
		//RoundedUtils.drawSelectRoundedRect(80, 90, this.width - 80, this.height - 80, 0, 40, 40, 0, new Color(0, 0, 0, 80).getRGB());
		//RoundedUtils.drawSelectRoundedRect(80, 50, this.width - 80, 90, 40, 0, 0, 40, new Color(0, 0, 0, 120).getRGB());
		//RoundedUtils.drawSelectRoundedRect(80, this.height - 120, this.width - 80, this.height - 100, 0, 40, 40, 0, new Color(0, 0, 0, 30).getRGB());
		//Gui.drawCenteredString(fontRendererObj, "Mod Menu", sr.getScaledWidth() / 2, 70, new Color(255, 180, 0, 255).getRGB());
		//GlStateManager.popMatrix();
		/*
		for (ModButton m : modButtons) {
			m.draw();
		}
		*/
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		String[] buttons1 = {"Keystrokes", "ArmorStatus", "CPS Display", "FPS Display"};
		
		int count1 = 0;
		for(String name : buttons1) {
			
			float x = width/buttons1.length * count1 + (width/buttons1.length) / 2f + 6 - mc.fontRendererObj.getStringWidth(name) / 2f;
			float y = height / 4;
			
			if(mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT) {
				switch(name) {
				case "Keystrokes":
					Client.getInstance().m.getModKeystrokes().isToggled = !Client.getInstance().m.getModKeystrokes().isToggled;
					if(Client.getInstance().m.getModKeystrokes().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lKeystrokes §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lKeystrokes §9is now: §f[§c§lOff§f]"));
					}
					break;
				case "ArmorStatus":
					Client.getInstance().m.getModArmorStatus().isToggled = !Client.getInstance().m.getModArmorStatus().isToggled;
					if(Client.getInstance().m.getModArmorStatus().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lArmorStatus §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lArmorStatus §9is now: §f[§c§lOff§f]"));
					}
					break;
				case "CPS Display":
					Client.getInstance().m.getModCPS().isToggled = !Client.getInstance().m.getModCPS().isToggled;
					if(Client.getInstance().m.getModCPS().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lCPS Display §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lCPS Display §9is now: §f[§c§lOff§f]"));
					}
					break;
				case "FPS Display":
					Client.getInstance().m.getModFPS().isToggled = !Client.getInstance().m.getModFPS().isToggled;
					if(Client.getInstance().m.getModFPS().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lFPS Display §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lFPS Display §9is now: §f[§c§lOff§f]"));
					}
					break;
				}
			}
			
			count1++;
		}
		
		String[] buttons2 = {"Animations", "Nametags", "Potion Status", "Coordinates"};
		
		int count2 = 0;
		for(String name : buttons2) {
			
			float x = width/buttons2.length * count2 + (width/buttons2.length) / 2f + 6 - mc.fontRendererObj.getStringWidth(name) / 2f;
			float y = (height / 4) * 2;
			
			if(mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT) {
				switch(name) {
				case "Animations":
					Client.getInstance().m.getModSlowSwing().isToggled = !Client.getInstance().m.getModSlowSwing().isToggled;
					if(Client.getInstance().m.getModSlowSwing().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lAnimations §9are now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lAnimations §9are now: §f[§c§lOff§f]"));
					}
					break;
				case "Nametags":
					Client.getInstance().m.getModNameTag().isToggled = !Client.getInstance().m.getModNameTag().isToggled;
					if(Client.getInstance().m.getModNameTag().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lNametags §9are now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lNametags §9are now: §f[§c§lOff§f]"));
					}
					break;
				case "Potion Status":
					Client.getInstance().m.getModPotionStatus().isToggled = !Client.getInstance().m.getModPotionStatus().isToggled;
					if(Client.getInstance().m.getModPotionStatus().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lPotion Status §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lPotion Status §9is now: §f[§c§lOff§f]"));
					}
					break;
				case "Coordinates":
					Client.getInstance().m.getModXYZ().isToggled = !Client.getInstance().m.getModXYZ().isToggled;
					if(Client.getInstance().m.getModXYZ().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lCoordinates §9are now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lCoordinates §9are now: §f[§c§lOff§f]"));
					}
					break;
				}
			}
			
			count2++;
		}
		
		String[] buttons3 = {"Hurt Camera", "AntiCheat", "Watermark", "Truesight"};
		
		int count3 = 0;
		for(String name : buttons3) {
			
			float x = width/buttons3.length * count3 + (width/buttons3.length) / 2f + 6 - mc.fontRendererObj.getStringWidth(name) / 2f;
			float y = (height / 4) * 3;
			
			if(mouseX >= x && mouseY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouseY < y + mc.fontRendererObj.FONT_HEIGHT) {
				switch(name) {
				case "Hurt Camera":
					Client.getInstance().m.getModHurtCam().isToggled = !Client.getInstance().m.getModHurtCam().isToggled;
					if(Client.getInstance().m.getModHurtCam().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lHurt Camera §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lHurt Camera §9is now: §f[§c§lOff§f]"));
					}
					break;
				case "AntiCheat":
					Client.getInstance().m.getModAntiCheat().isToggled = !Client.getInstance().m.getModAntiCheat().isToggled;
					if(Client.getInstance().m.getModAntiCheat().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lAntiCheat §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lAntiCheat §9is now: §f[§c§lOff§f]"));
					}
					break;
				case "Watermark":
					Client.getInstance().m.getModMMC().isToggled = !Client.getInstance().m.getModMMC().isToggled;
					if(Client.getInstance().m.getModMMC().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lWatermark §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lWatermark §9is now: §f[§c§lOff§f]"));
					}
					break;
				case "Truesight":
					Client.getInstance().m.getModTrueSight().isToggled = !Client.getInstance().m.getModTrueSight().isToggled;
					if(Client.getInstance().m.getModTrueSight().isEnabled()) {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lTruesight §9is now: §f[§6§lOn§f]"));
					} else {
						mc.thePlayer.addChatMessage(new ChatComponentText("§6§lTruesight §9is now: §f[§c§lOff§f]"));
					}
					break;
				}
			}
			
			count3++;
		}
		/*
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
		*/
	}

}

package mmc.gui.clickgui.comp;

import java.awt.Color;

import mmc.Client;
import mmc.mods.Mod;
import mmc.mods.ModInstances;
import mmc.util.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class ModButton {
	
	public int x, y, w, h;
	public Mod m;
	
	public ModButton(int x, int y, int w, int h, Mod m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
	}
	
	public void draw() {
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		//Gui.drawRect(sr.getScaledWidth() - sr.getScaledWidth() * 410 / 640, y - 5, x + w + 49, y + h + 5, new Color(255, 255, 255, 205).getRGB());
		//RoundedUtils.drawSmoothRoundedRect(x, y - 5, x + w + 49, y + h + 5, 8, new Color(0, 0, 0, 120).getRGB());
		RoundedUtils.drawRoundedRect(x, y - 5, x + w + 49, y + h + 5, 20, new Color(0, 0, 0, 120).getRGB());
		
		Gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, m.getClass().getSimpleName().replaceFirst("Mod", ""), x + 65, y + 3, getColor());
		//Minecraft.getMinecraft().fontRendererObj.drawString(m.getClass().getSimpleName().replaceFirst("Mod", ""), x + 3, y + 3, getColor());
	}
	
	private int getColor() {
		if(m.isToggled) {
			return new Color(255, 180, 0, 255).getRGB();
		} else {
			return new Color(255, 0, 20, 255).getRGB();
		}
	}
	
	public void onClick(int mouseX, int mouseY, int button) {
		if(mouseX >= x && mouseX <= x + w + 49 && mouseY >= y - 5 && mouseY <= y + h + 5) {
			if(m.isEnabled()) {
				m.isToggled = false;
				System.out.println("Legit");
			} else {
				m.isToggled = true;
				System.out.println("Hax");
			}
		}
	}

}

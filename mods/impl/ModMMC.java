package mmc.mods.impl;

import java.awt.Color;

import mmc.gui.hud.ScreenPosition;
import mmc.mods.ModDraggable;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class ModMMC extends ModDraggable {
	
	@Override
	public int getWidth() {
		return font.getStringWidth("MineMenClient v1.7 [Toggled]");
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		Gui.drawRect(pos.getAbsoluteX() - 5, pos.getAbsoluteY() - 5, pos.getAbsoluteX() + font.getStringWidth("MineMenClient v1.7 [Toggled]") + 5, pos.getAbsoluteY() + 15, new Color(0, 0, 0, 150).getRGB());
		font.drawString("MineMenClient v1.7 [Toggled]", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 2, new Color(150, 70, 30, 255).getRGB());
		font.drawString("MineMenClient v1.7 [Toggled]", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, new Color(255, 180, 0, 255).getRGB());
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		font.drawString("MineMenClient v1.7 [Toggled]", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 2, new Color(150, 70, 30, 255).getRGB());
		font.drawString("MineMenClient v1.7 [Toggled]", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, new Color(255, 180, 0, 255).getRGB());
	}

}

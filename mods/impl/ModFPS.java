package mmc.mods.impl;

import java.awt.Color;

import mmc.gui.hud.ScreenPosition;
import mmc.mods.ModDraggable;
import mmc.mods.ModInstances;
import net.minecraft.client.gui.Gui;

public class ModFPS extends ModDraggable {

	@Override
	public int getWidth() {
		return 54;
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT - 2;
	}

	@Override
	public void render(ScreenPosition pos) {
		Gui.drawRect(pos.getAbsoluteX() - 5, pos.getAbsoluteY() - 5, pos.getAbsoluteX() + font.getStringWidth("[FPS: " + mc.getDebugFPS() +"]") + 4, pos.getAbsoluteY() + 12, new Color(0, 0, 0, 150).getRGB());
		font.drawString("[FPS: " + mc.getDebugFPS() + "]", pos.getAbsoluteX(), pos.getAbsoluteY() + 1, new Color(150, 70, 30, 255).getRGB());
		font.drawString("[FPS: " + mc.getDebugFPS() + "]", pos.getAbsoluteX(), pos.getAbsoluteY(), new Color(255, 180, 0, 255).getRGB());
	}
	
}

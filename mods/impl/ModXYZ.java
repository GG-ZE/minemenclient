package mmc.mods.impl;

import java.awt.Color;

import mmc.gui.hud.ScreenPosition;
import mmc.mods.ModDraggable;
import net.minecraft.client.gui.Gui;

public class ModXYZ extends ModDraggable {
	
	@Override
	public int getWidth() {
		return font.getStringWidth(getXYZString());
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		Gui.drawRect(pos.getAbsoluteX() - 5, pos.getAbsoluteY() - 5, pos.getAbsoluteX() + font.getStringWidth(getXYZString()) + 4, pos.getAbsoluteY() + 12, new Color(0, 0, 0, 150).getRGB());
		font.drawString(getXYZString(), pos.getAbsoluteX(), pos.getAbsoluteY() + 1, new Color(150, 70, 30, 255).getRGB());
		font.drawString(getXYZString(), pos.getAbsoluteX(), pos.getAbsoluteY(), new Color(255, 180, 0, 255).getRGB());
	}

	private String getXYZString() {
		return String.format("XYZ: [%.1f | %.1f | %.1f]", 
			mc.getRenderViewEntity().posX, 
			mc.getRenderViewEntity().getEntityBoundingBox().minY, 
			mc.getRenderViewEntity().posZ);
	}

}

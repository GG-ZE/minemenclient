package mmc.mods.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import mmc.gui.hud.ScreenPosition;
import mmc.mods.ModDraggable;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class ModCPS extends ModDraggable {

	public List<Long> clicks = new ArrayList<Long>();
	public long lastPressed;
	public boolean wasPressed;
	
	@Override
	public int getWidth() {
		return font.getStringWidth("CPS: 00");
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		final boolean pressed = Mouse.isButtonDown(0);
		if(pressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis();
			this.wasPressed = pressed;
			if(pressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		Gui.drawRect(pos.getAbsoluteX() - 5, pos.getAbsoluteY() - 5, pos.getAbsoluteX() + font.getStringWidth("CPS: " + getCPS()) + 4, pos.getAbsoluteY() + 12, new Color(0, 0, 0, 150).getRGB());
		font.drawString("CPS: " + getCPS(), pos.getAbsoluteX(), pos.getAbsoluteY() + 1, new Color(150, 70, 30, 255).getRGB());
		font.drawString("CPS: " + getCPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), new Color(255, 180, 0, 255).getRGB());
	}
	
	private int getCPS() {
		final long time = System.currentTimeMillis();
		this.clicks.removeIf(aLong -> aLong + 1000 < time);
		return this.clicks.size();
	}

}

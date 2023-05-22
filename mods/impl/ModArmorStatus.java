package mmc.mods.impl;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import mmc.gui.hud.ScreenPosition;
import mmc.mods.ModDraggable;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModArmorStatus extends ModDraggable {
	
	@Override
	public int getWidth() {
		return 64;
	}

	@Override
	public int getHeight() {
		return 64;
	}

	@Override
	public void render(ScreenPosition pos) {
		if(mc.thePlayer.inventory.armorItemInSlot(0) == null && mc.thePlayer.inventory.armorItemInSlot(1) == null && mc.thePlayer.inventory.armorItemInSlot(2) == null && mc.thePlayer.inventory.armorItemInSlot(3) == null) {
			Gui.drawRect(pos.getAbsoluteX() - 5, pos.getAbsoluteY() - 5, pos.getAbsoluteX() + font.getStringWidth(String.format("%.2f%%", 100.00)) + 32, pos.getAbsoluteY() + 69, new Color(0, 0, 0, 0).getRGB());
		} else {
			Gui.drawRect(pos.getAbsoluteX() - 5, pos.getAbsoluteY() - 5, pos.getAbsoluteX() + font.getStringWidth(String.format("%.2f%%", 100.00)) + 32, pos.getAbsoluteY() + 69, new Color(0, 0, 0, 150).getRGB());
		}
		for(int i = 0; i < mc.thePlayer.inventory.armorInventory.length; i++) {
			ItemStack itemStack = mc.thePlayer.inventory.armorInventory[i];
			renderItemStack(pos, i, itemStack);
		}
		
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		renderItemStack(pos, 3, new ItemStack(Items.golden_helmet));
		renderItemStack(pos, 2, new ItemStack(Items.golden_chestplate));
		renderItemStack(pos, 1, new ItemStack(Items.golden_leggings));
		renderItemStack(pos, 0, new ItemStack(Items.golden_boots));
	}

	private void renderItemStack(ScreenPosition pos, int i, ItemStack is) {
		
		if(is == null) {
			return;
		}
		
		GL11.glPushMatrix();
		int yAdd = (-16 * i) + 48;
		
		if(is.getItem().isDamageable()) {
			double damage = ((is.getMaxDamage() - is.getItemDamage()) / (double) is.getMaxDamage()) * 100;
			font.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 24, pos.getAbsoluteY() + yAdd + 5, new Color(150, 70, 30, 255).getRGB());
			font.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 24, pos.getAbsoluteY() + yAdd + 4, new Color(255, 180, 0, 255).getRGB());
		}
		
		RenderHelper.enableGUIStandardItemLighting();
		mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX() + 3, pos.getAbsoluteY() + yAdd);
		
		GL11.glPopMatrix();
		
	}
	
}

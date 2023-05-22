package mmc.mods.impl;

import java.awt.Color;
import java.util.Collection;

import mmc.gui.hud.ScreenPosition;
import mmc.mods.ModDraggable;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ModPotionStatus extends ModDraggable {

	protected FontRenderer fontRendererObj;
	
	@Override
	public int getWidth() {
		return font.getStringWidth("Potion Effects");
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}
	
	@Override
	public void render(ScreenPosition pos) {
		int i = 0;
        int i2 = 5;
        Collection<PotionEffect> collection = this.mc.thePlayer.getActivePotionEffects();

        if (!collection.isEmpty())
        {
            GlStateManager.color(1.0F, 0.8F, 0.25F, 1.0F);
            GlStateManager.disableLighting();
            int l = 20;

            if (collection.size() > 5)
            {
                l = 132 / (collection.size() - 1);
            }

            for (PotionEffect potioneffect : this.mc.thePlayer.getActivePotionEffects())
            {
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                String s1 = I18n.format(potion.getName(), new Object[0]);
                if (potioneffect.getAmplifier() == 1)
                {
                    s1 = s1 + " " + I18n.format("enchantment.level.2", new Object[0]);
                }
                else if (potioneffect.getAmplifier() == 2)
                {
                    s1 = s1 + " " + I18n.format("enchantment.level.3", new Object[0]);
                }
                else if (potioneffect.getAmplifier() == 3)
                {
                    s1 = s1 + " " + I18n.format("enchantment.level.4", new Object[0]);
                }
                font.drawString(s1, pos.getAbsoluteX() + 5, pos.getAbsoluteY() + i2 + 1, new Color(150, 70, 30, 255).getRGB(), false);
                font.drawString(s1, pos.getAbsoluteX() + 5, pos.getAbsoluteY() + i2, new Color(255, 180, 0, 255).getRGB(), false);
                String s = Potion.getDurationString(potioneffect);
                font.drawString(s, pos.getAbsoluteX() + 5, pos.getAbsoluteY() + i2 + 11, new Color(150, 70, 30, 255).getRGB(), false);
                font.drawString(s, pos.getAbsoluteX() + 5, pos.getAbsoluteY() + i2 + 10, new Color(255, 180, 0, 255).getRGB(), false);
                i2 += l;
            }
        }
	}
	
	public void renderDummy(ScreenPosition pos) {
		font.drawString("Potion Effects", pos.getAbsoluteX(), pos.getAbsoluteY() + 1, new Color(150, 70, 30, 255).getRGB());
		font.drawString("Potion Effects", pos.getAbsoluteX(), pos.getAbsoluteY(), new Color(255, 180, 0, 255).getRGB());
	}
	
}
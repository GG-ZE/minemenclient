package mmc.modules.player;

import java.util.List;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import mmc.util.TimerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemFireball;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemSnowball;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;

public class FastPlace extends Module {
	
	public TimerUtil timer = new TimerUtil();
	
	public FastPlace() {
		super("FastPlace", Keyboard.KEY_NONE, Category.PLAYER);
	}
	
	public void onEnable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §a§lEnabled"));
	}
	
	public void onDisable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §c§lDisabled"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventUpdate && e.isPre()) {	
			
        	if(mc.thePlayer != null) {
				if(mc.thePlayer.getHeldItem() != null) {
					if(mc.thePlayer.getHeldItem().getItem() != null) {
						if(
								!(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemBlock) ||
								(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemEnderPearl) || 
								(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemBucket) || 
								(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemFishingRod) ||
								(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemSnowball) ||
								(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemFireball) ||
								(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemEgg) ||
								(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemFlintAndSteel) ||
								(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemSkull)
						   ) {
							mc.rightClickDelayTimer = 4;
						} else {
							if(mc.gameSettings.keyBindUseItem.isKeyDown() == true) {
								mc.gameSettings.keyBindUseItem.pressed = true;
							}
							mc.rightClickDelayTimer = 1;
						}
					}
				}
        	}
		}
	}
}

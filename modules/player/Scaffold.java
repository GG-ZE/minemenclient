package mmc.modules.player;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

public class Scaffold extends Module {
	
	public Scaffold() {
		super("Scaffold", Keyboard.KEY_NONE, Category.PLAYER);
	}
	
	public void onEnable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §a§lEnabled"));
	}
	
	public void onDisable() {
		if(mc.thePlayer == null) {
			return;
		}
		
		if (!GameSettings.isKeyDown(mc.gameSettings.keyBindSneak)) {
			Minecraft.getMinecraft().gameSettings.keyBindSneak.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), false);
        }
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §c§lDisabled"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventUpdate && e.isPre()) {
			if(mc.thePlayer != null && mc.inGameHasFocus) {
			if(mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() == Blocks.air) {
					Minecraft.getMinecraft().gameSettings.keyBindSneak.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), true);
				} else {
					Minecraft.getMinecraft().gameSettings.keyBindSneak.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), false);
				}
			}
		}
	}
}

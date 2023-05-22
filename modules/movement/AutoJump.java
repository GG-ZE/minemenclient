package mmc.modules.movement;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class AutoJump extends Module {

	boolean inAir = false;
	
	public AutoJump() {
		super("AutoJump", Keyboard.KEY_NONE, Category.MOVEMENT);
	}
	
	public void onEnable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §a§lEnabled"));
	}
	
	public void onDisable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §c§lDisabled"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventUpdate && e.isPre()) {
			if(inAir == false) {
				if(mc.thePlayer.hurtTime == 9 && mc.thePlayer.isSwingInProgress && mc.gameSettings.keyBindForward.isKeyDown() && mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() != Blocks.air) {
					mc.thePlayer.addChatMessage(new ChatComponentText("§6§lJump Reset Success"));
					mc.thePlayer.jump();
					inAir = true;
				}
			}
			if(mc.thePlayer.onGround) {
				inAir = false;
			}
		}
	}
}
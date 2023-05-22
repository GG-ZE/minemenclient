package mmc.modules.movement;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class Velocity extends Module {

	public Velocity() {
		super("Velocity", Keyboard.KEY_NONE, Category.MOVEMENT);
	}
	
	public void onEnable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §a§lEnabled"));
	}
	
	public void onDisable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §c§lDisabled"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventUpdate && e.isPre()) {
			
		}
	}
}
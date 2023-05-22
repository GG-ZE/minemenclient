package mmc.modules.render;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import mmc.modules.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class Motionblur extends Module {
	
	public Motionblur() {
		super("Motion Blur", Keyboard.KEY_NONE, Category.RENDER);
	}
	
	public void onEnable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §a§lForever Enabled"));
	}
	
	public void onDisable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §c§lError: Can't be disabled"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventUpdate && e.isPre()) {
		}
	}

}

package mmc.modules.render;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import mmc.modules.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class FullBright extends Module {
	
	public FullBright() {
		super("FullBright", Keyboard.KEY_N, Category.RENDER);
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 1000F;
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §a§lEnabled"));
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 0F;
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §c§lDisabled"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventUpdate && e.isPre()) {
			
		}
	}

}

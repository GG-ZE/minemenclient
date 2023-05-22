package mmc.modules.render;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import mmc.modules.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class RefreshChunk extends Module {
	
	public RefreshChunk() {
		super("Invisible Chunks", Keyboard.KEY_Z, Category.RENDER);
	}
	
	public void onEnable() {
		mc.renderGlobal.loadRenderers();
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + "- §a§lRefreshed"));
	}
	
	public void onDisable() {
		mc.renderGlobal.loadRenderers();
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + "- §a§lRefreshed"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventUpdate && e.isPre()) {
			
		}
	}

}

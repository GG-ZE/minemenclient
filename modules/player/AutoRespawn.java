package mmc.modules.player;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemFireball;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.util.ChatComponentText;

public class AutoRespawn extends Module {
	
	public AutoRespawn() {
		super("AutoRespawn", Keyboard.KEY_NONE, Category.PLAYER);
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

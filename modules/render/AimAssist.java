package mmc.modules.render;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventMotion;
import mmc.modules.Module;
import mmc.util.TimerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.WorldSettings.GameType;

public class AimAssist extends Module {
	
	EntityLivingBase target;
	
	public TimerUtil timer = new TimerUtil();
	
	public long randomizer;
	public int cps;

	public AimAssist() {
		super("Aura", Keyboard.KEY_H, Category.PLAYER);
	}
	
	public void onEnable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§c[CC]§f: " + name + " (Keybind: R) "+ " Enabled"));
	}
	
	public void onDisable() {
		mc.thePlayer.addChatMessage(new ChatComponentText("§c[CC]§f: " + name + " (Keybind: R) "+ " Disabled"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventMotion) {
			if(e.isPre()) {
				BlockPos pos = new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1, mc.thePlayer.posZ);
				mc.thePlayer.onGround = true;
				mc.theWorld.setBlockToRock(pos);
			}
		}
	}
}

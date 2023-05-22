package mmc.mods;

import mmc.gui.hud.HUDManager;
import mmc.mods.impl.ModAntiCheat;
import mmc.mods.impl.ModArmorStatus;
import mmc.mods.impl.ModCPS;
import mmc.mods.impl.ModFPS;
import mmc.mods.impl.ModHurtCam;
import mmc.mods.impl.ModKeystrokes;
import mmc.mods.impl.ModMMC;
import mmc.mods.impl.ModNameTag;
import mmc.mods.impl.ModPotionStatus;
import mmc.mods.impl.ModSlowSwing;
import mmc.mods.impl.ModTNTCountdown;
import mmc.mods.impl.ModTrueSight;
import mmc.mods.impl.ModXYZ;

public class ModInstances {

	private static ModMMC modMMC;
	private static ModArmorStatus modArmorStatus;
	private static ModFPS modFPS;
	private static ModPotionStatus modPotionStatus;
	private static ModXYZ modXYZ;
	private static ModKeystrokes modKeystrokes;
	private static ModTNTCountdown modTNTCountdown;
	private static ModCPS modCPS;
	private static ModPerspective modPerspective;
	private static ModHurtCam modHurtCam;
	private static ModSlowSwing modSlowSwing;
	private static ModNameTag modNameTag;
	private static ModAntiCheat modAntiCheat;
	private static ModTrueSight modTrueSight;
	
	public static void register(HUDManager api) {
		modMMC = new ModMMC();
		api.register(modMMC);
		
		modTrueSight = new ModTrueSight();
		api.register(modTrueSight);
		
		modAntiCheat = new ModAntiCheat();
		api.register(modAntiCheat);
		
		modArmorStatus = new ModArmorStatus();
		api.register(modArmorStatus);
		
		modFPS = new ModFPS();
		api.register(modFPS);
		
		modPotionStatus = new ModPotionStatus();
		api.register(modPotionStatus);
		
		modXYZ = new ModXYZ();
		api.register(modXYZ);
		
		modKeystrokes = new ModKeystrokes();
		api.register(modKeystrokes);
		
		modTNTCountdown = new ModTNTCountdown();
		api.register(modTNTCountdown);
		
		modCPS = new ModCPS();
		api.register(modCPS);
		
		modPerspective = new ModPerspective();
		api.register(modPerspective);
		
		modHurtCam = new ModHurtCam();
		api.register(modHurtCam);
		
		modSlowSwing = new ModSlowSwing();
		api.register(modSlowSwing);
		
		modNameTag = new ModNameTag();
		api.register(modNameTag);
	}
	
	public static ModMMC getModMMC() {
		return modMMC;
	}
	
	public static ModTrueSight getModTrueSight() {
		return modTrueSight;
	}
	
	public static ModAntiCheat getModAntiCheat() {
		return modAntiCheat;
	}
	
	public static ModArmorStatus getModArmorStatus() {
		return modArmorStatus;
	}
	
	public static ModFPS getModFPS() {
		return modFPS;
	}
	
	public static ModPotionStatus getModPotionStatus() {
		return modPotionStatus;
	}
	
	public static ModXYZ getModXYZ() {
		return modXYZ;
	}
	
	public static ModKeystrokes getModKeystrokes() {
		return modKeystrokes;
	}
	
	public static ModTNTCountdown getModTNTCountdown() {
		return modTNTCountdown;
	}
	
	public static ModCPS getModCPS() {
		return modCPS;
	}
	
	public static ModPerspective getModPerspective() {
		return modPerspective;
	}
	
	public static ModHurtCam getModHurtCam() {
		return modHurtCam;
	}
	
	public static ModSlowSwing getModSlowSwing() {
		return modSlowSwing;
	}
	
	public static ModNameTag getModNameTag() {
		return modNameTag;
	}
	
}

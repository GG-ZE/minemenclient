package mmc;

import java.text.DecimalFormat;
import java.util.concurrent.CopyOnWriteArrayList;

import mmc.cosmetic.impl.CosmeticYYCape;
import mmc.event.EventManager;
import mmc.event.EventTarget;
import mmc.event.impl.ClientTickEvent;
import mmc.events.Events;
import mmc.gui.SplashProgress;
import mmc.gui.clickgui.ClickGUI;
import mmc.gui.hud.HUDManager;
import mmc.mods.Mod;
import mmc.mods.ModInstances;
import mmc.modules.Module;
import mmc.modules.movement.AutoWalk;
import mmc.modules.movement.BunnyHop;
import mmc.modules.movement.Parkour;
import mmc.modules.movement.PartyBot;
import mmc.modules.movement.Velocity;
import mmc.modules.player.AutoRespawn;
import mmc.modules.player.FastPlace;
import mmc.modules.player.Scaffold;
import mmc.modules.render.FullBright;
import mmc.modules.render.Motionblur;
import mmc.modules.render.RefreshChunk;
import mmc.util.MotionBlur;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class Client {
	
	private static final Client INSTANCE = new Client();
	public static final Client getInstance() {
		return INSTANCE;
	}
	
	private DiscordRP discordRP = new DiscordRP();
	
	public Mod mod = new Mod();
	
	public ModInstances m = new ModInstances();
	
	private HUDManager hudManager;
	
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	
	public void init() {
		
		FileManager.init();
		SplashProgress.setProgress(1, "MMC - Initializing MineMenClient...");
		discordRP.start();
		
		EventManager.register(this);
		
		//MOVEMENT
		
		//REAL
		modules.add(new PartyBot());
		
		//FAKE
		//modules.add(new Velocity());
		//modules.add(new AutoJump());
		//modules.add(new AutoWalk());
		//modules.add(new BunnyHop());
		//modules.add(new Parkour());
		
		//RENDER
		//REAL
		modules.add(new Motionblur());
		modules.add(new FullBright());
		modules.add(new RefreshChunk());
		//modules.add(new AimAssist());
		
		//PLAYER
		//REAL
		//modules.add(new FastPlace());
		//modules.add(new Scaffold());
		//modules.add(new AutoRespawn());
		
		//HUD
		
	}
	
	public void start() {
		hudManager = HUDManager.getInstance();
		ModInstances.register(hudManager);
		
		Client.getInstance().m.getModHurtCam().isToggled = false;
		Client.getInstance().m.getModTrueSight().isToggled = false;
		Client.getInstance().m.getModSlowSwing().isToggled = false;
		Client.getInstance().m.getModAntiCheat().isToggled = false;
	}
	
	public void shutdown() {
		discordRP.shutdown();
	}

	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	@EventTarget
	public void onTick(ClientTickEvent e) {
		
		CosmeticYYCape.CAPEANIMATED.update();
		
		Minecraft mc = Minecraft.getMinecraft();
		
		if(mc.gameSettings.PARTY_BOT.isPressed()) {
			mc.thePlayer.sendChatMessage("gg");
			//BlockPos blockpos = mc.objectMouseOver.getBlockPos();
			//Block pointingBlock = mc.theWorld.getBlockState(blockpos).getBlock();
			//mc.theWorld.setBlockToAir(blockpos);
		}
		
		if(Client.getInstance().m.getModAntiCheat().isEnabled()) {
			if(mc.thePlayer != null) {
				if(mc.thePlayer.getLastAttacker() != null) {
					if(mc.thePlayer.hurtTime == 9 && mc.thePlayer.getLastAttacker().isSwingInProgress != false) {
						if(mc.thePlayer.getLastAttacker().getHeldItem() != null) {
							if(!(mc.thePlayer.getLastAttacker().getHeldItem().getItem() instanceof ItemBow || mc.thePlayer.getLastAttacker().getHeldItem().getItem() instanceof ItemFishingRod)) {
								double reachDist = 0;
								reachDist = Math.abs(mc.thePlayer.getDistanceToEntity(mc.thePlayer.getLastAttacker()) - 0.5657f);
								DecimalFormat df = new DecimalFormat("#.##");
								if(reachDist > 3 && reachDist < 6) {
									mc.thePlayer.addChatMessage(new ChatComponentText("§6" + mc.thePlayer.getLastAttacker().getName() + " hit you from: §d§l" + df.format(reachDist) + " §6blocks away."));
								}
								if(reachDist > 4 && reachDist < 6) {
									mc.thePlayer.addChatMessage(new ChatComponentText("§d§l@" + mc.thePlayer.getLastAttacker().getName() + " §c§lreach?"));
								}
							}
						}
					}
				}
				for(Entity player : mc.theWorld.loadedEntityList) {
					if(player instanceof EntityLivingBase) {
						EntityLivingBase entity = (EntityLivingBase)player;
						if(entity.ticksExisted > 20) {
							if(player.isEntityInsideOpaqueBlock()) {
								mc.thePlayer.addChatMessage(new ChatComponentText("§d§l@" + entity.getName() + " §c§lphase?"));
							}
						}
						if(Math.abs(entity.rotationPitch) > 90) {
							mc.thePlayer.addChatMessage(new ChatComponentText("§d§l@" + entity.getName() + " §c§lHACKER - ILLEGAL ROTATION"));
						}
						if(entity.hurtTime == 4) {
							if(entity.posY == entity.lastTickPosY) {
								mc.thePlayer.addChatMessage(new ChatComponentText("§d§l@" + entity.getName() + " §c§lHACKER - VELOCITY"));
							}
						}
					}
				}
			}
		}
		
		if(Minecraft.getMinecraft().inGameHasFocus && !mc.gameSettings.ofFastRender) {
			Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
			MotionBlur.getShader();
		} else if(Minecraft.getMinecraft().currentScreen != null && !mc.gameSettings.ofFastRender) {
			if(Minecraft.getMinecraft().currentScreen instanceof GuiChat) {
				Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
				MotionBlur.getShader();
			} else {
				if(!mc.gameSettings.ofFastRender) {
					Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
			    	Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
				}
			}
		}
		
		Minecraft.getMinecraft().gameSettings.keyBindSprint.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), true);
		
		if(Minecraft.getMinecraft().gameSettings.HUD_CONFIG.isPressed()) {
			hudManager.openConfigScreen();
		}
		
		if(Minecraft.getMinecraft().gameSettings.CLICK_GUI.isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
		}
		
	}
	
	public static void keyPress(int key) {
		for(Module m : modules) {
			if(m.getKey() == key) {
				m.toggle();
			}
		}
	}
	
	public static void onEvent(Events e) {
		for(Module m : modules) {
			if(!m.toggled)
				continue;
			
			m.onEvent(e);
		}
	}

}

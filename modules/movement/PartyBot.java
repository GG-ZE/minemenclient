package mmc.modules.movement;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.lwjgl.input.Keyboard;

import mmc.events.Events;
import mmc.events.listeners.EventUpdate;
import mmc.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class PartyBot extends Module {
	
	boolean started;
	double randomMode = 0.5;

	public PartyBot() {
		super("PartyBot", Keyboard.KEY_BACKSLASH, Category.MOVEMENT);
	}
	
	public void onEnable() {
		started = false;
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §a§lEnabled"));
	}
	
	public void onDisable() {
		started = true;
		mc.thePlayer.addChatMessage(new ChatComponentText("§f[§6§lMMC§f]: " + "§7§l" + name + " §c§lDisabled"));
	}
	
	public void onEvent(Events e) {
		if(e instanceof EventUpdate && e.isPre()) {
			if(mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() == Blocks.emerald_block && started == false) {
				started = true;
				Runnable partybot = new Runnable() {
				    public void run() {
				    	try {
							Thread.sleep(1000L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	randomMode = Math.random();
				        Minecraft.getMinecraft().thePlayer.sendChatMessage("./p join " + mc.thePlayer.getName() + " for party fights, starting in 15s!");
				        try {
							Thread.sleep(5000L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Starting in 10s...");
	    	        	if(!(mc.currentScreen instanceof GuiContainer)) {
	    	        		Minecraft.getMinecraft().gameSettings.keyBindBack.pressed = true;
	    	        	}
				        try {
							Thread.sleep(1000L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    	        	if(!(mc.currentScreen instanceof GuiContainer)) {
	    	        		Minecraft.getMinecraft().gameSettings.keyBindBack.pressed = false;
	    	        	}
				        try {
							Thread.sleep(4000L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Starting in 5s...");
				        try {
							Thread.sleep(500L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        mc.thePlayer.inventory.currentItem = 4;
				        try {
							Thread.sleep(125L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        mc.gameSettings.keyBindAttack.pressed = true;
				        try {
							Thread.sleep(125L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        mc.gameSettings.keyBindAttack.pressed = false;
				        try {
							Thread.sleep(350L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    	        if(!(mc.currentScreen instanceof GuiContainer)) {
					        mc.gameSettings.keyBindUseItem.pressed = true;
		    	        }
				        try {
							Thread.sleep(50L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    mc.gameSettings.keyBindUseItem.pressed = false;
				        try {
							Thread.sleep(50L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        if(!(mc.currentScreen instanceof GuiContainer)) {
					        mc.gameSettings.keyBindUseItem.pressed = true;
		    	        }
				        try {
							Thread.sleep(50L);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    mc.gameSettings.keyBindUseItem.pressed = false;
				        try {
		    				Thread.sleep(1250L);
		    			} catch (InterruptedException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
				        if(randomMode <= 0.125) { //SPLEEF
					        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Mode: Spleef FFA");
				        	if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 13, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 23, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    	        	mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 10, 0, 0, mc.thePlayer);
			    	        }
				        } else if(randomMode > 0.125 && randomMode <= 0.250) { // TOPFIGHT
					        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Mode: Topfight FFA");
				        	if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 13, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 21, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    	        	mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 10, 0, 0, mc.thePlayer);
			    	        }
				        } else if(randomMode > 0.250 && randomMode <= 0.375) { // SUMO
					        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Mode: Sumo RR");
				        	if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 15, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 11, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    	        	mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 14, 0, 0, mc.thePlayer);
			    	        }
				        } else if(randomMode > 0.375 && randomMode <= 0.500) { // PARKOUR
					        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Mode: Parkour Split");
				        	if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 11, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 28, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    	        	mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 11, 0, 0, mc.thePlayer);
			    	        }
				        } else if(randomMode > 0.500 && randomMode <= 0.625) { // SKYWARS
					        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Mode: SkyWars FFA");
				        	if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 13, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 13, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    	        	mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 10, 0, 0, mc.thePlayer);
			    	        }
				        } else if(randomMode > 0.625 && randomMode <= 0.750) { // ARCHER
					        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Mode: Archer FFA");
				        	if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 13, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 28, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    	        	mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 24, 0, 0, mc.thePlayer);
			    	        }
				        } else if(randomMode > 0.750 && randomMode <= 0.875) { // SURVIVAL GAMES
					        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Mode: SG FFA");
				        	if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 13, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 30, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    	        	mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 15, 0, 0, mc.thePlayer);
			    	        }
				        } else if(randomMode > 0.875) { // STICKFIGHT
					        Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc Mode: St1ick-fight Split");
				        	if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 11, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    		        mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 29, 0, 0, mc.thePlayer);
			    	        }
			    	        try {
			    				Thread.sleep(1250L);
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    	        if(mc.currentScreen instanceof GuiContainer) {
			    	        	mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 10, 0, 0, mc.thePlayer);
			    	        }
				        }
				        try {
		    				Thread.sleep(1000L);
		    			} catch (InterruptedException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    	        if(mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() != Blocks.emerald_block) {
		    	        	started = false;
		    	        	if(!(mc.currentScreen instanceof GuiContainer)) {
		    	        		mc.gameSettings.keyBindForward.pressed = true;
		    	        		try {
				    				Thread.sleep(788L);
				    			} catch (InterruptedException e) {
				    				// TODO Auto-generated catch block
				    				e.printStackTrace();
				    			}
		    	        		mc.gameSettings.keyBindForward.pressed = false;
		    	        		/*
		    	        		if(mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() == Blocks.emerald_block || mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() == Blocks.snow || mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() == Blocks.water || mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() == Blocks.flowing_water || mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() == Blocks.gold_block || mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)).getBlock() == Blocks.air) {
		    	        			mc.gameSettings.keyBindForward.pressed = false;
		    	        		}
		    	        		*/
		    	        	}
		    	        }
				    }
				};
				ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
				executor.schedule(partybot, 500, TimeUnit.MILLISECONDS);
			}
		}
	}
}
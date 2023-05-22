package mmc.mods;

import mmc.Client;
import mmc.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod {
	
	protected boolean isEnabled =  true;
	public boolean isToggled = true;
	
	protected final Minecraft mc;
	protected final FontRenderer font;
	protected final Client client;
	
	public Mod() {
		this.mc = Minecraft.getMinecraft();
		this.font = this.mc.fontRendererObj;
		this.client = Client.getInstance();
		toggleable(isToggled);
	}
	
	public void toggleable(boolean isToggled) {
		this.isEnabled = !isEnabled;
		this.isEnabled = isToggled;
		
		if(isToggled) {
			EventManager.register(this);
		} else {
			EventManager.unregister(this);
		}
	}
	
	public boolean isEnabled() {
		return isToggled;
	}
	
}

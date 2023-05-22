package mmc.modules;

import org.lwjgl.input.Keyboard;

import mmc.event.Event;
import mmc.events.Events;
import net.minecraft.client.Minecraft;

public class Module {
	
	public String name;
	public boolean toggled = false;
	public int keyCode;
	public Category category;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, int key, Category c) {
		this.name = name;
		this.keyCode = key;
		this.category = c;
	}
	
	public boolean isEnabled() {
		return toggled;
	}
	
	public int getKey() {
		return keyCode;
	}
	
	public void onEvent(Events e) {
		
	}
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public enum Category {
		MOVEMENT, //{ToggleSneak}, {BunnyHop}, {AutoWalk}, {AutoJump}, {Velocity}, {Parkour}
		PLAYER, //{Fastplace}, {Scaffold}, {AutoRespawn}, {AutoSword}, {DogPet}, {AutoRod}
		RENDER, //{ESP}, {Fullbright}, {Nametags}, {Hurtcam}, {SlowSwing}, {PerspectiveMod}, {MotionBlur}, {RefreshChunk}
	}

}

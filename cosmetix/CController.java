package mmc.cosmetix;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;

public class CController {
	
	//DATABASE
	
	public static boolean shouldRenderTopHat(AbstractClientPlayer player) {
		return false;
	}
	
	public static boolean shouldRenderDragonWings(AbstractClientPlayer player) {
		return true;
	}
	
	public static boolean shouldRenderDogPet(AbstractClientPlayer player) {
		return false;
	}
	
	public static float[] getTopHatColor(AbstractClientPlayer player) {
		//RGB CHANGE COLOR 0-1
		return new float[] {1, (float) 0.7, 0};
	}

}

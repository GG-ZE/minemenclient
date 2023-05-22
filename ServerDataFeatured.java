package mmc;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class ServerDataFeatured extends ServerData {
	
	public static final ResourceLocation STAR_ICON = new ResourceLocation("minemen/star.png");

	public ServerDataFeatured(String serverName, String serverIP) {
		super(serverName, serverIP, false);
	}

}

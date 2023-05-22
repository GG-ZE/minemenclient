package mmc.cosmetix;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class CModelBase extends ModelBase {
	
	protected final ModelBiped playerModel;
	
	public CModelBase(RenderPlayer player) {
		this.playerModel = player.getMainModel();
	}

}

package mmc.cosmetix.impl;

import org.lwjgl.opengl.GL11;

import mmc.cosmetix.CBase;
import mmc.cosmetix.CController;
import mmc.cosmetix.CModelBase;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CosmeticTopHat extends CBase {
	
	private final ModelTopHat modelTopHat;
	private static final ResourceLocation TEXTURE = new ResourceLocation("minemen/tophat.png");
	
	public CosmeticTopHat(RenderPlayer renderPlayer) {
		super(renderPlayer);
		modelTopHat = new ModelTopHat(renderPlayer);
	}

	@Override
	public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks,	float ageInTicks, float headYaw, float headPitch, float scale) {
		
		if(CController.shouldRenderTopHat(player)) {
			GlStateManager.pushMatrix();
			playerRenderer.bindTexture(TEXTURE);
			
			if(player.isSneaking()) {
				GL11.glTranslated(0, 0.225D, 0);
			}
			
			float[] color = CController.getTopHatColor(player);
			GL11.glColor3d(color[0], color[1], color[2]);
			modelTopHat.render(player, limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scale);
			GL11.glColor3f(1, 1, 1);
			GL11.glPopMatrix();
		}
		
	}
	
	private class ModelTopHat extends CModelBase {
		
		private ModelRenderer rim;
		private ModelRenderer peak;

		public ModelTopHat(RenderPlayer player) {
			super(player);
			rim = new ModelRenderer(playerModel, 0, 0);
			rim.addBox(-5.5F, -9F, -5.5F, 11, 2, 11);
			peak = new ModelRenderer(playerModel, 0, 13);
			peak.addBox(-3.5F, -14F, -3.5F, 7, 8, 7);
		}
		
		@Override
		public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
			//super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scale);
			rim.rotateAngleX = playerModel.bipedHead.rotateAngleX;
			rim.rotateAngleY = playerModel.bipedHead.rotateAngleY;
			rim.rotationPointX = 0.0F;
			rim.rotationPointY = 0.0F;
			rim.render(scale);
			
			peak.rotateAngleX = playerModel.bipedHead.rotateAngleX;
			peak.rotateAngleY = playerModel.bipedHead.rotateAngleY;
			peak.rotationPointX = 0.0F;
			peak.rotationPointY = 0.0F;
			peak.render(scale);
		}
		
	}

}

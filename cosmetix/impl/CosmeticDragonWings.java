package mmc.cosmetix.impl;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import mmc.cosmetic.CosmeticModelBase;
import mmc.cosmetix.CBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CosmeticDragonWings extends CBase {


    private static ModelRenderer wing;
    private static ModelRenderer wingTip;
    boolean flying = false;

    public static ModelDragonWings modelDragonWings;


    public CosmeticDragonWings(RenderPlayer renderPlayer) {
	    super(renderPlayer);
	
	        this.modelDragonWings = new ModelDragonWings(renderPlayer);
	
	        modelDragonWings.setTextureOffset("wingTip.bone", 112, 136);
	        modelDragonWings.setTextureOffset("wing.skin", -56, 88);
	        modelDragonWings.setTextureOffset("wing.bone", 112, 88);
	        modelDragonWings.setTextureOffset("wingTip.skin", -56, 144);
	
	        int bw = modelDragonWings.textureWidth;
	        int bh = modelDragonWings.textureHeight;
	        modelDragonWings.textureWidth = 256;
	        modelDragonWings.textureHeight = 256;
	        
	        this.wing = new ModelRenderer(modelDragonWings, "wing");
	        this.wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
	        this.wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
	        this.wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
	        this.wing.isHidden = true;
	        this.wingTip = new ModelRenderer(modelDragonWings, "wingTip");
	        this.wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
	        this.wingTip.isHidden = true;
	        this.wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
	        this.wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
	        this.wing.addChild(wingTip);
	        modelDragonWings.textureWidth = bw;
	        modelDragonWings.textureWidth = bh;
	    }


    @Override
    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float HeadYaw, float headPitch, float scale) {
        GlStateManager.pushMatrix();


        modelDragonWings.render(player, limbSwing, limbSwingAmount, ageInTicks, HeadYaw, headPitch, scale);
        modelDragonWings.setRotationAngles(scale, limbSwing, limbSwingAmount, ageInTicks, HeadYaw, headPitch, player);
        GL11.glPopMatrix();
    }

    protected void render(Entity player, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

    }

    private class ModelDragonWings extends CosmeticModelBase {


        public ModelDragonWings(RenderPlayer player) {
            super(player);


        }


        @Override
        public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

            super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);


            GlStateManager.pushMatrix();

            float f1 = ageInTicks / 80F;
            
            /*
            if(Minecraft.getMinecraft().thePlayer.moveForward != 0 || Minecraft.getMinecraft().thePlayer.moveStrafing != 0) {
            	f1 = ageInTicks / 60F;
            } else {
            	f1 = ageInTicks / 120F;
            }
            */

            /*
            if (Minecraft.getMinecraft().thePlayer.capabilities.isFlying) {
                f1 = ageInTicks / 200F;
            } else {
                f1 = ageInTicks / 80F;
            }
            */


            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/entity/enderdragon/dragon.png"));

            float anSpeed = 250.0F;
            /*
            if ((!entityIn.onGround) || (CosmeticDragonWings.this.flying)) {
                anSpeed = 50.0F;
                CosmeticDragonWings.this.flying = true;
            }
            */
            GlStateManager.scale(0.15D, 0.15D, 0.15D);
            GlStateManager.translate(0.0D, -0.3D, 1.1D);
            GlStateManager.rotate(50.0F, -50.0F, 0.0F, 0.0F);

            int x = 0;
            int index = 0;
            
                float hue = (System.currentTimeMillis() % 3000) / 3000f;
                //float hue = 0;
                int color = Color.HSBtoRGB(1.0F, 0.0F, 0.5F);

                for (int i = 0; i < 2; i++) {


                    float f6 = f1 * 9.1415927F * 2.0F;
                    CosmeticDragonWings.wing.rotateAngleX = (0.125F - (float) Math.cos(f6) * 0.2F);
                    CosmeticDragonWings.wing.rotateAngleY = 0.25F;
                    CosmeticDragonWings.wing.rotateAngleZ = ((float) (Math.sin(f6) + 1.225D) * 0.3F);


                    Minecraft.getMinecraft().fontRendererObj.drawString("", 0, 0, color);
                    CosmeticDragonWings.wingTip.rotateAngleZ = (-(float) (Math.sin(f6 + 2.0F) + 0.5D) * 0.75F);
                    CosmeticDragonWings.wing.isHidden = false;
                    CosmeticDragonWings.wingTip.isHidden = false;

                    if (entityIn.isInvisible()) {

                    } else {


                        GlStateManager.pushMatrix();

                        GlStateManager.disableLighting();

                        CosmeticDragonWings.wing.render(scale);
                        GlStateManager.blendFunc(1, 1);
                        GlStateManager.enableLighting();
                        GlStateManager.popMatrix();


                    }

                    CosmeticDragonWings.wing.isHidden = true;
                    CosmeticDragonWings.wingTip.isHidden = true;

                    if (i == 0) {
                        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
                    }
                    
                }


                GlStateManager.popMatrix();

            }
        /*

            if (WolveGuiOptions.optionGhostWingRainbow2) {
                for (int i = 0; i < 2; i++) {


                    float f6 = f1 * 9.1415927F * 2.0F;
                    CosmeticDragonWings.wing.rotateAngleX = (0.125F - (float) Math.cos(f6) * 0.2F);
                    CosmeticDragonWings.wing.rotateAngleY = 0.25F;
                    CosmeticDragonWings.wing.rotateAngleZ = ((float) (Math.sin(f6) + 1.225D) * 0.3F);


                    CosmeticDragonWings.wingTip.rotateAngleZ = (-(float) (Math.sin(f6 + 2.0F) + 0.5D) * 0.75F);
                    CosmeticDragonWings.wing.isHidden = false;
                    CosmeticDragonWings.wingTip.isHidden = false;

                    if (entityIn.isInvisible()) {

                    } else {


                        GlStateManager.pushMatrix();

                        GlStateManager.disableLighting();

                        CosmeticDragonWings.wing.render(scale);
                        GlStateManager.blendFunc(1, 1);
                        GlStateManager.enableLighting();
                        GlStateManager.popMatrix();


                    }

                    CosmeticDragonWings.wing.isHidden = true;
                    CosmeticDragonWings.wingTip.isHidden = true;

                    if (i == 0) {
                        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
                    }
                }


                GlStateManager.popMatrix();

            }*/

        }


        public void setRotationAngles(float scale, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, AbstractClientPlayer player) {
        	
        }

	    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
	
	    }
}


package mmc.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonSyntaxException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderUniform;
import net.minecraft.util.ResourceLocation;

public final class MotionBlur {
    private static final ResourceLocation LOCATION = new ResourceLocation("minecraft:shaders/post/mmc.json");
    private static final Logger LOGGER = LogManager.getLogger();
    private static ShaderGroup shader;
    private static float shaderBlur;
    public static boolean trouble;

    /**
     * Gets the current blur level.
     *
     * @return The blur level, ranging from <code>0F</code> to <code>1F</code>.
     */
    
    public static float getBlurFactor() {
    	return 0.0f;
    }

    public static ShaderGroup getShader() {
        // If there was an error, don't try to load again.
		if (trouble)
            return null;

        if (shader == null) {
            Minecraft mc = Minecraft.getMinecraft();

            // Force update.
            shaderBlur = Float.NaN;

            try {
                // Load shader from the location
                shader = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), LOCATION);
                shader.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
            } catch (IOException error) {
            	//catch (JsonSyntaxException | IOException error) {
                // Prevent shader from being loaded again.
                LOGGER.error("Could not load motion blur shader", error);
                trouble = true;
                return null;
            }
        }

        // Update the blur level.
        if (shaderBlur != getBlurFactor()) {
            shader.listShaders.forEach((shader) -> {
                ShaderUniform blendFactorUniform = shader.getShaderManager().getShaderUniform("BlurFactor");

                if (blendFactorUniform != null)
                    blendFactorUniform.set(getBlurFactor());
            });
            shaderBlur = getBlurFactor();
        }

        return shader;
    }
}

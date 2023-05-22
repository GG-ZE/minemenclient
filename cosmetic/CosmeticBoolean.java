package mmc.cosmetic;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticBoolean
{
    public static boolean yyCape;
    public static boolean staticCape;
    
    static {
        CosmeticBoolean.yyCape = true;
        CosmeticBoolean.staticCape = false;
    }
    
    
    public static boolean YYCape() {
        return CosmeticBoolean.yyCape;
    }
    
    public static boolean StaticCape() {
        return CosmeticBoolean.staticCape;
    }
}

package mmc.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScreenPosition {

    private static final Minecraft mc = Minecraft.getMinecraft();

    private int x, y;

    public ScreenPosition(double x, double y) {
        setRelative(x, y);
    }

    public ScreenPosition(int x, int y) {
        setAbsolute(x, y);
    }

    public static ScreenPosition fromRelativePosition(double x, double y) {
        return new ScreenPosition(x, y);
    }

    public static ScreenPosition fromAbsolute(int x, int y) {
        return new ScreenPosition(x, y);
    }

    public int getAbsoluteX() {
        return x;
    }

    public int getAbsoluteY() {
        return y;
    }

    public double getRelativeX() {
        ScaledResolution sr = new ScaledResolution(mc);
        return x / sr.getScaledWidth_double();
    }

    public double getRelativeY() {
        ScaledResolution sr = new ScaledResolution(mc);
        return y / sr.getScaledHeight_double();
    }

    public void setAbsolute(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setRelative(double x, double y) {
        ScaledResolution sr = new ScaledResolution(mc);
        this.x = (int) (sr.getScaledWidth() / x);
        this.y = (int) (sr.getScaledHeight() / y);
    }

}

/*
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScreenPosition {
	
	private static final Minecraft mc = Minecraft.getMinecraft();
	
	private double x, y;
	
	public ScreenPosition(double x, double y) {
		setRelative(x, y);
	}
	
	public ScreenPosition(int x, int y) {
		setAbsolute(x, y);
	}
	
	public static ScreenPosition fromRelativePosition(double x, double y) {
		return new ScreenPosition(x, y);
	}
	
	public static ScreenPosition fromAbsolutePosition(int x, int y) {
		return new ScreenPosition(x, y);
	}
	
	public int getAbsoluteX() {
		ScaledResolution res = new ScaledResolution(mc);
		
		return (int)(x * res.getScaledWidth());
	}
	
	public int getAbsoluteY() {
		ScaledResolution res = new ScaledResolution(mc);
		
		return (int)(y * res.getScaledHeight());
	}
	
	public double getRelativeX() {
		return x;
	}
	
	public double getRelativeY() {
		return y;
	}
	
	public void setRelative(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setAbsolute(int x, int y) {
		ScaledResolution res = new ScaledResolution(mc);
		
		this.x = (double)(x / res.getScaledWidth());
		this.y = (double)(y / res.getScaledHeight());
	}


}
*/

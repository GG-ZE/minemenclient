package mmc.gui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.SystemUtils;
import org.lwjgl.input.Keyboard;

import mmc.Client;
import mmc.util.DiscordWebhook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;

public class AuthMenu extends GuiScreen {
	
	public GuiTextField AuthCode;

	private ArrayList whitelist = new ArrayList<>();
	
    @Override
    protected void actionPerformed(final GuiButton button) {
        if (button.id == 0) {
            if(this.AuthCode.getText().equals("")) {
            	mc.displayGuiScreen(null);
                this.mc.displayGuiScreen(new AuthMenu());
            } else if(this.AuthCode.getText().equals("TklHR0VSU0VYc3Vtb2dhbmdvd25zYWxs")) {
                mc.displayGuiScreen(null);
                this.mc.displayGuiScreen(new MainMenu());
            } else {
            	mc.displayGuiScreen(null);
            	this.mc.displayGuiScreen(new AuthMenu());
            }

        }
    }

    @Override
    public void drawScreen(final int x2, final int y2, final float z2) {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        Gui.drawRect(0, 0, sr.getScaledWidth(), sr.getScaledHeight(), new Color(0, 0, 0, 75).getRGB());
        this.AuthCode.drawTextBox();
		Gui.drawCenteredString(this.mc.fontRendererObj, "Authenticator", (int)(this.width / 2), (int)(sr.getScaledHeight() / 2 - 65), -1);
        super.drawScreen(x2, y2, z2);
    }

    @Override
    public void initGui() {
    	
    	whitelist.add("Xenobolic");
    	whitelist.add("obvLogan");
    	whitelist.add("NSRD");
    	whitelist.add("SisterKenzu");
    	whitelist.add("Chainsaw_Denji");
    	whitelist.add("Everydqy");
    	whitelist.add("AntiGamingChairs");
    	whitelist.add("Heroisms");
    	whitelist.add("Dannysaur1x");
    	whitelist.add("oPolarized");
    	whitelist.add("Pqych");
    	whitelist.add("RqFa");
    	whitelist.add("St1ick");
    	whitelist.add("TradeBurger");
    	whitelist.add("Vinishoos");
    	whitelist.add("oVqru_");
    	whitelist.add("Muffinized");
    	
    	Client.getInstance().getDiscordRP().update("Status: Authenticating", "Connecting...");
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50 - 10, this.height / 2 - 20, 120, 20, I18n.format("Login", new Object[0])));
        (this.AuthCode = new GuiTextField(100, this.fontRendererObj, this.width / 2 - 50 - 10, sr.getScaledHeight() / 2 - 50, 120, 20)).setFocused(true);
        Keyboard.enableRepeatEvents(true);
        
    	for(int i = 0; i < whitelist.size(); i++) {
    		if(whitelist.get(i).toString() == mc.getSession().getUsername()) {
    			this.AuthCode.setText("TklHR0VSU0VYc3Vtb2dhbmdvd25zYWxs");
        		mc.displayGuiScreen(null);
                this.mc.displayGuiScreen(new MainMenu());
    		}
    	}
    }

    @Override
    protected void keyTyped(final char character, final int key) {
        try {
        	if(key != Keyboard.KEY_ESCAPE) {
        		super.keyTyped(character, key);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t' && !this.AuthCode.isFocused()) {
            this.AuthCode.setFocused(true);
        }
        if (character == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        if(key != Keyboard.KEY_ESCAPE) {
            this.AuthCode.textboxKeyTyped(character, key);
        }
    }
    
    @Override
    protected void mouseClicked(final int x2, final int y2, final int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.AuthCode.mouseClicked(x2, y2, button);
    }

    @Override
    public void onGuiClosed() {
        mc.entityRenderer.loadEntityShader(null);
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void updateScreen() {
        this.AuthCode.updateCursorCounter();
    }

}

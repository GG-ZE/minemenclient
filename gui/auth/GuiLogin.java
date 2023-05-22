package mmc.gui.auth;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import mmc.gui.MainMenu;
import mmc.gui.auth.microsoft.GuiLoginMicrosoft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;

public class GuiLogin extends GuiScreen {
    private GuiTextField username;

    @Override
    protected void actionPerformed(final GuiButton button) {
        if (button.id == 0) {
            if(this.username.getText().equals("")) {
            	mc.displayGuiScreen(null);
                this.mc.displayGuiScreen(new GuiLogin());
            } else {
                SessionChanger.getInstance().setUserOffline(this.username.getText());
            }

        }
        if (button.id == 1) {
        	mc.displayGuiScreen(null);
            mc.displayGuiScreen(new MainMenu());
        }
        if (button.id == 3) {
        	SessionChanger.getInstance().microsoftLoginAuth();
        }
    }

    @Override
    public void drawScreen(final int x2, final int y2, final float z2) {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.username.drawTextBox();
		Gui.drawCenteredString(this.mc.fontRendererObj, "Username", (int)(this.width / 2), (int)(sr.getScaledHeight() / 2 - 65), -1);
        super.drawScreen(x2, y2, z2);
    }

    @Override
    public void initGui() {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, width / 2 - 52, height - 32, 100, 20, "Cancel"));
        this.buttonList.add(new GuiButton(2, width / 2 + 4 - 150, height - 56, 100, 20, "Use Cracked"));
        this.buttonList.add(new GuiButton(3, width / 2 + 4 + 50, height - 56, 100, 20, "Use Microsoft"));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50 - 10, this.height / 2 - 20, 120, 20, I18n.format("Login (Cracked)", new Object[0])));
        (this.username = new GuiTextField(100, this.fontRendererObj, this.width / 2 - 50 - 10, sr.getScaledHeight() / 2 - 50, 120, 20)).setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void keyTyped(final char character, final int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t' && !this.username.isFocused()) {
            this.username.setFocused(true);
        }
        if (character == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(character, key);
    }

    @Override
    protected void mouseClicked(final int x2, final int y2, final int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.username.mouseClicked(x2, y2, button);
    }

    @Override
    public void onGuiClosed() {
        mc.entityRenderer.loadEntityShader(null);
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
    }
}
package mmc.gui.auth;

import mmc.gui.MainMenu;
import mmc.gui.auth.microsoft.GuiLoginMicrosoft;
import mmc.gui.auth.mojang.GuiLoginMojang;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class AltManagerGui extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, width / 2 - 52, height - 32, 100, 20, "Cancel"));
        this.buttonList.add(new GuiButton(1, width / 2 + 4 - 150, height - 56, 100, 20, "Use Cracked"));
        this.buttonList.add(new GuiButton(2, width / 2 + 4 + 50, height - 56, 100, 20, "Use Microsoft"));
        //this.buttonList.add(new GuiButton(3, width / 2 - 150 - 4, height - 48, 100, 20, "Use Mojang"));
        //this.buttonList.add(new GuiButton(4, width / 2 - 50, height - 24, 100, 20, "Coming Soon..."));
        //this.buttonList.add(new GuiButton(5, width / 2 - 150 - 4, height - 24, 100, 20, "Coming Soon..."));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            mc.displayGuiScreen(new MainMenu());
        }
        if(button.id == 1){
            mc.displayGuiScreen(new GuiLogin());
        }
        if(button.id == 2){
        	SessionChanger.getInstance().microsoftLoginAuth();
            //mc.displayGuiScreen(new GuiLoginMicrosoft());
        }
    }
}

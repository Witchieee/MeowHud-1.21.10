package meow.code.hud;

import meow.code.MeowHudClient;
import meow.code.conf.HudConfig;
import meow.code.conf.ConfigInfo;

import java.util.ArrayList;

import net.minecraft.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;

import net.minecraft.world.entity.Entity;

import net.minecraft.resources.ResourceLocation;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;

public class MyHud{
    static HudConfig config = new HudConfig();
    static Minecraft client = Minecraft.getInstance();
    static Entity camera;
    static int[] x = new int[3];
    static int[] y = new int[3];
    static int update_delay = 3; // in seconds

    public static void init(){
        config.load();
        config.name = client.getUser().getName();

        x[0] = 0;
        y[0] = 0;

        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, ResourceLocation.fromNamespaceAndPath(MeowHudClient.MOD_ID, "before_chat"), MyHud::render);
    }

    public static void render(GuiGraphics draw, DeltaTracker tick){
        config.ping = client.getConnection().getPlayerInfo(config.name).getLatency() + "";
        config.tps = "0";
        config.fps = client.getFps() + "";
        
        camera = client.getCameraEntity();
        config.cords_x = (int)camera.getX() + "";
        config.cords_y = (int)camera.getY() + "";
        config.cords_z = (int)camera.getZ() + "";

        config.movment = getMovment();

        if(Util.getMillis() / 1000 % update_delay == 0){
            config.ping = client.getConnection().getPlayerInfo(config.name).getLatency() + "";
            config.tps = "0";
            config.fps = client.getFps() + "";

            x[1] = draw.guiWidth() / 2 - 1;
            x[2] = draw.guiWidth();

            y[1] = draw.guiHeight() / 2 - 1;
            y[2] = draw.guiHeight();
        }

        for(ArrayList<ConfigInfo> colom : config.config){
            int row_offset_y = 0;
            int row_offset_x = 0;
            for(ConfigInfo row : colom){
                String line = "";
                row_offset_x += row.offset_x;
                row_offset_y += row.offset_y;

                for(ConfigInfo.InfoClass key : row.keys){
                    line += key.get();
                }
                
                if(row.align) draw.drawCenteredString(client.font, line, x[row.pos_x] + row_offset_x, y[row.pos_y] + row_offset_y, row.color);
                else draw.drawString(client.font, line, x[row.pos_x] + row_offset_x, y[row.pos_y] + row_offset_y, row.color);
            }
        }
    }

    static int getMovment(){
        if(camera.isSwimming()) return 0;
        if(camera.isCrouching()) return 1;
        if(camera.isSprinting()) return 2;
        return 3;
    }
}

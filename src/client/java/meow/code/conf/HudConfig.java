package meow.code.conf;

import meow.code.MeowHudClient;

import java.nio.file.Path;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public class HudConfig{
    public String name;
    public String ping;
    public String tps;
    public String fps;
    public String cords_x;
    public String cords_y;
    public String cords_z;
    public int movment;

    public ArrayList<ArrayList<ConfigInfo>> config = new ArrayList<ArrayList<ConfigInfo>>();
    
    public void load(){
        MeowHudClient.LOGGER.info("loading config");

        config = new ConfigBuilder().build(this);
    }
}

// name
// ping
// tps
// fps
// cords
// movment
// armor
// hand
// offhand

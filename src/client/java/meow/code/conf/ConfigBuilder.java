package meow.code.conf;

import meow.code.MeowHudClient;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import net.minecraft.client.Minecraft;

import net.fabricmc.loader.api.FabricLoader;

public class ConfigBuilder{
    HudConfig arg0;
    Path config_path;
    List<String> reader;
    ArrayList<String> keys = new ArrayList<String>();
    ArrayList<String> values = new ArrayList<String>();
    ArrayList<ArrayList<ConfigInfo>> holder = new ArrayList<ArrayList<ConfigInfo>>();

    int at_colom;
    int at_row;

    public ConfigBuilder(){
        config_path = FabricLoader.getInstance().getConfigDir().resolve("config.witchie");
    }
    
    public ConfigBuilder(Path path){
        config_path = path;
    }

    public ArrayList<ArrayList<ConfigInfo>> build(HudConfig arg0){
        MeowHudClient.LOGGER.info("Building config holder");

        this.arg0 = arg0;

        try{
            reader = Files.readAllLines(config_path);
        } catch(IOException e){
            return holder;
        }

        at_colom = 0;

        while(loop("colom {")){
            if(reader.isEmpty()) return holder;
            holder.add(new ArrayList<ConfigInfo>());
            at_row = 0;

            while(loop("row {")){
                if(reader.isEmpty()) return holder;
                holder.get(at_colom).add(new ConfigInfo());
                
                confiClassLoader();
                at_row++;
            }

            at_colom++;
        }
        

        return holder;
    }

    void confiClassLoader(){
        String line;
        DefaultConfig preset = new DefaultConfig();
        ConfigInfo object = holder.get(at_colom).get(at_row);

        object.holder = arg0;

        while(!reader.isEmpty()){
            line = reader.remove(0).trim();   
            
            switch(line){
                // exit row handel
                case "}":
                    return;

                case "":
                    break;

                // row atr
                case "%OFFSETX":
                    if(reader.isEmpty()) return;
                    object.offset_x = Integer.parseInt(reader.remove(0).trim());
                    break;
                
                case "%OFFSETY":
                    if(reader.isEmpty()) return;
                    object.offset_y = Integer.parseInt(reader.remove(0).trim());
                    break;

                case "%POSX":
                    if(reader.isEmpty()) return;
                    object.pos_x = Integer.parseInt(reader.remove(0).trim());
                    break;

                case "%POSY":
                    if(reader.isEmpty()) return;
                    object.pos_y = Integer.parseInt(reader.remove(0).trim());
                    break;

                case "%COLOR {": 
                    setMultiple(preset.new Color());

                    for(String entry : values){
                        object.color <<= 8;
                        object.color |= Integer.parseInt(entry);
                    }

                    break;

                case "%SETMOVMENT {":
                    setMultiple(preset.new Movment());
                    
                    for(int i = 0; i < values.size(); i++){
                        object.movment[i] = values.get(i);
                    }
                    
                    break;

                case "%ALIGN":
                    if(reader.isEmpty()) return;
                    object.align = Boolean.parseBoolean(reader.remove(0).trim());
                    break;

                //keys
                case "%NAME":
                    object.keys.add(object.new NAME());
                    break;

                case "%PING":
                    object.keys.add(object.new PING());
                    break;

                case "%TPS":
                    object.keys.add(object.new TPS());
                    break;

                case "%FPS":
                    object.keys.add(object.new FPS());
                    break;

                case "%CORDSX":
                    object.keys.add(object.new CORDSX());
                    break;

                case "%CORDSY":
                    object.keys.add(object.new CORDSY());
                    break;

               case "%CORDSZ":
                    object.keys.add(object.new CORDSZ());
                    break;

                case "%MOVMENT":
                    object.keys.add(object.new MOVMENT());
                    break;

                // for custom string key
                case "%SPACE":
                    object.keys.add(object.new STRING(" "));
                    break;

                case "%TAP":
                    object.keys.add(object.new STRING("    "));
                    break;
                
                default:
                    object.keys.add(object.new STRING(line));
            }
        }
    }

    void setMultiple(DefaultConfig.Info object){
        String line;
        keys = object.keys;
        values = object.values;
        
        while(!reader.isEmpty()){
            line = reader.remove(0).trim();

            if(line.equals("}") || reader.isEmpty()) return;
            if(!keys.contains(line)) continue;
            values.set(keys.indexOf(line), reader.remove(0).trim());
        }
    }

    boolean loop(String word){
        String line;

        while(!reader.isEmpty()){
            line = reader.remove(0).trim();

            if(line.equals("}")) break;
            if(line.equals(word)) return true;
        }

        return false;
    }   
}

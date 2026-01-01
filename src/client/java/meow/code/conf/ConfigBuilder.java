package meow.code.conf;

import meow.code.MeowHudClient;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;

import net.fabricmc.loader.api.FabricLoader;

public class ConfigBuilder{
    HudConfig arg0;
    ConfigInfo object;
    Path config_path;
    List<String> reader;
    ArrayList<ArrayList<ConfigInfo>> holder = new ArrayList<ArrayList<ConfigInfo>>();
    ArrayList<ConfigInfo> colom = new ArrayList<ConfigInfo>();

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

        while(loop("colom {")){
            if(reader.isEmpty()) return holder;
            at_colom = Integer.parseInt(reader.remove(0).trim());
            holder.add(at_colom, colom);

            while(loop("row {")){
                if(reader.isEmpty()) return holder;
                at_row = Integer.parseInt(reader.remove(0).trim());
                holder.get(at_colom).add(at_row, new ConfigInfo());
                
                confiClassLoader();
            }
        }

        return holder;
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

    void confiClassLoader(){
        String line;
        object = holder.get(at_colom).get(at_row);

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
                    setColor();
                    break;

                case "%SETMOVMENT {":
                    setMovment();
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

    void setColor(){
        String line;

        while(!reader.isEmpty()){
            line = reader.remove(0).trim();

             switch(line){
                case "}":
                    return;

                case "%ALPA":
                    if(reader.isEmpty()) return;
                    object.color &= 0x00FFFFFF;
                    object.color |= Integer.parseInt(reader.remove(0).trim()) << 24;
                    break;

                case "%RED":
                    if(reader.isEmpty()) return;
                    object.color &= 0xFF00FFFF;
                    object.color |= Integer.parseInt(reader.remove(0).trim()) << 16;
                    break;

                case "%GREEN":
                    if(reader.isEmpty()) return;
                    object.color &= 0xFFFF00FF;
                    object.color |= Integer.parseInt(reader.remove(0).trim()) << 8;
                    break;

                 case "%BLUE":
                    if(reader.isEmpty()) return;
                    object.color &= 0xFFFFFF00;
                    object.color |= Integer.parseInt(reader.remove(0).trim());
                    break;

                 default:
                    break;
            }           
        }
    }

    void setMovment(){
        String line;

        while(!reader.isEmpty()){
            line = reader.remove(0).trim();

            switch(line){
                case "}":
                    return;

                case "%SWIM":
                    if(reader.isEmpty()) return;
                    object.movment[0] = reader.remove(0).trim();
                    break;

                case "%CROUCH":
                    if(reader.isEmpty()) return;
                    object.movment[1] = reader.remove(0).trim();
                    break;

                case "%SPRINT":
                    if(reader.isEmpty()) return;
                    object.movment[2] = reader.remove(0).trim();
                    break;

                 case "%STAND":
                    if(reader.isEmpty()) return;
                    object.movment[3] = reader.remove(0).trim();
                    break;

                 default:
                    break;
            }
        }
    }
}

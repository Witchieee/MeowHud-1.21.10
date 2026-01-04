package meow.code.conf;

import java.util.ArrayList;
import java.nio.ByteBuffer;

import net.minecraft.client.Minecraft;

public class ConfigInfo{
    DefaultConfig preset = new DefaultConfig();
    public HudConfig holder;

    public int offset_x = preset.new OffsetX().offset_x;
    public int offset_y = preset.new OffsetY().offset_y;
    public int pos_x = preset.new PosX().pos_x;
    public int pos_y = preset.new PosY().pos_y;
    public int color = preset.new Color().color;
    public boolean align = preset.new Align().align;
    public String[] movment = preset.new Movment().movment;
    public ArrayList<ConfigInfo.InfoClass> keys = new ArrayList<ConfigInfo.InfoClass>(); 

    public class InfoClass{
        public String get(){
            return "?";
        }
    }

    public class NAME extends InfoClass{
        public String get(){
            return holder.name;
        }
    }

    public class PING extends InfoClass{
        public String get(){
            return holder.ping;
        }
    }

    public class TPS extends InfoClass{
        public String get(){
            return holder.tps;
        }
    }

    public class FPS extends InfoClass{
        public String get(){
            return holder.fps;
        }
    }

    public class CORDSX extends InfoClass{
        public String get(){
            return holder.cords_x;
        }
    }

    public class CORDSY extends InfoClass{
        public String get(){
            return holder.cords_y;
        }
    }

    public class CORDSZ extends InfoClass{
        public String get(){
            return holder.cords_z;
        }
    }

    public class MOVMENT extends InfoClass{
        public String get(){
            return movment[holder.movment];
        }
    }

    public class STRING extends InfoClass{
        String text;

        public STRING(String text){
            this.text = text;
        }
        public String get(){
            return text;
        }
    }
}

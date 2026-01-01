package meow.code.conf;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;

public class ConfigInfo{
    public HudConfig holder;

    public int offset_x = 0;
    public int offset_y = 10;
    public int pos_x = 0;
    public int pos_y = 0;
    public int color = 0xFFFF0000;
    public boolean align = false;
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
            return holder.movment;
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

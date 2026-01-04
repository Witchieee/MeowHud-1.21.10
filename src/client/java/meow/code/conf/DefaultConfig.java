package meow.code.conf;

import java.util.ArrayList;

public class DefaultConfig{
    public class Info{
        ArrayList<String> keys = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();
    }

    public class OffsetX extends Info{
        final int offset_x = 0;
    }

    public class OffsetY extends Info{
        final int offset_y = 10;
    }

    public class PosX extends Info{
        final int pos_x = 0;
    }

    public class PosY extends Info{
        final int pos_y = 0;
    }

    public class Color extends Info{
        final int color = 0xFF000000;
        
        public Color(){
            keys.add("%TRANS");
            keys.add("%RED");
            keys.add("%GREEN");
            keys.add("%BLUE");

            values.add("255");
            values.add("0");
            values.add("0");
            values.add("0");
        }
    }

    public class Align extends Info{
        final boolean align = false;
    }

    public class Movment extends Info{
        final String[] movment = {"Swimming", "Crouching", "Sprinting", ""};

        public Movment(){
            keys.add("%SWIM");
            keys.add("%CROUCH");
            keys.add("%SPRINT");
            keys.add("%STAND");

            values.add("Swimming");
            values.add("Crouching");
            values.add("Sprinting");
            values.add("");
        }
    }
}


package meow.code;

import meow.code.hud.MyHud;

import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeowHudClient implements ClientModInitializer {
    public static final String MOD_ID = "meowhud";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    @Override
	public void onInitializeClient() {
        MyHud.init();
    }
}

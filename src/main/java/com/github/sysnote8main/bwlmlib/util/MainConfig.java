package com.github.sysnote8main.bwlmlib.util;

import com.github.sysnote8main.bwlmlib.Tags;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Tags.modid)
@LangKey("Config of BWLMLib")
public class MainConfig {
    public static ExpBoxTier ExpBox = new ExpBoxTier();
    public static class HealthModifier {
        public static int tier1_level = 30;
        public static float tier1_divisor = 2;
        public static int tier2_level = 50;
        public static float tier2_divisor = 2.5f;
        public static int tier3_level = 75;
        public static float tier3_divisor = 7.5f;
        public static int tier4_level = 150;
        public static float tier4_divisor = 15;
        public static int tier_level_max = 300;
    }
    public static class ExpBoxTier {
        public static boolean isEnabled = true;
        public static int tier1 = 500;
        public static int tier2 = 3000;
        public static int tier3 = 7500;
        public static int tier4 = 30000;
        public static int tier5 = 75000;
    }
    @Mod.EventBusSubscriber(modid = Tags.modid)
    private static class Handler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e) {
            if(e.getModID().equals(Tags.modid)) {
                ConfigManager.sync(Tags.modid, Type.INSTANCE);
            }
        }
    }
}

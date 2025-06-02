package cool.bot.botslib;


import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = BotsLib.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();


    // List of block tags as strings that can be watered as crops
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> WATERABLE_CROPS_TAGS = BUILDER
            .comment("List of block tags as strings that can be watered as crops")
            .defineList("waterableCropsTags", List.of("minecraft:crops", "dewdrop:crops"), Config::validateBlockTag);

    // Max Crop Height
    private static final ForgeConfigSpec.IntValue MAX_CROP_HEIGHT = BUILDER
            .comment("The maximum length certain functions will look for farmland under a multipart crop block, you probably don't need to modify this.")
            .defineInRange("maxCropHeight", 2, 0, 64);

    // Yikes!
    private static boolean validateBlockTag(Object o) {
        return true;
    }


    static final ForgeConfigSpec SERVER_CONFIG = BUILDER.build();


    public static List<? extends String> waterableCropsTags;
    public static int maxCropHeight;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        waterableCropsTags = WATERABLE_CROPS_TAGS.get();
        maxCropHeight = MAX_CROP_HEIGHT.get();
    }
}
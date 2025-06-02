package cool.bot.botslib.util;

import net.minecraftforge.fml.ModList;
import sereneseasons.core.SereneSeasons;


public class Compatibility {

    public static final ModList modlist = ModList.get();

    public static boolean sereneSeasonsLoaded() {
        return modlist.isLoaded(SereneSeasons.MOD_ID);
    }
}

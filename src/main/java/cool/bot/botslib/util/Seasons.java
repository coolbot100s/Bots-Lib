package cool.bot.botslib.util;

import net.minecraft.world.level.Level;
import sereneseasons.api.season.SeasonHelper;

public class Seasons {

    public enum BotsSeason {
        SPRING,
        SUMMER,
        FALL,
        WINTER,
        NONE
    }

    public static BotsSeason getSeason(Level level) {
        if(Compatibility.sereneSeasonsLoaded()) {
            return switch (SeasonHelper.getSeasonState(level).getSeason()) {
                case SPRING -> BotsSeason.SPRING;
                case SUMMER -> BotsSeason.SUMMER;
                case AUTUMN -> BotsSeason.FALL;
                case WINTER -> BotsSeason.WINTER;
            };
        } else {
            return BotsSeason.NONE;
        }
    }

}

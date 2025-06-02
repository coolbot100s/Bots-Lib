package cool.bot.botslib;

import com.mojang.logging.LogUtils;
import cool.bot.botslib.item.DewDropCreativeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BotsLib.MODID)
public class BotsLib {
    public static final String MODID = "bots_lib";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BotsLib() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DewDropCreativeTab.register(modEventBus);

    }

}

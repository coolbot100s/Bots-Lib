package cool.bot.botslib;

import com.mojang.logging.LogUtils;
import cool.bot.botslib.item.DewDropCreativeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(BotsLib.MODID)
public class BotsLib {
    public static final String MODID = "bots_lib";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BotsLib(ModContainer container) {
        IEventBus modEventBus = container.getEventBus();
        DewDropCreativeTab.register(modEventBus);

    }
    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}

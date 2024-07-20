package cool.bot.botslib.item;


import com.mojang.brigadier.exceptions.CommandSyntaxException;
import cool.bot.botslib.BotsLib;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DewDropCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BotsLib.MODID);

    public static final ItemStack DEW_DROP_ICON_ITEM = createIconItem();
    public static ItemStack createIconItem() {
        ItemStack stack = new ItemStack(Items.SHEARS, 1);
        CompoundTag tag = stack.getOrCreateTag();
        String nbtString = "{display:{Name:'[\"\",{\"text\":\"Dew Drop Icon Item\",\"italic\":false}]',Lore:['[\"\",{\"text\":\"This is a retextured shears used to display Dew Drops icon on the creative tab in a Vanilla Friendly way. \",\"italic\":false,\"color\":\"gray\"}]','[\"\",{\"text\":\"If this looks wrong to you, install Bot\\'s Lib on the client!\",\"italic\":false,\"color\":\"gray\"}]']},CustomModelData:66614}";
        try {
            tag = TagParser.parseTag(nbtString);
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
        stack.setTag(tag);
        return stack;
    }



    public static final RegistryObject<CreativeModeTab> DEWDROP_TAB = CREATIVE_MODE_TABS.register("dewdrop_tab",
            () -> CreativeModeTab.builder().icon(() -> DEW_DROP_ICON_ITEM)
                    .title(Component.translatableWithFallback("creativetab.dewdrop_tab", "Dew Drop"))
                    .displayItems((parameters, output) -> output.accept(DEW_DROP_ICON_ITEM))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
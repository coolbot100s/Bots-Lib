package cool.bot.botslib.item;


import cool.bot.botslib.BotsLib;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.component.ItemLore;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class DewDropCreativeTab {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BotsLib.MODID);

    public static final ItemStack DEW_DROP_ICON_ITEM = createIconItem();
    public static ItemStack createIconItem() {
        ItemStack stack = new ItemStack(Items.SHEARS, 1);
        stack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(66614));
        stack.set(DataComponents.CUSTOM_NAME, Component.translatable("item.bots_lib.custom_shears").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        stack.set(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.bots_lib.custom_shears.lore.0").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)), Component.translatable("item.bots_lib.custom_shears.lore.1").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)))));
        return stack;
    }


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DEWDROP_TAB = CREATIVE_MODE_TABS.register("dewdrop_tab",
            () -> CreativeModeTab.builder().icon(() -> DEW_DROP_ICON_ITEM)
                    .title(Component.translatableWithFallback("creativetab.dewdrop_tab", "Dew Drop"))
                    .displayItems((parameters, output) -> output.accept(DEW_DROP_ICON_ITEM))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
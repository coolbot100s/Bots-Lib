package cool.bot.botslib.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class DewDropBlockTags {


    // Dew Drop project blocktags
    public static final TagKey<Block> WATERABLE = tag("waterable");
    public static final TagKey<Block> CROP = tag("crops");
    public static final TagKey<Block> SPRINKLER = tag("sprinkler");


    public static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation("dewdrop", name));
    }
}

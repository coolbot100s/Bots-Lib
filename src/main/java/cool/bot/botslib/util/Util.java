package cool.bot.botslib.util;



import cool.bot.botslib.tag.DewDropBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;

import static cool.bot.botslib.Config.maxCropHeight;
import static cool.bot.botslib.Config.waterableCropsTags;

public final class Util {

    /*  Custom Raycast function that more accurately returns the block or fluid the player is looking at without using any extra datatypes.
    /   Returns null if the player is staring at nothing, as you do.
    */
    @Nullable
    public static BlockPos blockHighlightedOrNull(Player player) {
        HitResult hitResult = player.pick(player.getBlockReach(),1.0F,true);
        if (!(hitResult.getType() == HitResult.Type.BLOCK)) {
            return null;
        }
        return BlockPos.containing(hitResult.getLocation().add(hitResult.getLocation().subtract(player.getEyePosition()).normalize().multiply(0.001, 0.001, 0.001)));
    }

    public static boolean isMoistWaterable(ServerLevel level, BlockPos pos) {
       return level.getBlockState(pos).is(DewDropBlockTags.WATERABLE) && level.getBlockState(pos).getValue(BlockStateProperties.MOISTURE) >= 1;
    }
    public static boolean isDryWaterable(ServerLevel level, BlockPos pos) {
        return level.getBlockState(pos).is(DewDropBlockTags.WATERABLE) && level.getBlockState(pos).getValue(BlockStateProperties.MOISTURE) == 0;
    }

    public static boolean isWaterableCrop(ServerLevel level, BlockPos pos) {
        for (String tag1 : waterableCropsTags) {
            if (level.getBlockState(pos).getTags().anyMatch(tag2 -> tag2.location().toString().equals(tag1))) {return true;}
        }
       return false;
    }


    /*  Returns the block position of the dewdrop:waterable that a given crop is planted on, returns null if it's planted on something else.
    /   Multiblock crops should have all parts tagged with a valid tag per isWaterableCrop
    */
    @Nullable
    public static BlockPos getDewdropWaterableFromCrop(ServerLevel level, BlockPos pos, int maxDistance) {
        for (int i = 1; i <= maxDistance; i++) {
            BlockPos belowPos = pos.below(i);
            if (level.getBlockState(pos).is(DewDropBlockTags.WATERABLE)) {
                return belowPos;
            } else if (!isWaterableCrop(level, pos)) {
                return null;
            }
        }
        return null;
    }

    public static BlockPos getDewdropWaterableFromCrop(ServerLevel level, BlockPos pos) {
        return getDewdropWaterableFromCrop(level, pos, maxCropHeight);
    }

    // Calling these methods on blocks that do not have a moisture property like farmland (0-7) will break things.
    public static void setMoist(ServerLevel level, BlockPos pos) {
        level.setBlock(pos, level.getBlockState(pos).setValue(BlockStateProperties.MOISTURE, 7), 3);
    }
    public static void setDry(ServerLevel level, BlockPos pos) {
        level.setBlock(pos, level.getBlockState(pos).setValue(BlockStateProperties.MOISTURE, 0), 3);
    }



}
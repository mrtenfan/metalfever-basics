package ru.mrtenfan.metalfeverbasis.blocks.ores;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;

public class ItemMetalsOre extends ItemMultiTexture {

    public ItemMetalsOre(Block block) {
        super(block, block, MetalsOre.metadata);
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile." + MetalsOre.metadata[stack.getItemDamage()] + "_ore";
    }
}

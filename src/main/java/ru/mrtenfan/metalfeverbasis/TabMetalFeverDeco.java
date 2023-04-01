package ru.mrtenfan.metalfeverbasis;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.init.MFBlocks;

public class TabMetalFeverDeco extends CreativeTabs {

	public TabMetalFeverDeco(String lable) {
		super(lable);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return getIconItemStack().getItem();
	}
	public ItemStack getIconItemStack() {
		return new ItemStack(MFBlocks.metals_ore, 1, 2);
	}
}

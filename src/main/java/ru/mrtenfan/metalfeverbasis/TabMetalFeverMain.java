package ru.mrtenfan.metalfeverbasis;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.init.MFItems;

public class TabMetalFeverMain extends CreativeTabs {

	public TabMetalFeverMain(String lable) {
		super(lable);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return getIconItemStack().getItem();
	}
	public ItemStack getIconItemStack() {
		return new ItemStack(MFItems.metals_ingot, 1, 1);
	}
}

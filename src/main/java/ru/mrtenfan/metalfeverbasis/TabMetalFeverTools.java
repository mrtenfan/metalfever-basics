package ru.mrtenfan.metalfeverbasis;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.mrtenfan.metalfeverbasis.init.MFTools;

public class TabMetalFeverTools extends CreativeTabs {

	public TabMetalFeverTools(String lable) {
		super(lable);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return MFTools.bronze_chestplate;
	}
}

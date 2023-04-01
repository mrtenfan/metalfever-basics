package ru.mrtenfan.metalfeverbasis.tools.tool;

import net.minecraft.item.ItemHoe;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class BronzeHoe extends ItemHoe {

	public BronzeHoe(String name, ToolMaterial mat) {
		super(mat);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverTools);
	}
}

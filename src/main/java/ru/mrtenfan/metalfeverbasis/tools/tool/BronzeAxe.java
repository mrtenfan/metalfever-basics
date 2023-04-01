package ru.mrtenfan.metalfeverbasis.tools.tool;

import net.minecraft.item.ItemAxe;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class BronzeAxe extends ItemAxe {

	public BronzeAxe(String name, ToolMaterial mat) {
		super(mat);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverTools);
	}
}

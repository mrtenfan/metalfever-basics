package ru.mrtenfan.metalfeverbasis.tools.tool;

import net.minecraft.item.ItemAxe;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class CobaltAxe extends ItemAxe {

	public CobaltAxe(String name, ToolMaterial mat) {
		super(mat);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverTools);
	}
}

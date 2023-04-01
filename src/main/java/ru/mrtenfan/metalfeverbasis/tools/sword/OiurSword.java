package ru.mrtenfan.metalfeverbasis.tools.sword;

import net.minecraft.item.ItemSword;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class OiurSword extends ItemSword {

	public OiurSword(String name, ToolMaterial mat) {
		super(mat);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverTools);
	}
}

package ru.mrtenfan.metalfeverbasis.tools.tool;

import net.minecraft.item.ItemPickaxe;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class CobaltPickaxe extends ItemPickaxe {

	public CobaltPickaxe(String name, ToolMaterial mat) {
		super(mat);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverTools);
	}
}

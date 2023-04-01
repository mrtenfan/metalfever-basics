package ru.mrtenfan.metalfeverbasis.tools.tool;

import net.minecraft.item.ItemSpade;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class MewniShovel extends ItemSpade {

	public MewniShovel(String name, ToolMaterial mat) {
		super(mat);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverTools);
	}
}

package ru.mrtenfan.metalfeverbasis.tools.tool;

import net.minecraft.item.ItemSpade;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class JoykShovel extends ItemSpade {

	public JoykShovel(String name, ToolMaterial mat) {
		super(mat);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverTools);
	}
}

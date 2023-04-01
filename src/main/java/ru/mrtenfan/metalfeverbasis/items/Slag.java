package ru.mrtenfan.metalfeverbasis.items;

import net.minecraft.item.Item;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class Slag extends Item {
	
	public Slag(String name) {
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverMain);
		this.setMaxStackSize(32);
	}
}

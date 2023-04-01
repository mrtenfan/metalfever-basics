package ru.mrtenfan.metalfeverbasis.tools.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class OiurArmor extends ItemArmor {

	private String texturePath = "metalfeverbasis:textures/models/armors/";
	public OiurArmor(int id, int armorType, ArmorMaterial mat) {
		super(mat, id, armorType);
		this.setCreativeTab(MFOther.TabMetalFeverTools);
		this.setMaxStackSize(1);
		this.setTextureName();
	}
	private void setTextureName() {
		  if(armorType == 0||armorType == 1||armorType == 3){
			    this.texturePath += "oiur_layer_" + 1 + ".png";
			  }
			  else {
			    this.texturePath += "oiur_layer_" + 2 + ".png";
			  }
	}
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		return this.texturePath;
	}
}

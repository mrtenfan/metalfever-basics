package ru.mrtenfan.metalfeverbasis.items.gears;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class BMetalsGear extends Item {
	
	public static final String name = "_gear";
    public static final String[] metadata = new String[] {
            "copper", //0
            "lead", //1
            "nickel", //2
            "platinum", //3
            "silver", //4
            "tin", //5
            "iron", //6
            "gold" //7
        };
	
	public BMetalsGear() {
        super();
        this.setHasSubtypes(true);
        this.setCreativeTab(MFOther.TabMetalFeverMain);
	}

	public IIcon[] icons = new IIcon[metadata.length];
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < metadata.length; i ++) {
	        this.icons[i] = reg.registerIcon("metalfeverbasis:" + metadata[i] + name);
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > metadata.length)
	        meta = 0;

	    return this.icons[meta];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < metadata.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return "item." + metadata[stack.getItemDamage()] + name;
	}
}
package ru.mrtenfan.metalfeverbasis.tools.hammers;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class OiurHammer extends Item {
	
	private static boolean inf;
	
	public OiurHammer(String name, int dur, boolean infinity) {
		this.setNoRepair();
		this.setMaxStackSize(1);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverMain);
		if (infinity == false)
		this.setMaxDamage(dur);
		setContainerItem(this);
		inf = infinity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, final boolean b) {
        info.add(I18n.format((inf ? "text.maxdamage.inf" : "text.maxdamage"), new Object[0]) + (inf ? null : (itemStack.getMaxDamage() - itemStack.getItemDamage())));
    }

    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    public ItemStack getContainerItem(ItemStack is) {
    	if (is.getItemDamage() >= 0) {
    	is.setItemDamage(is.getItemDamage() + 1);
    	return is;
    	}
    	return super.getContainerItem(is);
    	}

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
        return false;
    }
}
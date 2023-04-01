package ru.mrtenfan.metalfeverbasis.tools.hammers;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class IronHammer extends Item {
	
	public IronHammer(String name, int dur) {
		this.setNoRepair();
		this.setMaxStackSize(1);
		this.setTextureName("metalfeverbasis:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MFOther.TabMetalFeverMain);
		this.setMaxDamage(dur);
		this.setContainerItem(this);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, final boolean b) {
        info.add(I18n.format("text.maxdamage", new Object[0]) + (itemStack.getMaxDamage() - itemStack.getItemDamage()));
    } //Выводит информацию о кол-во использования 

    public boolean hasContainerItem(ItemStack stack) {
        return true;
    } //Для метадаты

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
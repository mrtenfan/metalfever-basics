package ru.mrtenfan.metalfeverbasis.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAlloyFurnace extends Slot {

	public SlotAlloyFurnace(EntityPlayer player, IInventory inventory , int i, int j, int k) {
		super(inventory, i, j, k);
	}
	
	public boolean isItemValid(ItemStack itemStack) {
		return false;
	}
}

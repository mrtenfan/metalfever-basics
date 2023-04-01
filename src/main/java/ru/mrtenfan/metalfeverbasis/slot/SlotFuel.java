package ru.mrtenfan.metalfeverbasis.slot;


import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityAlloyFurnace;

public class SlotFuel extends Slot {

	public SlotFuel(IInventory inventory , int i, int j, int k) {
		super(inventory, i, j, k);
	}
	
	public boolean isItemValid(ItemStack itemStack) {
		 return TileEntityAlloyFurnace.getItemBurnTime(itemStack) > 0;
	}
}

package ru.mrtenfan.metalfeverbasis.tileentity;

import net.minecraft.item.ItemStack;
import ru.mrtenfan.MTFCore.Debuging;
import ru.mrtenfan.MTFCore.utils.ItemUtils;
import ru.mrtenfan.metalfeverbasis.MetalFeverMain;
import ru.mrtenfan.metalfeverbasis.blocks.AlloyFurnace;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe.AlloyingFuel;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe.AlloyingRecipe;
import ru.mrtenfan.metalfeverbasis.init.MFItems;

public class TileEntityAlloyFurnace extends TileEntityBaseFurnace {

	public TileEntityAlloyFurnace() {
		super("container.alloyFurnace", 5, 400, new int[] {0, 1}, new int[] {3, 4}, new int[] {2});
	}

	public static boolean hasItemBurnTime(ItemStack itemStack) {
		return getItemBurnTime(itemStack) > 0;
	}

	public static int getItemBurnTime(ItemStack itemStack) {
		if (itemStack == null) 
			return 0;
		else {
			for(AlloyingFuel fuel : AlloyFurnaceRecipe.fuels) {
				if(ItemUtils.isItemEqual(fuel.getItem(), itemStack, true)) {
					return fuel.getBurnTime();
				}
			}
		}
		return 0;
	}

	private boolean canAlloy(AlloyingRecipe recipe) {
		if (slots[0] == null || slots[1] == null)
			return false;

		if(recipe == null) return false;
		ItemStack itemStack = recipe.getResult(); 
		ItemStack slag = new ItemStack(MFItems.slag);

		if(slots[3] == null) return true;
		if(!slots[3].isItemEqual(itemStack)) return false;
		if(slots[4] == null) return true;
		if(!slots[4].isItemEqual(slag)) return false;
		else return slots[3].stackSize + itemStack.stackSize <= 64 && slots[4].stackSize < 32;

	}

	private void alloyItem(AlloyingRecipe recipe) {
		if (canAlloy(recipe)) {
			ItemStack itemStack = recipe.getResult();
			ItemStack slag = new ItemStack(MFItems.slag);
			int[] number = recipe.getInputNumbers(slots[0], slots[1]);

			if (slots[3] == null)
				slots[3] = itemStack.copy();
			else if (slots[3].isItemEqual(itemStack)) 
				slots[3].stackSize += itemStack.stackSize;

			if (slots[4] == null)
				slots[4] = slag.copy();
			else if (slots[4].isItemEqual(slag)) 
				slots[4].stackSize += slag.stackSize;


			for (int i = 0; i < 2; i++) {
				if (slots[i].stackSize <= 0)
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				else
					slots[i].stackSize -= number[i];


				if (slots[i].stackSize <= 0)
					slots[i] = null;

				Debuging.easterEgg("This is an Easter egg during alloying with a 10 percent chance.", 0.1, MetalFeverMain.modName);
			}
		}
	}

	@Override
	public void updateEntity() {
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;

		if(this.isBurning())
			this.burnTime--;

		if(!worldObj.isRemote) {
			AlloyingRecipe recipe = AlloyFurnaceRecipe.getRecipe(slots[0], slots[1]);
			if(this.burnTime == 0 && this.canAlloy(recipe)) {
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[2]);

				if(this.isBurning()) {
					flag1 = true;

					if(this.slots[2] != null) {
						this.slots[2].stackSize--;

						if(this.slots[2].stackSize == 0)
							this.slots[2] = this.slots[2].getItem().getContainerItem(this.slots[2]);
					}
				}
			}

			if(this.isBurning() && this.canAlloy(recipe)) {
				this.cookTime++;

				if(this.cookTime == this.processingSpeed) {
					this.cookTime = 0;
					this.alloyItem(recipe);
					flag1 = true;
				}
			} else
				cookTime = 0;

			if(flag != this.isBurning()) {
				flag1 = true;
				AlloyFurnace.updateBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if(flag1)
			this.markDirty(); 
	}
}
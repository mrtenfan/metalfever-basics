package ru.mrtenfan.metalfeverbasis.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.ForgeEventFactory;
import ru.mrtenfan.metalfeverbasis.blocks.RecyclingFurnace;
import ru.mrtenfan.metalfeverbasis.crafting.RecyclingFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.crafting.RecyclingFurnaceRecipe.RecyclingRecipe;
import ru.mrtenfan.metalfeverbasis.init.MFItems;

public class TileEntityRecyclingFurnace extends TileEntityBaseFurnace {
	
	public TileEntityRecyclingFurnace() {
		super("container.recyclingFurnace", 4, 800, new int[] {0}, new int[] {2, 3}, new int[] {1});
	}
	
	public static int getItemBurnTime(ItemStack itemStack) {
		return getItemBurnTimeM(itemStack) / 2;
	}

	public static int getItemBurnTimeM(ItemStack itemStack) {
		if(itemStack == null) return 0;
    	int moddedBurnTime = ForgeEventFactory.getFuelBurnTime(itemStack);
    	if (moddedBurnTime >= 0) return moddedBurnTime;
    	
        Item item = itemStack.getItem();

        if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
        {
            Block block = Block.getBlockFromItem(item);

            if (block == Blocks.wooden_slab)
            {
                return 150;
            }

            if (block.getMaterial() == Material.wood)
            {
                return 300;
            }

            if (block == Blocks.coal_block)
            {
                return 1600 * 9;
            }
        }

        if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
        if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
        if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
        if (item == Items.stick) return 100;
        if (item == Items.coal) return 1600;
        if (item == Items.lava_bucket) return 20000;
        if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
        if (item == Items.blaze_rod) return 2400;
		return GameRegistry.getFuelValue(itemStack);
	}
	
	private boolean canRecycle(RecyclingRecipe recipe) {
		if(slots[0] == null) return false;
		
		if(recipe == null || recipe.getResult() == null) return false;
		int i = recipe.getResult().stackSize;
		ItemStack itemStack = recipe.getResult(); 
		ItemStack slag = new ItemStack(MFItems.slag);

		if(slots[2] == null) return true;
		if(!slots[2].isItemEqual(itemStack)) return false;
		if(slots[3] == null) return true;
		if(!slots[3].isItemEqual(slag)) return false;
		else return slots[2].stackSize + i <= 64 && slots[3].stackSize < 32;
	}
	
	private void recycleItem(RecyclingRecipe recipe) {
		if (canRecycle(recipe)) {
			ItemStack itemStack = recipe.getResult();
			ItemStack slag = new ItemStack(MFItems.slag);

			if (slots[2] == null)
				slots[2] = itemStack.copy();
			else if (slots[2].isItemEqual(itemStack)) 
				slots[2].stackSize += itemStack.stackSize;

			if (slots[3] == null)
				slots[3] = slag.copy();
			else if (slots[3].isItemEqual(slag)) 
				slots[3].stackSize += 1;

			if (slots[0].stackSize <= 0)
				slots[0] = new ItemStack(slots[0].getItem().setFull3D());
			else
				slots[0].stackSize--;


			if (slots[0].stackSize <= 0)
				slots[0] = null;
		}
	}
	
	@Override
	public void updateEntity() {
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;

		if(this.isBurning())
			this.burnTime--;

		if(!worldObj.isRemote) {
			RecyclingRecipe recipe = RecyclingFurnaceRecipe.getRecipe(slots[0]);
			if(this.burnTime == 0 && this.canRecycle(recipe)) {
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);

				if(this.isBurning()) {
					flag1 = true;

					if(this.slots[1] != null) {
						this.slots[1].stackSize--;

						if(this.slots[1].stackSize == 0)
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
					}
				}
			}

			if(this.isBurning() && this.canRecycle(recipe)) {
				this.cookTime++;

				if(this.cookTime == this.processingSpeed) {
					this.cookTime = 0;
					this.recycleItem(recipe);
					flag1 = true;
				}
			} else
				cookTime = 0;
			
			if(flag != this.isBurning()) {
				flag1 = true;
				RecyclingFurnace.updateBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if(flag1)
			this.markDirty(); 
	}
}
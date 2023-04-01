package ru.mrtenfan.metalfeverbasis.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.crafting.RecyclingFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.slot.SlotAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.slot.SlotFuel;
import ru.mrtenfan.metalfeverbasis.slot.SlotSlag;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityRecyclingFurnace;

public class ContainerRecyclingFurnace extends Container {

	private TileEntityRecyclingFurnace entity;
	private int lastBurnTime;
	private int lastCookTime;
	private int lastCurrentItemBurnTime;
	
	public ContainerRecyclingFurnace(InventoryPlayer playerInv, TileEntityRecyclingFurnace tileEntity) {
		entity = tileEntity;

		this.addSlotToContainer(new Slot(entity, 0, 56, 18)); //input
		this.addSlotToContainer(new SlotFuel(entity, 1, 56, 53)); //fuel
		this.addSlotToContainer(new SlotAlloyFurnace(playerInv.player, entity, 2, 116, 35)); //output
		this.addSlotToContainer(new SlotSlag(playerInv.player, entity, 3, 141, 35)); //slag output
	      
		for (int i = 0; i < 3; ++i){
	        for (int j = 0; j < 9; ++j){
	            this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	          }
	         }
	    for (int i = 0; i < 9; ++i){
	        this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
	    }
	}
	
	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.entity.cookTime);
		crafting.sendProgressBarUpdate(this, 1, this.entity.burnTime);
		crafting.sendProgressBarUpdate(this, 2, this.entity.currentItemBurnTime);
	}

	//	Tile Entity 0-3: 0-3
	//	Player Inventory 4-30: 4-30
	//	Player Inventory 0-8: 31-40
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerInv, int slotIn) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIn);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if(slotIn == 2 || slotIn == 3) {
            	if(!this.mergeItemStack(itemstack1, 4, 40, true)) {
            		return null;
            	}
            }
            else if(slotIn != 0 && slotIn != 1) {
            	if(RecyclingFurnaceRecipe.getRecipe(itemstack1) != null) {
            		if(!this.mergeItemStack(itemstack1, 0, 1, false)) {
            			return null;
            		}
            	}else if(TileEntityRecyclingFurnace.getItemBurnTime(itemstack1) > 0) {
            		if(!this.mergeItemStack(itemstack1, 1, 2, false)) {
            			return null;
            		}
            	}else if(slotIn >= 4 && slotIn < 31) {
            		if(!this.mergeItemStack(itemstack1, 31, 40, false)) {
            			return null;
            		}
            	}else if(slotIn >= 31 && slotIn < 40 && !this.mergeItemStack(itemstack1, 4, 30, false)) {
            		return null;
            	}
            }else if(!this.mergeItemStack(itemstack1, 4, 40, false)) {
            	return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(playerInv, itemstack1);
        }

        return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return entity.isUseableByPlayer(player);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting par1 = (ICrafting)this.crafters.get(i);
			
			if (this.lastCookTime != this.entity.cookTime) {
				par1.sendProgressBarUpdate(this, 0, this.entity.cookTime);
			}
			if (this.lastBurnTime != this.entity.burnTime) {
				par1.sendProgressBarUpdate(this, 1, this.entity.burnTime);
			}
			if (this.lastCurrentItemBurnTime != this.entity.currentItemBurnTime) {
				par1.sendProgressBarUpdate(this, 2, this.entity.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.entity.cookTime;
		this.lastBurnTime = this.entity.burnTime;
		this.lastCurrentItemBurnTime = this.entity.currentItemBurnTime;
	}
	
	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			entity.cookTime = j;
		}
		
		if (i == 1) {
			entity.burnTime = j;
		}
		
		if (i == 2) {
			entity.currentItemBurnTime = j;
		}
	}
}
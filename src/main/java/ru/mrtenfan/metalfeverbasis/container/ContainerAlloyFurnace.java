package ru.mrtenfan.metalfeverbasis.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.slot.SlotAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.slot.SlotFuel;
import ru.mrtenfan.metalfeverbasis.slot.SlotSlag;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityAlloyFurnace;

public class ContainerAlloyFurnace extends Container {

	private TileEntityAlloyFurnace alloyfurnace;
	private int lastBurnTime;
	private int lastCookTime;
	private int lastCurrentItemBurnTime;
	
	public ContainerAlloyFurnace(InventoryPlayer playerInv, TileEntityAlloyFurnace tileEntity) {
		
		alloyfurnace = tileEntity;
		
		this.addSlotToContainer(new Slot(alloyfurnace, 0, 45, 17)); //input 1
		this.addSlotToContainer(new Slot(alloyfurnace, 1, 67, 17)); //input 2
		this.addSlotToContainer(new SlotFuel(alloyfurnace, 2, 56, 53)); //fuel
		this.addSlotToContainer(new SlotAlloyFurnace(playerInv.player, alloyfurnace, 3, 116, 35)); //output
		this.addSlotToContainer(new SlotSlag(playerInv.player, alloyfurnace, 4, 141, 35)); //slag output
	      
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
		crafting.sendProgressBarUpdate(this, 0, this.alloyfurnace.cookTime);
		crafting.sendProgressBarUpdate(this, 1, this.alloyfurnace.burnTime);
		crafting.sendProgressBarUpdate(this, 2, this.alloyfurnace.currentItemBurnTime);
	}

	//	Tile Entity 0-4: 0-4
	//	Player Inventory 5-31: 5-31
	//	Player Inventory 0-8: 32-41
	@Override
    public ItemStack transferStackInSlot(EntityPlayer playerInv, int slotIn)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIn);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if(slotIn == 3 || slotIn == 4) {
            	if(!this.mergeItemStack(itemstack1, 5, 41, true)) {
            		return null;
            	}
            }
            else if(slotIn != 0 && slotIn != 1 && slotIn != 2) {
            	if(AlloyFurnaceRecipe.isUsedForRecipe(itemstack1)) {
            		if(!this.mergeItemStack(itemstack1, 0, 2, false)) {
            			return null;
            		}
            	}else if(TileEntityAlloyFurnace.hasItemBurnTime(itemstack1)) {
            		if(!this.mergeItemStack(itemstack1, 1, 2, false)) {
            			return null;
            		}
            	}else if(slotIn >= 5 && slotIn < 32) {
            		if(!this.mergeItemStack(itemstack1, 32, 41, false)) {
            			return null;
            		}
            	}else if(slotIn >= 32 && slotIn < 41 && !this.mergeItemStack(itemstack1, 5, 31, false)) {
            		return null;
            	}
            }else if(!this.mergeItemStack(itemstack1, 5, 41, false)) {
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
		
		return alloyfurnace.isUseableByPlayer(player);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting par1 = (ICrafting)this.crafters.get(i);
			
			if (this.lastCookTime != this.alloyfurnace.cookTime) {
				par1.sendProgressBarUpdate(this, 0, this.alloyfurnace.cookTime);
			}
			if (this.lastBurnTime != this.alloyfurnace.burnTime) {
				par1.sendProgressBarUpdate(this, 1, this.alloyfurnace.burnTime);
			}
			if (this.lastCurrentItemBurnTime != this.alloyfurnace.currentItemBurnTime) {
				par1.sendProgressBarUpdate(this, 2, this.alloyfurnace.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.alloyfurnace.cookTime;
		this.lastBurnTime = this.alloyfurnace.burnTime;
		this.lastCurrentItemBurnTime = this.alloyfurnace.currentItemBurnTime;
	}
	
	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			alloyfurnace.cookTime = j;
		}
		
		if (i == 1) {
			alloyfurnace.burnTime = j;
		}
		
		if (i == 2) {
			alloyfurnace.currentItemBurnTime = j;
		}
	}
}

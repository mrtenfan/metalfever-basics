package ru.mrtenfan.metalfeverbasis.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBaseFurnace extends TileEntity implements ISidedInventory {
	
	protected String localyzedName;
	protected ItemStack slots[];
	protected String containerName;

	public int processingSpeed;
	public int burnTime;
	public int currentItemBurnTime;
	public int cookTime;

	protected final int[] slots_top;
	protected final int[] slots_bottom;
	protected final int[] slots_side;
	
	public TileEntityBaseFurnace(String conName, int numberOfSlots, int procSpeed, int[] top, int[] bottom, int[]side) {
		this.slots = new ItemStack[numberOfSlots];
		this.containerName = conName;	
		this.processingSpeed = procSpeed;
		this.slots_top = top;
		this.slots_bottom = bottom;
		this.slots_side = side;
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return slots[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int decr) {
		if (slots[slot] != null) {
			if (slots[slot].stackSize <= decr) {
				ItemStack itemStack = slots[slot];
				slots[slot] = null;
				return itemStack;
			}

			ItemStack itemStack1 = slots[slot].splitStack(decr);

			if (slots[slot].stackSize == 0)
				slots[slot] = null;

			return itemStack1;
		} else
			return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return slots[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		slots[slot] = itemStack;
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
			itemStack.stackSize = getInventoryStackLimit();
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.localyzedName : containerName;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.localyzedName != null && this.localyzedName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return side == 0 ? slots_bottom : (side == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack itemStack, int var3) {
		return this.isItemValidForSlot(var1, itemStack);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack itemStack, int var3) {
		return var3 != 0 || var1 != 1;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		slots = new ItemStack[getSizeInventory()];

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound nbt1 = (NBTTagCompound)list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");

			if (b0 >= 0 && b0 < slots.length) {
				slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}

		cookTime = nbt.getShort("CookTime");
		burnTime = nbt.getShort("BurnTime");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("CookTime", (short)cookTime);
		nbt.setShort("BurnTime", (short)burnTime);
		NBTTagList list = new NBTTagList();

		for (int i = 0; i < slots.length; i++ ) {
			if (slots[i] != null) {
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte)i);
				slots[i].writeToNBT(nbt1);
				list.appendTag(nbt1);
			}
		}

		nbt.setTag("Items", list);
	}

	public boolean isBurning() {
		return burnTime > 0;
	}

	public boolean isAlloying() {
		return this.cookTime > 0;
	}

	public int getAlloyProgressScaled(int i) {
		return this.cookTime * i / processingSpeed;
	}

	public int getBurnTimeRemainingScaled(int i) {
		if (this.currentItemBurnTime == 0)
		{
			this.currentItemBurnTime = processingSpeed;
		}
		return this.burnTime * i / this.currentItemBurnTime;
	}
}
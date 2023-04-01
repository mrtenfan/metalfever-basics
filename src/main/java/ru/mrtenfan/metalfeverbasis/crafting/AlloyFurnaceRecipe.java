package ru.mrtenfan.metalfeverbasis.crafting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.MTFCore.utils.ItemUtils;
import ru.mrtenfan.MTFCore.utils.OreStack;

public class AlloyFurnaceRecipe {

    public static ArrayList<AlloyingRecipe> recipes = new ArrayList<AlloyingRecipe>();
    public static List<AlloyingFuel> fuels = new ArrayList<AlloyingFuel>();
    
    public static void fuelInit() {
    	fuels.add(new AlloyingFuel(new ItemStack(Items.coal), 400));
    }

	public static void addRecipe(AlloyingRecipe recipe) {
		recipes.add(recipe);
	}

	/**adding new recipes for Alloy Furnace.Map: [input1, input2], output */
    public static void addAlloyingRecipe(Object[] input, ItemStack output) {
        if(!(input[0] instanceof ItemStack || input[0] instanceof OreStack))
        	throw new RuntimeException("Alloying recipe input is invalid!");

        if(!(input[1] instanceof ItemStack || input[1] instanceof OreStack))
        	throw new RuntimeException("Alloying recipe input is invalid!");

        recipes.add(new AlloyingRecipe(input, output));
    }

	/**adding new recipes for Alloy Furnace.Map: input1, input2, output */
    public static void addAlloyingRecipe(Object input1, Object input2, ItemStack output) {
        if(!(input1 instanceof ItemStack || input1 instanceof OreStack))
        	throw new RuntimeException("Alloying recipe input is invalid!");

        if(!(input2 instanceof ItemStack || input2 instanceof OreStack))
        	throw new RuntimeException("Alloying recipe input is invalid!");

        recipes.add(new AlloyingRecipe(input1, input2, output));
    }
    		
    public static AlloyingRecipe getRecipe(ItemStack slot1, ItemStack slot2) {
    	for(AlloyingRecipe recipe : recipes) {
    		if(getOutput(slot1, slot2, recipe.getInput())) return recipe;
    	}
		return null;
    }
	
	public static boolean getOutput(ItemStack item, ItemStack item2, Object[] inputs) {
		if(item == null || item2 == null)
			return false;
		for(Object obj : inputs) {
			if(obj instanceof ItemStack) {
				ItemStack is = (ItemStack)obj;
				if(!((ItemUtils.isItemEqual(item, is, false) || ItemUtils.isItemEqual(item2, is, false)) && (item.stackSize >= is.stackSize || item2.stackSize >= is.stackSize)))
					return false;
			} else if(obj instanceof OreStack) {
				OreStack os = (OreStack)obj;
				if(!((ItemUtils.isItemEqual(item, os.getStack(), true) || ItemUtils.isItemEqual(item2, os.getStack(), true)) && (item.stackSize >= os.stackSize || item2.stackSize >= os.stackSize)))
					return false;
			} else
				return false;
		}
		return true;
	}

	public static boolean isUsedForRecipe(ItemStack itemStack) {
		for(AlloyingRecipe recipe : recipes)
			if(recipe.isUsedInRecipe(itemStack))
				return true;
		return false;
	}
	
	public static class AlloyingFuel {
		private final ItemStack fuel;
		private final int burnTime;
		
		public AlloyingFuel(ItemStack itemStack, int burn){
			this.fuel = itemStack;
			this.burnTime = burn;
		}
		
		public int getBurnTime() {
			return burnTime;
		}

		public ItemStack getItem() {
			return fuel;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == null || o == null) return false;
			if(!(o instanceof AlloyingFuel)) return false;
			AlloyingFuel f = (AlloyingFuel)o;
			return ItemUtils.isItemEqual(this.getItem(), f.getItem(), true) ? this.getBurnTime() == f.getBurnTime() : false;
		}
	}
    
    public static class AlloyingRecipe {
        private final Object[] input = new Object[2];
        private final ItemStack result;
        private final ArrayList<AlloyingFuel> fuel = (ArrayList<AlloyingFuel>)fuels;

        public AlloyingRecipe(Object[] input2, ItemStack result) {
        	if(!(input2[0] instanceof ItemStack || input2[0] instanceof OreStack || input2[1] instanceof ItemStack || input2[1] instanceof OreStack)) 
        		throw new RuntimeException("Input must be ItemStack or OreStack(OreDictionary)");
            this.input[0] = input2[0];
            this.input[1] = input2[1];
            this.result = result;
        }

		public AlloyingRecipe(Object oInput1, Object oInput2, ItemStack result) {
        	if(!(oInput1 instanceof ItemStack || oInput1 instanceof OreStack || oInput2 instanceof ItemStack || oInput2 instanceof OreStack))
        		throw new RuntimeException("Input must be ItemStack or OreStack(OreDictionary)");
			this.input[0] = oInput1;
			this.input[1] = oInput2;
            this.result = result;
		}

		public ItemStack getResult() {
            return result;
        }
		
		public Object[] getInput() {
			return input;
		}
		
		public Object getInput(int i) {
			return input[i];
		}
		
		public ArrayList<AlloyingFuel> getFuel() {
			return fuel;
		}
		
		public int[] getInputNumbers(ItemStack slot1, ItemStack slot2) {
			int[] ret = new int[2];
			if(input[0] instanceof OreStack) {
				if(ItemUtils.isItemEqual(((OreStack)input[0]).getStack(), slot1, true))
					ret[0] = ((OreStack)input[0]).stackSize;
				else
					ret[1] = ((OreStack)input[0]).stackSize;
			} else if(input[0] instanceof ItemStack) {
				if(ItemUtils.isItemEqual(((ItemStack)input[0]), slot1, false))
					ret[0] = ((ItemStack)input[0]).stackSize;
				else
					ret[1] = ((ItemStack)input[0]).stackSize;
			}
			if(input[1] instanceof OreStack) {
				if(ItemUtils.isItemEqual(((OreStack)input[1]).getStack(), slot2, true))
					ret[1] = ((OreStack)input[1]).stackSize;
				else
					ret[0] = ((OreStack)input[1]).stackSize;
			} else if(input[1] instanceof ItemStack) {
				if(ItemUtils.isItemEqual(((ItemStack)input[1]), slot2, false))
					ret[1] = ((ItemStack)input[1]).stackSize;
				else
					ret[0] = ((ItemStack)input[1]).stackSize;
			}
			return ret;
		}
		
		public boolean isUsedInRecipe(ItemStack itemStack) {
			for(int i = 0; i < 2; i++) {
				if(input[i] instanceof OreStack) {
					if(ItemUtils.isItemEqual(((OreStack)input[i]).getStack(), itemStack, true))
						return true;
				} else if(input[i] instanceof ItemStack) {
					if(ItemUtils.isItemEqual(input[i], itemStack, false))
						return true;
				}
			}
			return false;
		}
		
		@Override
		public String toString() {
			return "(" + result + ")=A(" + input[0] + ")&(" + input[1] + ")";
		}
    }
}

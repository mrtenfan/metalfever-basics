package ru.mrtenfan.metalfeverbasis.crafting;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import ru.mrtenfan.MTFCore.utils.ItemUtils;
import ru.mrtenfan.MTFCore.utils.OreStack;

public class RecyclingFurnaceRecipe {

	public static ArrayList<RecyclingRecipe> recipes = new ArrayList<RecyclingRecipe>();

	public static void addRecipe(RecyclingRecipe recipe) {
		recipes.add(recipe);
	}

	public static void addRecyclingRecipe(Object input, ItemStack result) {
		addRecipe(new RecyclingRecipe(input, result));
	}

	public static RecyclingRecipe getRecipe(ItemStack itemStack) {
		for(RecyclingRecipe recipe : recipes) {
			if(getOutput(itemStack, recipe.getInput())) return recipe;
		}
		return null;
	}

	private static boolean getOutput(ItemStack itemStack, Object input) {
		if(input == null) return false;
		if(input instanceof OreStack)
			return ItemUtils.isItemEqual(((OreStack)input).getStack(), itemStack, true) && itemStack.stackSize >= ((OreStack)input).stackSize;
		else
			return ItemUtils.isItemEqual((ItemStack)input, itemStack, false) && itemStack.stackSize >= ((ItemStack)input).stackSize;
	}

	public static class RecyclingRecipe {		
		private final Object input;
		private final ItemStack result;

		public RecyclingRecipe(Object input, ItemStack output) {
			if(!(input instanceof ItemStack || input instanceof OreStack))
				throw new RuntimeException("Input isn't ItemStack or OreStack");
			this.input = input;
			this.result = output;
		}

		public Object getInput() {
			return input;
		}

		public ItemStack getResult() {
			return result;
		}

		public boolean isUsedInRecipe(ItemStack is) {
			return (input instanceof OreStack) ? ItemUtils.isItemEqual(((OreStack)input).getStack(), is, true) : ItemUtils.isItemEqual((ItemStack)input, is, false);
		}

		@Override
		public String toString() {
			return "(" + result + ")=R(" + input + ")";
		}
	}
}
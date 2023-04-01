package ru.mrtenfan.metalfeverbasis.integration.minetweaker;

import java.util.ArrayList;
import java.util.List;

import minetweaker.IUndoableAction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.MTFCore.Debuging;
import ru.mrtenfan.MTFCore.utils.ItemUtils;
import ru.mrtenfan.MTFCore.utils.MinetweakerUtils;
import ru.mrtenfan.metalfeverbasis.MetalFeverMain;
import ru.mrtenfan.metalfeverbasis.crafting.RecyclingFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.crafting.RecyclingFurnaceRecipe.RecyclingRecipe;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.metalfever.RecyclingFurnace")
public class MTRecyclingFurnace {

	public static final String name = "Metal Fever Basis Recycling Furnace";

	@ZenMethod
	public static void addRecipe(IIngredient  input1, IItemStack output) {
		Object oInput1 = MinetweakerUtils.toIoOStack(input1);
		System.out.println(input1 + ":" + oInput1);
		if(oInput1 == null) {
			Debuging.errorOutput("Some input is null!", MetalFeverMain.modName);
			return;
		}
		ItemStack oResult = MinetweakerUtils.toStack(output);
		
		addRecipe(new RecyclingRecipe(oInput1, oResult));
	}

	@ZenMethod
	public static void removeRecipe(IItemStack output) {
		MineTweakerAPI.apply(new Remove(MinetweakerUtils.toStack(output)));
	}

	public static void addRecipe(RecyclingRecipe r) {
		MineTweakerAPI.apply(new Add(r));
	}

	private static class Add implements IUndoableAction {
		private final RecyclingRecipe recipe;

		public Add(RecyclingRecipe r) {
			this.recipe = r;
		}

		@Override
		public void apply() {
			RecyclingFurnaceRecipe.addRecipe(recipe);
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			for (RecyclingRecipe recipeType : RecyclingFurnaceRecipe.recipes) {
				if(recipeType == recipe) {
					RecyclingFurnaceRecipe.recipes.remove(recipeType);
					break;
				}
			}
		}

		@Override
		public String describe() {
			return "Adding " + name + " recipe for " + recipe.getResult().getDisplayName();
		}

		@Override
		public String describeUndo() {
			return "Removing " + name + " recipe for " + recipe.getResult().getDisplayName();
		}

		@Override
		public Object getOverrideKey() {
			return "add@:" + recipe.getResult();
		}
	}

	private static class Remove implements IUndoableAction {
		private final ItemStack output;
		List<RecyclingRecipe> removedRecipes = new ArrayList<RecyclingRecipe>();

		public Remove(ItemStack output) {
			this.output = output;
		}

		@Override
		public void apply() {
			for (RecyclingRecipe recipeType : RecyclingFurnaceRecipe.recipes) {
				if (ItemUtils.isItemEqual(recipeType.getResult(), output, true)) {
					removedRecipes.add((RecyclingRecipe) recipeType);
					RecyclingFurnaceRecipe.recipes.remove(recipeType);
					break;
				}
			}
		}

		@Override
		public void undo() {
			if (removedRecipes != null) {
				for (RecyclingRecipe recipe : removedRecipes) {
					if (recipe != null) {
						RecyclingFurnaceRecipe.addRecipe(recipe);
					}
				}
			}
		}

		@Override
		public String describe() {
			return "Removing " + name + " recipe for " + output.getDisplayName();
		}

		@Override
		public String describeUndo() {
			return "Re-Adding " + name + " recipe for " + output.getDisplayName();
		}

		@Override
		public Object getOverrideKey() {
			return "remove@:" + output;
		}

		@Override
		public boolean canUndo() {
			return true;
		}
	}
}
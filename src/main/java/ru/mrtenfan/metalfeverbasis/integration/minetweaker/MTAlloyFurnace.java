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
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe.AlloyingFuel;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe.AlloyingRecipe;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.metalfever.AlloyFurnace")
public class MTAlloyFurnace {

	public static final String name = "Metal Fever Basis Alloy Furnace";

	@ZenMethod
	public static void addRecipe(IIngredient  input1, IIngredient  input2, IItemStack output) {
		Object oInput1 = MinetweakerUtils.toIoOStack(input1);
		Object oInput2 = MinetweakerUtils.toIoOStack(input2);
		if(oInput1 == null || oInput2 == null) {
			Debuging.errorOutput("Some input is null!", MetalFeverMain.modName);
			return;
		}
		ItemStack oResult = MinetweakerUtils.toStack(output);
		
		addRecipe(new AlloyingRecipe(oInput1, oInput2, oResult));
	}

	@ZenMethod
	public static void removeRecipe(IItemStack output) {
		MineTweakerAPI.apply(new Remove(MinetweakerUtils.toStack(output)));
	}

	@ZenMethod
	public static void addFuel(IItemStack fuel, int numberOfAlloying) {
		MineTweakerAPI.apply(new AddFuel(MinetweakerUtils.toStack(fuel), numberOfAlloying * 200));
	}

	@ZenMethod
	public static void removeFuel(IItemStack fuel) {
		MineTweakerAPI.apply(new RemoveFuel(MinetweakerUtils.toStack(fuel)));
	}

	public static void addRecipe(AlloyingRecipe r) {
		MineTweakerAPI.apply(new Add(r));
	}

	private static class Add implements IUndoableAction {
		private final AlloyingRecipe recipe;

		public Add(AlloyingRecipe r) {
			this.recipe = r;
		}

		@Override
		public void apply() {
			AlloyFurnaceRecipe.addRecipe(recipe);
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			for (AlloyingRecipe recipeType : AlloyFurnaceRecipe.recipes) {
				if(recipeType == recipe) {
					AlloyFurnaceRecipe.recipes.remove(recipeType);
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

		//recipe.getResult()
		@Override
		public Object getOverrideKey() {
			return "add@r:" + recipe.getResult();
		}
	}

	private static class AddFuel implements IUndoableAction {
		private final ItemStack fuel;
		private final int burnTime;

		public AddFuel(ItemStack stack, int burn) {
			this.fuel = stack;
			this.burnTime = burn;
		}

		@Override
		public void apply() {
			AlloyFurnaceRecipe.fuels.add(new AlloyingFuel(fuel, burnTime));
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			for (AlloyingFuel fuels : AlloyFurnaceRecipe.fuels) {
				if(ItemUtils.isItemEqual(fuels.getItem(), fuel, true)) {
					AlloyFurnaceRecipe.fuels.remove(fuels);
					break;
				}
			}
		}

		@Override
		public String describe() {
			return "Adding " + name + " fuel " + fuel.getDisplayName();
		}

		@Override
		public String describeUndo() {
			return "Removing " + name + " fuel " + fuel.getDisplayName();
		}

		@Override
		public Object getOverrideKey() {
			return "add@f:" + fuel;
		}
	}

	private static class Remove implements IUndoableAction {
		private final ItemStack output;
		List<AlloyingRecipe> removedRecipes = new ArrayList<AlloyingRecipe>();

		public Remove(ItemStack output) {
			this.output = output;
		}

		@Override
		public void apply() {
			for (AlloyingRecipe recipeType : AlloyFurnaceRecipe.recipes) {
				if (ItemUtils.isItemEqual(recipeType.getResult(), output, true)) {
					removedRecipes.add((AlloyingRecipe) recipeType);
					AlloyFurnaceRecipe.recipes.remove(recipeType);
					break;
				}
			}
		}

		@Override
		public void undo() {
			if (removedRecipes != null) {
				for (AlloyingRecipe recipe : removedRecipes) {
					if (recipe != null) {
						AlloyFurnaceRecipe.addRecipe(recipe);
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
			return "remove@r:" + output;
		}

		@Override
		public boolean canUndo() {
			return true;
		}
	}
	
	private static class RemoveFuel implements IUndoableAction {
		private final ItemStack fuel;
		List<AlloyingFuel> removedFuels = new ArrayList<AlloyingFuel>();

		public RemoveFuel(ItemStack itemStack) {
			this.fuel = itemStack;
		}

		@Override
		public void apply() {
			for(AlloyingFuel fuels : AlloyFurnaceRecipe.fuels) {
				if(ItemUtils.isItemEqual(fuels.getItem(), fuel, false)) {
					removedFuels.add(fuels);
					AlloyFurnaceRecipe.fuels.remove(fuels);
					break;
				}
			}
		}

		@Override
		public void undo() {
			if (removedFuels != null) {
				for (AlloyingFuel fuels : removedFuels) {
					if (fuels != null) {
						AlloyFurnaceRecipe.fuels.add(fuels);
					}
				}
			}
		}

		@Override
		public String describe() {
			return "Removing " + name + " fuel " + fuel.getDisplayName();
		}

		@Override
		public String describeUndo() {
			return "Re-Adding " + name + " fuel " + fuel.getDisplayName();
		}

		@Override
		public Object getOverrideKey() {
			return "remove@f:" + fuel;
		}

		@Override
		public boolean canUndo() {
			return true;
		}
	}
}
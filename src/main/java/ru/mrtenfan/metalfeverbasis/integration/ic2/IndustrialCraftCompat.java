package ru.mrtenfan.metalfeverbasis.integration.ic2;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.init.MFBlocks;
import ru.mrtenfan.metalfeverbasis.init.MFItems;

public class IndustrialCraftCompat {

	public static void compatInit() {
		registerMaceratorRecipe(new ItemStack(MFBlocks.metals_ore, 1, 0), new ItemStack(MFItems.metals_dust, 2, 0));
		registerMaceratorRecipe(new ItemStack(MFBlocks.metals_ore, 1, 3), new ItemStack(MFItems.metals_dust, 2, 3));
		registerMaceratorRecipe(new ItemStack(MFBlocks.metals_ore, 1, 4), new ItemStack(MFItems.metals_dust, 2, 4));
		registerMaceratorRecipe(new ItemStack(MFBlocks.metals_ore, 1, 7), new ItemStack(MFItems.metals_dust, 2, 7));
		registerMaceratorRecipe(new ItemStack(MFBlocks.metals_ore, 1, 8), new ItemStack(MFItems.metals_dust, 2, 10));
		registerMaceratorRecipe(new ItemStack(MFBlocks.metals_ore, 1, 9), new ItemStack(MFItems.metals_dust, 2, 11));
		registerMaceratorRecipe(new ItemStack(MFBlocks.metals_ore, 1, 10), new ItemStack(MFItems.metals_dust, 2, 12));
		registerMaceratorRecipe(new ItemStack(MFItems.metals_ingot, 1, 0), new ItemStack(MFItems.metals_dust, 1, 0));
		registerMaceratorRecipe(new ItemStack(MFItems.metals_ingot, 1, 3), new ItemStack(MFItems.metals_dust, 1, 3));
		registerMaceratorRecipe(new ItemStack(MFItems.metals_ingot, 1, 4), new ItemStack(MFItems.metals_dust, 1, 4));
		registerMaceratorRecipe(new ItemStack(MFItems.metals_ingot, 1, 7), new ItemStack(MFItems.metals_dust, 1, 7));
		registerMaceratorRecipe(new ItemStack(MFItems.metals_ingot, 1, 8), new ItemStack(MFItems.metals_dust, 1, 10));
		registerMaceratorRecipe(new ItemStack(MFItems.metals_ingot, 1, 9), new ItemStack(MFItems.metals_dust, 1, 11));
		registerMaceratorRecipe(new ItemStack(MFItems.metals_ingot, 1, 10), new ItemStack(MFItems.metals_dust, 1, 12));
		registerMaceratorRecipe(new ItemStack(MFItems.alloys_ingot, 1, 1), new ItemStack(MFItems.alloys_dust, 1, 1));
		registerMaceratorRecipe(new ItemStack(MFItems.alloys_ingot, 1, 2), new ItemStack(MFItems.alloys_dust, 1, 2));
		registerMaceratorRecipe(new ItemStack(MFItems.alloys_ingot, 1, 3), new ItemStack(MFItems.alloys_dust, 1, 3));
		registerMaceratorRecipe(new ItemStack(MFItems.alloys_ingot, 1, 4), new ItemStack(MFItems.alloys_dust, 1, 4));
		registerMaceratorRecipe(new ItemStack(MFItems.alloys_ingot, 1, 6), new ItemStack(MFItems.alloys_dust, 1, 6));
	}
	
	public static void registerMaceratorRecipe(ItemStack input, ItemStack output) {
		registerMaceratorRecipe(new RecipeInputItemStack(input), output);
	}
	
	private static void registerMaceratorRecipe(IRecipeInput input, ItemStack output) {
		Recipes.macerator.addRecipe(input, null, output);
	}
}

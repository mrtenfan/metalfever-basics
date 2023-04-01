package ru.mrtenfan.metalfeverbasis.integration.NEI;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.MTFCore.Debuging;
import ru.mrtenfan.MTFCore.utils.ItemUtils;
import ru.mrtenfan.MTFCore.utils.OreStack;
import ru.mrtenfan.metalfeverbasis.MetalFeverMain;
import ru.mrtenfan.metalfeverbasis.GUI.GUIAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe.AlloyingFuel;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe.AlloyingRecipe;

public class AlloyFurnaceRecipeHandler extends TemplateRecipeHandler {

	public Class <?extends GuiContainer> getGuiClass() {
		return GUIAlloyFurnace.class;
	}

	public class CachedAlloyingRecipe extends CachedRecipe {

		public final List<PositionedStack> input = new ArrayList<PositionedStack>();
		public final PositionedStack output;

		@Override
		public List<PositionedStack> getIngredients() {
			return this.getCycledIngredients(AlloyFurnaceRecipeHandler.this.cycleticks / 20, this.input);
		}

		@Override
		public PositionedStack getResult () {
			return this.output;
		}

		public CachedAlloyingRecipe(AlloyingRecipe recipe) {
			if (recipe == null){
				throw new NullPointerException("Recipe must not be null.");
			} else {
				if(recipe.getInput(0) instanceof OreStack)
					this.input.add(new PositionedStack(((OreStack)recipe.getInput(0)).getStacks(), 33, 9));
				else if(recipe.getInput(0) instanceof ItemStack)
					this.input.add(new PositionedStack(((ItemStack)recipe.getInput(0)), 33, 9));
				else
					Debuging.warnOutput("Not possible to init a recipe of " + recipe.getResult(), MetalFeverMain.modName);
				if(recipe.getInput(1) instanceof OreStack)
					this.input.add(new PositionedStack(((OreStack)recipe.getInput(1)).getStacks(), 55, 9));
				else if(recipe.getInput(1) instanceof ItemStack)
					this.input.add(new PositionedStack(((ItemStack)recipe.getInput(1)), 55, 9));
				else
					Debuging.warnOutput("Not possible to init a recipe of " + recipe.getResult(), MetalFeverMain.modName);
				this.output = new PositionedStack(recipe.getResult(), 104, 27);
				this.input.add(new PositionedStack(getItemStackFromAllFuel(recipe.getFuel()), 44, 45));
			}
		}
	}

	@Override
	public int recipiesPerPage() {
		return 2;
	}

	public List<ItemStack> getItemStackFromAllFuel(ArrayList<AlloyingFuel> fuel) {
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		for(AlloyingFuel f : fuel) {
			list.add(f.getItem());
		}
		return list;
	}

	public String getRecipeID() {
		return "mtf.alloyFurnace";
	}

	@Override
	public void loadTransferRects () {
		this.transferRects.add(new RecipeTransferRect(new Rectangle(70, 28, 28, 21), this.getRecipeID(), new Object[0]));
	}

	@Override
	public String getRecipeName() {
		return I18n.format("container.alloyFurnace", new Object[0]);
	}

	@Override
	public String getGuiTexture() {
		return "metalfeverbasis:textures/gui/alloy_furnace_GUI_NEI.png";
	}

	public String getOverlayIdentifier() {
		return "alloyFurnace";
	}

	public void drawBackground(int recipeNumber) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GuiDraw.changeTexture(this.getGuiTexture());
		GuiDraw.drawTexturedModalRect(0, 0, -1, 5, 150, 80);
	}

	public void drawExtras(int recipeNumber) {
		float f = this.cycleticks >= 20 ? (float)((this.cycleticks - 20) % 60) / 60.0F : 0.0F;
		this.drawProgressBar(66, 26, 160, 0, 24, 17, f, 0);
		this.drawProgressBar(44, 28, 160, 17, 14, 14, f, 7);
	}

	@Override
	public void loadCraftingRecipes (String outputId, Object... results) {
		if (outputId.equals(this.getRecipeID())) {
			for (AlloyingRecipe alloying : AlloyFurnaceRecipe.recipes) {
				this.arecipes.add(new CachedAlloyingRecipe(alloying));
			}
		}
		else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes (ItemStack result) {
		for (AlloyingRecipe alloying : AlloyFurnaceRecipe.recipes) {
			if (NEIServerUtils.areStacksSameTypeCrafting(alloying.getResult(), result) && ItemUtils.isItemEqual(alloying.getResult(), result, true)) {
				this.arecipes.add(new CachedAlloyingRecipe(alloying));
			}
		}
	}

	@Override
	public void loadUsageRecipes (ItemStack ingred) {
		for (AlloyingRecipe alloying : AlloyFurnaceRecipe.recipes) {
			Object input1 = alloying.getInput(0), input2 = alloying.getInput(1);
			if((input1 instanceof OreStack)
					? NEIServerUtils.areStacksSameTypeCrafting(((OreStack)input1).getStack(), ingred) && ItemUtils.isItemEqual(((OreStack)input1).getStack(), ingred, true)
							: NEIServerUtils.areStacksSameTypeCrafting(((ItemStack)input1), ingred) && ItemUtils.isItemEqual(((ItemStack)input1), ingred, false)
							|| (input2 instanceof OreStack) ? NEIServerUtils.areStacksSameTypeCrafting(((OreStack)input2).getStack(), ingred) && ItemUtils.isItemEqual(((OreStack)input2).getStack(), ingred, true)
									: NEIServerUtils.areStacksSameTypeCrafting(((ItemStack)input2), ingred) && ItemUtils.isItemEqual(((ItemStack)input2), ingred, false))
				this.arecipes.add(new CachedAlloyingRecipe(alloying));
		}
	}
}
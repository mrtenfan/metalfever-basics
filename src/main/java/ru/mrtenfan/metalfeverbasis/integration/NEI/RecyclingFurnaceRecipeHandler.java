package ru.mrtenfan.metalfeverbasis.integration.NEI;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lwjgl.opengl.GL11;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.ItemList;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import ru.mrtenfan.MTFCore.utils.ItemUtils;
import ru.mrtenfan.MTFCore.utils.OreStack;
import ru.mrtenfan.metalfeverbasis.GUI.GUIRecyclingFurnace;
import ru.mrtenfan.metalfeverbasis.crafting.RecyclingFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.crafting.RecyclingFurnaceRecipe.RecyclingRecipe;

public class RecyclingFurnaceRecipeHandler extends TemplateRecipeHandler {

	public Class <?extends GuiContainer> getGuiClass() {
		return GUIRecyclingFurnace.class;
	}

	public class CachedRecyclingRecipe extends CachedRecipe {

		public final List<PositionedStack> input = new ArrayList<PositionedStack>();
		private final PositionedStack result;

		@Override
		public List<PositionedStack> getIngredients() {
			return this.getCycledIngredients(RecyclingFurnaceRecipeHandler.this.cycleticks / 20, this.input);
		}

		@Override
		public PositionedStack getResult() {
			return result;
		}

        public PositionedStack getOtherStack() {
            return afuels.get((cycleticks / 48) % afuels.size()).stack;
        }

		public CachedRecyclingRecipe(RecyclingRecipe recipe) {
			if(recipe == null)
				throw new NullPointerException("Recipe must not be null.");
			else {
				if(recipe.getInput() instanceof OreStack)
					this.input.add(new PositionedStack(((OreStack)recipe.getInput()).getStacks(), 41, 5));
				else
					this.input.add(new PositionedStack((ItemStack)recipe.getInput(), 41, 5));
				this.result = new PositionedStack(recipe.getResult(), 101, 22);
			}
		}
	}

	@Override
	public int recipiesPerPage() {
		return 2;
	}

	public String getRecipeID() {
        return "mtf.recyclingFurnace";
    }

    @Override
    public void loadTransferRects () {
        this.transferRects.add(new RecipeTransferRect(new Rectangle(70, 28, 28, 21), this.getRecipeID(), new Object[0]));
    }
    
	@Override
	public String getRecipeName() {
		return I18n.format("container.recyclingFurnace", new Object[0]);
	}

	@Override
	public String getGuiTexture() {
		return "metalfeverbasis:textures/gui/recycling_furnace_GUI_NEI.png";
	}
	
    public String getOverlayIdentifier() {
        return "recyclingFurnace";
    }
    
    public void drawBackground(int recipeNumber) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GuiDraw.changeTexture(this.getGuiTexture());
        GuiDraw.drawTexturedModalRect(0, 0, -1, 5, 150, 80);
    }
    
    public void drawExtras(int recipeNumber) {
          float f = this.cycleticks >= 160 ? (float)((this.cycleticks - 160) % 160) / 160.0F : 0.0F;
          this.drawProgressBar(63, 21, 154, 0, 24, 17, f, 0);
          this.drawProgressBar(40, 22, 154, 16, 14, 14, f, 7);
    }

    @Override
    public void loadCraftingRecipes (String outputId, Object... results) {
        if (outputId.equals(this.getRecipeID())) {
            for (RecyclingRecipe recipe : RecyclingFurnaceRecipe.recipes) {
                this.arecipes.add(new CachedRecyclingRecipe(recipe));
            }
        }
        else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes (ItemStack result) {
        for (RecyclingRecipe recipe : RecyclingFurnaceRecipe.recipes) {
            if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getResult(), result) && ItemUtils.isItemEqual(recipe.getResult(), result, true)) {
                this.arecipes.add(new CachedRecyclingRecipe(recipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes (ItemStack ingred) {
    	for (RecyclingRecipe recipe : RecyclingFurnaceRecipe.recipes) {
    		Object input = recipe.getInput();
    		if((input instanceof OreStack)
    				? NEIServerUtils.areStacksSameTypeCrafting(((OreStack)input).getStack(), ingred) && ItemUtils.isItemEqual(((OreStack)input).getStack(), ingred, true)
    				: NEIServerUtils.areStacksSameTypeCrafting((ItemStack)recipe.getInput(), ingred) && ItemUtils.isItemEqual((ItemStack)recipe.getInput(), ingred, false))
    			this.arecipes.add(new CachedRecyclingRecipe(recipe));
        }
    }
    
    @Override
    public TemplateRecipeHandler newInstance() {
        if (afuels == null || afuels.isEmpty())
            findFuels();
        return super.newInstance();
    }
    
    public static class FuelPair
    {
        public FuelPair(int x, int y, ItemStack ingred, int burnTime) {
            this.stack = new PositionedStack(ingred, x, y, false);
            this.burnTime = burnTime;
        }

        public PositionedStack stack;
        public int burnTime;
    }

    public static ArrayList<FuelPair> afuels;

    private static Set<Item> excludedFuels() {
        Set<Item> efuels = new HashSet<Item>();
        efuels.add(Item.getItemFromBlock(Blocks.brown_mushroom));
        efuels.add(Item.getItemFromBlock(Blocks.red_mushroom));
        efuels.add(Item.getItemFromBlock(Blocks.standing_sign));
        efuels.add(Item.getItemFromBlock(Blocks.wall_sign));
        efuels.add(Item.getItemFromBlock(Blocks.trapped_chest));
        return efuels;
    }
    
    private static void findFuels() {
        afuels = new ArrayList<FuelPair>();
        Set<Item> efuels = excludedFuels();
        for (ItemStack item : ItemList.items) {
            Block block = Block.getBlockFromItem(item.getItem());
            if (block instanceof BlockDoor)
                continue;
            if (efuels.contains(item.getItem()))
                continue;

            int burnTime = TileEntityFurnace.getItemBurnTime(item);
            if (burnTime > 0)
                afuels.add(new FuelPair(41, 40, item.copy(), burnTime));
        }
    }
}
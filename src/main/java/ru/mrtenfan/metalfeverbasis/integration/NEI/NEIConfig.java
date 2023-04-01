package ru.mrtenfan.metalfeverbasis.integration.NEI;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.metalfeverbasis.init.MFBlocks;

public class NEIConfig implements IConfigureNEI {

	@Override
	public String getName() {
		return "Metal Fever";
	}

	@Override
	public String getVersion() {
		return "${version}";
	}

	@Override
	public void loadConfig() {
		API.hideItem(new ItemStack(MFBlocks.alloy_furnace_active));
		API.hideItem(new ItemStack(MFBlocks.recycling_furnace_active));
		register(new AlloyFurnaceRecipeHandler());
		register(new RecyclingFurnaceRecipeHandler());
	}
	
	public void register(TemplateRecipeHandler handler) {
		API.registerRecipeHandler(handler);
		API.registerUsageHandler(handler);
	}
}
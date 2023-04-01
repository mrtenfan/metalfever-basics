package ru.mrtenfan.metalfeverbasis.integration.ThermalExpansion;

import cofh.thermalexpansion.item.TEItems;
import cofh.thermalexpansion.util.crafting.PulverizerManager;
import cofh.thermalexpansion.util.crafting.SmelterManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ru.mrtenfan.MTFCore.Debuging;
import ru.mrtenfan.metalfeverbasis.MetalFeverMain;
import ru.mrtenfan.metalfeverbasis.init.MFItems;

public class ThermalExpansionCompat {

	public static void compatInit() {
		registerInductionSmelterRecipe(2400, new ItemStack(Items.iron_ingot), new ItemStack(Items.coal, 3, 0), new ItemStack(MFItems.alloys_ingot, 1, 1), new ItemStack(TEItems.itemMaterial, 1, 514), 15);
		registerInductionSmelterRecipe(2400, new ItemStack(MFItems.metals_ingot, 1, 2), new ItemStack(MFItems.metals_ingot, 1, 3), new ItemStack(MFItems.alloys_ingot, 2, 2));
		registerInductionSmelterRecipe(2400, new ItemStack(MFItems.metals_ingot, 1, 2), new ItemStack(Items.gold_ingot), new ItemStack(MFItems.alloys_ingot, 2, 3));
		registerInductionSmelterRecipe(2400, new ItemStack(MFItems.alloys_ingot, 2, 0), new ItemStack(MFItems.metals_ingot, 1, 10), new ItemStack(MFItems.alloys_ingot, 3, 4));
		registerInductionSmelterRecipe(2400, new ItemStack(MFItems.alloys_ingot, 1, 1), new ItemStack(Items.coal, 3, 0), new ItemStack(MFItems.alloys_ingot, 1, 5), new ItemStack(TEItems.itemMaterial, 1, 514), 15);
	}

	
	public static void registerPulverizerRecipe(int rfUsed, ItemStack input, ItemStack output) {
		registerPulverizerRecipe(rfUsed, input, output, null, 0);
	}
	
	private static void registerPulverizerRecipe(int rfUsed, ItemStack input, ItemStack output1, ItemStack output2, int chanceOfOutput2) {
		if(!PulverizerManager.addRecipe(rfUsed, input, output1, output2, chanceOfOutput2))
			Debuging.warnOutput("It isn't possible to add in pulverizer custom recipe.Please contact the author to fix this error!", MetalFeverMain.modName);
	}
	
	public static void registerInductionSmelterRecipe(int rfUsed, ItemStack input1, ItemStack input2, ItemStack output) {
		registerInductionSmelterRecipe(rfUsed, input1, input2, output, null, 0);
	}
	
	private static void registerInductionSmelterRecipe(int rfUsed, ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2, int chanceOfOutput2) {
		if(SmelterManager.addRecipe(rfUsed, input1, input2, output1, output2, chanceOfOutput2))
			Debuging.warnOutput("It isn't possible to add in induction smelter custom recipe.Please contact the author to fix this error!", MetalFeverMain.modName);
	}
}

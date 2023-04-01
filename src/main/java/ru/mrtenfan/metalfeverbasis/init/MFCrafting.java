package ru.mrtenfan.metalfeverbasis.init;

import java.util.Iterator;
import java.util.List;

import buildcraft.BuildCraftCore;
import cofh.thermalfoundation.ThermalFoundation;
import cofh.thermalfoundation.item.TFItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ru.mrtenfan.MTFCore.Debuging;
import ru.mrtenfan.MTFCore.utils.ItemUtils;
import ru.mrtenfan.MTFCore.utils.OreDictUtils;
import ru.mrtenfan.MTFCore.utils.OreStack;
import ru.mrtenfan.metalfeverbasis.ConfigFile;
import ru.mrtenfan.metalfeverbasis.MetalFeverMain;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.crafting.RecyclingFurnaceRecipe;

public class MFCrafting {

	public static void initializeCraftings() {
		if (ConfigFile.EnabPlates) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.iron_hammer), 
					new Object[] {"II ", "ISI", " S ", 'I', "ingotIron", 'S', "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_hammer), 
					new Object[] {"CC ", "CSC", " S ", 'C', "ingotCrudeIron", 'S', "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_hammer), 
					new Object[] {"OO ", "OSO", " S ", 'O', "ingotOiur", 'S', "stickWood"}));
		}
		if(ConfigFile.EnabCutters) {
			if(ConfigFile.EnabPlates) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.iron_cutters),
						new Object[] {" P ", "PIS", " S ", 'P', "plateIron", 'I', "ingotIron", 'S', "stickWood"}));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_cutters),
						new Object[] {" P ", "PIS", " S ", 'P', "plateCrudeIron", 'I', "ingotIron", 'S', "stickWood"}));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_cutters),
						new Object[] {" P ", "PIS", " S ", 'P', "plateOiur", 'I', "ingotIron", 'S', "stickWood"}));
			} else {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.iron_cutters),
						new Object[] {" P ", "PIS", " S ", 'P', "ingotIron", 'I', "ingotIron", 'S', "stickWood"}));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_cutters),
						new Object[] {" P ", "PIS", " S ", 'P', "ingotCrudeIron", 'I', "ingotIron", 'S', "stickWood"}));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_cutters),
						new Object[] {" P ", "PIS", " S ", 'P', "ingotOiur", 'I', "ingotIron", 'S', "stickWood"}));
			}
		}
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_sword), 
				new Object[] {"B", "B", "S", 'B', "ingotBronze", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_pickaxe), 
				new Object[] {"BBB", " S ", " S ", 'B', "ingotBronze", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_shovel), 
				new Object[] {"B", "S", "S", 'B', "ingotBronze", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_axe), 
				new Object[] {"BB", "BS", " S", 'B', "ingotBronze", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_axe), 
				new Object[] {"BB", "SB", "S ", 'B', "ingotBronze", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_hoe), 
				new Object[] {"BB", " S", " S", 'B', "ingotBronze", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_hoe), 
				new Object[] {"BB", "S ", "S ", 'B', "ingotBronze", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_helmet), 
				new Object[] {"BBB", "B B", 'B', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_chestplate), 
				new Object[] {"B B", "BBB", "BBB", 'B', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_leggs), 
				new Object[] {"BBB", "B B", "B B", 'B', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.bronze_boots), 
				new Object[] {"B B", "B B", 'B', "ingotBronze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_sword), 
				new Object[] {"C", "C", "S", 'C', "ingotCrudeIron", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_pickaxe), 
				new Object[] {"CCC", " S ", " S ", 'C', "ingotCrudeIron", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_shovel), 
				new Object[] {"C", "S", "S", 'C', "ingotCrudeIron", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_axe), 
				new Object[] {"CC", "CS", " S", 'C', "ingotCrudeIron", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_axe), 
				new Object[] {"CC", "SC", "S ", 'C', "ingotCrudeIron", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_hoe), 
				new Object[] {"CC", " S", " S", 'C', "ingotCrudeIron", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.crude_iron_hoe), 
				new Object[] {"CC", "S ", "S ", 'C', "ingotCrudeIron", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.joyk_sword), 
				new Object[] {"J", "J", "S", 'J', "ingotJoyk", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.joyk_pickaxe), 
				new Object[] {"JJJ", " S ", " S ", 'J', "ingotJoyk", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.joyk_shovel), 
				new Object[] {"J", "S", "S", 'J', "ingotJoyk", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.joyk_axe), 
				new Object[] {"JJ", "JS", " S", 'J', "ingotJoyk", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.joyk_axe), 
				new Object[] {"JJ", "SJ", "S ", 'J', "ingotJoyk", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.mewni_sword), 
				new Object[] {"M", "M", "S", 'M', "ingotMewni", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.mewni_pickaxe), 
				new Object[] {"MMM", " S ", " S ", 'M', "ingotMewni", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.mewni_shovel), 
				new Object[] {"M", "S", "S", 'M', "ingotMewni", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.mewni_axe), 
				new Object[] {"MM", "MS", " S", 'M', "ingotMewni", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.mewni_axe), 
				new Object[] {"MM", "SM", "S ", 'M', "ingotMewni", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_sword), 
				new Object[] {"O", "O", "S", 'O', "ingotOiur", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_pickaxe), 
				new Object[] {"OOO", " S ", " S ", 'O', "ingotOiur", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_shovel), 
				new Object[] {"O", "S", "S", 'O', "ingotOiur", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_axe), 
				new Object[] {"OO", "OS", " S", 'O', "ingotOiur", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_axe), 
				new Object[] {"OO", "SO", "S ", 'O', "ingotOiur", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_helmet), 
				new Object[] {"OOO", "O O", 'O', "ingotOiur"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_chestplate), 
				new Object[] {"O O", "OOO", "OOO", 'O', "ingotOiur"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_leggs), 
				new Object[] {"OOO", "O O", "O O", 'O', "ingotOiur"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.oiur_boots), 
				new Object[] {"O O", "O O", 'O', "ingotOiur"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_sword), 
				new Object[] {"T", "T", "S", 'T', "ingotSteel", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_pickaxe), 
				new Object[] {"TTT", " S ", " S ", 'T', "ingotSteel", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_shovel), 
				new Object[] {"T", "S", "S", 'T', "ingotSteel", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_axe), 
				new Object[] {"TT", "TS", " S", 'T', "ingotSteel", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_axe), 
				new Object[] {"TT", "ST", "S ", 'T', "ingotSteel", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_hoe), 
				new Object[] {"TT", " S", " S", 'T', "ingotSteel", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_hoe), 
				new Object[] {"TT", "S ", "S ", 'T', "ingotSteel", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_helmet), 
				new Object[] {"SSS", "S S", 'S', "ingotSteel"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_chestplate), 
				new Object[] {"S S", "SSS", "SSS", 'S', "ingotSteel"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_leggs), 
				new Object[] {"SSS", "S S", "S S", 'S', "ingotSteel"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.steel_boots), 
				new Object[] {"S S", "S S", 'S', "ingotSteel"}));
		if (ConfigFile.EzAlloys) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_ingot, 4, 0), 
					"ingotTin", "ingotCopper", "ingotCopper", "ingotCopper"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 1), 
					"ingotIron", "itemCoal", "itemCoal", "itemCoal"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_ingot, 2, 2), 
					"ingotTin", "ingotLead"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 3), 
					"ingotLead", "ingotGold"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_ingot, 2, 4), 
					"ingotBronze", "ingotBronze", "ingotTitanium"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 5), 
					"ingotCrudeIron", "itemCoal", "itemCoal", "itemCoal", "itemCoal", "itemCoal", "itemCoal"));
		}
		if (ConfigFile.DustAlloys && ConfigFile.EnabDust) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_dust, 4, 0), 
					"dustTin", "dustCopper", "dustCopper", "dustCopper"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_dust, 1, 1), 
					"dustIron", "itemCoal", "itemCoal", "itemCoal"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_dust, 2, 2), 
					"dustNickel", "dustLead"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_dust, 1, 3), 
					"dustLead", "dustGold"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_dust, 2, 4), 
					"dustBronze", "dustBronze", "dustTitanium"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_dust, 1, 5), 
					"dustCrudeIron", "itemCoal", "itemCoal", "itemCoal"));
		}
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.cobalt_sword), 
				new Object[] {"C", "C", "S", 'C', "ingotCobalt", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.cobalt_pickaxe), 
				new Object[] {"CCC", " S ", " S ", 'C', "ingotCobalt", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.cobalt_shovel), 
				new Object[] {"C", "S", "S", 'C', "ingotCobalt", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.cobalt_axe), 
				new Object[] {"CC", "CS", " S", 'C', "ingotCobalt", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFTools.cobalt_axe), 
				new Object[] {"CC", "SC", "S ", 'C', "ingotCobalt", 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.alloy_furnace),
				new Object[] {"III", "IFI", "OOO", 'I', "plateIron", 'F', new ItemStack(Blocks.furnace), 'O', new ItemStack(Blocks.obsidian)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 0), "ingotAluminum"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 0), "ingotAluminium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 1), "ingotCopper"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 2), "ingotLead"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 3), "ingotNickel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 4), "ingotPlatinum"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 5), "ingotSilver"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 6), "ingotTin"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 7), "ingotTungsten"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 9), "ingotCobalt"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 10), "ingotChrome"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.metals_nugget, 9, 11), "ingotTitanium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_nugget, 9, 0), "ingotBronze"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_nugget, 9, 1), "ingotCrudeIron"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_nugget, 9, 2), "ingotJoyk"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_nugget, 9, 3), "ingotMewni"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_nugget, 9, 4), "ingotOiur"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_nugget, 9, 5), "ingotSteel"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 0), "NNN", "NNN", "NNN", 'N', "nuggetAluminum"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 0), "NNN", "NNN", "NNN", 'N', "nuggetAluminium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 1), "NNN", "NNN", "NNN", 'N', "nuggetCopper"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 2), "NNN", "NNN", "NNN", 'N', "nuggetLead"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 3), "NNN", "NNN", "NNN", 'N', "nuggetNickel"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 4), "NNN", "NNN", "NNN", 'N', "nuggetPlatinum"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 5), "NNN", "NNN", "NNN", 'N', "nuggetSilver"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 6), "NNN", "NNN", "NNN", 'N', "nuggetTin"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 7), "NNN", "NNN", "NNN", 'N', "nuggetTungsten"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 8), "NNN", "NNN", "NNN", 'N', "nuggetCobalt"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 9), "NNN", "NNN", "NNN", 'N', "nuggetChrome"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.metals_ingot, 1, 10), "NNN", "NNN", "NNN", 'N', "nuggetTitanium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 0), "NNN", "NNN", "NNN", 'N', "nuggetBronze"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 1), "NNN", "NNN", "NNN", 'N', "nuggetCrudeIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 2), "NNN", "NNN", "NNN", 'N', "nuggetJoyk"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 3), "NNN", "NNN", "NNN", 'N', "nuggetMewni"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 4), "NNN", "NNN", "NNN", 'N', "nuggetOiur"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 5), "NNN", "NNN", "NNN", 'N', "nuggetSteel"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.alloys_nugget, 9, 6), "ingotCreative"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.alloys_ingot, 1, 6), "NNN", "NNN", "NNN", 'N', "nuggetCreative"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.recycling_furnace),
				new Object[] {"III", "IFI", "OOO", 'I', "plateJoyk", 'F', new ItemStack(Blocks.furnace), 'O', new ItemStack(Blocks.stonebrick)}));
	}

	public static void initializeHammerCraft() {
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 0), "ingotAluminum");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 0), "ingotAluminium");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 1), "ingotCopper");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 2), "ingotLead");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 3), "ingotNickel");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 4), "ingotPlatinum");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 5), "ingotSilver");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 6), "ingotTin");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 7), "ingotTungsten");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 8), "ingotIron");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 9), "ingotGold");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 10), "ingotCobalt");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 11), "ingotChrome");
		addHammerRecipe(new ItemStack(MFItems.metals_plate, 1, 12), "ingotTitanium");

		addHammerRecipe(new ItemStack(MFItems.alloys_plate, 1, 0), "ingotBronze");
		addHammerRecipe(new ItemStack(MFItems.alloys_plate, 1, 1), "ingotCrudeIron");
		addHammerRecipe(new ItemStack(MFItems.alloys_plate, 1, 2), "ingotJoyk");
		addHammerRecipe(new ItemStack(MFItems.alloys_plate, 1, 3), "ingotMewni");
		addHammerRecipe(new ItemStack(MFItems.alloys_plate, 1, 4), "ingotOiur");
		addHammerRecipe(new ItemStack(MFItems.alloys_plate, 1, 5), "ingotSteel");
		addHammerRecipe(new ItemStack(MFItems.alloys_plate, 1, 6), "ingotCreative");
		
		if(MetalFeverMain.THERMAL) {                                               
			addHammerRecipe(new ItemStack(MFItems.therm_plate, 1, 0), "ingotMithril");
			addHammerRecipe(new ItemStack(MFItems.therm_plate, 1, 1), "ingotInvar");
			addHammerRecipe(new ItemStack(MFItems.therm_plate, 1, 2), "ingotElectrum"); 
			addHammerRecipe(new ItemStack(MFItems.therm_plate, 1, 3), "ingotSignalum");
			addHammerRecipe(new ItemStack(MFItems.therm_plate, 1, 4), "ingotLumium");
			addHammerRecipe(new ItemStack(MFItems.therm_plate, 1, 5), "ingotEnderium");
		}
		if(MetalFeverMain.ENDER) {
			addHammerRecipe(new ItemStack(MFItems.ender_plate, 1, 0), "ingotElectricalSteel");
			addHammerRecipe(new ItemStack(MFItems.ender_plate, 1, 1), "ingotEnergeticAlloy");
			addHammerRecipe(new ItemStack(MFItems.ender_plate, 1, 2), "ingotSoularium");
			addHammerRecipe(new ItemStack(MFItems.ender_plate, 1, 3), "ingotVibrantAlloy");
			addHammerRecipe(new ItemStack(MFItems.ender_plate, 1, 4), "ingotDarkSteel");
		}
		if(MetalFeverMain.REACTORS) {
			addHammerRecipe(new ItemStack(MFItems.breactor_plate, 1, 0), "ingotYellorium");
			addHammerRecipe(new ItemStack(MFItems.breactor_plate, 1, 1), "ingotCyanite");
			addHammerRecipe(new ItemStack(MFItems.breactor_plate, 1, 2), "ingotBlutonium");
			addHammerRecipe(new ItemStack(MFItems.breactor_plate, 1, 3), "ingotLudicrite");
		}
		if(MetalFeverMain.TINKERS) {
			addHammerRecipe(new ItemStack(MFItems.tinkers_plate, 1, 0), "ingotAlumite");
			addHammerRecipe(new ItemStack(MFItems.tinkers_plate, 1, 1), "ingotArdite");
			addHammerRecipe(new ItemStack(MFItems.tinkers_plate, 1, 2), "ingotManyullyn");
		}
		if(MetalFeverMain.DRACONIC) {
			addHammerRecipe(new ItemStack(MFItems.draconic_plate, 1, 0), "ingotDraconium");
			addHammerRecipe(new ItemStack(MFItems.draconic_plate, 1, 1), "ingotDraconiumAwakened");
		}
	}

	public static void initializeSmeltings() { //Iron = 0.7F, Gold = 1.0F
		int i;
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 0), new ItemStack(MFItems.metals_ingot, 1, 0), 0.3F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 1), new ItemStack(MFItems.metals_ingot, 1, 1), 0.5F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 2), new ItemStack(MFItems.metals_ingot, 1, 2), 0.6F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 3), new ItemStack(MFItems.metals_ingot, 1, 3), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 4), new ItemStack(MFItems.metals_ingot, 1, 4), 0.9F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 5), new ItemStack(MFItems.metals_ingot, 1, 5), 0.9F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 6), new ItemStack(MFItems.metals_ingot, 1, 6), 0.5F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 7), new ItemStack(MFItems.metals_ingot, 1, 7), 0.75F);
		if(ConfigFile.EnabDust) {
			for(i = 0; i < 8; i++) {
				GameRegistry.addSmelting(new ItemStack(MFItems.metals_dust, 1, i), new ItemStack(MFItems.metals_ingot, 1, i), 0.5F);
			}
			GameRegistry.addSmelting(new ItemStack(MFItems.metals_dust, 1, 8), new ItemStack(Items.iron_ingot), 0.5F);
			GameRegistry.addSmelting(new ItemStack(MFItems.metals_dust, 1, 9), new ItemStack(Items.gold_ingot), 0.5F);
			GameRegistry.addSmelting(new ItemStack(MFItems.metals_dust, 1, 10), new ItemStack(MFItems.metals_ingot, 1, 8), 0.5F);
			GameRegistry.addSmelting(new ItemStack(MFItems.metals_dust, 1, 11), new ItemStack(MFItems.metals_ingot, 1, 9), 0.5F);
			GameRegistry.addSmelting(new ItemStack(MFItems.metals_dust, 1, 12), new ItemStack(MFItems.metals_ingot, 1, 10), 0.5F);
			for(i = 0; i < 7; i++) {
				GameRegistry.addSmelting(new ItemStack(MFItems.alloys_dust, 1, i), new ItemStack(MFItems.alloys_ingot, 1, i), 0.5F);
			}
		}
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 8), new ItemStack(MFItems.metals_ingot, 1, 8), 0.9F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 9), new ItemStack(MFItems.metals_ingot, 1, 9), 0.9F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.metals_ore, 1, 10), new ItemStack(MFItems.metals_ingot, 1, 10), 0.5F);
	}

	public static void initializeCustomCrafting() {
		AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotCopper", 3), new OreStack("ingotTin"), new ItemStack(MFItems.alloys_ingot, 4, 0));
		AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotBronze", 2), new OreStack("ingotTitanium"), new ItemStack(MFItems.alloys_ingot, 3, 4));
		AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotLead"), new OreStack("ingotGold"), new ItemStack(MFItems.alloys_ingot, 2, 3));
		AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotLead"), new OreStack("ingotNickel"), new ItemStack(MFItems.alloys_ingot, 2, 2));
		if(ConfigFile.CrudeAlloy)
			AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotIron"), new ItemStack(Items.coal, 3), new ItemStack(MFItems.alloys_ingot, 1, 1));
		if(ConfigFile.SteelAlloy)
			AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotCrudeIron"), new ItemStack(Items.coal, 3), new ItemStack(MFItems.alloys_ingot, 1, 5));
		if(ConfigFile.AFInteg) {
			if(OreDictUtils.doesOreExist("ingotElectrum")) {
				AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotGold"), new OreStack("ingotSilver"), new OreStack("ingotElectrum", 2).getStack());
			}
			if(OreDictUtils.doesOreExist("ingotInvar")) {
				AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotIron", 2), new OreStack("ingotNickel"), new OreStack("ingotInvar", 3).getStack());
			}
			if(OreDictUtils.doesOreExist("ingotConstantan")) {
				AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotCopper"), new OreStack("ingotNickel"), new OreStack("ingotConstantan", 2).getStack());
			}
			if(OreDictUtils.doesOreExist("ingotAluminumBrass")) {
				AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotCopper"), new OreStack("ingotAluminum"), new OreStack("ingotAluminumBrass", 4).getStack());
				AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotCopper"), new OreStack("ingotAluminium"), new OreStack("ingotAluminumBrass", 4).getStack());
			}
			if(OreDictUtils.doesOreExist("ingotManyullyn") && OreDictUtils.doesOreExist("ingotArdite")) {
				AlloyFurnaceRecipe.addAlloyingRecipe(new OreStack("ingotCobalt"), new OreStack("ingotArdite"), new OreStack("ingotManyullyn").getStack());
			}
		}
		
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_sword), new ItemStack(Items.iron_ingot, 2));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_pickaxe), new ItemStack(Items.iron_ingot, 3));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_axe), new ItemStack(Items.iron_ingot, 3));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_shovel), new ItemStack(Items.iron_ingot, 1));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_hoe), new ItemStack(Items.iron_ingot, 2));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_sword), new ItemStack(Items.gold_ingot, 2));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_pickaxe), new ItemStack(Items.gold_ingot, 3));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_axe), new ItemStack(Items.gold_ingot, 3));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_shovel), new ItemStack(Items.gold_ingot, 1));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_hoe), new ItemStack(Items.gold_ingot, 2));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_helmet), new ItemStack(Items.iron_ingot, 4));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_chestplate), new ItemStack(Items.iron_ingot, 8));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_leggings), new ItemStack(Items.iron_ingot, 7));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_boots), new ItemStack(Items.iron_ingot, 4));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_helmet), new ItemStack(Items.gold_ingot, 4));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_chestplate), new ItemStack(Items.gold_ingot, 8));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_leggings), new ItemStack(Items.gold_ingot, 7));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.golden_boots), new ItemStack(Items.gold_ingot, 4));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.iron_door), new ItemStack(Items.iron_ingot, 6));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Blocks.iron_bars, 8), new ItemStack(Items.iron_ingot, 3));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Blocks.heavy_weighted_pressure_plate), new ItemStack(Items.iron_ingot, 2));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.bucket), new ItemStack(Items.iron_ingot, 3));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.flint_and_steel), new ItemStack(Items.iron_ingot, 1));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.shears), new ItemStack(Items.iron_ingot, 2));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.compass), new ItemStack(Items.iron_ingot, 4));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.cauldron), new ItemStack(Items.iron_ingot, 7));
		RecyclingFurnaceRecipe.addRecyclingRecipe(new ItemStack(Items.clock), new ItemStack(Items.gold_ingot, 4));
	}

	public static void initializeCuttersCrafting(boolean ngc, boolean plate) {
		if(ngc) {
			if(plate) {
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 0), "plateAluminum");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 1), "plateCopper");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 2), "plateLead");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 3), "plateNickel");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 4), "platePlatinum");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 5), "plateSilver");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 6), "plateTin");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 7), "plateTungsten");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 8), "plateIron");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 9), "plateGold");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 10), "plateCobalt");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 11), "plateChrome");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 12), "plateTitanium");

				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 0), "plateBronze");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 1), "plateCrudeIron");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 2), "plateJoyk");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 3), "plateMewni");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 4), "plateOiur");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 5), "plateSteel");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 6), "plateCreative");

				if(MetalFeverMain.ENDER) {
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 0), "plateElectricalSteel");
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 1), "plateEnergeticAlloy");
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 2), "plateSoularium");
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 3), "platePhasedGold");
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 4), "plateDarkSteel");
				}

				if(MetalFeverMain.TINKERS) {
					addCutterRecipe(new ItemStack(MFItems.tinkers_gear_part, 1, 0), "plateAlumite");
					addCutterRecipe(new ItemStack(MFItems.tinkers_gear_part, 1, 1), "plateArdite");
					addCutterRecipe(new ItemStack(MFItems.tinkers_gear_part, 1, 2), "plateManyullyn");
				}

				if(MetalFeverMain.THERMAL) {
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 0), "plateMithril");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 1), "plateInvar");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 2), "plateElectrum");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 3), "plateSignalum");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 4), "plateLumium");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 5), "plateEnderium");
				}

				if(MetalFeverMain.REACTORS) {
					addCutterRecipe(new ItemStack(MFItems.breactor_gear_part, 1, 0), "plateYellorium");
					addCutterRecipe(new ItemStack(MFItems.breactor_gear_part, 1, 1), "plateCyanite");
					addCutterRecipe(new ItemStack(MFItems.breactor_gear_part, 1, 2), "plateBlutonium");
					addCutterRecipe(new ItemStack(MFItems.breactor_gear_part, 1, 3), "plateLudicrite");
				}

				if(MetalFeverMain.DRACONIC) {
					addCutterRecipe(new ItemStack(MFItems.draconic_gear_part, 1, 0), "plateDraconium");
					addCutterRecipe(new ItemStack(MFItems.draconic_gear_part, 1, 1), "plateDraconiumAwakened");
				}
			} else {
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 0), "ingotAluminum");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 1), "ingotCopper");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 2), "ingotLead");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 3), "ingotNickel");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 4), "ingotPlatinum");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 5), "ingotSilver");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 6), "ingotTin");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 7), "ingotTungsten");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 8), "ingotIron");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 9), "ingotGold");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 10), "ingotCobalt");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 11), "ingotChrome");
				addCutterRecipe(new ItemStack(MFItems.metals_gear_part, 1, 12), "ingotTitanium");

				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 0), "ingotBronze");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 1), "ingotCrudeIron");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 2), "ingotJoyk");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 3), "ingotMewni");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 4), "ingotOiur");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 5), "ingotSteel");
				addCutterRecipe(new ItemStack(MFItems.alloys_gear_part, 1, 6), "ingotCreative");

				if(MetalFeverMain.ENDER) {
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 0), "ingotElectricalSteel");
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 1), "ingotEnergeticAlloy");
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 2), "ingotSoularium");
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 3), "ingotVibrantAlloy");
					addCutterRecipe(new ItemStack(MFItems.ender_gear_part, 1, 4), "ingotDarkSteel");
				}

				if(MetalFeverMain.TINKERS) {
					addCutterRecipe(new ItemStack(MFItems.tinkers_gear_part, 1, 0), "ingotAlumite");
					addCutterRecipe(new ItemStack(MFItems.tinkers_gear_part, 1, 1), "ingotArdite");
					addCutterRecipe(new ItemStack(MFItems.tinkers_gear_part, 1, 2), "ingotManyullyn");
				}

				if(MetalFeverMain.THERMAL) {
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 0), "ingotMythril");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 1), "ingotInvar");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 2), "ingotElectrum");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 3), "ingotSignalum");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 4), "ingotLumium");
					addCutterRecipe(new ItemStack(MFItems.thermal_gear_part, 1, 5), "ingotEnderium");
				}

				if(MetalFeverMain.REACTORS) {
					addCutterRecipe(new ItemStack(MFItems.breactor_gear_part, 1, 0), "ingotYellorium");
					addCutterRecipe(new ItemStack(MFItems.breactor_gear_part, 1, 1), "ingotCyanite");
					addCutterRecipe(new ItemStack(MFItems.breactor_gear_part, 1, 2), "ingotBlutonium");
					addCutterRecipe(new ItemStack(MFItems.breactor_gear_part, 1, 3), "ingotLudicrite");
				}

				if(MetalFeverMain.DRACONIC) {
					addCutterRecipe(new ItemStack(MFItems.draconic_gear_part, 1, 0), "ingotDraconium");
					addCutterRecipe(new ItemStack(MFItems.draconic_gear_part, 1, 1), "ingotDraconiumAwakened");
				}
			}
		}
	}

	public static void initializeGearCrafting(boolean ngc) {
		if(ngc) {
			deleteGearsRecipes();
			
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 0), "gearPartCopper");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 1), "gearPartLead");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 2), "gearPartNickel");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 3), "gearPartPlatinum");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 4), "gearPartSilver");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 5), "gearPartTin");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 6), "gearPartIron");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 7), "gearPartGold");
			
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 0), "gearPartAluminum");
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 1), "gearPartTungsten");
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 2), "gearPartCobalt");
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 3), "gearPartChrome");
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 4), "gearPartTitanium");

			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 0), "gearPartBronze");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 1), "gearPartCrudeIron");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 2), "gearPartJoyk");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 3), "gearPartMewni");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 4), "gearPartOiur");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 5), "gearPartSteel");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 6), "gearPartCreative");

			if(MetalFeverMain.ENDER) {
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 0), "gearPartElectricalSteel");
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 1), "gearPartEnergeticAlloy");
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 2), "gearPartSoularium");
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 3), "gearPartPhasedGold");
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 4), "gearPartDarkSteel");
			}

			if(MetalFeverMain.TINKERS) {
				addGearRecipe(new ItemStack(MFItems.tinkers_gear, 1, 0), "gearPartAlumite");
				addGearRecipe(new ItemStack(MFItems.tinkers_gear, 1, 1), "gearPartArdite");
				addGearRecipe(new ItemStack(MFItems.tinkers_gear, 1, 2), "gearPartManyullyn");
			}

			if(MetalFeverMain.REACTORS) {
				addGearRecipe(new ItemStack(MFItems.breactor_gear, 1, 0), "gearPartYellorium");
				addGearRecipe(new ItemStack(MFItems.breactor_gear, 1, 1), "gearPartCyanite");
				addGearRecipe(new ItemStack(MFItems.breactor_gear, 1, 2), "gearPartBlutonium");
				addGearRecipe(new ItemStack(MFItems.breactor_gear, 1, 3), "gearPartLudicrite");
			}

			if(MetalFeverMain.DRACONIC) {
				addGearRecipe(new ItemStack(MFItems.draconic_gear, 1, 0), "gearPartDraconium");
				addGearRecipe(new ItemStack(MFItems.draconic_gear, 1, 1), "gearPartDraconiumAwakened");
			}
		} else {
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 0), "plateCopper");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 1), "plateLead");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 2), "plateNickel");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 3), "platePlatinum");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 4), "plateSilver");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 5), "plateTin");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 6), "plateIron");
			addGearRecipe(new ItemStack(MFItems.metals_gear_b, 1, 7), "plateGold");
			
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 0), "plateAluminum");
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 1), "plateTungsten");
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 2), "plateCobalt");
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 3), "plateChrome");
			addGearRecipe(new ItemStack(MFItems.metals_gear_c, 1, 4), "plateTitanium");

			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 0), "plateBronze");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 1), "plateCrudeIron");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 2), "plateJoyk");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 3), "plateMewni");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 4), "plateOiur");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 5), "plateSteel");
			addGearRecipe(new ItemStack(MFItems.alloys_gear, 1, 6), "plateCreative");

			if(MetalFeverMain.ENDER) {
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 0), "plateElectricalSteel");
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 1), "plateEnergeticAlloy");
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 2), "plateSoularium");
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 3), "platePhasedGold");
				addGearRecipe(new ItemStack(MFItems.ender_gear, 1, 4), "plateDarkSteel");
			}

			if(MetalFeverMain.TINKERS) {
				addGearRecipe(new ItemStack(MFItems.tinkers_gear, 1, 0), "plateAlumite");
				addGearRecipe(new ItemStack(MFItems.tinkers_gear, 1, 1), "plateArdite");
				addGearRecipe(new ItemStack(MFItems.tinkers_gear, 1, 2), "plateManyullyn");
			}

			if(MetalFeverMain.REACTORS) {
				addGearRecipe(new ItemStack(MFItems.breactor_gear, 1, 0), "plateYellorium");
				addGearRecipe(new ItemStack(MFItems.breactor_gear, 1, 1), "plateCyanite");
				addGearRecipe(new ItemStack(MFItems.breactor_gear, 1, 2), "plateBlutonium");
				addGearRecipe(new ItemStack(MFItems.breactor_gear, 1, 3), "plateLudicrite");
			}

			if(MetalFeverMain.DRACONIC) {
				addGearRecipe(new ItemStack(MFItems.draconic_gear, 1, 0), "plateDraconium");
				addGearRecipe(new ItemStack(MFItems.draconic_gear, 1, 1), "plateDraconiumAwakened");
			}
		}
	}
	
	public static void deleteGearsRecipes() {
		ItemStack[] items = new ItemStack[] {};
		if(Loader.isModLoaded("BuildCraft"))
			items = new ItemStack[] { new ItemStack(BuildCraftCore.ironGearItem), new ItemStack(BuildCraftCore.goldGearItem) };
		else if(Loader.isModLoaded(ThermalFoundation.modName))
			items = new ItemStack[] { TFItems.gearCopper, TFItems.gearLead, TFItems.gearNickel, TFItems.gearPlatinum, TFItems.gearSilver, TFItems.gearTin, TFItems.gearGold, TFItems.gearIron, TFItems.gearBronze,
					TFItems.gearMithril, TFItems.gearInvar, TFItems.gearElectrum, TFItems.gearSignalum, TFItems.gearLumium, TFItems.gearEnderium};
		else if(Loader.isModLoaded("BuildCraft") && Loader.isModLoaded(ThermalFoundation.modName))
			items = new ItemStack[] { new ItemStack(BuildCraftCore.ironGearItem), new ItemStack(BuildCraftCore.goldGearItem), TFItems.gearCopper, TFItems.gearLead, TFItems.gearNickel,
					TFItems.gearPlatinum, TFItems.gearSilver, TFItems.gearTin, TFItems.gearGold, TFItems.gearIron, TFItems.gearBronze, TFItems.gearMithril, TFItems.gearInvar, TFItems.gearElectrum, TFItems.gearSignalum,
					TFItems.gearLumium, TFItems.gearEnderium };
		@SuppressWarnings("unchecked")
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

		Iterator<IRecipe> remover = recipes.iterator();

		while(remover.hasNext()) {
			IRecipe recipe = remover.next();
			if(recipe != null) {
				ItemStack result = recipe.getRecipeOutput();
				if(result != null) {
					if(result.getItem() == MFItems.metals_gear_b || result.getItem() == MFItems.metals_gear_c || result.getItem() == MFItems.alloys_gear) break;
					for(int i = 0; i < items.length; i++)
						if(items[i] != null)
							if(ItemUtils.isItemEqual(result, items[i], false)) {
								remover.remove();
								Debuging.infoOutput("Deleting recipe for " + items[i].getDisplayName(), MetalFeverMain.modID);
								items[i] = null;
								break;
							}
				}
			}
		}
	}

	private static void addCutterRecipe(ItemStack result, Object input) {
		final String cutter = "anyCutters";
		if(input instanceof ItemStack || input instanceof String) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(result, new Object[] {input, cutter}));
		} else { 
			Debuging.errorOutput("Input aren't instanceof ItemStack or String!", MetalFeverMain.modID);
		}
	}
	
	private static void addHammerRecipe(ItemStack result, Object input) {
		final String hammer = "anyHammers";
		if(input instanceof ItemStack || input instanceof String) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(result, new Object[] {input, input, hammer}));
		} else { 
			Debuging.errorOutput("Input aren't instanceof ItemStack or String!", MetalFeverMain.modID);
		}
	}
	
	private static void addGearRecipe(ItemStack result, Object input) {
		final String tin = "ingotTin";
		if(input instanceof ItemStack || input instanceof String) {
			GameRegistry.addRecipe(new ShapedOreRecipe(result, new Object[] 
					{" M ", "MIM", " M ", 'M', input, 'I', tin}));
		} else { 
			Debuging.errorOutput("Input aren't instanceof ItemStack or String!", MetalFeverMain.modID);
		}
	}
}
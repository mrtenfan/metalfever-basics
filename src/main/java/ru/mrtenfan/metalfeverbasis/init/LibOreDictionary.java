package ru.mrtenfan.metalfeverbasis.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import ru.mrtenfan.metalfeverbasis.ConfigFile;
import ru.mrtenfan.metalfeverbasis.MetalFeverMain;

public final class LibOreDictionary {

	// Ores/руды
	public static final String[] ORE = new String[] {"oreAluminum", "oreAluminium", "oreCopper", "oreLead", "oreNickel",
			"orePlatinum", "oreSilver",  "oreTin",  "oreTungsten", "oreCobalt", "oreChrome", "oreTitanium"};
	// Ingots/слитки
	public static final String[] INGOT = new String[] {"ingotAluminum", "ingotAluminium", "ingotCopper", "ingotLead", "ingotNickel", 
			"ingotPlatinum", "ingotSilver", "ingotTin", "ingotTungsten", "ingotCobalt", "ingotChrome", "ingotTitanium"};
	public static final String[] ALLOY = new String[] {"ingotBronze","ingotCrudeIron",  "ingotJoyk", "ingotMewni", "ingotOiur",
			"ingotSteel", "ingotCreative"};
	// Plates/Пластины
	public static final String[] MPLATE = new String[] {"plateAluminum", "plateAluminium", "plateCopper", "plateLead", "plateNickel", 
			"platePlatinum", "plateSilver", "plateTin", "plateTungsten", "plateIron", "plateGold", "plateCobalt", "plateChrome", "plateTitanium"};
	public static final String[] APLATE = new String[] {"plateBronze", "plateCrudeIron", "plateJoyk", "plateMewni", "plateOiur",
			"plateSteel", "plateCreative"};
	public static final String[] EPLATE = new String[] {"plateElectricalSteel", "plateEnergeticAlloy", "plateSoularium", "platePhasedGold", "plateDarkSteel"};
	public static final String[] TPLATE = new String[] {"plateMithril", "plateInvar", "plateElectrum", "plateSignalum", "plateLumium", "plateEnderium"};
	public static final String[] BRPLATE = new String[] {"plateYellorium", "plateCyanite", "plateBluetonium", "plateLudicrite"};
	public static final String[] DEPLATE = new String[] {"plateDraconium", "plateDraconiumAwakened"};
	public static final String[] TCPLATE = new String[] {"plateAlumite", "plateArdite", "plateManyullyn"};
	// Nuggets/Кусочки
	public static final String[] MNUGGET = new String[] {"nuggetAluminum", "nuggetAluminium", "nuggetCopper", "nuggetLead", "nuggetNickel",
			"nuggetPlatinum", "nuggetSilver", "nuggetTin", "nuggetTungsten", "nuggetIron", "nuggetCobalt", "nuggetChrome", "nuggetTitanium"};
	public static final String[] ANUGGET = new String[] {"nuggetBronze", "nuggetCrudeIron", "nuggetJoyk", "nuggetMewni", "nuggetOiur", 
			"nuggetSteel", "nuggetCreative"};
	// Dusts/Пыль
	public static final String[] MDUST = new String[] {"dustAluminum", "dustAluminium", "dustCopper", "dustLead", "dustNickel", 
			"dustPlatinum", "dustSilver", "dustTin", "dustTungsten", "dustIron", "dustGold", "dustCobalt", "dustChrome", "dustTitanium"};
	public static final String[] ADUST = new String[] {"dustBronze", "dustCrudeIron", "dustJoyk", "dustMewni", "dustOiur",
			"dustSteel", "dustCreative"};
	//Other/прочее
	public static final String HAMMERS = "anyHammers";
	public static final String SLAG = "itemSlag";
	public static final String CUTTERS = "anyCutters";
	//Gear and it's parts/ Шестерни и их части
	public static final String[] MGEARPART = new String[] {"gearPartAluminum", "gearPartAluminium", "gearPartCopper", "gearPartLead", "gearPartNickel", 
			"gearPartPlatinum", "gearPartSilver", "gearPartTin", "gearPartTungsten", "gearPartIron", "gearPartGold", "gearPartCobalt", "gearPartChrome", "gearPartTitanium"};
	public static final String[] AGEARPART = new String[] {"gearPartBronze", "gearPartCrudeIron", "gearPartJoyk", "gearPartMewni", "gearPartOiur",
			"gearPartSteel", "gearPartCreative"};
	public static final String[] EGEARPART = new String[] {"gearPartElectricalSteel", "gearPartEnergeticAlloy", "gearPartSoularium", "gearPartPhasedGold", "gearPartDarkSteel"};
	public static final String[] TGEARPART = new String[] {"gearPartMythril", "gearPartInvar", "gearPartElectrum", "gearPartSignalum", "gearPartLumium", "gearPartEnderium"};
	public static final String[] TCGEARPART = new String[] {"gearPartAlumite", "gearPartArdite", "gearPartManyullyn"};
	public static final String[] RGEARPART = new String[] {"gearPartYellorium", "gearPartCyanite", "gearPartBluetonium", "gearPartLudicrite"};
	public static final String[] DGEARPART = new String[] {"gearPartDraconium", "gearPartDraconiumAwakened"};
	
	public static final String[] BMGEAR = new String[] {"gearCopper", "gearLead", "gearNickel", "gearPlatinum", "gearSilver", "gearTin", "gearIron", "gearGold"};
	public static final String[] CMGEAR = new String[] {"gearAluminum", "gearAluminium", "gearTungsten", "gearCobalt", "gearChrome", "gearTitanium"};
	public static final String[] AGEAR = new String[] {"gearBronze", "gearCrudeIron", "gearJoyk", "gearMewni", "gearOiur", "gearSteel", "gearCreative"};
	public static final String[] EGEAR = new String[] {"gearElectricalSteel", "gearEnergeticAlloy", "gearSoularium", "gearPhasedGold", "gearDarkSteel"};
	public static final String[] TCGEAR = new String[] {"gearAlumite", "gearArdite", "gearManyullyn"};
	public static final String[] RGEAR = new String[] {"gearYellorium", "gearCyanite", "gearBluetonium", "gearLudicrite"};
	public static final String[] DGEAR = new String[] {"gearDraconium", "gearDraconiumAwakened"};
	
	public static void oreDictRegister() {
		// Hammers/Молоты
		registerOre(HAMMERS, new ItemStack(MFTools.iron_hammer, 1, OreDictionary.WILDCARD_VALUE));
		registerOre(HAMMERS, new ItemStack(MFTools.crude_iron_hammer, 1, OreDictionary.WILDCARD_VALUE));
		registerOre(HAMMERS, new ItemStack(MFTools.oiur_hammer, 1, OreDictionary.WILDCARD_VALUE));
		// Cutters/Кусачки
		registerOre(CUTTERS, new ItemStack(MFTools.iron_cutters, 1, OreDictionary.WILDCARD_VALUE));
		registerOre(CUTTERS, new ItemStack(MFTools.crude_iron_cutters, 1, OreDictionary.WILDCARD_VALUE));
		registerOre(CUTTERS, new ItemStack(MFTools.oiur_cutters, 1, OreDictionary.WILDCARD_VALUE));
//		//registerOre(, );
		for (int i = 0; i < ORE.length; i++) {
			if (i < 1) 
				registerOre(ORE[i], new ItemStack(MFBlocks.metals_ore, 1, i));
			else
				registerOre(ORE[i], new ItemStack(MFBlocks.metals_ore, 1, i-1));
		}
		
		for (int i = 0; i < INGOT.length; i++) {
			if (i < 1) 
				registerOre(INGOT[i], new ItemStack(MFItems.metals_ingot, 1, i));
			else
				registerOre(INGOT[i], new ItemStack(MFItems.metals_ingot, 1, i-1));
		}
		
		for (int i = 0; i < ALLOY.length; i++) {
			registerOre(ALLOY[i], new ItemStack(MFItems.alloys_ingot, 1, i));
		}
		
		if (ConfigFile.EnabPlates) {
			for (int i = 0; i < MPLATE.length; i++) {
				if (i < 1) 
					registerOre(MPLATE[i], new ItemStack(MFItems.metals_plate, 1, i));
				else
					registerOre(MPLATE[i], new ItemStack(MFItems.metals_plate, 1, i-1));
			}
			for (int i = 0; i < APLATE.length; i++) {
				registerOre(APLATE[i], new ItemStack(MFItems.alloys_plate, 1, i));
			}
			if(MetalFeverMain.ENDER) {
				for (int i = 0; i < EPLATE.length; i++) {
					registerOre(EPLATE[i], new ItemStack(MFItems.ender_plate, 1, i));
				}
			}
			if(MetalFeverMain.THERMAL) {
				for (int i = 0; i < TPLATE.length; i++) {
					registerOre(TPLATE[i], new ItemStack(MFItems.therm_plate, 1, i));
				}
			}
			if(MetalFeverMain.DRACONIC)
				for(int i = 0; i < DEPLATE.length; i++) {
					registerOre(DEPLATE[i], new ItemStack(MFItems.draconic_plate, 1, i));
				}
			if(MetalFeverMain.REACTORS)
				for(int i = 0; i < BRPLATE.length; i++) {
					registerOre(BRPLATE[i], new ItemStack(MFItems.breactor_plate, 1, i));
				}
			if(MetalFeverMain.TINKERS)
				for(int i = 0; i < TCPLATE.length; i++) {
					registerOre(TCPLATE[i], new ItemStack(MFItems.tinkers_plate, 1, i));
				}
		}
		
		for (int i = 0; i < MNUGGET.length; i++) {
			if (i < 1) 
				registerOre(MNUGGET[i], new ItemStack(MFItems.metals_nugget, 1, i));
			else
				registerOre(MNUGGET[i], new ItemStack(MFItems.metals_nugget, 1, i-1));
		}
		for (int i = 0; i < ANUGGET.length; i++) {
			registerOre(ANUGGET[i], new ItemStack(MFItems.alloys_nugget, 1, i));
		}
		
		if (ConfigFile.EnabDust) {
			for (int i = 0; i < MDUST.length; i++) {
				if (i < 1) 
					registerOre(MDUST[i], new ItemStack(MFItems.metals_dust, 1, i));
				else
					registerOre(MDUST[i], new ItemStack(MFItems.metals_dust, 1, i-1));
			}
			for (int i = 0; i < ADUST.length; i++) {
				registerOre(ADUST[i], new ItemStack(MFItems.alloys_dust, 1, i));
			}
		}
		
		if(ConfigFile.EnabGearParts) {
			for (int i = 0; i < MGEARPART.length; i++) {
				if (i < 1) 
					registerOre(MGEARPART[i], new ItemStack(MFItems.metals_gear_part, 1, i));
				else
					registerOre(MGEARPART[i], new ItemStack(MFItems.metals_gear_part, 1, i-1));
			}
			for (int i = 0; i < AGEARPART.length; i++) {
				registerOre(AGEARPART[i], new ItemStack(MFItems.alloys_gear_part, 1, i));
			}
			if(MetalFeverMain.ENDER) {
				for (int i = 0; i < EGEARPART.length; i++) {
					registerOre(EGEARPART[i], new ItemStack(MFItems.ender_gear_part, 1, i));
				}
			}
			if(MetalFeverMain.THERMAL) {
				for (int i = 0; i < TGEARPART.length; i++) {
					registerOre(TGEARPART[i], new ItemStack(MFItems.thermal_gear_part, 1, i));
				}
			}
			if(MetalFeverMain.DRACONIC)
				for(int i = 0; i < DGEARPART.length; i++) {
					registerOre(DGEARPART[i], new ItemStack(MFItems.draconic_gear_part, 1, i));
				}
			if(MetalFeverMain.REACTORS)
				for(int i = 0; i < RGEARPART.length; i++) {
					registerOre(RGEARPART[i], new ItemStack(MFItems.breactor_gear_part, 1, i));
				}
			if(MetalFeverMain.TINKERS)
				for(int i = 0; i < TCGEARPART.length; i++) {
					registerOre(TCGEARPART[i], new ItemStack(MFItems.tinkers_gear_part, 1, i));
				}
		}

		for (int i = 0; i < CMGEAR.length; i++) {
			if (i < 1) 
				registerOre(CMGEAR[i], new ItemStack(MFItems.metals_gear_c, 1, i));
			else
				registerOre(CMGEAR[i], new ItemStack(MFItems.metals_gear_c, 1, i-1));
		}
		for (int i = 0; i < BMGEAR.length; i++) {
			registerOre(BMGEAR[i], new ItemStack(MFItems.metals_gear_b, 1, i));
		}
		for (int i = 0; i < AGEAR.length; i++) {
			registerOre(AGEAR[i], new ItemStack(MFItems.alloys_gear, 1, i));
		}
		if(MetalFeverMain.ENDER) {
			for (int i = 0; i < EGEAR.length; i++) {
				registerOre(EGEAR[i], new ItemStack(MFItems.ender_gear, 1, i));
			}
		}
		if(MetalFeverMain.DRACONIC)
			for(int i = 0; i < DGEAR.length; i++) {
				registerOre(DGEAR[i], new ItemStack(MFItems.draconic_gear, 1, i));
			}
		if(MetalFeverMain.REACTORS)
			for(int i = 0; i < RGEAR.length; i++) {
				registerOre(RGEAR[i], new ItemStack(MFItems.breactor_gear, 1, i));
			}
		if(MetalFeverMain.TINKERS)
			for(int i = 0; i < TCGEAR.length; i++) {
				registerOre(TCGEAR[i], new ItemStack(MFItems.tinkers_gear, 1, i));
			}
		
		registerOre(SLAG, new ItemStack(MFItems.slag));
		OreDictionary.initVanillaEntries();
	}
	
	private static void registerOre(String name, ItemStack itemStack) {
		OreDictionary.registerOre(name, itemStack);
	}
}
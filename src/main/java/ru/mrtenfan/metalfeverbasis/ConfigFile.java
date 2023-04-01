 package ru.mrtenfan.metalfeverbasis;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

import net.minecraftforge.common.config.Configuration;
import ru.mrtenfan.MTFCore.Debuging;

public class ConfigFile {
	
	public final String items = "Items";
	public final String gen = "Generation";
	public final String integ = "Integration";
	public final String twk = "Tweaks";
	
	public Configuration config;
	
	public static int DurIron;
	public static int DurCrude;
	public static boolean OiurInfinity;
	public static int DurOiur;
	public static boolean EnabPlates;
	public static boolean EnabDust;
	public static boolean EnabBronzeTool;
	public static boolean EnabBronzeArmor;
	public static boolean EnabCrudeTool;
	public static boolean EnabJoykTool;
	public static boolean EnabMewniTool;
	public static boolean EnabOiurTool;
	public static boolean EnabOiurArmor;
	public static boolean EnabSteelTool;
	public static boolean EnabSteelArmor;
	public static boolean EnabAlumSpawn;
	public static int[] AlumSpawn;
	public static boolean EnabCopSpawn;
	public static int[] CopSpawn;
	public static boolean EnabLeadSpawn;
	public static int[] LeadSpawn;
	public static boolean EnabNicSpawn;
	public static int[] NicSpawn;
	public static boolean EnabPlatSpawn;
	public static int[] PlatSpawn;
	public static boolean EnabTinSpawn;
	public static int[] TinSpawn;
	public static boolean EnabTungSpawn;
	public static int[] TungSpawn;
	public static boolean EnabSilSpawn;
	public static int[] SilSpawn;
	public static boolean ThermFoundInteg;
	public static boolean EnderIOInteg;
	public static boolean EzAlloys;
	public static boolean DustAlloys;
	public static boolean EnabCobaltSpawn;
	public static int[] CobaltSpawn;
	public static boolean EnabChromiumSpawn;
	public static int[] ChromiumSpawn;
	public static boolean EnabTitaniumSpawn;
	public static int[] TitaniumSpawn;
	public static boolean EnabCobaltTool;
	public static boolean TCInteg;
	public static boolean BigReactInteg;
	public static boolean DEInteg;
	public static boolean AFInteg;
	public static boolean SteelAlloy;
	public static boolean CrudeAlloy;
	public static boolean ThermExpanInteg;
	public static boolean IC2Integ;
	public static boolean EnabHammerCrafts;
	public static boolean EnabCutters;
	public static boolean EnabGearParts;
//	public static int NumberOfIngots;
    
    public ConfigFile(String directory, File oldFile) {
    	File configFile = new File(directory + "/MetalFever/Basis.cfg");
    	if(oldFile.exists()) {
    		moveFile(oldFile, configFile);
    	}
    	
    	config = new Configuration(configFile);
    	config.load();
    	
    	config.addCustomCategoryComment(items, "Change Metal Fever - Basis items for your modpack");
    	config.addCustomCategoryComment(gen, "Change Metal Fever - Basis generation for your modpack");
    	config.addCustomCategoryComment(integ, "Change Metal Fever - Basis integration for your modpack");
    	config.addCustomCategoryComment(twk, "Tweaks Metal Fever - Basis");
    	
    	EnabPlates=config.get(items, "Are plates enabled", true).getBoolean(true);
    	EnabDust=config.get(items, "Are dusts enabled", false).getBoolean(false);
    	DurIron=config.get(items, "Default durability of Iron Hammer and Cutter(dur -= dur / 4)", 80).getInt(80);
    	DurCrude=config.get(items, "Default durability of Crude Iron Hammer and Cutter(dur -= dur / 4)", 160).getInt(160);
    	OiurInfinity=config.get(items, "The hammer of Oiur is infinite?", false).getBoolean(false);
    	DurOiur=config.get(items, "Default durability of Oiur Hammer(if OiurInfinity = false) and Cutter(if OiurInfinity == false: dur -= dur / 4)", 640).getInt(640);
    	EnabBronzeArmor=config.get(items, "Are the Bronze armor enabled", true).getBoolean(true);
    	EnabBronzeTool=config.get(items, "Are Bronze tools enabled", true).getBoolean(true);
    	EnabCrudeTool=config.get(items, "Are Crude Iron tools enabled", true).getBoolean(true);
    	EnabJoykTool=config.get(items, "Are Joyk tools enabled", true).getBoolean(true);
    	EnabMewniTool=config.get(items, "Are Mewni tools enabled", true).getBoolean(true);
    	EnabOiurArmor=config.get(items, "Are the Oiur armor enabled", true).getBoolean(true);
    	EnabOiurTool=config.get(items, "Are Oiur tools enabled", true).getBoolean(true);
    	EnabSteelArmor=config.get(items, "Are the Steel armor enabled", true).getBoolean(true);
    	EnabSteelTool=config.get(items, "Are Steel tools enabled", true).getBoolean(true);
    	EnabCobaltTool=config.get(items, "Are Cobalt tools enabled", true).getBoolean(true);
    	
    	EzAlloys=config.get(twk, "Can alloys crafts in Crafting Table", false).getBoolean(false);
    	DustAlloys=config.get(twk, "Can craft alloys dust from metals dust", true).getBoolean(true);
    	
    	SteelAlloy=config.get(twk, "Can alloy steel in alloy furnace", true).getBoolean(true);
    	CrudeAlloy=config.get(twk, "Can alloy crude iron in alloy furnace", true).getBoolean(true);
    	
    	EnabAlumSpawn=config.get(gen, "Is Aluminum ore generated", true).getBoolean(true);
    	AlumSpawn=config.get(gen, "Settings for generation aluminum ore: mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {5, 8, 4, 8, 100, 15, 69}).setDefaultValues(new int[] {5, 8, 4, 8, 100, 15, 69}).getIntList();                                               
    	EnabCopSpawn=config.get(gen, "Is Copper ore generated", true).getBoolean(true);
    	CopSpawn=config.get(gen, "Settings for generation copper ore: mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {5, 10, 6, 12, 100, 20, 99}).setDefaultValues(new int[] {5, 10, 6, 12, 100, 20, 99}).getIntList();                                               
    	EnabLeadSpawn=config.get(gen, "Is Lead ore generated", true).getBoolean(true);
    	LeadSpawn=config.get(gen, "Settings for generation lead ore: mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {3, 6, 4, 8, 100, 1, 45}).setDefaultValues(new int[] {3, 6, 4, 8, 100, 1, 45}).getIntList();                                               
    	EnabNicSpawn=config.get(gen, "Is Nickel ore generated", true).getBoolean(true);
    	NicSpawn=config.get(gen, "Settings for generation nickel ore: mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {2, 6, 3, 9, 100, 10, 69}).setDefaultValues(new int[] {2, 6, 3, 9, 100, 10, 69}).getIntList();                                               
    	EnabPlatSpawn=config.get(gen, "Is Platinum ore generated", true).getBoolean(true);
    	PlatSpawn=config.get(gen, "Settings for generation platinum ore: mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {2, 4, 2, 5, 80, 10, 30}).setDefaultValues(new int[] {2, 4, 2, 5, 80, 10, 30}).getIntList();                                               
    	EnabTinSpawn=config.get(gen, "Is Tin ore generated", true).getBoolean(true);
    	TinSpawn=config.get(gen, "Settings for generation tin ore: mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {3, 8, 6, 10, 100, 30, 99}).setDefaultValues(new int[] {3, 8, 6, 10, 100, 30, 99}).getIntList();                                               
    	EnabTungSpawn=config.get(gen, "Is Tungsten ore generated", true).getBoolean(true);
    	TungSpawn=config.get(gen, "Settings for generation tungsten ore: mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {1, 4, 3, 7, 80, 10, 20}).setDefaultValues(new int[] {1, 4, 3, 7, 80, 10, 20}).getIntList();                                               
    	EnabSilSpawn=config.get(gen, "Is Silver ore generated", true).getBoolean(true);
    	SilSpawn=config.get(gen, "Settings for generation silver ore: mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {3, 8, 4, 9, 100, 10, 45}).setDefaultValues(new int[] {3, 8, 4, 9, 100, 10, 45}).getIntList();
    	
    	EnabCobaltSpawn=config.get(gen, "Is Cobalt ore generated", true).getBoolean(true);
    	CobaltSpawn=config.get(gen, "Settings for generation cobalt ore: minVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {2, 5, 10, 20, 90, 1, 255}).setDefaultValues(new int[] {2, 5, 10, 20, 90, 1, 255}).getIntList();
    	EnabChromiumSpawn=config.get(gen, "Is Chromium ore generated", true).getBoolean(true);
    	ChromiumSpawn=config.get(gen, "Settings for generation chromium ore: minVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {2, 4, 10, 20, 90, 1, 255}).setDefaultValues(new int[] {2, 4, 10, 20, 90, 1, 255}).getIntList();
    	EnabTitaniumSpawn=config.get(gen, "Is Titanium ore generated", true).getBoolean(true);
    	TitaniumSpawn=config.get(gen, "Settings for generation titanium ore: minVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY", new int[] {2, 4, 10, 20, 90, 1, 255}).setDefaultValues(new int[] {2, 4, 10, 20, 90, 1, 255}).getIntList();
    	
    	ThermFoundInteg=config.get(integ, "Is there integration with Thermal Foundation", true).getBoolean(true);
    	EnderIOInteg=config.get(integ, "Is there integration with Ender IO", true).getBoolean(true);
    	
    	TCInteg=config.get(integ, "Is there integration with Tinkers' Construct", true).getBoolean(true);
    	BigReactInteg=config.get(integ, "Is there integration with Big Reactors", true).getBoolean(true);
    	DEInteg=config.get(integ, "Is there integration with Draconic Evolution", true).getBoolean(true);
    	AFInteg=config.get(integ, "As long as this is 'true' alloy furnace will have alloys from other mods", true).getBoolean(true);
    	
    	ThermExpanInteg=config.get(integ, "Is there integration with Thermal Expansion", true).getBoolean(true);
    	IC2Integ=config.get(integ, "Is there integration with Industrial Craft 2", true).getBoolean(true);
    	
    	EnabHammerCrafts=config.get(twk, "While it's \"true\" - players can craft plates from ingot with hammer", true).getBoolean(true);
    	
    	EnabCutters=config.get(twk, "Are cutters enabled", true).getBoolean(true);
    	EnabGearParts=config.get(twk, "Are enabled new gear-system", true).getBoolean(true);
    	
//    	if(config.hasChanged()) {
//    		
//    	}
    	
    	config.save();
    }

	private void moveFile(File oldFile, File newFile) {
		try {
			Files.move(oldFile.getAbsoluteFile(), newFile.getAbsoluteFile());
		} catch(IOException e) {
			if(!newFile.exists())
			Debuging.errorOutput("Exception while moving file: " + e.getMessage(), MetalFeverMain.modName);
		}
		if(!oldFile.delete())
			Debuging.errorOutput("Error when trying to delete an old configuration file", MetalFeverMain.modName);
	}
}
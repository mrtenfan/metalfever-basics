package ru.mrtenfan.metalfeverbasis;

import cofh.thermalexpansion.ThermalExpansion;
import cofh.thermalfoundation.ThermalFoundation;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import minetweaker.MineTweakerAPI;
import ru.mrtenfan.MTFCore.MTFCoreMain;
import ru.mrtenfan.metalfeverbasis.crafting.AlloyFurnaceRecipe;
import ru.mrtenfan.metalfeverbasis.handler.GuiHandler;
import ru.mrtenfan.metalfeverbasis.init.LibOreDictionary;
import ru.mrtenfan.metalfeverbasis.init.MFBlocks;
import ru.mrtenfan.metalfeverbasis.init.MFCrafting;
import ru.mrtenfan.metalfeverbasis.init.MFItems;
import ru.mrtenfan.metalfeverbasis.init.MFOther;
import ru.mrtenfan.metalfeverbasis.init.MFTools;
import ru.mrtenfan.metalfeverbasis.integration.ThermalExpansion.ThermalExpansionCompat;
import ru.mrtenfan.metalfeverbasis.integration.ic2.IndustrialCraftCompat;
import ru.mrtenfan.metalfeverbasis.integration.minetweaker.MTAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.integration.minetweaker.MTRecyclingFurnace;

@Mod(modid = MetalFeverMain.modID, name = MetalFeverMain.modName, version = MetalFeverMain.version, dependencies = MTFCoreMain.version_group)
public class MetalFeverMain {

	public static final String modID = "MetalFeverBasis";
	public static final String modName = "Metal Fever - Basis";
	public static final String version = "1.4.0.7";
	public static final String version_max = "1.4.0.999";

	public static final String version_group = "required-after:" + modID + "@[" + version + "," + version_max + "];";

	public static boolean THERMAL;
	public static boolean ENDER;
	public static boolean REACTORS;
	public static boolean TINKERS;
	public static boolean DRACONIC;

	@Instance("MetalFeverBasis")
	public static MetalFeverMain instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		new ConfigFile(e.getModConfigurationDirectory().getAbsolutePath(), e.getSuggestedConfigurationFile());
		MFBlocks.preInitialize();
		MFItems.preInitialize();
		MFTools.preInitialize();

		//ОБЯЗАТЕЛЬНО ДЛЯ GUI
		new GuiHandler();
		NetworkRegistry.INSTANCE.registerGuiHandler(MetalFeverMain.instance, new GuiHandler());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		updateModStatus();
		
		MFBlocks.initialize();
		MFItems.initialize();
		MFTools.initialize();
		MFOther.initializeSpawnOres();
		LibOreDictionary.oreDictRegister();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		MFCrafting.initializeCraftings();
		if(ConfigFile.EnabPlates && ConfigFile.EnabHammerCrafts)
			MFCrafting.initializeHammerCraft();
		MFCrafting.initializeSmeltings();

		MFCrafting.initializeCustomCrafting();

		AlloyFurnaceRecipe.fuelInit();
		if(Loader.isModLoaded("MineTweaker3")) {
			minetweakerInit();
		}

		if(ConfigFile.ThermExpanInteg && Loader.isModLoaded(ThermalExpansion.modId))
			ThermalExpansionCompat.compatInit();
		if(ConfigFile.IC2Integ && Loader.isModLoaded("IndustrialCraft 2"))
			IndustrialCraftCompat.compatInit();

		if(ConfigFile.EnabCutters)
			MFCrafting.initializeCuttersCrafting(ConfigFile.EnabGearParts, ConfigFile.EnabPlates);
		MFCrafting.initializeGearCrafting(ConfigFile.EnabGearParts);
	}
	
	private void minetweakerInit() {
		MineTweakerAPI.registerClass(MTAlloyFurnace.class);
		MineTweakerAPI.registerClass(MTRecyclingFurnace.class);
	}

	private void updateModStatus() {
		THERMAL = ConfigFile.ThermFoundInteg && Loader.isModLoaded(ThermalFoundation.modId);
		ENDER = ConfigFile.EnderIOInteg && Loader.isModLoaded("EnderIO");
		REACTORS = ConfigFile.BigReactInteg && Loader.isModLoaded("BigReactors");
		TINKERS = ConfigFile.TCInteg && Loader.isModLoaded("TConstruct");
		DRACONIC = ConfigFile.DEInteg && Loader.isModLoaded("DraconicEvolution");
	}
}
/*
 * Дальше будет крик души автора...
 * Слабонервным не читать! :)
 * 
 * 
 */
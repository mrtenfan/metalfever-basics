package ru.mrtenfan.metalfeverbasis.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import ru.mrtenfan.metalfeverbasis.ConfigFile;
import ru.mrtenfan.metalfeverbasis.MetalFeverMain;
import ru.mrtenfan.metalfeverbasis.items.Slag;
import ru.mrtenfan.metalfeverbasis.items.dusts.AlloysDust;
import ru.mrtenfan.metalfeverbasis.items.dusts.MetalsDust;
import ru.mrtenfan.metalfeverbasis.items.gears.AlloysGear;
import ru.mrtenfan.metalfeverbasis.items.gears.AlloysGearPart;
import ru.mrtenfan.metalfeverbasis.items.gears.BMetalsGear;
import ru.mrtenfan.metalfeverbasis.items.gears.BReactorGear;
import ru.mrtenfan.metalfeverbasis.items.gears.BReactorGearPart;
import ru.mrtenfan.metalfeverbasis.items.gears.CMetalsGear;
import ru.mrtenfan.metalfeverbasis.items.gears.DraconicGear;
import ru.mrtenfan.metalfeverbasis.items.gears.DraconicGearPart;
import ru.mrtenfan.metalfeverbasis.items.gears.EnderGear;
import ru.mrtenfan.metalfeverbasis.items.gears.EnderGearPart;
import ru.mrtenfan.metalfeverbasis.items.gears.MetalsGearPart;
import ru.mrtenfan.metalfeverbasis.items.gears.ThermalGearPart;
import ru.mrtenfan.metalfeverbasis.items.gears.TinkersGear;
import ru.mrtenfan.metalfeverbasis.items.gears.TinkersGearPart;
import ru.mrtenfan.metalfeverbasis.items.ingots.AlloysIngot;
import ru.mrtenfan.metalfeverbasis.items.ingots.MetalsIngot;
import ru.mrtenfan.metalfeverbasis.items.nuggets.AlloysNugget;
import ru.mrtenfan.metalfeverbasis.items.nuggets.MetalsNugget;
import ru.mrtenfan.metalfeverbasis.items.plates.AlloysPlate;
import ru.mrtenfan.metalfeverbasis.items.plates.BReactorPlate;
import ru.mrtenfan.metalfeverbasis.items.plates.DraconicPlate;
import ru.mrtenfan.metalfeverbasis.items.plates.EnderPlate;
import ru.mrtenfan.metalfeverbasis.items.plates.MetalsPlate;
import ru.mrtenfan.metalfeverbasis.items.plates.ThermalPlate;
import ru.mrtenfan.metalfeverbasis.items.plates.TinkersPlate;

public class MFItems {

	public static Item metals_ingot;
	public static Item alloys_ingot;
	public static Item metals_plate;
	public static Item alloys_plate;
	public static Item metals_nugget;
	public static Item alloys_nugget;
	public static Item metals_dust;
	public static Item alloys_dust;
	public static Item ender_plate;
	public static Item therm_plate;
	public static Item slag;
	public static Item tinkers_plate;
	public static Item breactor_plate;
	public static Item draconic_plate;
	public static Item metals_gear_b;
	public static Item metals_gear_c;
	public static Item alloys_gear;
	public static Item ender_gear;
	public static Item tinkers_gear;
	public static Item breactor_gear;
	public static Item draconic_gear;
	public static Item metals_gear_part;
	public static Item alloys_gear_part;
	public static Item ender_gear_part;
	public static Item tinkers_gear_part;
	public static Item thermal_gear_part;
	public static Item breactor_gear_part;
	public static Item draconic_gear_part;

	public static void preInitialize() {
    	metals_ingot = new MetalsIngot();
    	alloys_ingot = new AlloysIngot();
    	metals_plate = new MetalsPlate();
    	alloys_plate = new AlloysPlate();
    	metals_nugget = new MetalsNugget();
    	alloys_nugget = new AlloysNugget();
    	metals_dust = new MetalsDust();
    	alloys_dust = new AlloysDust();
    	ender_plate = new EnderPlate();
    	therm_plate = new ThermalPlate();
    	slag = new Slag("slag");
    	tinkers_plate = new TinkersPlate();
    	breactor_plate = new BReactorPlate();
    	draconic_plate = new DraconicPlate();
    	metals_gear_b = new BMetalsGear();
    	metals_gear_c = new CMetalsGear();
    	alloys_gear = new AlloysGear();
    	ender_gear = new EnderGear();
    	tinkers_gear = new TinkersGear();
    	breactor_gear = new BReactorGear();
    	draconic_gear = new DraconicGear();
    	metals_gear_part = new MetalsGearPart();
    	alloys_gear_part = new AlloysGearPart();
    	ender_gear_part = new EnderGearPart();
    	tinkers_gear_part = new TinkersGearPart();
    	thermal_gear_part = new ThermalGearPart();
    	breactor_gear_part = new BReactorGearPart();
    	draconic_gear_part = new DraconicGearPart();
	}

	public static void initialize() {
		   GameRegistry.registerItem(metals_ingot, "item.metalIngot");
		   GameRegistry.registerItem(alloys_ingot, "item.alloyIngot");
		   if (ConfigFile.EnabPlates) {
			   GameRegistry.registerItem(metals_plate, "item.metalPlate");
			   GameRegistry.registerItem(alloys_plate, "item.alloyPlate");
			   if(MetalFeverMain.THERMAL)
				   GameRegistry.registerItem(therm_plate, "item.integration.foundationPlate");
			   if(MetalFeverMain.ENDER)
				   GameRegistry.registerItem(ender_plate, "item.integration.enderIOPlate");
			   if(MetalFeverMain.REACTORS)
				   GameRegistry.registerItem(breactor_plate, "item.integration.bigReactorsPlate");
			   if(MetalFeverMain.TINKERS)
				   GameRegistry.registerItem(tinkers_plate, "item.integration.tinkersConstructPlate");
			   if(MetalFeverMain.DRACONIC)
				   GameRegistry.registerItem(draconic_plate, "item.integration.draconicEvolutionPlate");
		   }
		   GameRegistry.registerItem(metals_nugget, "item.metalNugget");
		   GameRegistry.registerItem(alloys_nugget, "item.alloyNugget");
		   if (ConfigFile.EnabDust) {
			   GameRegistry.registerItem(metals_dust, "item.metalDust");
			   GameRegistry.registerItem(alloys_dust, "item.alloyDust");
		   }
		   GameRegistry.registerItem(slag, "item.slag");
		   GameRegistry.registerItem(metals_gear_b, "item.metalGearB");
		   GameRegistry.registerItem(metals_gear_c, "item.metalGearC");
		   GameRegistry.registerItem(alloys_gear, "item.alloyGear");
		   if(MetalFeverMain.ENDER)
			   GameRegistry.registerItem(ender_gear, "item.enderIOGear");
		   if(MetalFeverMain.REACTORS)
			   GameRegistry.registerItem(breactor_gear, "item.bigReactorsGear");
		   if(MetalFeverMain.TINKERS)
			   GameRegistry.registerItem(tinkers_gear, "item.tinkersConstructGear");
		   if(MetalFeverMain.DRACONIC)
			   GameRegistry.registerItem(draconic_gear, "item.draconicEvolutionGear");
		   if(ConfigFile.EnabGearParts) {
			   GameRegistry.registerItem(metals_gear_part, "item.metalGearPart");
			   GameRegistry.registerItem(alloys_gear_part, "item.alloyGearPart");
			   if(MetalFeverMain.THERMAL)
				   GameRegistry.registerItem(thermal_gear_part, "item.foundationGearPart");
			   if(MetalFeverMain.ENDER)
				   GameRegistry.registerItem(ender_gear_part, "item.enderIOGearPart");
			   if(MetalFeverMain.REACTORS)
				   GameRegistry.registerItem(breactor_gear_part, "item.bigReactorsGearPart");
			   if(MetalFeverMain.TINKERS)
				   GameRegistry.registerItem(tinkers_gear_part, "item.tinkersConstructGearPart");
			   if(MetalFeverMain.DRACONIC)
				   GameRegistry.registerItem(draconic_gear_part, "item.draconicEvolutionGearPart");
		   }
	}
}
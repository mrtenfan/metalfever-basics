package ru.mrtenfan.metalfeverbasis.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import ru.mrtenfan.metalfeverbasis.ConfigFile;
import ru.mrtenfan.metalfeverbasis.tools.armor.BronzeArmor;
import ru.mrtenfan.metalfeverbasis.tools.armor.OiurArmor;
import ru.mrtenfan.metalfeverbasis.tools.armor.SteelArmor;
import ru.mrtenfan.metalfeverbasis.tools.cutters.CrudeCutters;
import ru.mrtenfan.metalfeverbasis.tools.cutters.IronCutters;
import ru.mrtenfan.metalfeverbasis.tools.cutters.OiurCutters;
import ru.mrtenfan.metalfeverbasis.tools.hammers.CrudeHammer;
import ru.mrtenfan.metalfeverbasis.tools.hammers.IronHammer;
import ru.mrtenfan.metalfeverbasis.tools.hammers.OiurHammer;
import ru.mrtenfan.metalfeverbasis.tools.sword.BronzeSword;
import ru.mrtenfan.metalfeverbasis.tools.sword.CobaltSword;
import ru.mrtenfan.metalfeverbasis.tools.sword.CrudeIronSword;
import ru.mrtenfan.metalfeverbasis.tools.sword.JoykSword;
import ru.mrtenfan.metalfeverbasis.tools.sword.MewniSword;
import ru.mrtenfan.metalfeverbasis.tools.sword.OiurSword;
import ru.mrtenfan.metalfeverbasis.tools.sword.SteelSword;
import ru.mrtenfan.metalfeverbasis.tools.tool.BronzeAxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.BronzeHoe;
import ru.mrtenfan.metalfeverbasis.tools.tool.BronzePickaxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.BronzeShovel;
import ru.mrtenfan.metalfeverbasis.tools.tool.CobaltAxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.CobaltPickaxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.CobaltShovel;
import ru.mrtenfan.metalfeverbasis.tools.tool.CrudeIronAxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.CrudeIronHoe;
import ru.mrtenfan.metalfeverbasis.tools.tool.CrudeIronPickaxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.CrudeIronShovel;
import ru.mrtenfan.metalfeverbasis.tools.tool.JoykAxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.JoykPickaxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.JoykShovel;
import ru.mrtenfan.metalfeverbasis.tools.tool.MewniAxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.MewniPickaxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.MewniShovel;
import ru.mrtenfan.metalfeverbasis.tools.tool.OiurAxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.OiurPickaxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.OiurShovel;
import ru.mrtenfan.metalfeverbasis.tools.tool.SteelAxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.SteelHoe;
import ru.mrtenfan.metalfeverbasis.tools.tool.SteelPickaxe;
import ru.mrtenfan.metalfeverbasis.tools.tool.SteelShovel;

public class MFTools {

	public static Item iron_hammer;
	public static Item crude_iron_hammer;
	public static Item oiur_hammer;
	public static Item bronze_sword;
	public static Item bronze_pickaxe;
	public static Item bronze_shovel;
	public static Item bronze_axe;
	public static Item bronze_hoe;
	public static Item crude_iron_sword;
	public static Item crude_iron_pickaxe;
	public static Item crude_iron_shovel;
	public static Item crude_iron_axe;
	public static Item crude_iron_hoe;
	public static Item joyk_sword;
	public static Item joyk_pickaxe;
	public static Item joyk_shovel;
	public static Item joyk_axe;
	public static Item mewni_sword;
	public static Item mewni_pickaxe;
	public static Item mewni_shovel;
	public static Item mewni_axe;
	public static Item oiur_sword;
	public static Item oiur_pickaxe;
	public static Item oiur_shovel;
	public static Item oiur_axe;
	public static Item steel_sword;
	public static Item steel_pickaxe;
	public static Item steel_shovel;
	public static Item steel_axe;
	public static Item steel_hoe;
	public static Item bronze_helmet;
	public static Item bronze_chestplate;
	public static Item bronze_leggs;
	public static Item bronze_boots;
	public static Item oiur_helmet;
	public static Item oiur_chestplate;
	public static Item oiur_leggs;
	public static Item oiur_boots;
	public static Item steel_helmet;
	public static Item steel_chestplate;
	public static Item steel_leggs;
	public static Item steel_boots;
	public static Item cobalt_sword;
	public static Item cobalt_pickaxe;
	public static Item cobalt_shovel;
	public static Item cobalt_axe;
	public static Item iron_cutters;
	public static Item crude_iron_cutters;
	public static Item oiur_cutters;

	public static void preInitialize() {	
    	iron_hammer = new IronHammer("iron_hammer", ConfigFile.DurIron);
    	crude_iron_hammer = new CrudeHammer("crude_iron_hammer", ConfigFile.DurCrude);
    	oiur_hammer = new OiurHammer("oiur_hammer", ConfigFile.DurOiur, ConfigFile.OiurInfinity);
    	bronze_sword = new BronzeSword("bronze_sword", MFOther.BRONZETO);
    	bronze_pickaxe = new BronzePickaxe("bronze_pickaxe", MFOther.BRONZETO);
    	bronze_shovel = new BronzeShovel("bronze_shovel", MFOther.BRONZETO);
    	bronze_axe = new BronzeAxe("bronze_axe", MFOther.BRONZETO);
    	bronze_hoe = new BronzeHoe("bronze_hoe", MFOther.BRONZETO);
    	crude_iron_sword = new CrudeIronSword("crude_iron_sword", MFOther.CRUDEIRON);
    	crude_iron_pickaxe = new CrudeIronPickaxe("crude_iron_pickaxe", MFOther.CRUDEIRON);
    	crude_iron_shovel = new CrudeIronShovel("crude_iron_shovel", MFOther.CRUDEIRON);
    	crude_iron_axe = new CrudeIronAxe("crude_iron_axe", MFOther.CRUDEIRON);
    	crude_iron_hoe = new CrudeIronHoe("crude_iron_hoe", MFOther.CRUDEIRON);
    	joyk_sword = new JoykSword("joyk_sword", MFOther.JOYK);
    	joyk_pickaxe = new JoykPickaxe("joyk_pickaxe", MFOther.JOYK);
    	joyk_shovel = new JoykShovel("joyk_shovel", MFOther.JOYK);
    	joyk_axe = new JoykAxe("joyk_axe", MFOther.JOYK);
    	mewni_sword = new MewniSword("mewni_sword", MFOther.MEWNI);
    	mewni_pickaxe = new MewniPickaxe("mewni_pickaxe", MFOther.MEWNI);
    	mewni_shovel = new MewniShovel("mewni_shovel", MFOther.MEWNI);
    	mewni_axe = new MewniAxe("mewni_axe", MFOther.MEWNI);
    	oiur_sword = new OiurSword("oiur_sword", MFOther.OIURTO);
    	oiur_pickaxe = new OiurPickaxe("oiur_pickaxe", MFOther.OIURTO);
    	oiur_shovel = new OiurShovel("oiur_shovel", MFOther.OIURTO);
    	oiur_axe = new OiurAxe("oiur_axe", MFOther.OIURTO);
    	steel_sword = new SteelSword("steel_sword", MFOther.STEELTO);
    	steel_pickaxe = new SteelPickaxe("steel_pickaxe", MFOther.STEELTO);
    	steel_shovel = new SteelShovel("steel_shovel", MFOther.STEELTO);
    	steel_axe = new SteelAxe("steel_axe", MFOther.STEELTO);
    	steel_hoe = new SteelHoe("steel_hoe", MFOther.STEELTO);
    	bronze_helmet = new BronzeArmor(0, 0, MFOther.BRONZEAR).setUnlocalizedName("bronze_helmet").setTextureName("metalfeverbasis:bronze_helmet");
    	bronze_chestplate = new BronzeArmor(0, 1, MFOther.BRONZEAR).setUnlocalizedName("bronze_chestplate").setTextureName("metalfeverbasis:bronze_chestplate");
    	bronze_leggs = new BronzeArmor(0, 2, MFOther.BRONZEAR).setUnlocalizedName("bronze_leggs").setTextureName("metalfeverbasis:bronze_leggings");
    	bronze_boots = new BronzeArmor(0, 3, MFOther.BRONZEAR).setUnlocalizedName("bronze_boots").setTextureName("metalfeverbasis:bronze_boots");
    	oiur_helmet = new OiurArmor(0, 0, MFOther.OIURAR).setUnlocalizedName("oiur_helmet").setTextureName("metalfeverbasis:oiur_helmet");
    	oiur_chestplate = new OiurArmor(0, 1, MFOther.OIURAR).setUnlocalizedName("oiur_chestplate").setTextureName("metalfeverbasis:oiur_chestplate");
    	oiur_leggs = new OiurArmor(0, 2, MFOther.OIURAR).setUnlocalizedName("oiur_leggs").setTextureName("metalfeverbasis:oiur_leggings");
    	oiur_boots = new OiurArmor(0, 3, MFOther.OIURAR).setUnlocalizedName("oiur_boots").setTextureName("metalfeverbasis:oiur_boots");
    	steel_helmet = new SteelArmor(0, 0, MFOther.STEELAR).setUnlocalizedName("steel_helmet").setTextureName("metalfeverbasis:steel_helmet");
    	steel_chestplate = new SteelArmor(0, 1, MFOther.STEELAR).setUnlocalizedName("steel_chestplate").setTextureName("metalfeverbasis:steel_chestplate");
    	steel_leggs = new SteelArmor(0, 2, MFOther.STEELAR).setUnlocalizedName("steel_leggs").setTextureName("metalfeverbasis:steel_leggings");
    	steel_boots = new SteelArmor(0, 3, MFOther.STEELAR).setUnlocalizedName("steel_boots").setTextureName("metalfeverbasis:steel_boots");
    	cobalt_sword = new CobaltSword("cobalt_sword", MFOther.COBALT);
    	cobalt_pickaxe = new CobaltPickaxe("cobalt_pickaxe", MFOther.COBALT);
    	cobalt_shovel = new CobaltShovel("cobalt_shovel", MFOther.COBALT);
    	cobalt_axe = new CobaltAxe("cobalt_axe", MFOther.COBALT);
    	iron_cutters = new IronCutters("iron_metal_cutters", ConfigFile.DurIron);
    	crude_iron_cutters = new CrudeCutters("crude_iron_metal_cutters", ConfigFile.DurCrude);
    	oiur_cutters = new OiurCutters("oiur_metal_cutters", ConfigFile.DurOiur, ConfigFile.OiurInfinity);
	}

	public static void initialize() {
		if (ConfigFile.EnabPlates) {
			GameRegistry.registerItem(iron_hammer, "item.ironHammer");
			GameRegistry.registerItem(crude_iron_hammer, "item.crudeIronHammer");
			GameRegistry.registerItem(oiur_hammer, "item.oiurHammer");
		}
    	if (ConfigFile.EnabBronzeTool) {
    		GameRegistry.registerItem(bronze_sword, "item.bronzeSword");
    		GameRegistry.registerItem(bronze_pickaxe, "item.bronzePickaxe");
    		GameRegistry.registerItem(bronze_shovel, "item.bronzeShovel");
    		GameRegistry.registerItem(bronze_axe, "item.bronzeAxe");
    		GameRegistry.registerItem(bronze_hoe, "item.bronzeHoe");
    	}
    	if (ConfigFile.EnabCrudeTool) {
    		GameRegistry.registerItem(crude_iron_sword, "item.crudeIronSword");
    		GameRegistry.registerItem(crude_iron_pickaxe, "item.crudeIronPickaxe");
    		GameRegistry.registerItem(crude_iron_shovel, "item.crudeIronShovel");
    		GameRegistry.registerItem(crude_iron_axe, "item.crudeIronAxe");
    		GameRegistry.registerItem(crude_iron_hoe, "item.crudeIronHoe");
    	}
    	if (ConfigFile.EnabJoykTool) {
    		GameRegistry.registerItem(joyk_sword, "item.joykSword");
    		GameRegistry.registerItem(joyk_pickaxe, "item.joykPickaxe");
    		GameRegistry.registerItem(joyk_shovel, "item.joykShovel");
    		GameRegistry.registerItem(joyk_axe, "item.joykAxe");
    	}
    	if (ConfigFile.EnabMewniTool) {
    		GameRegistry.registerItem(mewni_sword, "item.mewniSword");
    		GameRegistry.registerItem(mewni_pickaxe, "item.mewniPickaxe");
    		GameRegistry.registerItem(mewni_shovel, "item.mewniShovel");
    		GameRegistry.registerItem(mewni_axe, "item.mewniAxe");
    	}
    	if (ConfigFile.EnabOiurTool) {
    		GameRegistry.registerItem(oiur_sword, "item.oiurSword");
    		GameRegistry.registerItem(oiur_pickaxe, "item.oiurPickaxe");
    		GameRegistry.registerItem(oiur_shovel, "item.oiurShovel");
    		GameRegistry.registerItem(oiur_axe, "item.oiurAxe");
    	}
    	if (ConfigFile.EnabSteelTool) {
    		GameRegistry.registerItem(steel_sword, "item.steelSword");
    		GameRegistry.registerItem(steel_pickaxe, "item.steelPickaxe");
    		GameRegistry.registerItem(steel_shovel, "item.steelShovel");
    		GameRegistry.registerItem(steel_axe, "item.steelAxe");
    		GameRegistry.registerItem(steel_hoe, "item.steelHoe");
    	}
    	if (ConfigFile.EnabBronzeArmor) {
    		GameRegistry.registerItem(bronze_helmet, "item.bronzeHelmet");
    		GameRegistry.registerItem(bronze_chestplate, "item.bronzeChestplate");
    		GameRegistry.registerItem(bronze_leggs, "item.bronzeLeggs");
    		GameRegistry.registerItem(bronze_boots, "item.bronzeBoots");
    	}
    	if (ConfigFile.EnabOiurArmor) {
    		GameRegistry.registerItem(oiur_helmet, "item.oiurHelmet");
    		GameRegistry.registerItem(oiur_chestplate, "item.oiurChestplate");
    		GameRegistry.registerItem(oiur_leggs, "item.oiurLeggs");
    		GameRegistry.registerItem(oiur_boots, "item.oiurBoots");
    	}
    	if (ConfigFile.EnabSteelArmor) {
    		GameRegistry.registerItem(steel_helmet, "item.steelHelmet");
    		GameRegistry.registerItem(steel_chestplate, "item.steelChestplate");
    		GameRegistry.registerItem(steel_leggs, "item.steelLeggs");
    		GameRegistry.registerItem(steel_boots, "item.steelBoots");
    	}
    	if (ConfigFile.EnabCobaltTool) {
    		GameRegistry.registerItem(cobalt_sword, "item.cobaltSword");
    		GameRegistry.registerItem(cobalt_pickaxe, "item.cobaltPickaxe");
    		GameRegistry.registerItem(cobalt_shovel, "item.cobaltShovel");
    		GameRegistry.registerItem(cobalt_axe, "item.cobaltAxe");
    	}
    	if(ConfigFile.EnabCutters) {
			GameRegistry.registerItem(iron_cutters, "item.ironCutters");
			GameRegistry.registerItem(crude_iron_cutters, "item.crudeIronCutters");
			GameRegistry.registerItem(oiur_cutters, "item.oiurCutters");
    	}
	}
}
package ru.mrtenfan.metalfeverbasis.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import ru.mrtenfan.metalfeverbasis.TabMetalFeverDeco;
import ru.mrtenfan.metalfeverbasis.TabMetalFeverMain;
import ru.mrtenfan.metalfeverbasis.TabMetalFeverTools;

public class MFOther {

	public static final ToolMaterial BRONZETO = EnumHelper.addToolMaterial("BRONZE", 2, 377, 4.5F, 2.0F, 12); //max = 22(gold)* 1
	public static final ToolMaterial CRUDEIRON = EnumHelper.addToolMaterial("CRUDEIRON", 2, 502, 5.5F, 1.5F, 9);
	public static final ToolMaterial JOYK = EnumHelper.addToolMaterial("JOYK", 2, 196, 3.75F, 1.0F, 16);
	public static final ToolMaterial MEWNI = EnumHelper.addToolMaterial("MEWNI", 1, 56, 10.0F, 0.5F, 8);
	public static final ToolMaterial OIURTO = EnumHelper.addToolMaterial("OIUR", 4, 2888, 8.0F, 6.0F, 12);
	public static final ToolMaterial STEELTO = EnumHelper.addToolMaterial("STEEL", 3, 803, 5.0F, 3.5F, 12);
	public static final ArmorMaterial BRONZEAR = EnumHelper.addArmorMaterial("BRONZE", 15, new int[] {2, 6, 5, 2}, 11); //max = 25(gold) * 1
	public static final ArmorMaterial OIURAR = EnumHelper.addArmorMaterial("OIUR", 40, new int[] {4, 9, 7, 4}, 19);
	public static final ArmorMaterial STEELAR = EnumHelper.addArmorMaterial("STEEL", 20, new int[] {3, 8, 6, 3}, 12);
	public static CreativeTabs TabMetalFeverMain = new TabMetalFeverMain("tabMetalFeverMain");
	public static CreativeTabs TabMetalFeverDeco = new TabMetalFeverDeco("tabMetalFeverDeco"); //Update 1.2.0
	public static CreativeTabs TabMetalFeverTools = new TabMetalFeverTools("tabMetalFeverTools");
	public static OreGenerator oregenerator = new OreGenerator();
	//Update 1.1.0
	public static final ToolMaterial COBALT = EnumHelper.addToolMaterial("COBALT", 4, 2341, 11.0F, 4.0F, 17);
    
	
	public static void initializeSpawnOres() {
		GameRegistry.registerWorldGenerator(oregenerator, 1);
	}
}

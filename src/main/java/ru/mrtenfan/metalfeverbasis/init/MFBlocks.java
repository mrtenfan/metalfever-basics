package ru.mrtenfan.metalfeverbasis.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.mrtenfan.metalfeverbasis.blocks.AlloyFurnace;
import ru.mrtenfan.metalfeverbasis.blocks.RecyclingFurnace;
import ru.mrtenfan.metalfeverbasis.blocks.ores.ItemMetalsOre;
import ru.mrtenfan.metalfeverbasis.blocks.ores.MetalsOre;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityRecyclingFurnace;

public class MFBlocks {
	
	public static Block metals_ore;
	public static Block alloy_furnace;
	public static Block alloy_furnace_active;
	public static final int GUI_ID_alloy_furnace = 1;
	public static Block recycling_furnace;
	public static Block recycling_furnace_active;
	public static final int GUI_ID_recycling_furnace = 2;

	public static void preInitialize() {
		metals_ore = new MetalsOre(Material.rock, 3F, 5F, "pickaxe");
    	alloy_furnace = new AlloyFurnace(Material.rock, "alloy_furnace_idle", 3.5F, 15F, "pickaxe", 1, false);
    	alloy_furnace_active = new AlloyFurnace(Material.rock, "alloy_furnace_active", 3.5F, 15F, "pickaxe", 1, true);
    	recycling_furnace = new RecyclingFurnace(Material.iron, "recycling_furnace_idle", 3.5F, 15F, "pickaxe", 1, false);
    	recycling_furnace_active = new RecyclingFurnace(Material.iron, "recycling_furnace_active", 3.5F, 15F, "pickaxe", 1, true);
	}

	public static void initialize() {
		GameRegistry.registerBlock(metals_ore, ItemMetalsOre.class, "tile.metalOre");
		GameRegistry.registerBlock(alloy_furnace, "tile.alloyFurnace");
		GameRegistry.registerBlock(alloy_furnace_active, "tile.alloyFurnaceActive");
    	GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, "tileEntity.alloyFurnace");
		GameRegistry.registerBlock(recycling_furnace, "tile.recyclingFurnace");
		GameRegistry.registerBlock(recycling_furnace_active, "tile.recyclingFurnaceActive");
    	GameRegistry.registerTileEntity(TileEntityRecyclingFurnace.class, "tileEntity.recyclingFurnace");
	}
}
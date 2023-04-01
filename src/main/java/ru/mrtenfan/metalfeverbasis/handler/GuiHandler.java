package ru.mrtenfan.metalfeverbasis.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ru.mrtenfan.metalfeverbasis.GUI.GUIAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.GUI.GUIRecyclingFurnace;
import ru.mrtenfan.metalfeverbasis.container.ContainerAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.container.ContainerRecyclingFurnace;
import ru.mrtenfan.metalfeverbasis.init.MFBlocks;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityRecyclingFurnace;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null) {
			switch(ID) {
			case MFBlocks.GUI_ID_alloy_furnace:
				if (entity instanceof TileEntityAlloyFurnace) 
					return new ContainerAlloyFurnace(player.inventory, (TileEntityAlloyFurnace) entity); 
			case MFBlocks.GUI_ID_recycling_furnace:
				if (entity instanceof TileEntityRecyclingFurnace) 
					return new ContainerRecyclingFurnace(player.inventory, (TileEntityRecyclingFurnace) entity); 
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null) {
			switch(ID) {
			case MFBlocks.GUI_ID_alloy_furnace:
				if (entity instanceof TileEntityAlloyFurnace) 
					return new GUIAlloyFurnace(player.inventory, (TileEntityAlloyFurnace) entity); 
			case MFBlocks.GUI_ID_recycling_furnace:
				if (entity instanceof TileEntityRecyclingFurnace) 
					return new GUIRecyclingFurnace(player.inventory, (TileEntityRecyclingFurnace) entity);     
			}
		}
		return null;
	}
}
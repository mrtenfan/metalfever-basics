package ru.mrtenfan.metalfeverbasis.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import ru.mrtenfan.metalfeverbasis.container.ContainerRecyclingFurnace;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityRecyclingFurnace;

public class GUIRecyclingFurnace extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation("metalfeverbasis:textures/gui/recycling_furnace_GUI.png");

	public TileEntityRecyclingFurnace entity;

	public GUIRecyclingFurnace(InventoryPlayer playerInv, TileEntityRecyclingFurnace tileEntity) {
		 super(new ContainerRecyclingFurnace(playerInv, tileEntity));
		  
		 this.entity = tileEntity;
	  
		 xSize = 176;
		 ySize = 166;
	}

	 public void drawGuiContainerForegroundLayer(int par1, int par2) {
		 String name = this.entity.hasCustomInventoryName() ? this.entity.getInventoryName() : I18n.format(this.entity.getInventoryName(), new Object[0]);
		 
		 this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 4, 4210752);
		 this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 92, 4210752);
	 }
	 
	 @Override
	 public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		  GL11.glColor4f(1F, 1F, 1F, 1F);
		  mc.getTextureManager().bindTexture(texture);
		  drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
		  
		  if (entity.isAlloying()) { 
			  int i = entity.getBurnTimeRemainingScaled(13);
			  drawTexturedModalRect(guiLeft + 56, guiTop + 50 - i - 1, 176, 31 - i - 1, 17, i - 1);

			  int j = entity.getAlloyProgressScaled(24);
			  drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 0, j + 1, 17);
		  }
	 }
}
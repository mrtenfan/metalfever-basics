package ru.mrtenfan.metalfeverbasis.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import ru.mrtenfan.metalfeverbasis.container.ContainerAlloyFurnace;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityAlloyFurnace;

public class GUIAlloyFurnace extends GuiContainer {

	 public static final ResourceLocation texture = new ResourceLocation("metalfeverbasis:textures/gui/alloy_furnace_GUI.png");
	 
	 public TileEntityAlloyFurnace alloyfurnace;

	 public GUIAlloyFurnace(InventoryPlayer playerInv, TileEntityAlloyFurnace tileEntity) {
		 super(new ContainerAlloyFurnace(playerInv, tileEntity));
	  
		 this.alloyfurnace = tileEntity;
	  
		 xSize = 176;
		 ySize = 166;
	 }

	 public void drawGuiContainerForegroundLayer(int par1, int par2) {
		 String name = this.alloyfurnace.hasCustomInventoryName() ? this.alloyfurnace.getInventoryName() : I18n.format(this.alloyfurnace.getInventoryName(), new Object[0]);
		 
		 this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 4, 4210752);
		 this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 4, 4210752);
	 }
	 
	 @Override
	 public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		  GL11.glColor4f(1F, 1F, 1F, 1F);
		  mc.getTextureManager().bindTexture(texture);
		  drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
		  
		  if (alloyfurnace.isAlloying()) { 
			  
			  int i = alloyfurnace.getBurnTimeRemainingScaled(13);
			  drawTexturedModalRect(guiLeft + 56, guiTop + 50 - i -1, 176, 31 - i - 1, 17, i - 1);

			  int j = alloyfurnace.getAlloyProgressScaled(24);
			  drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 0, j + 1, 17);
		  }
	 }
}
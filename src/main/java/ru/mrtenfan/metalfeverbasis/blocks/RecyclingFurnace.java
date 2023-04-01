package ru.mrtenfan.metalfeverbasis.blocks;

import java.util.Random;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.mrtenfan.metalfeverbasis.MetalFeverMain;
import ru.mrtenfan.metalfeverbasis.init.MFBlocks;
import ru.mrtenfan.metalfeverbasis.init.MFOther;
import ru.mrtenfan.metalfeverbasis.tileentity.TileEntityRecyclingFurnace;

public class RecyclingFurnace extends BlockContainer {
	
	private Random rand;
	private final boolean isActive;
	private static boolean keepInventory = false;
	private String  texPath= "metalfeverbasis:";
    @SideOnly(Side.CLIENT)
    protected IIcon BlockIconFront;
    protected IIcon BlockIconSide;
    protected IIcon BlockIconTop;
    protected IIcon BlockIconDown;

    public RecyclingFurnace(Material mat, String name, float hard, float resist, String tool, int lvl, boolean work) {
		super(mat);
		if (!work)
		this.setCreativeTab(MFOther.TabMetalFeverDeco);
		else
    	this.setLightLevel(0.625F);
		this.setHardness(hard);
		this.setResistance(resist);
		this.setHarvestLevel(tool, lvl);
		this.setBlockName(name);
		rand = new Random();
		isActive = work;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(MFBlocks.recycling_furnace);
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        // Регистрируем путь до png-текстур для разных сторон блока
    	BlockIconFront = par1IconRegister.registerIcon(this.isActive ? texPath + "recycling_furnace_front_on" : texPath + "recycling_furnace_front_off");
        BlockIconSide = par1IconRegister.registerIcon(texPath + "recycling_furnace_side");
        BlockIconTop = par1IconRegister.registerIcon(texPath + "recycling_furnace_top");
        BlockIconDown = par1IconRegister.registerIcon(texPath + "recycling_furnace_bottom");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 0)  
        	return BlockIconDown; 
        if (side == 1)  
        	return BlockIconTop; 
        if (meta == 2 && side == 2)  
        	return BlockIconFront; 
        if (meta == 3 && side == 5)  
        	return BlockIconFront; 
        if (meta == 0 && side == 3)  
        	return BlockIconFront; 
        if (meta == 1 && side == 4)  
        	return BlockIconFront; 
        return BlockIconSide;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityPlayer, ItemStack itemStack){
        int i = MathHelper.floor_double((double)(entityPlayer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, i, 2);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	if (world.isRemote) {
    		return true;
    	}else if (!player.isSneaking()) {
    		TileEntityRecyclingFurnace entity = (TileEntityRecyclingFurnace) world.getTileEntity(x, y, z);
    		if (entity != null) {
    			FMLNetworkHandler.openGui(player, MetalFeverMain.instance, MFBlocks.GUI_ID_recycling_furnace, world, x, y, z);
    		}
    		return true;
    	} else
    		return false;
    }
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityRecyclingFurnace();
	}

	public static void updateBlockState(boolean isAlloying, World world, int xCoord, int yCoord, int zCoord) {
		
		int i = world.getBlockMetadata(xCoord, yCoord, zCoord);
		TileEntity entity = world.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if (isAlloying) 
			world.setBlock(xCoord, yCoord, zCoord, MFBlocks.recycling_furnace_active);
		else 
			world.setBlock(xCoord, yCoord, zCoord, MFBlocks.recycling_furnace);
		
		keepInventory = false;
		world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		
		if (entity != null) {
			entity.validate();
			world.setTileEntity(xCoord, yCoord, zCoord, entity);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) {
		if (!keepInventory) {
			TileEntityRecyclingFurnace entity = (TileEntityRecyclingFurnace) world.getTileEntity(x, y, z);
			
			if(entity != null) {
				for(int i = 0; i < entity.getSizeInventory(); i++) {
					ItemStack itemstack = entity.getStackInSlot(i);
					
					if(itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
						
						while(itemstack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;
							
							if(j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -=j;
							
							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage())); 
							
							if(itemstack.hasTagCompound()) {
								item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}
							
							world.spawnEntityInWorld(item);
						}
					}
				}
				
				world.func_147453_f(x, y, z, oldblock);
			}
		}
		
		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}
	
	public Item getItem(World world, int x, int y, int z) {
	    return Item.getItemFromBlock(MFBlocks.recycling_furnace);
	}

	//Update 1.2.0
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
    	if(this.isActive) {
    		int dir = world.getBlockMetadata(x, y, z);
    		
    		float x1 = (float)x + 0.5F;
    		float y1 = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
    		float z1 = (float)z + 0.5F;
    		
    		float f = 0.52F;
    		float f1 = random.nextFloat() * 0.6F - 0.3F;

    		//North = 2/2 p
    		//South = 0/3 p
    		//West = 1/4 o
    		//East = 3/5 o
    		if(dir == 1) {
    			world.spawnParticle("smoke", (double)(x1-f), (double)(y1), (double)(z1+f1), 0.0D, 0.0D, 0.0D);
    			world.spawnParticle("flame", (double)(x1-f), (double)(y1), (double)(z1+f1), 0.0D, 0.0D, 0.0D);
    		}
    		else if(dir == 3) {
    			world.spawnParticle("smoke", (double)(x1+f), (double)(y1), (double)(z1+f1), 0.0D, 0.0D, 0.0D);
    			world.spawnParticle("flame", (double)(x1+f), (double)(y1), (double)(z1+f1), 0.0D, 0.0D, 0.0D);
    		}
    		else if(dir == 2) { 
    			world.spawnParticle("smoke", (double)(x1+f1), (double)(y1), (double)(z1-f), 0.0D, 0.0D, 0.0D);
    			world.spawnParticle("flame", (double)(x1+f1), (double)(y1), (double)(z1-f), 0.0D, 0.0D, 0.0D);
    		}
    		else if(dir == 0) { 
    			world.spawnParticle("smoke", (double)(x1+f1), (double)(y1), (double)(z1+f), 0.0D, 0.0D, 0.0D);
    			world.spawnParticle("flame", (double)(x1+f1), (double)(y1), (double)(z1+f), 0.0D, 0.0D, 0.0D);
    		}
    	}
    }

}
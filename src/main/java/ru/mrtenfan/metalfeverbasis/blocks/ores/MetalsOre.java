package ru.mrtenfan.metalfeverbasis.blocks.ores;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ru.mrtenfan.metalfeverbasis.init.MFOther;

public class MetalsOre extends Block {

    public static final String[] metadata = new String[] {
            "aluminum", //0 
            "copper", //1
            "lead", //2
            "nickel", //3
            "platinum", //4
            "silver",   //5
            "tin", //6
            "tungsten", //7
            "cobalt", //8
            "chromium", //9
            "titanium" //10
        };
    
    @SideOnly(Side.CLIENT)
    private IIcon[] icon_array;
    
	public MetalsOre(Material mat, Float hard, Float resist, String tool) {
		super(mat);
        setCreativeTab(MFOther.TabMetalFeverDeco);
        setHardness(hard);
        setResistance(resist);
        for(int i = 0; i < metadata.length; i++) {
        	if(i == 4 || i == 7 || i == 9)
        		setHarvestLevel(tool, 2, i);
        	if(i == 8 || i == 10)
        		setHarvestLevel(tool, 3, i);
        	else
        		setHarvestLevel(tool, 1, i);
        }
    }
	
    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
    	return icon_array[Math.min(MetalsOre.metadata.length - 1, metadata)];
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs table, List list) {
        for (int j = 0; j < metadata.length; ++j) {
            list.add(new ItemStack(id, 1, j));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        super.registerBlockIcons(ir);
        icon_array = new IIcon[metadata.length];
        for (int i = 0; i < metadata.length; ++i) {
            icon_array[i] = ir.registerIcon("metalfeverbasis:" + metadata[i] + "_ore");
        }
    }
}
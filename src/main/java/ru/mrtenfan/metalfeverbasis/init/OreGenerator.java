package ru.mrtenfan.metalfeverbasis.init;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import ru.mrtenfan.metalfeverbasis.ConfigFile;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	    generateOverworld(random, chunkX, chunkZ, world);
	    generateNether(random, chunkX, chunkZ, world);
	}

	private void generateOverworld(Random random, int chunkX, int chunkZ, World world) {
		generateOverworld(world, random, chunkX * 16, chunkZ * 16);
	}
	
	private void generateNether(Random rand, int chunkX, int chunkZ, World world) {
	  generateNether(world, rand, chunkX * 16, chunkZ * 16);
	}

	private void generateOverworld(World world, Random random, int chunkX, int chunkZ) {
		//maxX, maxZ, mimVeinSize, maxVeinSize, minVeinsPerChunk, maxVeinsPerChunk, chanceToSpawn, minY, maxY
		if (ConfigFile.EnabAlumSpawn)
			addOreSpawn(MFBlocks.metals_ore, 0, Blocks.stone, world, random, chunkX, chunkZ, 16, 16, ConfigFile.AlumSpawn[0], ConfigFile.AlumSpawn[1], ConfigFile.AlumSpawn[2], ConfigFile.AlumSpawn[3], ConfigFile.AlumSpawn[4], ConfigFile.AlumSpawn[5], ConfigFile.AlumSpawn[6]);                             
		if (ConfigFile.EnabCopSpawn)
			addOreSpawn(MFBlocks.metals_ore, 1, Blocks.stone, world, random, chunkX, chunkZ, 16, 16, ConfigFile.CopSpawn[0], ConfigFile.CopSpawn[1], ConfigFile.CopSpawn[2], ConfigFile.CopSpawn[3], ConfigFile.CopSpawn[4], ConfigFile.CopSpawn[5], ConfigFile.CopSpawn[6]);
		if (ConfigFile.EnabLeadSpawn)
			addOreSpawn(MFBlocks.metals_ore, 2, Blocks.stone, world, random, chunkX, chunkZ, 16, 16, ConfigFile.LeadSpawn[0], ConfigFile.LeadSpawn[1], ConfigFile.LeadSpawn[2], ConfigFile.LeadSpawn[3], ConfigFile.LeadSpawn[4], ConfigFile.LeadSpawn[5], ConfigFile.LeadSpawn[6]);
		if (ConfigFile.EnabNicSpawn)
			addOreSpawn(MFBlocks.metals_ore, 3, Blocks.stone, world, random, chunkX, chunkZ, 16, 16, ConfigFile.NicSpawn[0], ConfigFile.NicSpawn[1], ConfigFile.NicSpawn[2], ConfigFile.NicSpawn[3], ConfigFile.NicSpawn[4], ConfigFile.NicSpawn[5], ConfigFile.NicSpawn[6]);
		if (ConfigFile.EnabPlatSpawn)
			addOreSpawn(MFBlocks.metals_ore, 4, Blocks.stone, world, random, chunkX, chunkZ, 16, 16, ConfigFile.PlatSpawn[0], ConfigFile.PlatSpawn[1], ConfigFile.PlatSpawn[2], ConfigFile.PlatSpawn[3], ConfigFile.PlatSpawn[4], ConfigFile.PlatSpawn[5], ConfigFile.PlatSpawn[6]);
		if (ConfigFile.EnabTinSpawn)
			addOreSpawn(MFBlocks.metals_ore, 6, Blocks.stone, world, random, chunkX, chunkZ, 16, 16, ConfigFile.TinSpawn[0], ConfigFile.TinSpawn[1], ConfigFile.TinSpawn[2], ConfigFile.TinSpawn[3], ConfigFile.TinSpawn[4], ConfigFile.TinSpawn[5], ConfigFile.TinSpawn[6]);
		if (ConfigFile.EnabTungSpawn)
			addOreSpawn(MFBlocks.metals_ore, 7, Blocks.stone, world, random, chunkX, chunkZ, 16, 16, ConfigFile.TungSpawn[0], ConfigFile.TungSpawn[1], ConfigFile.TungSpawn[2], ConfigFile.TungSpawn[3], ConfigFile.TungSpawn[4], ConfigFile.TungSpawn[5], ConfigFile.TungSpawn[6]);
		if (ConfigFile.EnabSilSpawn)
			addOreSpawn(MFBlocks.metals_ore, 5, Blocks.stone, world, random, chunkX, chunkZ, 16, 16, ConfigFile.SilSpawn[0], ConfigFile.SilSpawn[1], ConfigFile.SilSpawn[2], ConfigFile.SilSpawn[3], ConfigFile.SilSpawn[4], ConfigFile.SilSpawn[5], ConfigFile.SilSpawn[6]);
	}

	//Update 1.2.0
	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		if (ConfigFile.EnabCobaltSpawn && !Loader.isModLoaded("TConstruct"))
			addOreSpawn(MFBlocks.metals_ore, 8, Blocks.netherrack, world, random, chunkX, chunkZ, 16, 16, ConfigFile.CobaltSpawn[0], ConfigFile.CobaltSpawn[1], ConfigFile.CobaltSpawn[2], ConfigFile.CobaltSpawn[3], ConfigFile.CobaltSpawn[4], ConfigFile.CobaltSpawn[5], ConfigFile.CobaltSpawn[6]);
		if (ConfigFile.EnabChromiumSpawn)
			addOreSpawn(MFBlocks.metals_ore, 9, Blocks.netherrack, world, random, chunkX, chunkZ, 16, 16, ConfigFile.ChromiumSpawn[0], ConfigFile.ChromiumSpawn[1], ConfigFile.ChromiumSpawn[2], ConfigFile.ChromiumSpawn[3], ConfigFile.ChromiumSpawn[4], ConfigFile.ChromiumSpawn[5], ConfigFile.ChromiumSpawn[6]);
		if (ConfigFile.EnabTitaniumSpawn)
			addOreSpawn(MFBlocks.metals_ore, 10, Blocks.netherrack, world, random, chunkX, chunkZ, 16, 16, ConfigFile.TitaniumSpawn[0], ConfigFile.TitaniumSpawn[1], ConfigFile.TitaniumSpawn[2], ConfigFile.TitaniumSpawn[3], ConfigFile.TitaniumSpawn[4], ConfigFile.TitaniumSpawn[5], ConfigFile.TitaniumSpawn[6]);
	}
	
	public static void addOreSpawn(Block ore, Block replace, World world, Random rand, int blockXPos, int blockZPos, int maxX, int maxZ,
	int minVeinSize, int maxVeinSize, int minVeinsPerChunk, int maxVeinsPerChunk, int chanceToSpawn, int minY, int maxY) {
	  if (rand.nextInt(101) < (100 - chanceToSpawn)) return;
	  int veins = rand.nextInt(maxVeinsPerChunk - minVeinsPerChunk + 1) + minVeinsPerChunk;
	  for (int i = 0; i < veins; i++) {
	    int posX = blockXPos + rand.nextInt(maxX);
	    int posY = minY + rand.nextInt(maxY - minY);
	    int posZ = blockZPos + rand.nextInt(maxZ);
	    int VeinSize = minVeinSize + rand.nextInt(maxVeinSize - minVeinSize + 1);
	    (new WorldGenMinable(ore, VeinSize,
	      replace)).generate(world, rand, posX, posY, posZ);
	  }
	}
	
	public static void addOreSpawn(Block ore, int meta, Block replace, World world, Random rand, int blockXPos, int blockZPos, int maxX, int maxZ, int minVeinSize, int maxVeinSize, int minVeinsPerChunk, int maxVeinsPerChunk, int chanceToSpawn, int minY, int maxY) {
	  if (rand.nextInt(101) < (100 - chanceToSpawn)) return;
	  int veins = rand.nextInt(maxVeinsPerChunk - minVeinsPerChunk + 1) + minVeinsPerChunk;
	  for (int i = 0; i < veins; i++) {
	    int posX = blockXPos + rand.nextInt(maxX);
	    int posY = minY + rand.nextInt(maxY - minY);
	    int posZ = blockZPos + rand.nextInt(maxZ);
	    int VeinSize = minVeinSize + rand.nextInt(maxVeinSize - minVeinSize + 1);
	    (new WorldGenMinable(ore, meta, VeinSize,
	      replace)).generate(world, rand, posX, posY, posZ);
	  }
	}
}

package WorldGen;

import blocks.DaftcraftBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 06/06/14
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public class worldGen implements IWorldGenerator {

   @Override
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
   {
      switch(world.provider.getDimensionId())
      {
         case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
         case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
         case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
      }

   }

   private void generateEnd(World world, Random random, int x, int z) {

   }

   private void generateSurface(World world, Random random, int x, int z)
   {
      for(int count=0;count<25;count++)
      {
         int chunkX= x+random.nextInt(16);
         int chunkY=random.nextInt(20);
         int chunkZ=z+random.nextInt(16);
         BlockPos pos=new BlockPos(chunkX,chunkY,chunkZ);
         new WorldGenMinable(DaftcraftBlocks.randomonium.getDefaultState(),random.nextInt(5-1)+1).generate(world,random,pos);
         //new WorldGenMinable(daftcraftBlocks.randomonium.getDefaultState(),random.nextInt(5-1)+1).generate(world,random,new BlockPos(chunkX,chunkY,chunkZ));
      }

    /*  BiomeGenBase biome=world.getWorldChunkManager().getBiomeGenAt(x,z);



      if(biome==BiomeGenBase.desert)
      {
         for(int g=0;g<1;g++)
         {
            int i=x+random.nextInt(256);      //X
            int k=z+random.nextInt(256); //Z
            int j=world.getHeightValue(i,k);  //Y

            System.out.println(" a dome was placed at position X:" + i +" Y:" + j + " Z:" + k);
            new glassoasistest1().generate(world,random,i,j,k);

         }
      }

      for(int i=0;i<1;i++)
      {
         int X=x+random.nextInt(256);      //X
         int Z=z+random.nextInt(256); //Z
         int Y=world.getHeightValue(X,Z);  //Y

         System.out.println("a house was placed");
         new CreepyHouse().generate(world, random, X, Y, Z);

      }      */




   }

   private void generateNether(World world, Random random, int x, int z)
   {

   }
}//class

package blocks;

import config.DaftcraftConfig;
import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 26/05/14
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class Randomonium extends Block {


   private int numbergen, casenumber;
   private boolean canExplode;
   Random rand = new Random();


   public Randomonium(Material material) {

      super(material);
      setCreativeTab(myMod.daftcraft);
      setLightLevel(1.0f);
      setHardness(1.0f);
      setUnlocalizedName("randomonium");
      canExplode = DaftcraftConfig.randomoniumExplosion;

   }


 /*  @Override
   public int onBlockPlaced(World world, int x, int y, int z, int side, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
   {


   }  */


   @Override
   public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
      return false;
   }


   @Override
   public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {

      numbergen = rand.nextInt(81);
      if (!world.isRemote) {

         if (numbergen == 99) {
            world.setBlockState(pos, Blocks.diamond_ore.getDefaultState());
            world.destroyBlock(pos, true);
         } else if (numbergen == 98) {
            world.setBlockState(pos, Blocks.emerald_ore.getDefaultState());
            world.destroyBlock(pos, true);
         } else if (numbergen < 98 && numbergen >= 90) {
            world.setBlockState(pos, Blocks.gold_ore.getDefaultState());
            world.destroyBlock(pos, true);
         } else if (numbergen < 90 && numbergen >= 80) {
            world.setBlockState(pos, Blocks.iron_ore.getDefaultState());
            world.destroyBlock(pos, true);
         } else if (numbergen < 80 && numbergen >= 60) {
            world.setBlockState(pos, Blocks.redstone_ore.getDefaultState());
            world.destroyBlock(pos, true);
         } else if (numbergen < 60 && numbergen >= 20) {
            world.setBlockState(pos, Blocks.coal_ore.getDefaultState());
            world.destroyBlock(pos, true);
         } else {
            casenumber = 0;
            if (canExplode) {
               world.createExplosion(null, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), 2.0f, true);
            }
         }

         Minecraft.getMinecraft().thePlayer.sendChatMessage("you called number " + numbergen);
      }
   }
}

  /* @Override
   public int quantityDropped(IBlockState state, int fortune, Random random)
   {
      if(casenumber==1)
      {
         return 1;
      }
      else if(casenumber==2)
      {
         return 2;
      }
      else if(casenumber==3)
      {
         return rand.nextInt(5-1)+1;
      }
      else if(casenumber==4)
      {
         return rand.nextInt(5-1)+1;
      }
      else if(casenumber==5)
      {
         return rand.nextInt(8-1)+1;
      }
      else
      {
         return 0;
      }

   }     */











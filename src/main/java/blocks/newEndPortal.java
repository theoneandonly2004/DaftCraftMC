package blocks;

import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 31/05/14
 * Time: 00:43
 * To change this template use File | Settings | File Templates.
 */
public class newEndPortal extends Block
{


   public newEndPortal(Material material)
   {
      super(material);
      setUnlocalizedName("portal block");
      setCreativeTab(myMod.daftcraft);




   }


   @Override
   public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity)
   {
      int count=0;
      Block topper=Blocks.diamond_block;
      if(!world.isRemote)
      {
         if(world.isBlockPowered(pos))
         {


            for(int X=-3;X<6;X+=6)
            {
               for(int Z=-3;Z<6;Z+=6)
               {
                  for(int Y=0;Y<4;Y++)
                  {
                     if(world.getBlockState(pos).getBlock()==Blocks.obsidian)
                     {
                        if(world.getBlockState(pos.up(1))==topper)
                        {
                           count++;
                           if(count%4==0)
                           {
                              if(world.provider.getDimensionId()==1 || world.provider.getDimensionId()==0)
                              {
                                 entity.travelToDimension(1);
                              }
                              else
                              {
                                 entity.travelToDimension(-1);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock)
   {

      if(world.isBlockIndirectlyGettingPowered(pos)>0)
      {
         this.lightLevel(true);
      }
      else
      {
         this.lightLevel(false);
      }
   }





   public void lightLevel(boolean isPowered)
  {
     if(isPowered)
     {
        setLightLevel(2.0f);
     }
     else
     {
        setLightLevel(0);
     }
  }


}






//class

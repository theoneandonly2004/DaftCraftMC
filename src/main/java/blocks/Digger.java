package blocks;

import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import tileEntities.TileEntityDigger;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 18/06/14
 * Time: 13:27
 * To change this template use File | Settings | File Templates.
 */
public class Digger extends BlockContainer
{

   public Digger(Material material)
   {
      super(material);
      setCreativeTab(myMod.daftcraft);
      setHardness(1.0f);
   }



 /*  @Override
   public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
   {
      int count=1;
      if(world.isBlockIndirectlyGettingPowered(x,y,z))
      {
         while(world.getBlock(x,y-count,z)!= Blocks.bedrock)
         {
            if(world.getBlock(x,y-count,z)instanceof BlockOre)
            {
            world.func_147480_a(x,y-count,z,true);
            }
            else
            {
               world.setBlockToAir(x,y-count,z);
            }
            count++;

         }
      }
   }  */

   @Override
   public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
   {
      player.openGui(myMod.modInstance,0,world,pos.getX(),pos.getY(),pos.getZ());

      return true;
   }





   @Override
   public TileEntity createNewTileEntity(World world, int p_149915_2_)
   {
      return new TileEntityDigger();
   }

   @Override
   public void breakBlock(World world, BlockPos pos, IBlockState state)
   {
      Random rand=new Random();
      TileEntityDigger digger = (TileEntityDigger)world.getTileEntity(pos);

      if (digger != null)
      {
         for (int count = 0; count < digger.getSizeInventory(); ++count)
         {
            ItemStack itemstack = digger.getStackInSlot(count);

            if (itemstack != null)
            {
               float f = rand.nextFloat() * 0.8F + 0.1F;
               float f1 = rand.nextFloat() * 0.8F + 0.1F;
               EntityItem entityitem;

               for (float f2 = rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
               {
                  int j1 = rand.nextInt(21) + 10;

                  if (j1 > itemstack.stackSize)
                  {
                     j1 = itemstack.stackSize;
                  }

                  itemstack.stackSize -= j1;
                  entityitem = new EntityItem(world, (double)((float)pos.getX() + f), (double)((float)pos.getY() + f1), (double)((float)pos.getZ() + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                  float f3 = 0.05F;
                  entityitem.motionX = (double)((float)rand.nextGaussian() * f3);
                  entityitem.motionY = (double)((float)rand.nextGaussian() * f3 + 0.2F);
                  entityitem.motionZ = (double)((float)rand.nextGaussian() * f3);

                  if (itemstack.hasTagCompound())
                  {
                     entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                  }
               }
            }
         }

         world.destroyBlock(pos,true);
      }

      super.breakBlock(world, pos, state);
   }




}//class


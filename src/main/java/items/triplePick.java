package items;

import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 30/05/14
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class triplePick extends ItemPickaxe{

   public triplePick(Item.ToolMaterial material)
   {
      super(material);
      setMaxStackSize(1);
      setMaxDamage(2000);
      setUnlocalizedName("triple pickaxe");
      setCreativeTab(myMod.daftcraft);



   }

   @Override
   public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, BlockPos pos, EntityLivingBase target)
   {
      int roation = MathHelper.floor_double((double) (target.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
      BlockPos currentPos;


      if(!world.isRemote)
      {
         if(world.getBlockState(pos).getBlock().getBlockHardness(world,pos)>=0)
         {
            if(block.getMaterial()== Material.iron || block.getMaterial()==Material.rock || block.getMaterial()==Material.anvil)
            {
               if(roation==0 || roation==2)
               {

                  for(int X=-1;X<2;X++)
                  {
                     for(int Y=-1;Y<2;Y++)
                     {
                        currentPos=new BlockPos(pos.getX()+X,pos.getY()+Y,pos.getZ());
                        if(world.getBlockState(currentPos).getBlock().getBlockHardness(world,currentPos)>=0)
                        {
                           world.destroyBlock(currentPos, true);
                           itemStack.setItemDamage(itemStack.getItemDamage()+1);
                        }



                     }
                  }
               }
               else
               {
                  for(int Z=-1;Z<2;Z++)
                  {
                     for(int Y=-1;Y<2;Y++)
                     {
                        currentPos=new BlockPos(pos.getX(),pos.getY()+Y,pos.getZ()+Z);
                        if(world.getBlockState(currentPos).getBlock().getBlockHardness(world,currentPos)>=0)
                        {
                           world.destroyBlock(currentPos,true);
                           itemStack.setItemDamage(itemStack.getItemDamage()+1);
                        }



                     }
                  }
               }



               //itemStack.setItemDamage(itemStack.getItemDamage()-1);






            }


         }

      }
      return true;

   }


}



//class



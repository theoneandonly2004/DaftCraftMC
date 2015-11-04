package items;

import items.Registry.DaftcraftItems;
import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 01/06/14
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
public class ReinforcedAxe extends ItemAxe
{


   public ReinforcedAxe(ToolMaterial material)
   {

      super(material);
      ItemStack axe=new ItemStack(DaftcraftItems.reinforcedAxe);
      setCreativeTab(myMod.daftcraft);
      setMaxStackSize(1);
      setMaxDamage(2000);
      setUnlocalizedName("reinforced axe");
   }

   @Override
   public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, BlockPos pos, EntityLivingBase player)
   {
      int count=0;



      if(!world.isRemote)
      {
         if(!player.isSneaking())
         {



            while(world.getBlockState(pos.up(count)).getBlock().getMaterial()== Material.leaves || world.getBlockState(pos.up(count)).getBlock().getMaterial()== Material.wood)
            {
               world.destroyBlock(pos.up(count),true);
               count++;
               itemStack.setItemDamage(itemStack.getItemDamage()+1);
            }

         }
         else
         {
            itemStack.setItemDamage(itemStack.getItemDamage()+1);
            count=1;
         }






         if(itemStack.getItemDamage()>itemStack.getMaxDamage())
         {
            itemStack.stackSize--;
         }

      }


      return true;

   }




}//class

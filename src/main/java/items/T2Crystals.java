package items;

import keystuff.myMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 02/06/14
 * Time: 21:16
 * To change this template use File | Settings | File Templates.
 */

public class T2Crystals extends Item
{



   public T2Crystals()
   {

      setCreativeTab(myMod.daftcraft);
      setMaxStackSize(1);


   }




   /*@Override
   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
   {
      if(world.getBlockState(x,y,z)== daftcraftBlocks.digger)
      {
         world.setBlockMetadataWithNotify(x,y,z,2,3);
         stack.setItemDamage(stack.getItemDamage()+3);

         return false;
      }
      return true;
   } */


   /*@Override
   public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
   {
      return false;

   }  */

   @Override
   public ItemStack getContainerItem(ItemStack itemStack)
   {
         ItemStack cStack=itemStack.copy();
         cStack.setItemDamage(cStack.getItemDamage()+1);
         cStack.stackSize=1;
         return cStack;
   }




   @Override
   public boolean hasContainerItem(ItemStack stack)
   {
      return stack.getItemDamage()<stack.getMaxDamage();
   }

   @Override
   public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
   {
      if(!world.isRemote)
      {
         if(player.isSneaking())
         {
            if(itemStack.getItemDamage()<itemStack.getMaxDamage())
            {
               itemStack.setItemDamage(itemStack.getItemDamage()+1);
               player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1320, 1));
               player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,1320,1));
               player.addPotionEffect(new PotionEffect(Potion.poison.id,300,1));
            }
         }
      }

      return true;

   }



   @Override
   public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
   {
      list.add(itemStack.getMaxDamage()-itemStack.getItemDamage() +" uses left");

   }
}
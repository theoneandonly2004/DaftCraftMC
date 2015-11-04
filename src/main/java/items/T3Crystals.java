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


public class T3Crystals extends Item
{



   public T3Crystals()
   {

      setCreativeTab(myMod.daftcraft);
      setMaxStackSize(1);


   }

  /* @Override
   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
   {
      if(world.getBlock(x,y,z)== daftcraftBlocks.digger)
      {

         world.setBlockMetadataWithNotify(x,y,z,3,3);
         stack.setItemDamage(stack.getItemDamage()+3);

         return false;
      }
      else  if(world.getBlock(x,y,z)== daftcraftBlocks.summoner)
      {

         world.setBlockMetadataWithNotify(x,y,z,1,1);

         return false;
      }
      return true;
   }

   @Override
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

               player.addPotionEffect(new PotionEffect(Potion.regeneration.id,160,2));
               player.addPotionEffect(new PotionEffect(Potion.fireResistance.id,1320,3));
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

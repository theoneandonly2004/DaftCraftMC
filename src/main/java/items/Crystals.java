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


public class Crystals extends Item
{



   public Crystals()
   {

      setCreativeTab(myMod.daftcraft);
      setMaxStackSize(1);


   }


   @Override
   public Item setContainerItem(Item containerItem)
   {
      return containerItem;
   }


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
   public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
   {
      if(!world.isRemote)
      {
         if(player.isSneaking())
         {
            if(stack.getItemDamage()<stack.getMaxDamage())
            {
               stack.setItemDamage(stack.getItemDamage()+1);
               player.addPotionEffect(new PotionEffect(Potion.nightVision.id,1000,1));
               player.addPotionEffect(new PotionEffect(Potion.digSpeed.id,1020,2));
               player.addPotionEffect(new PotionEffect(Potion.resistance.id,1020,2));
               player.addPotionEffect(new PotionEffect(Potion.poison.id,200,1));
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

}//class

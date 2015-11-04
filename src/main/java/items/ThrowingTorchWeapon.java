package items;

import items.Registry.DaftcraftItems;
import keystuff.myMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import projectiles.throwableTorch;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 23/06/14
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class ThrowingTorchWeapon extends ItemSnowball
{
   public ThrowingTorchWeapon()
   {
      setCreativeTab(myMod.daftcraft);
      setMaxStackSize(64);
      setMaxDamage(100);

   }

   @Override
   public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
   {

         if(player.inventory.hasItem(DaftcraftItems.throwingTorchAmmo) && !player.capabilities.isCreativeMode)
         {
         player.inventory.consumeInventoryItem(DaftcraftItems.throwingTorchAmmo);
         world.spawnEntityInWorld(new throwableTorch(world,player));
         itemStack.setItemDamage(itemStack.getItemDamage()+1);
         return itemStack;
         }
      else if(player.capabilities.isCreativeMode)
         {
            world.spawnEntityInWorld(new throwableTorch(world,player));
            return itemStack;
         }


      return itemStack;
   }
}//class

package items;

import entities.FunEgg;
import entities.PotatoGrenade;
import keystuff.myMod;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 11/06/14
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class BlasterThingy extends ItemSnowball
{
   public BlasterThingy()
   {
      super();
      setCreativeTab(myMod.daftcraft);
      setUnlocalizedName("blaster");
      setMaxDamage(300);
   }

   @Override
   public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
   {

     // String checkName=player.getCommandSenderEntity().getName();




     // String name=player.getDisplayName();



      if (!player.capabilities.isCreativeMode)
      {
         if(player.inventory.hasItem(Items.egg))
         {

            world.spawnEntityInWorld(new FunEgg(world, player));
            player.inventory.consumeInventoryItem(Items.egg);

            itemStack.setItemDamage(itemStack.getItemDamage()+1);
            return itemStack;

         }
      }
      else
      {
         if(!player.isSneaking())
         {
            world.spawnEntityInWorld(new FunEgg(world, player));
         }

      }






      world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));



      return itemStack;
   }






   }


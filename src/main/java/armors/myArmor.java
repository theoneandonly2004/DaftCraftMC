package armors;

import items.Registry.DaftcraftItems;
import keystuff.myMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 30/05/14
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public class myArmor extends ItemArmor {

   public myArmor(ArmorMaterial material, int id, int position)
   {
      super(material, id, position);
      setCreativeTab(myMod.daftcraft);

    /*  if(position==0)  //helmet
      {

      }
      else if(position==1) //chest
      {

      }
      else if(position==2) //leggings
      {

      }
      else if(position==3)  //boots
      {

      }     */
   }

   @Override
   public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
   {
      if(itemStack.getItem()== DaftcraftItems.chestPiece)
      {
         itemStack.addEnchantment(Enchantment.unbreaking,4);

      }

   }
}//class

package armors;

import keystuff.myMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 17/06/14
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
public class VisorHeadpiece extends ItemArmor
{

   static final int maxCountdown=500;
   static int counter=maxCountdown;
   static String name;

   public VisorHeadpiece(ArmorMaterial material, int id, int position)
   {
      super(material, id, position);
      setCreativeTab(myMod.daftcraft);

   }

   @Override
   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
   {
      if(slot==0)
      {
      return myMod.MODID +":textures/models/armor/visorsec.png" ;
      }
      else if(slot==1)
      {
         return myMod.MODID +":textures/models/armor/visorsec.png" ;
      }
      else
      {
         return null;
      }
   }


   @Override
   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
   {


     /* if(player.getEquipmentInSlot(0)== itemStack)
      {
         player.addPotionEffect(new PotionEffect(Potion.nightVision.id,200,2));
      }

      if(player.getEquipmentInSlot(1)== itemStack)
      {
         player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,200,2));
      }  */


      if(player.getEquipmentInSlot(4)== itemStack)
      {

         player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 2));
      }

      if(player.getEquipmentInSlot(3)== itemStack)
      {

         player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 2));
      }


   }
}//class

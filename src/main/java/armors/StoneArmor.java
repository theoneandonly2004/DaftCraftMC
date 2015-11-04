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
 * Date: 07/08/14
 * Time: 00:00
 * To change this template use File | Settings | File Templates.
 */
public class StoneArmor extends ItemArmor
{


   public StoneArmor(ArmorMaterial material, int id, int position)
   {
      super(material, id, position);
      setCreativeTab(myMod.daftcraft);

   }



   @Override
   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
   {
      if(slot==0)
      {
         return myMod.MODID +":textures/models/armor/cobblestonearmor.png" ;
      }
      else if(slot==1)
      {
         return myMod.MODID +":textures/models/armor/cobblestonearmor.png" ;
      }
      else if(slot==2)
      {
         return myMod.MODID +":textures/models/armor/cobbblestoneboots.png" ;
      }
      else if(slot==3)
      {
         return myMod.MODID +":textures/models/armor/cobblestonearmor.png" ;
      }
      else
      {
         return null;
      }


   }

   @Override
   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
   {
      int weight=0;







    /* if(player.getCurrentArmor(0)!= null && player.getCurrentArmor(1)!= null && player.getCurrentArmor(2)!= null && player.getCurrentArmor(3)!= null)
     {
        ItemStack chest=player.getCurrentArmor(1);
        ItemStack headpiece=player.getCurrentArmor(0);
        ItemStack leggings=player.getCurrentArmor(2);
        ItemStack boots=player.getCurrentArmor(3);

        if(chest.getItem()==daftcraftItems.cobblestoneChestpiece)
        {
           if(headpiece.getItem()==daftcraftItems.cobblestoneHeadpiece)
           {
              if(leggings.getItem()==daftcraftItems.cobblestoneLeggings)
              {
                 if(boots.getItem()==daftcraftItems.cobblestoneBoots)
                 {
                    System.out.println("the entire stone set is on");
                    player.clearActivePotions();
                    player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 5));
                 }
              }
           }
        }






     }*/



            if(player.getEquipmentInSlot(1)== itemStack)
            {

               player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));
            }

      if(player.getEquipmentInSlot(2)== itemStack)
      {

         player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));

      }
       if(player.getEquipmentInSlot(3)== itemStack)
      {

         player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));

      }
       if(player.getEquipmentInSlot(4)== itemStack)
            {

               player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 2));


            }



     }









      }






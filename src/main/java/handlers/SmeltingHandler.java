package handlers;


import items.Registry.DaftcraftItems;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 06/06/14
 * Time: 00:07
 * To change this template use File | Settings | File Templates.
 */
public class SmeltingHandler
{

   @SubscribeEvent
   public void onSmelting(PlayerEvent.ItemSmeltedEvent event)
   {
      int damage;
      String playerName = EnumChatFormatting.getTextWithoutFormattingCodes(event.player.getName());
      String uuid= event.player.getUniqueID().toString();




      if(event.smelting.getTagCompound()==null)
      {
         event.smelting.setTagCompound(new NBTTagCompound());
      }
      if(!event.smelting.getTagCompound().hasKey("Owner"))
      {
         event.smelting.getTagCompound().setString("Owner",uuid);
      }





    /* if(event.smelting.getItem()== DaftcraftItems.rubyCrystalT3)
     {
        damage=event.smelting.getItemDamage();
        event.smelting.setItemDamage(damage);

     }
      else  if(event.smelting.getItem()== DaftcraftItems.rubyCrystalT2)
     {
        event.smelting.setItemDamage(event.smelting.getItemDamage()-5);


   }
     else  if(event.smelting.getItem()== DaftcraftItems.rubyCrystal)
     {

        //event.smelting.setItemDamage(event.smelting.getItemDamage()+5);


     } */


   }

}//class

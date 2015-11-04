package handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Daniel on 07/12/2014.
 */
public class ItemPickUpHandler
{

   @SubscribeEvent
   public void ItemPickup(EntityItemPickupEvent event)
   {
      String playerName = EnumChatFormatting.getTextWithoutFormattingCodes(event.entityPlayer.getName());
      String username=event.entityPlayer.getDisplayNameString();
      String playerID=event.entityPlayer.getUniqueID().toString();
      ItemStack stack=event.item.getEntityItem();
      String playerPickupID;

      if(stack.getTagCompound() == null)
      {
         stack.setTagCompound(new NBTTagCompound());
      }

      if(!stack.getTagCompound().hasKey("ID"))
      {
         stack.getTagCompound().setString("ID",playerID);
      }

      if(!stack.getTagCompound().hasKey("Owner"))
      {
         stack.getTagCompound().setString("Owner", username);
      }
      else
      {
         if(stack.getTagCompound().hasKey("ID") && stack.getTagCompound().hasKey("Owner"))
         {
            playerPickupID = stack.getTagCompound().getString("ID");

            if(playerPickupID.equals(playerID))
            {
               stack.getTagCompound().setString("Owner",username);
            }
         }
      }
   }
}//class

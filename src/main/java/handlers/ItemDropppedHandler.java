package handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.UUID;

/**
 * Created by Daniel on 08/12/2014.
 */
public class ItemDropppedHandler
{

   @SubscribeEvent
   public void ItemDrooped(ItemTossEvent event)
   {

      String ownerName;
      String id;
      String playerName = EnumChatFormatting.getTextWithoutFormattingCodes(event.player.getName());
      String uuid=event.player.getUniqueID().toString();

      ItemStack stack=event.entityItem.getEntityItem();


      if(stack.getTagCompound() == null)
      {
         stack.setTagCompound(new NBTTagCompound());
      }

      if(!stack.getTagCompound().hasKey("ID"))
      {
         stack.getTagCompound().setString("ID",uuid);
      }

      if(stack.getTagCompound().hasKey("Owner"))
      {
         ownerName=stack.getTagCompound().getString("Owner");

         if(stack.getTagCompound().hasKey("ID"))
         {
            id=stack.getTagCompound().getString("ID");

            if(id.equals(uuid))
            {
               event.entityItem.getEntityItem().getTagCompound().removeTag("Owner");
               event.entityItem.getEntityItem().getTagCompound().removeTag("ID");
            }
         }


      }
   }

}//class

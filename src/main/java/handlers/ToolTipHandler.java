package handlers;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Daniel on 07/12/2014.
 */
public class ToolTipHandler
{

   @SubscribeEvent
   public void ToolTip(ItemTooltipEvent event)
   {
      String playerName = EnumChatFormatting.getTextWithoutFormattingCodes(event.entityPlayer.getName());
      String uuid=event.entityPlayer.getUniqueID().toString();

      if(event.itemStack.getTagCompound()==null)
      {
         event.itemStack.setTagCompound(new NBTTagCompound());
      }
      if(event.itemStack.getTagCompound().getString("Owner")== null)
      {
         event.itemStack.getTagCompound().setString("Owner",playerName);
      }

      event.toolTip.add("Items owner is: "+ event.itemStack.getTagCompound().getString("Owner"));
   }
}//class

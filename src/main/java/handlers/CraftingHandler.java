package handlers;

import items.Registry.DaftcraftItems;
import keystuff.DaftcraftAchievements;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 04/06/14
 * Time: 23:12
 * To change this template use File | Settings | File Templates.
 */
public class CraftingHandler
{

   @SubscribeEvent
   public void onPlayerItemCrafted(PlayerEvent.ItemCraftedEvent event)
   {
      String playerName = EnumChatFormatting.getTextWithoutFormattingCodes(event.player.getName());
      ItemStack stack=event.crafting;
      String playerPickupID;
      String playerID=event.player.getUniqueID().toString();


      if(stack.getTagCompound()==null)
      {
        stack.setTagCompound(new NBTTagCompound());
      }

      if(!stack.getTagCompound().hasKey("ID"))
      {
         stack.getTagCompound().setString("ID", playerID);
      }

      if(!stack.getTagCompound().hasKey("Owner"))
      {
         stack.getTagCompound().setString("Owner", playerName);
      }

      else if(stack.getTagCompound().hasKey("Owner"))
      {
         if(stack.getTagCompound().hasKey("ID"))
         {
            playerPickupID = stack.getTagCompound().getString("ID");

            if (playerPickupID.equals(playerID))
            {
               stack.getTagCompound().setString("Owner",playerName);
            }
         }
      }

       if(event.crafting.getItem().equals(DaftcraftItems.rubyCrystal))
      {
         event.player.addStat(DaftcraftAchievements.firstCrystal,1);
      }

         if(event.crafting.getItem().equals(DaftcraftItems.rubyCrystalT2))
         {
            event.player.addStat(DaftcraftAchievements.secondCrystal,1);

            if(event.craftMatrix.getStackInSlot(4).getItem()== DaftcraftItems.rubyCrystal)
            {
            event.craftMatrix.getStackInSlot(4).setItemDamage(DaftcraftItems.rubyCrystal.getMaxDamage());

            }


         }

         if(event.crafting.getItem()== DaftcraftItems.belt)
         {
            if(event.craftMatrix.getStackInSlot(4).getItem()== DaftcraftItems.rubyCrystalT2)
            {
               event.craftMatrix.getStackInSlot(4).setItemDamage( event.craftMatrix.getStackInSlot(4).getItemDamage()+5);
            }

            if(event.craftMatrix.getStackInSlot(4).getItem()== DaftcraftItems.rubyCrystalT3)
            {
               event.craftMatrix.getStackInSlot(4).setItemDamage( event.craftMatrix.getStackInSlot(4).getItemDamage()+3);
            }
         }

      if(event.crafting.getItem()== DaftcraftItems.visor)
      {

         if(event.craftMatrix.getStackInSlot(4).getItem()== DaftcraftItems.rubyCrystalT2)
         {
            event.craftMatrix.getStackInSlot(4).setItemDamage( event.craftMatrix.getStackInSlot(4).getItemDamage()+3);
         }

         if(event.craftMatrix.getStackInSlot(4).getItem()== DaftcraftItems.rubyCrystalT3)
         {
            event.craftMatrix.getStackInSlot(4).setItemDamage( event.craftMatrix.getStackInSlot(4).getItemDamage()+2);
         }
      }


      else if(event.crafting.getItem()== DaftcraftItems.rubyCrystalT3)
         {



            event.craftMatrix.getStackInSlot(1).setItemDamage(DaftcraftItems.rubyCrystal.getMaxDamage());
            event.craftMatrix.getStackInSlot(3).setItemDamage(DaftcraftItems.rubyCrystal.getMaxDamage());
            event.craftMatrix.getStackInSlot(5).setItemDamage(DaftcraftItems.rubyCrystal.getMaxDamage());
            event.craftMatrix.getStackInSlot(7).setItemDamage(DaftcraftItems.rubyCrystal.getMaxDamage());
            event.craftMatrix.getStackInSlot(4).setItemDamage(DaftcraftItems.rubyCrystalT2.getMaxDamage());
         }

      if(event.crafting.getItem().equals(DaftcraftItems.blaster))
      {
         event.player.addStat(DaftcraftAchievements.egglauncher,1);
      }




   }






}//class

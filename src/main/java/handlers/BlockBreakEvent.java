package handlers;

import items.Registry.DaftcraftItems;
import net.minecraft.block.state.BlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class BlockBreakEvent
{
   @SubscribeEvent
   public void onBreak(BlockEvent.HarvestDropsEvent event)
   {
      //String playerName=event.harvester.getCommandSenderEntity().getName();


      if(event.harvester != null)
      {
         for (int count = 0; count < event.drops.size(); count++)
         {
            if (event.drops.get(count).getTagCompound() == null)
            {
               event.drops.get(count).setTagCompound(new NBTTagCompound());
            }

            if(!event.drops.get(count).getTagCompound().hasKey("Owner"))
            {
               event.drops.get(count).getTagCompound().setString("Owner", event.harvester.getCommandSenderEntity().getName());
               event.drops.get(count).getTagCompound().setString("ID", event.harvester.getUniqueID().toString());
            }

         }
      }






      Random rand=new Random();
      if(event.harvester!=null)
      {
         ItemStack heldItem=event.harvester.getHeldItem();
         EntityPlayer player=event.harvester;
         if(heldItem!=null)
         {

            if(heldItem.getItem()== DaftcraftItems.doubler)
            {


               if(event.state.getBlock()== Blocks.iron_ore)
               {
                  event.drops.clear();
                  event.drops.add(new ItemStack(DaftcraftItems.ironDust,2));
               }
                  else  if(event.state.getBlock()== Blocks.gold_ore)
                  {
                     event.drops.clear();
                     event.drops.add(new ItemStack(DaftcraftItems.goldDust,2));
                  }
                        else  if(event.state.getBlock()== Blocks.diamond_ore)
                        {
                           event.drops.clear();
                           event.drops.add(new ItemStack(DaftcraftItems.diamondDust,2));
                        }
            }
         }

      }
   }

}//class

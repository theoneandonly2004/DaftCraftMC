package items;

import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Daniel on 05/01/2015.
 */
public class FlightRing extends Item
{
   private PlayerCapabilities capabilities=new PlayerCapabilities();
   private int timer=0;
   private final int MAXTIME=20*5;
   public FlightRing()
   {
      this.setCreativeTab(myMod.daftcraft);
      this.maxStackSize=1;
      this.setMaxDamage(1000);
   }



   @Override
   public boolean canHarvestBlock(Block blockIn)
   {
      return false;
   }

   @Override
   public void onUpdate(ItemStack stack, World worldIn, Entity player, int itemSlot, boolean isSelected)
   {

      if(isSelected)
      {

         if(player instanceof EntityPlayer)
         {
            ((EntityPlayer) player).capabilities.allowFlying=true;
            if((((EntityPlayer) player).capabilities.isFlying) && !((EntityPlayer) player).capabilities.isCreativeMode)
            {
               timer++;
            }
         }
      }
      else
      {
         if(player instanceof EntityPlayer)
         {
            if(!((EntityPlayer) player).capabilities.isCreativeMode)
            {
               ((EntityPlayer) player).capabilities.allowFlying = false;
               ((EntityPlayer) player).capabilities.isFlying=false;
            }
         }
      }

      if(timer >= MAXTIME)
      {
         timer=0;
         this.setDamage(stack,stack.getItemDamage()+1);
      }
   }
}//class

package fuels;

import items.Registry.DaftcraftItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;


public class FuelHandler implements IFuelHandler
{


   @Override
   public int getBurnTime(ItemStack fuel)
   {

      Item item=fuel.getItem();

      if(item== DaftcraftItems.betterCoal)
      {

         return 1600*4;
      }
      if(item== DaftcraftItems.ultraCoal)
      {
         return 1600*12;
      }
      if(item== DaftcraftItems.uberCoal)
      {
         return 1600*64;
      }

      if(item==Items.blaze_powder)
      {
         return 2400/3;
      }

         return 0;



   }
}//class

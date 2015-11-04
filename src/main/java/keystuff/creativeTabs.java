package keystuff;

import items.Registry.DaftcraftItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 31/05/14
 * Time: 00:16
 * To change this template use File | Settings | File Templates.
 */
public class creativeTabs extends CreativeTabs
{


   public creativeTabs(String label) {
      super(label);
   }

   @Override
   public Item getTabIconItem()
   {

      return DaftcraftItems.creativeIcon;

   }
}//class

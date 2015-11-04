package keystuff;

import items.Registry.DaftcraftItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 28/09/14
 * Time: 23:12
 * To change this template use File | Settings | File Templates.
 */
public class DaftcraftOreDictionaryRegistry
{
   public static void registerOreDictionary()
   {
      OreDictionary.registerOre("dustGold",new ItemStack(DaftcraftItems.goldDust));
      OreDictionary.registerOre("dustIron",new ItemStack(DaftcraftItems.ironDust));
      OreDictionary.registerOre("dustDiamond",new ItemStack(DaftcraftItems.diamondDust));

   }





}//class

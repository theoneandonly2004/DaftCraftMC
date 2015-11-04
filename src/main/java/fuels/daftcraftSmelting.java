package fuels;

import items.Registry.DaftcraftItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 31/05/14
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
public class daftcraftSmelting
{


   public static void initSmeltingRecipes()
   {
      ItemStack rubyIn=new ItemStack(DaftcraftItems.rubyCrystal,1,OreDictionary.WILDCARD_VALUE);
      ItemStack rubyOut=new ItemStack(DaftcraftItems.rubyCrystal,1,rubyIn.getItemDamage());
       int xp=10;
      GameRegistry.addSmelting(DaftcraftItems.diamondDust, new ItemStack(Items.diamond), xp);
      GameRegistry.addSmelting(DaftcraftItems.goldDust,new ItemStack(Items.gold_ingot),xp);
      GameRegistry.addSmelting(DaftcraftItems.ironDust,new ItemStack(Items.iron_ingot),xp);
      GameRegistry.addSmelting(new ItemStack(Items.coal,9),new ItemStack(DaftcraftItems.betterCoal),xp);
      GameRegistry.addSmelting(Items.rotten_flesh,new ItemStack(Items.leather),xp);
      GameRegistry.addSmelting(rubyIn,new ItemStack(DaftcraftItems.rubyCrystal,1,rubyIn.getMaxDamage()-rubyIn.getItemDamage()-5),xp);
      GameRegistry.addSmelting(new ItemStack(DaftcraftItems.rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE),new ItemStack(DaftcraftItems.rubyCrystalT2,1),xp);
      GameRegistry.addSmelting(new ItemStack(DaftcraftItems.rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE),new ItemStack(DaftcraftItems.rubyCrystalT3,1),xp);
      GameRegistry.addSmelting(new ItemStack(Items.egg),new ItemStack(DaftcraftItems.friedEggs),xp);


   }

}//class

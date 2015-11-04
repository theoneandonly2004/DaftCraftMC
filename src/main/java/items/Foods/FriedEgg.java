package items.Foods;

import keystuff.myMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 26/05/14
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public class FriedEgg extends ItemFood {

   public FriedEgg(int healAmount, float saturation, boolean wolfFood)
   {
      super(healAmount, saturation, wolfFood);
      setMaxStackSize(64);
      setCreativeTab(myMod.daftcraft);
      setUnlocalizedName("fried eggs");
   }



}//class

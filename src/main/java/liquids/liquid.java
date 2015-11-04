package liquids;

import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.Fluid;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 26/05/14
 * Time: 23:53
 * To change this template use File | Settings | File Templates.
 */
public class liquid extends Fluid {

   public liquid(String fluidName)
   {
      super(fluidName);
      setUnlocalizedName("liquid awesome");
      setBlock(Blocks.emerald_block);
      setDensity(1000);
      setLuminosity(2);
      setGaseous(false);
      rarity= EnumRarity.COMMON;
   }


}//class

package items;

import keystuff.myMod;
import net.minecraft.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 08/06/14
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class ObsidianSticks extends Item
{

   public ObsidianSticks()
   {
      setCreativeTab(myMod.daftcraft);
      setMaxStackSize(64);
      setUnlocalizedName("obsidian stick");
      setFull3D();

   }

   @Override
   public boolean isDamageable()
   {
      return false;
   }
}//class

package GUIStuff;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 29/10/14
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
public class DiggerSlot extends Slot
{

   public DiggerSlot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
      super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
   }

   @Override
   public boolean isItemValid(ItemStack p_75214_1_) {
      return true;
   }
}//class

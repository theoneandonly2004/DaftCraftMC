package GUIStuff;

import keystuff.DaftcraftInfo;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import tileEntities.TileEntityDigger;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 29/10/14
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
public class DiggerContainer extends Container
{
   private TileEntityDigger digger;
   private int slotNumber= DaftcraftInfo.DIGGERSLOTS;

   public DiggerContainer(InventoryPlayer inventoryPlayer, TileEntityDigger digger)
   {
      this.digger = digger;


      for(int count=0;count<9;count++)
      {
         addSlotToContainer(new Slot(inventoryPlayer,count,8+count*18,58+51));
      }

      for(int y=0;y<3;y++)
      {
         for(int x=0;x<9;x++)
         {
            addSlotToContainer(new Slot(inventoryPlayer,x + y * 9 + 9, 8 + x * 18, y * 18 + 51));
         }
      }

      for(int x=0;x<digger.getSizeInventory();x++)
      {
         addSlotToContainer(new Slot(digger, x, 44 + x * 18, 20));
      }

   }

   @Override
   public boolean canInteractWith(EntityPlayer player)
   {
      return digger.isUseableByPlayer(player);
   }

   @Override
   public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
   {
      return null;
   }
}//class

package GUIStuff;


import items.BlasterThingy;
import keystuff.myMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import tileEntities.TileEntityDigger;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 23/10/14
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
public class GUIHandler implements IGuiHandler
{

   public GUIHandler()
   {
      NetworkRegistry.INSTANCE.registerGuiHandler(myMod.modInstance,this);
   }



   @Override
   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
      BlockPos current=new BlockPos(x,y,z);
      switch(ID)
      {

         case 0:
            TileEntityDigger digger;
            digger=(TileEntityDigger)world.getTileEntity(current);

            if(digger!=null)
            {
               return new DiggerContainer(player.inventory,digger);
            }

            break;



      }
      return null;
   }

   @Override
   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
      BlockPos current=new BlockPos(x,y,z);
      switch(ID)
      {

         case 0:
            TileEntityDigger digger;
            digger=(TileEntityDigger)world.getTileEntity(current);
            if(digger !=null )
            {
               return new GUIMachine(player.inventory,digger);
            }
            break;



      }
      return null;
   }
}//class

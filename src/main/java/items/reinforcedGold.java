package items;

import keystuff.myMod;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 30/05/14
 * Time: 00:33
 * To change this template use File | Settings | File Templates.
 */
public class reinforcedGold extends Item
{
   public reinforcedGold()
   {
      setCreativeTab(myMod.daftcraft);
      setUnlocalizedName("reinforced gold");
      setMaxStackSize(64);

   }

   @Override
   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
   {
      long craftTime=System.currentTimeMillis()/1000;

      if((System.currentTimeMillis()/1000)-craftTime==5)
      {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("BOOOOOM!!!");
      }

   }
}//class

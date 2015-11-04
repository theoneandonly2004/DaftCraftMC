package items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

/**
 * Created by Daniel on 21/11/2014.
 */
public class RemoteTeleporter extends Item
{
   private double clickPositionX=-1,clickPositionY=-1,clickPositionZ=-1;

   public RemoteTeleporter()
   {
      this.setMaxStackSize(1);
      maxStackSize=1;
   }


   @Override
   public void onCreated(ItemStack stack, World world, EntityPlayer player)
   {
      BlockPos pos;
      Random rand=new Random();
      int count=0;
      if(player.getBedLocation(0)!= null)
      {
         clickPositionX = player.getBedLocation(0).getX();
         clickPositionY = player.getBedLocation(0).getY();
         clickPositionZ = player.getBedLocation(0).getZ();

      }
      else
      {
         clickPositionX=player.posX;
         clickPositionY=player.posY;
         clickPositionZ=player.posZ;

      }


   }

   public double getClickPositionX()
   {
      return clickPositionX;
   }

   public double getClickPositionY()
   {
      return clickPositionY;
   }

   public double getClickPositionZ()
   {
      return clickPositionZ;
   }




   @Override
   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
   {
      if(stack.getTagCompound()==null)
      {
         stack.setTagCompound(new NBTTagCompound());
      }

      if(clickPositionX != -1 && clickPositionY != -1 && clickPositionZ != -1 )
      {

         if (!world.isRemote)
         {
            if (player.isSneaking())
            {
               clickPositionX = player.posX;
               clickPositionY = player.posY;
               clickPositionZ = player.posZ;


               stack.getTagCompound().setDouble("posX", clickPositionX);
               stack.getTagCompound().setDouble("posY", clickPositionY);
               stack.getTagCompound().setDouble("posZ", clickPositionZ);
            }
            else
            {
               clickPositionX=stack.getTagCompound().getDouble("posX");
               clickPositionY=stack.getTagCompound().getDouble("posY");
               clickPositionZ=stack.getTagCompound().getDouble("posZ");
               player.setPositionAndUpdate(clickPositionX, clickPositionY, clickPositionZ);   //teleports the player to their clicked position
               world.playSoundEffect(player.posX,player.posY,player.posZ,"mob.endermen.portal", 1.0F, 1.0F);

            }
         }
      }
         else
         {
               clickPositionX = player.posX;
               clickPositionY = player.posY;
               clickPositionZ = player.posZ;

            stack.getTagCompound().setDouble("posX",clickPositionX);
            stack.getTagCompound().setDouble("posY",clickPositionY);
            stack.getTagCompound().setDouble("posZ",clickPositionZ);

         }

      return stack;
      }

   @Override
   public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_)
   {

      if(stack.getTagCompound() == null)
      {
         stack.setTagCompound(new NBTTagCompound());
      }

      if(clickPositionX != -1 && clickPositionY != -1 && clickPositionZ != -1 )
      {
         list.add("position X:" +(int) stack.getTagCompound().getDouble("posX"));
         list.add("position Y:" + (int)stack.getTagCompound().getDouble("posY"));
         list.add("position Z:" + (int)stack.getTagCompound().getDouble("posZ"));
      }
   }
}


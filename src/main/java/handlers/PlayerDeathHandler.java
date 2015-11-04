package handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 24/08/14
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
public class PlayerDeathHandler
{

   @SubscribeEvent
   public void onDeath(LivingDeathEvent event)
   {
      Entity entity;
      double posX,posY,posZ;
      int count=0;
      String playername;

      if(event.entity instanceof EntityPlayer)
      {
         entity=event.entity;



         if(!entity.worldObj.isRemote)
         {

               posX=entity.posX;
               posY=entity.posY;
               posZ=entity.posZ;
            BlockPos pos=new BlockPos(posX,posY,posZ);


         //entity.worldObj.setBlock((int)(posX),(int)(posY),(int)posZ, Blocks.torch);


         entity.worldObj.setBlockState(pos,Blocks.torch.getDefaultState());




         }
      }
   }

}//class

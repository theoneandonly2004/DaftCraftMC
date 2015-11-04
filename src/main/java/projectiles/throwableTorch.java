package projectiles;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 23/06/14
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class throwableTorch extends EntityThrowable
{

   public throwableTorch(World par1World) {
      super(par1World);

   }

   public throwableTorch(World par1World, EntityLivingBase par2EntityLivingBase) {
      super(par1World, par2EntityLivingBase);
   }

   public throwableTorch(World par1World, double par2, double par4, double par6) {
      super(par1World, par2, par4, par6);
   }

   @Override
   protected void onImpact(MovingObjectPosition hit)
   {
      BlockPos pos=new BlockPos(hit.hitVec.xCoord,hit.hitVec.yCoord,hit.hitVec.zCoord);
      if(this.worldObj.getBlockState(pos).getBlock()!=null )
      {
         worldObj.setBlockState(pos, Blocks.torch.getDefaultState());
         this.setDead();
      }




   }
}//class

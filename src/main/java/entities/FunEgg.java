package entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 11/06/14
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class FunEgg extends EntityThrowable{

   public FunEgg(World world) {
      super(world);

   }

   public FunEgg(World world, EntityLivingBase target) {
      super(world, target);
   }

   public FunEgg(World world, double x, double y, double z) {
      super(world, x, y, z);
   }

   @Override
   protected void onImpact(MovingObjectPosition hit)
   {
      BlockPos pos=new BlockPos(hit.hitVec.xCoord,hit.hitVec.yCoord,hit.hitVec.zCoord);
      if(!this.worldObj.isRemote)
      {
         if (hit.entityHit != null)
         {
            hit.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2.0F);
            this.setDead();
         }

         else if(this.worldObj.getBlockState(pos).getBlock()== Blocks.air)
         {
      EntityChicken chicken=new EntityChicken(this.worldObj);
         chicken.setGrowingAge(-18000);
      chicken.setPosition(pos.getX()+0.5,pos.getY()+1,pos.getZ()+0.5);

      this.worldObj.spawnEntityInWorld(chicken);
         this.setDead();
          }
      }
   }
}//class

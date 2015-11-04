package entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 18/06/14
 * Time: 12:33
 * To change this template use File | Settings | File Templates.
 */
public class PotatoGrenade extends EntityThrowable
{
   private int timer=100;

   public PotatoGrenade(World par1World) {
      super(par1World);
   }

   public PotatoGrenade(World par1World, EntityLivingBase par2EntityLivingBase) {
      super(par1World, par2EntityLivingBase);
   }

   public PotatoGrenade(World par1World, double par2, double par4, double par6) {
      super(par1World, par2, par4, par6);
   }

   @Override
   protected void onImpact(MovingObjectPosition var1)
   {
      if(!this.worldObj.isRemote)
      {

     this.worldObj.createExplosion(this,var1.hitVec.xCoord,var1.hitVec.yCoord,var1.hitVec.zCoord,4.0f,true);
      this.setDead();
         if(var1.entityHit!=null)
         {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6.0F);
         }


      }
   }


}//class

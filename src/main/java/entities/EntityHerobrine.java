package entities;

import items.Registry.DaftcraftItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 13/06/14
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
public class EntityHerobrine extends EntityMob implements IBossDisplayData
{

 int timer=500;
   int randomNumber;
   Random rand=new Random();
   int lightningTimer=600;//20*5*60;

   private float[] field_82220_d = new float[2];
   private float[] field_82221_e = new float[2];
   private float[] field_82217_f = new float[2];
   private float[] field_82218_g = new float[2];
   private int[] field_82223_h = new int[2];
   private int[] field_82224_i = new int[2];
   private int field_82222_j;
   private BlockPos currentPos;


   @Override
   public boolean canBreatheUnderwater()
   {
      return true;

   }

   public EntityHerobrine(World world)
   {
      super(world);
      currentPos=new BlockPos(posX,posY,posZ);
      this.setSize(0.6F, 1.8F);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
      this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
      this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
      this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
      this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class,  true));
      this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
      this.isImmuneToFire=true;


      this.worldObj.playBroadcastSound(1013,currentPos, 0);






      this.setHealth(getMaxHealth());


   }



   @Override
   protected Item getDropItem()
   {
      return Items.nether_star;
   }

    @Override
   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
   {
      this.dropItem(Items.nether_star,6);
   }

    @Override
   public void onStruckByLightning(EntityLightningBolt lightningBolt)
   {
      this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,200,5));
   }

   @Override
   protected void addRandomArmor()
   {
      this.setCurrentItemOrArmor(0,new ItemStack(Items.diamond_sword));
      this.setCurrentItemOrArmor(1,new ItemStack(Items.diamond_chestplate));
   }

   @Override
   protected void applyEntityAttributes()
   {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10000000000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.33000000417232513D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0D);


   }

   @Override
   public boolean canAttackWithItem()
   {
      return true;
   }

   @Override
   public boolean attackEntityFrom(DamageSource damageSource, float p_70097_2_)
   {
      Entity player=damageSource.getEntity();

      if(player!=null)
      {
         if(damageSource instanceof EntityDamageSourceIndirect)
         {
            if(player instanceof EntityPlayer)
            {
            //((EntityPlayer) player).setPositionAndUpdate(this.posX,this.posY,this.posZ);

               this.setPositionAndUpdate(player.posX,player.posY,player.posZ);
               this.playSound("mob.endermen.portal", 1.0F, 1.0F);


            }
         }

            if(player instanceof EntityPlayer)
            {
               if(((EntityPlayer) player).getCurrentEquippedItem()==new ItemStack(DaftcraftItems.notchsWrath,1,OreDictionary.WILDCARD_VALUE))
               {
                  ((EntityPlayer) player).destroyCurrentEquippedItem();
                  player.setCurrentItemOrArmor(0,new ItemStack(Items.wooden_sword));
               }
            }



         }




      return super.attackEntityFrom(damageSource, p_70097_2_);
   }

   @Override
   public boolean attackEntityAsMob(Entity entity)
   {
      entity.motionY=0.5;
      entity.motionZ=0.5;
      return false;
   }

   @Override
   protected void collideWithEntity(Entity entity)
   {
      randomNumber=rand.nextInt(100);
      if(entity instanceof EntityPlayer)
      {
        ((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.poison.id,200,3));
         ((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.blindness.id,200,10));

         if(randomNumber<=10)
         {
            EntitySkeleton skeleton=new EntitySkeleton(entity.worldObj);
            skeleton.setSkeletonType(1);
            skeleton.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
            skeleton.setCurrentItemOrArmor(1,new ItemStack(Items.golden_boots));
            skeleton.setCurrentItemOrArmor(2,new ItemStack(Items.golden_leggings));
            skeleton.setCurrentItemOrArmor(3,new ItemStack(Items.golden_chestplate));
            skeleton.setCurrentItemOrArmor(4,new ItemStack(Items.golden_helmet));
            skeleton.setPosition(this.posX, this.posY + 1, this.posZ);
            skeleton.setEquipmentDropChance(0,0);
            worldObj.spawnEntityInWorld(skeleton);


         }
         if(!worldObj.isRemote)
         {
         entity.motionY=2;
         entity.motionZ=0.5;
         }

      }





   }

   @Override
   public void onLivingUpdate()
   {

      BossStatus.setBossStatus(this,true);


      EntityPlayer player=worldObj.getClosestPlayerToEntity(this,1000);
      int checkX=-1;
      int checkZ=-1;

      if(!this.worldObj.isRemote)
      {




      if(this.getHealth()<=1000)
      {
         if(timer==0)

         {


            if(player!=null)
            {
            EntitySkeleton skeleton=new EntitySkeleton(this.worldObj);
            //skeleton.setPosition(this.posX-1,this.posY,this.posZ);
            skeleton.setPosition(player.posX,player.posY,player.posZ);
            }


            EntitySkeleton secskeleton=new EntitySkeleton(this.worldObj);
            secskeleton.setPosition(this.posX+1,this.posY,this.posZ);



            EntitySkeleton thirdskeleton=new EntitySkeleton(this.worldObj);
            thirdskeleton.setPosition(this.posX,this.posY,this.posZ+1);



            EntitySkeleton fourskeleton=new EntitySkeleton(this.worldObj);
            fourskeleton.setPosition(this.posX,this.posY,this.posZ-1);





            timer=1000;
         }
         else
         {
            timer--;
         }

      }
         else
      {
         if(timer<=0)
         {
            for(int count=0;count<2;count++)
            {
            EntitySkeleton skeleton=new EntitySkeleton(this.worldObj);
            skeleton.setCurrentItemOrArmor(0,new ItemStack(Items.bow));
            skeleton.setCurrentItemOrArmor(1,new ItemStack(Items.iron_helmet));
            skeleton.setCurrentItemOrArmor(2,new ItemStack(Items.iron_helmet));
            skeleton.setCurrentItemOrArmor(3,new ItemStack(Items.iron_helmet));
            skeleton.setCurrentItemOrArmor(4,new ItemStack(Items.iron_helmet));
            skeleton.setPosition(this.posX+1,this.posY,this.posZ);
            skeleton.setEquipmentDropChance(0,0);

            this.worldObj.spawnEntityInWorld(skeleton);

               EntitySkeleton secSkeleton=new EntitySkeleton(this.worldObj);
               secSkeleton.setCurrentItemOrArmor(0,new ItemStack(Items.bow));
               secSkeleton.setCurrentItemOrArmor(4,new ItemStack(Items.iron_helmet));
               secSkeleton.setCurrentItemOrArmor(3,new ItemStack(Items.iron_chestplate));
               secSkeleton.setCurrentItemOrArmor(2,new ItemStack(Items.iron_leggings));
               secSkeleton.setCurrentItemOrArmor(1,new ItemStack(Items.iron_boots));
               secSkeleton.setEquipmentDropChance(0,0);

               secSkeleton.setPosition(this.posX+checkX,this.posY,this.posZ+checkZ);
               this.worldObj.spawnEntityInWorld(secSkeleton);

               checkX+=2;
               checkZ+=2;
            }


            timer=500;

         }
         else
         {
            timer--;
         }

      }



      }

      if(lightningTimer==0)
      {
         int count=0;
         for(int X=-1;X<2;X++)
         {
            for(int Z=-1;Z<2;Z++)
            {
               EntityLightningBolt herobrineBolt=new EntityLightningBolt(worldObj,posX,posY,posZ);
               herobrineBolt.setPosition(posX+X,posY,posZ+Z);

               worldObj.addWeatherEffect(herobrineBolt);
               count++;
            }
         }




         lightningTimer=600;//20*5*60;
      }
      else
      {
         lightningTimer--;
      }

      super.onLivingUpdate();

   }






 }
















package items;

import keystuff.myMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 11/06/14
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class HerobrinesRage extends Item
{
   public HerobrinesRage()
   {
      setCreativeTab(myMod.daftcraft);
      setMaxStackSize(1);
      setUnlocalizedName("herobrines rage");
      setMaxDamage(500);
   }



   /* @Override
   public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
   {
      EntityLightningBolt lightning=new EntityLightningBolt(world,player.posX,player.posY,player.posZ);
      lightning.setPosition(player.posX+2,player.posY,player.posZ+2);
      world.spawnEntityInWorld(lightning);

      return itemStack;
   }                     */


   @Override
   public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target)
   {
      EntityLightningBolt lightning=new EntityLightningBolt(target.worldObj,target.posX,target.posY,target.posZ);
      lightning.setPosition(target.posX,target.posY,target.posZ);
      player.worldObj.spawnEntityInWorld(lightning);
      itemStack.setItemDamage(itemStack.getItemDamage()+1);
      return true;
   }

   @Override
   public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
   {
      if(entity instanceof EntityPlayer)
      {
         ((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.fireResistance.id,2,200));
      }

   }

   @Override
   public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
   {
      EntityLightningBolt lightning=new EntityLightningBolt(world,hitX,hitY,hitZ);
      lightning.setPosition(hitX,hitY,hitZ);
      player.worldObj.spawnEntityInWorld(lightning);
      itemStack.setItemDamage(itemStack.getItemDamage()+1);
      return true;

   }



 /*  @Override
   public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
   {
      if(player.isSneaking())
      {
         if(player.inventory.hasItem(Items.diamond_sword))
         {
           System.out.println("you have chosen power");
            return new ItemStack(Items.egg);
         }
         else if(player.inventory.hasItem(Items.diamond_chestplate))
         {
            System.out.println("you have chosen courage");
            return new ItemStack(Items.blaze_rod);
         }
         else if(player.inventory.hasItem(Items.bow))
         {
            System.out.println("you have chosen wisdom");
            return new ItemStack(Items.poisonous_potato);
         }
      }

      return itemStack;
   }    */
}//class

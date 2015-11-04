package items;

import entities.EntityHerobrine;
import keystuff.myMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 28/05/14
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class NotchsWrath extends ItemSword
{
   PlayerCapabilities capabilities;
   Random rand=new Random();

   public NotchsWrath(ToolMaterial material)
   {
      super(material);
      setUnlocalizedName("notch's wrath");
      setCreativeTab(myMod.daftcraft);
      capabilities=new PlayerCapabilities();


   }





   @Override
   public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
   {


      if(target.getHealth()>2000 && isCharged(target))
      {
         target.getMaxHealth();
         target.setHealth(target.getMaxHealth() - target.getMaxHealth() + 1000);
         target.setCurrentItemOrArmor(0, new ItemStack(this));
         if(player instanceof EntityPlayer)
         {
        ((EntityPlayer) player).addChatMessage(new ChatComponentText("your sword has lost all power draining most of herobrines power"));
         player.setCurrentItemOrArmor(0,new ItemStack(Items.wooden_sword));
         }

      }
       if(capabilities.isCreativeMode)
      {
         target.setHealth(0);
      }


         target.setFire(2);



      return true;
   }

   @Override
   public boolean itemInteractionForEntity(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase target)
   {
      System.out.println(target.getHealth());
      return true;
   }



   public boolean isCharged(Entity target)
   {
      return(target instanceof EntityHerobrine);
   }


}


//class

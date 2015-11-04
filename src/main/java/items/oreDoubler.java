package items;

import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 28/05/14
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class oreDoubler extends ItemPickaxe

{

   public oreDoubler(ToolMaterial material )
   {
      super(material);



      setMaxStackSize(1);
      setUnlocalizedName("ore doubler");

      setCreativeTab(myMod.daftcraft);

   }



   @Override
   public ItemStack getContainerItem(ItemStack itemStack)
   {
      ItemStack cStack=itemStack.copy();
      cStack.setItemDamage(cStack.getItemDamage()+1);
      cStack.stackSize=1;
      return cStack;

   }


   @Override
   public boolean hasContainerItem(ItemStack stack)
   {
      return stack.getItemDamage()<stack.getMaxDamage();
   }

   @Override
   public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
   {
      list.add(itemStack.getMaxDamage()-itemStack.getItemDamage() +" uses left");

   }

   @Override
   public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target)
   {
      System.out.println("herobrines health is " + target.getHealth());

      return true;

   }

   @Override
   public boolean onBlockDestroyed(ItemStack itemStack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
   {
      itemStack.setItemDamage(itemStack.getItemDamage()+1);

      return true;

   }


}//class

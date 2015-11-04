package items;

import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 26/05/14
 * Time: 23:27
 * To change this template use File | Settings | File Templates.
 */
public class voidPick extends ItemPickaxe {

   public voidPick(ToolMaterial material)
   {
      super(material);
      setMaxStackSize(1);
      setMaxDamage(800);
      setUnlocalizedName("void pick");
      setCreativeTab(myMod.daftcraft);




   }

   @Override
   public boolean onBlockDestroyed(ItemStack stack, World world, Block block, BlockPos pos, EntityLivingBase player)
   {
      BlockPos currentPos;
      int rotation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

      if(!world.isRemote)
      {
         if(block.getMaterial()==Material.iron || block.getMaterial()==Material.rock || block.getMaterial()==Material.anvil)
         {
            currentPos=new BlockPos(pos.getX(),pos.getY(),pos.getZ());

            if(rotation==0 || rotation==2)
            {
               world.setBlockToAir(pos);
               world.setBlockToAir(pos.up(1));
               world.setBlockToAir(pos.down(1));
               //world.func_147480_a((x+X),(y+Y),z,true);



            }
            else
            {
               world.setBlockToAir(pos);
               world.setBlockToAir(pos.up(1));
               world.setBlockToAir(pos.down(1));
            }
         }
         else
         {
            world.setBlockToAir(pos);
         }




      }
      return true;


   }


   @Override
   public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
   {
      int destroyedBlocks=0;

      for(int count=0;count<11;count++)
      {
         if(world.getBlockState(pos.up(count))!=Blocks.air)
         {



            if(world.getBlockState(pos.up(count))instanceof BlockGravel || world.getBlockState(pos.up(count)).getBlock()instanceof BlockSand)
            {
               world.setBlockToAir(pos.up(count));
               destroyedBlocks++;
            }

         }
      }
      itemStack.setItemDamage(itemStack.getItemDamage()+destroyedBlocks);

      if(itemStack.getItemDamage()>=itemStack.getMaxDamage())
      {
         itemStack.stackSize--;
      }
      return true;

   }


}//class

package items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 12/11/2014.
 */
public class TestOreFindingThing extends Item
{
   public TestOreFindingThing()
   {
      this.setUnlocalizedName("ore Finder");
      this.setMaxDamage(10);
   }



   @Override
   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
   {
      double posX=player.posX,posY=player.posY,posZ=player.posZ;
      BlockPos pos=new BlockPos(posX,posY,posZ);
      List<Block> ores=new ArrayList<Block>();
      Block currentBlock;

      for(int Y=0;Y<3;Y++)
      {
         for(int X=0;X<16;X++)
         {
            for(int Z=0;Z<16;Z++)
            {
               if(world.getBlockState(pos.east(X).up(Y).north(Z)).getBlock() instanceof BlockOre)
               {
                  currentBlock=world.getBlockState(pos.east(X).up(Y).north(Z)).getBlock();
                  if(!ores.contains(currentBlock))
                  {
                     ores.add(currentBlock);
                  }
               }
            }
         }
      }

      if(stack.getTagCompound()==null)
      {
         stack.setTagCompound(new NBTTagCompound());

      }
      String name="";
      for(int count=0;count<ores.size();count++)
      {
         name=name+ores.get(count).getUnlocalizedName();
      }
      stack.getTagCompound().setString("OresList", name);
      return stack;
   }



   @Override
   public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_)
   {
      if(stack.getTagCompound() == null)
      {
         stack.setTagCompound(new NBTTagCompound());
      }
      list.add(stack.getTagCompound().getString("OreList"));
   }
}//class

package blocks;

import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 31/05/14
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */
public class compressedBlocks extends Block {

   protected compressedBlocks(Material material)
   {
      super(material);
      setCreativeTab(myMod.daftcraft);

   }

   @Override
   public boolean canCreatureSpawn(IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type)
   {
      return false;
   }




}//class

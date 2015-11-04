package blocks;

import config.DaftcraftConfig;
import items.Registry.DaftcraftItems;
import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import tileEntities.TileEntityDigger;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 31/05/14
 * Time: 23:24
 * To change this template use File | Settings | File Templates.
 */
public class DaftcraftBlocks
{
   public static TileEntity diggerTileEntity;
   public static Block randomonium;
   public static Block summoner;
   public static Block portal;
   public static Block test;
   public static Block compressedGold;
   public static Block digger;

   public static void init()
   {

      digger=new Digger(Material.iron).setUnlocalizedName("hole digger");

         if(!DaftcraftConfig.portalDisabled)
         {
         portal=new newEndPortal(Material.iron);
         }

      randomonium =new Randomonium(Material.iron);

         if(!DaftcraftConfig.summonorDisabled)
         {
         summoner=new TheSummonor(Material.dragonEgg);
         }

      compressedGold=new compressedBlocks(Material.iron).setUnlocalizedName("reinforced gold block").setHardness(7.0f).setResistance(100f);
   }

   public static void registerBlocks()
   {
      GameRegistry.registerBlock(compressedGold,"reinforced gold block");

         if(!DaftcraftConfig.summonorDisabled)
         {
            GameRegistry.registerBlock(summoner, "the summoner");
         }

      GameRegistry.registerBlock(randomonium, "randomonium ore");

         if(!DaftcraftConfig.portalDisabled)
         {
            GameRegistry.registerBlock(portal,"portal block");
         }
      GameRegistry.registerBlock(digger,"hole digger");
      GameRegistry.registerTileEntity(TileEntityDigger.class,"DiggerTileEntity");
   }

   public static void registerBlockRenders()
   {
         if(!DaftcraftConfig.portalDisabled)
         {
            registerRendering(Item.getItemFromBlock(portal));
         }

         if(!DaftcraftConfig.summonorDisabled)
         {
            registerRendering(Item.getItemFromBlock(summoner));
         }
      registerRendering(Item.getItemFromBlock(digger));
      registerRendering(Item.getItemFromBlock(compressedGold));
      registerRendering(Item.getItemFromBlock(randomonium));


   }

   public static void registerRendering(Item pItem)
   {
      Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(pItem, 0, new ModelResourceLocation(myMod.MODID +":" + pItem.getUnlocalizedName().substring(5), "inventory"));
   }

   public static void registerBlockRecipes()
   {
      GameRegistry.addRecipe(new ItemStack(digger),
              "III",
              "PDP",
              " R ",
              'I',new ItemStack(Items.iron_ingot),
              'P',new ItemStack(Items.iron_pickaxe),
              'D',new ItemStack(Items.diamond_pickaxe),
              'R',new ItemStack(DaftcraftItems.rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE));


      GameRegistry.addRecipe(new ItemStack(compressedGold),
              "RRR",
              "RRR",
              "RRR",
              'R', DaftcraftItems.reinforcedGoldIngot);

      if(!DaftcraftConfig.summonorDisabled)
      {
      GameRegistry.addRecipe(new ItemStack(summoner),
              "BBB",
              "BDB",
              "BBB",
              'B', Blocks.iron_bars,
              'D', new ItemStack(DaftcraftItems.rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE));
      }

      if(!DaftcraftConfig.portalDisabled)
      {
      GameRegistry.addRecipe(new ItemStack(portal),
              "OOO",
              "ORO",
              "OOO",
              'O',Blocks.obsidian,
              'R',new ItemStack(DaftcraftItems.rubyCrystalT3,1, OreDictionary.WILDCARD_VALUE));
      }
   }



}//class

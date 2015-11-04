package keystuff;

import GUIStuff.GUIHandler;
import WorldGen.worldGen;
import blocks.DaftcraftBlocks;
import config.DaftcraftConfig;
import entities.daftcraftEntities;
import fuels.FuelHandler;
import fuels.daftcraftSmelting;
import handlers.*;
import items.Registry.DaftcraftItems;
import liquids.liquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import proxies.CommonProxy;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 26/05/14
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
@Mod(modid = myMod.MODID, version = myMod.VERSION)//, = "client.gui.GUIFactory")

public class myMod
{
   public static boolean endOnly;
   public static final String MODID="daftcraft";
   public static final String VERSION="A1.0";
   @SidedProxy(clientSide = "proxies.ClientProxy",serverSide = "proxies.CommonProxy")
   public static CommonProxy proxy;

   @Mod.Instance(MODID)
   public static myMod modInstance;






   public static CreativeTabs daftcraft=new creativeTabs("daftCraft");
   public static WorldGen.worldGen worldGen= new worldGen();



   public Fluid myfluid;



   @Mod.EventHandler
   public void preInit(FMLPreInitializationEvent event)
   {
      //proxy.registerRenderingThings();
      DaftcraftConfig.init(event.getSuggestedConfigurationFile());
      DaftcraftItems.init();
      DaftcraftItems.RegisterItems();
      DaftcraftBlocks.init();
      DaftcraftBlocks.registerBlocks();
      daftcraftEntities.mainRegitry();

   }




   @Mod.EventHandler
   public void init(FMLInitializationEvent event)
   {
      proxy.registerRenderingThings();
      new GUIHandler();
      daftcraftSmelting.initSmeltingRecipes();
      DaftcraftItems.registerItemRecipes();
      DaftcraftBlocks.registerBlockRecipes();
      GameRegistry.registerFuelHandler(new FuelHandler());
      GameRegistry.registerWorldGenerator(worldGen, 1);
      FMLCommonHandler.instance().bus().register(new CraftingHandler());
      FMLCommonHandler.instance().bus().register(new ToolTipHandler());
      FMLCommonHandler.instance().bus().register(new SmeltingHandler());
      FMLCommonHandler.instance().bus().register(new PlayerDeathHandler());
      FMLCommonHandler.instance().bus().register(new ToolTipHandler());
      FMLCommonHandler.instance().bus().register(new ItemPickUpHandler());
      FMLCommonHandler.instance().bus().register(new BlockBreakEvent());
      FMLCommonHandler.instance().bus().register(new ItemDropppedHandler());
      MinecraftForge.EVENT_BUS.register(new BlockBreakEvent());
      MinecraftForge.EVENT_BUS.register(new PlayerDeathHandler());
      MinecraftForge.EVENT_BUS.register(new ToolTipHandler());
      MinecraftForge.EVENT_BUS.register(new ItemPickUpHandler());
      MinecraftForge.EVENT_BUS.register(new ItemDropppedHandler());




      DaftcraftAchievements.addAchievements();

      GameRegistry.registerWorldGenerator(worldGen,1);
      DaftcraftOreDictionaryRegistry.registerOreDictionary();


      }




   @Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event)
   {

   }

}//class

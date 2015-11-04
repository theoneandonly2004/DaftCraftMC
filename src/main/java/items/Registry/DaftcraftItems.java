package items.Registry;

import armors.StoneArmor;
import armors.VisorHeadpiece;
import blocks.DaftcraftBlocks;
import config.DaftcraftConfig;
import items.*;
import items.Foods.FriedEgg;
import keystuff.daftcraftMaterials;
import keystuff.myMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 31/05/14
 * Time: 23:28
 * To change this template use File | Settings | File Templates.
 */
public class DaftcraftItems

{
   public static String textures=myMod.MODID +":";


   public static Item flightRing;
   public static Item portableTeleporter;

   public static Item testbow;

   public static Item cobblestoneHeadpiece;
   public static Item cobblestoneChestpiece;
   public static Item cobblestoneLeggings;
   public static Item cobblestoneBoots;
   public static Item visor;
   public static Item belt;
   public static Item throwingTorchAmmo;
   public static Item throwingTorchWeapon;

   public static Item blaster;
   public static Item boomPotato;
   public static Item obsidianStick;
   public static Item friedEggs;
   public static Item voidPickaxe;
   public static Item notchsWrath;
   public static Item ironDust;
   public static Item goldDust;
   public static Item diamondDust;
   public static Item doubler;
   public static Item triplePickaxe;
   public static Item creativeIcon;
   public static Item reinforcedGoldIngot;
   public static Item chestPiece;

   public static Item betterCoal;
   public static Item ultraCoal;
   public static Item uberCoal;
   public static Item rubyCrystal;
   public static Item rubyCrystalT2;
   public static Item rubyCrystalT3;
   public static Item reinforcedAxe;

   public static Item herobrinesRage;




   public static void init()
   {
      portableTeleporter=new RemoteTeleporter().setUnlocalizedName("portable teleporter").setCreativeTab(myMod.daftcraft);

      cobblestoneHeadpiece=new StoneArmor(daftcraftMaterials.stoneMaterial,4,0).setUnlocalizedName("stone headpiece");

      cobblestoneChestpiece=new StoneArmor(daftcraftMaterials.stoneMaterial,4,1).setUnlocalizedName("stone chestpiece");

      cobblestoneLeggings=new StoneArmor(daftcraftMaterials.stoneMaterial,4,2).setUnlocalizedName("stone leggings");

      cobblestoneBoots=new StoneArmor(daftcraftMaterials.stoneMaterial,4,3).setUnlocalizedName("stone boots");

      visor=new VisorHeadpiece(daftcraftMaterials.mightyGold,4,0).setUnlocalizedName("visor headpiece");

      belt=new VisorHeadpiece(daftcraftMaterials.mightyGold,4,1).setUnlocalizedName("super belt");

      herobrinesRage =new HerobrinesRage();

      blaster =new BlasterThingy().setFull3D();

      obsidianStick=new ObsidianSticks();

      rubyCrystalT3=new T3Crystals().setUnlocalizedName("ruby tier 3").setMaxDamage(100);

      rubyCrystalT2=new T2Crystals().setUnlocalizedName("ruby tier 2").setMaxDamage(30);

      rubyCrystal=new Crystals().setUnlocalizedName("ruby").setMaxDamage(10);

      reinforcedAxe=new ReinforcedAxe(daftcraftMaterials.reinforcedGold);

      betterCoal=new fuelItems().setUnlocalizedName("better coal");

      ultraCoal=new fuelItems().setUnlocalizedName("ultra coal");

      uberCoal=new fuelItems().setUnlocalizedName("uber fuel");

      triplePickaxe=new triplePick(daftcraftMaterials.reinforcedGold);

      creativeIcon=new creativetabitem().setUnlocalizedName("CreativeIcon");

      reinforcedGoldIngot=new reinforcedGold();

      voidPickaxe=new voidPick(daftcraftMaterials.reinforcedGold);

      notchsWrath =new NotchsWrath(daftcraftMaterials.reinforcedGold);

      friedEggs=new FriedEgg(2,0.5f,true);

      doubler=new oreDoubler(daftcraftMaterials.reinforcedGold).setMaxDamage(100);

      ironDust=new Dusts().setUnlocalizedName("iron dust");

      goldDust=new Dusts().setUnlocalizedName("gold dust");

      diamondDust=new Dusts().setUnlocalizedName("diamond dust");

      flightRing=new FlightRing().setUnlocalizedName("flight ring");
   }

   public static void RegisterItems()
   {
      GameRegistry.registerItem(flightRing,flightRing.getUnlocalizedName().substring(5));

      GameRegistry.registerItem(portableTeleporter, "portable teleporter");

      GameRegistry.registerItem(cobblestoneHeadpiece,"stone headpiece");

      GameRegistry.registerItem(cobblestoneChestpiece,"stone chestpiece");

      GameRegistry.registerItem(cobblestoneLeggings,"stone leggings");

      GameRegistry.registerItem(cobblestoneBoots,"stone boots");

      GameRegistry.registerItem(visor,"visor headpiece");

      GameRegistry.registerItem(belt,"super belt");

      GameRegistry.registerItem(herobrinesRage,"herobrines rage");

      GameRegistry.registerItem(blaster,"blaster");

      GameRegistry.registerItem(obsidianStick,"obsidian stick");

      GameRegistry.registerItem(rubyCrystalT3,"ruby tier 3");

      GameRegistry.registerItem(rubyCrystalT2,"ruby tier 2");

      GameRegistry.registerItem(rubyCrystal,"ruby");

      GameRegistry.registerItem(reinforcedAxe,"reinforced axe");

      GameRegistry.registerItem(betterCoal,"better coal");

      GameRegistry.registerItem(ultraCoal,"ultra coal");

      GameRegistry.registerItem(uberCoal,"uber fuel");

      GameRegistry.registerItem(triplePickaxe, "triple pickaxe");

      GameRegistry.registerItem(creativeIcon,"CreativeIcon");

      GameRegistry.registerItem(reinforcedGoldIngot,"reinforced gold");

      GameRegistry.registerItem(voidPickaxe,"void pick");

      GameRegistry.registerItem(notchsWrath,"notch's wrath");

      GameRegistry.registerItem(friedEggs, "fried eggs");

      GameRegistry.registerItem(doubler,"ore doubler");

      GameRegistry.registerItem(ironDust,"iron dust");

      GameRegistry.registerItem(goldDust,"gold dust");

      GameRegistry.registerItem(diamondDust,"diamond dust");

      OreDictionary.registerOre("diamond dust",diamondDust);
      OreDictionary.registerOre("iron dust",ironDust);
      OreDictionary.registerOre("gold dust",goldDust);

   }

   public static void registerRender()
   {
      registerItemRendering(portableTeleporter);
      registerItemRendering(friedEggs);
      registerItemRendering(goldDust);
      registerItemRendering(diamondDust);
      registerItemRendering(ironDust);
      registerItemRendering(rubyCrystal);
      registerItemRendering(rubyCrystalT2);
      registerItemRendering(rubyCrystalT3);
      registerItemRendering(doubler);
      registerItemRendering(cobblestoneBoots);
      registerItemRendering(cobblestoneLeggings);
      registerItemRendering(cobblestoneChestpiece);
      registerItemRendering(cobblestoneHeadpiece);
      registerItemRendering(visor);
      registerItemRendering(belt);
      registerItemRendering(obsidianStick);
      registerItemRendering(reinforcedAxe);
      registerItemRendering(triplePickaxe);
      registerItemRendering(creativeIcon);
      registerItemRendering(betterCoal);
      registerItemRendering(ultraCoal);
      registerItemRendering(uberCoal);
      registerItemRendering(reinforcedGoldIngot);
      registerItemRendering(voidPickaxe);
      registerItemRendering(notchsWrath);
      //
      registerItemRendering(herobrinesRage);
      registerItemRendering(blaster);
      //







   }


   public static void registerItemRendering(Item pItem)
   {
      Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(pItem,0,new ModelResourceLocation(myMod.MODID +":" + pItem.getUnlocalizedName().substring(5), "inventory"));
   }

   public static void registerItemRecipes()
   {

      GameRegistry.addShapelessRecipe(new ItemStack(herobrinesRage),new ItemStack(Items.nether_star),new ItemStack(herobrinesRage,1,OreDictionary.WILDCARD_VALUE));
      if(!DaftcraftConfig.boomPotatoDisabled)
      {
      GameRegistry.addShapelessRecipe(new ItemStack(boomPotato,3),new ItemStack(Items.poisonous_potato),new ItemStack(Blocks.tnt));
      }
      GameRegistry.addShapelessRecipe(new ItemStack(diamondDust,2),new ItemStack(Blocks.diamond_ore),new ItemStack(doubler,1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(ironDust, 2), new ItemStack(Blocks.iron_ore), new ItemStack(doubler, 1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(goldDust,2),new ItemStack(Blocks.gold_ore),new ItemStack(doubler,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addShapelessRecipe(new ItemStack(DaftcraftItems.triplePickaxe), new ItemStack(DaftcraftItems.rubyCrystalT2, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(DaftcraftItems.triplePickaxe, 1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(DaftcraftItems.triplePickaxe),new ItemStack(DaftcraftItems.rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE),new ItemStack(DaftcraftItems.triplePickaxe,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addShapelessRecipe(new ItemStack(DaftcraftItems.reinforcedAxe), new ItemStack(DaftcraftItems.rubyCrystalT2, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(DaftcraftItems.reinforcedAxe, 1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(DaftcraftItems.reinforcedAxe),new ItemStack(DaftcraftItems.rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE),new ItemStack(DaftcraftItems.reinforcedAxe,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addShapelessRecipe(new ItemStack(DaftcraftItems.voidPickaxe), new ItemStack(DaftcraftItems.voidPickaxe, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(DaftcraftItems.rubyCrystal, 1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(DaftcraftItems.voidPickaxe),new ItemStack(DaftcraftItems.voidPickaxe,1,OreDictionary.WILDCARD_VALUE),new ItemStack(DaftcraftItems.rubyCrystalT2,1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(DaftcraftItems.voidPickaxe),new ItemStack(DaftcraftItems.voidPickaxe,1,OreDictionary.WILDCARD_VALUE),new ItemStack(DaftcraftItems.rubyCrystalT3,1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(obsidianStick, 2), new ItemStack(Blocks.obsidian), new ItemStack(Blocks.obsidian), new ItemStack(rubyCrystal, 1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(obsidianStick,2),new ItemStack(Blocks.obsidian),new ItemStack(Blocks.obsidian),new ItemStack(rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(obsidianStick, 2), new ItemStack(Blocks.obsidian), new ItemStack(Blocks.obsidian), new ItemStack(rubyCrystalT3, 1, OreDictionary.WILDCARD_VALUE));
      GameRegistry.addShapelessRecipe(new ItemStack(betterCoal),new ItemStack(Items.coal),new ItemStack(Items.coal),new ItemStack(Items.coal),new ItemStack(Items.redstone));
      GameRegistry.addShapelessRecipe(new ItemStack(reinforcedGoldIngot, 9), new ItemStack(DaftcraftBlocks.compressedGold));



      GameRegistry.addRecipe(new ItemStack(ultraCoal),
              "OCO",
              "CDC",
              "OCO",
              'C',new ItemStack(Items.coal),
              'O',new ItemStack(Blocks.obsidian),
              'D',new ItemStack(Items.diamond));

      GameRegistry.addRecipe(new ItemStack(uberCoal),
              " C ",
              "CNC",
              " C ",
              'C', new ItemStack(DaftcraftItems.ultraCoal),
              'N', new ItemStack(Items.nether_star));

      GameRegistry.addRecipe(new ItemStack(blaster),
              "III",
              "RRL",
              "IIL",
              'I',new ItemStack(Items.iron_ingot),
              'R',new ItemStack(Blocks.redstone_block),
              'L',new ItemStack(Items.leather));

      GameRegistry.addRecipe(new ItemStack(belt),
              "LLL",
              "RCR",
              "LLL",
              'L',new ItemStack(Items.iron_ingot),
              'C',new ItemStack(rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE),
              'R',new ItemStack(Items.redstone));

      GameRegistry.addRecipe(new ItemStack(belt),
              "LLL",
              "RCR",
              "LLL",
              'L', new ItemStack(Items.iron_ingot),
              'C', new ItemStack(rubyCrystalT3, 1, OreDictionary.WILDCARD_VALUE),
              'R', new ItemStack(Items.redstone));

      GameRegistry.addRecipe(new ItemStack(visor),
              "LLL",
              "GCG",
              "LLL",
              'L',new ItemStack(Items.iron_ingot),
              'C',new ItemStack(rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE),
              'G',new ItemStack(Blocks.glass,1));

      GameRegistry.addRecipe(new ItemStack(visor),
              "LLL",
              "GCG",
              "LLL",
              'L',new ItemStack(Items.iron_ingot),
              'C',new ItemStack(rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE),
              'G',new ItemStack(Blocks.glass,1));



      GameRegistry.addRecipe(new ItemStack(rubyCrystalT3),
              " O ",
              "OTO",
              " O ",
              'O', new ItemStack(rubyCrystal,1,OreDictionary.WILDCARD_VALUE),
              'T', new ItemStack(rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addRecipe(new ItemStack(rubyCrystalT2),
              " D ",
              "DRD",
              " D ",
              'R',new ItemStack(rubyCrystal,1,OreDictionary.WILDCARD_VALUE),
              'D',Items.diamond);

      GameRegistry.addRecipe(new ItemStack(rubyCrystal),
              " R ",
              "RDR",
              " R ",
              'R',Items.redstone,
              'D',Items.diamond);

      GameRegistry.addRecipe(new ItemStack(reinforcedGoldIngot),
           "OGO",
           "GRG",
           "OGO",
           'O', Blocks.obsidian,
           'G', Items.gold_ingot,
           'R',new ItemStack(DaftcraftItems.rubyCrystal,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addRecipe(new ItemStack(reinforcedGoldIngot),
              "OGO",
              "GRG",
              "OGO",
              'O', Blocks.obsidian,
              'G', Items.gold_ingot,
              'R',new ItemStack(DaftcraftItems.rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addRecipe(new ItemStack(reinforcedGoldIngot),
              "OGO",
              "GRG",
              "OGO",
              'O', Blocks.obsidian,
              'G', Items.gold_ingot,
              'R',new ItemStack(DaftcraftItems.rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE));

     /* GameRegistry.addRecipe(new ItemStack(chestPiece),
              "R R",
              "RRR",
              "RRR",
              'R',reinforcedGoldIngot); */

      GameRegistry.addRecipe(new ItemStack(reinforcedAxe),
              "RD ",
              "RS ",
              " S ",
              'R',reinforcedGoldIngot,
              'S',obsidianStick,
              'D', new ItemStack(rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addRecipe(new ItemStack(reinforcedAxe),
              "RD ",
              "RS ",
              " S ",
              'R',reinforcedGoldIngot,
              'S',obsidianStick,
              'D', new ItemStack(rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addRecipe(new ItemStack(notchsWrath),
              " R ",
              " R ",
              " S ",
              'R',reinforcedGoldIngot,
              'S',obsidianStick);

      GameRegistry.addRecipe(new ItemStack(triplePickaxe),
              "RDR",
              " S ",
              " S ",
              'R',reinforcedGoldIngot,
              'S',obsidianStick,
              'D',new ItemStack(rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE));

      GameRegistry.addRecipe(new ItemStack(triplePickaxe),
              "RDR",
              " S ",
              " S ",
              'R',reinforcedGoldIngot,
              'S',obsidianStick,
              'D',new ItemStack(rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE));


      GameRegistry.addRecipe(new ItemStack(voidPickaxe),
           "RDR",
           " S ",
           " S ",
           'R',Blocks.obsidian,
           'D',new ItemStack(rubyCrystal,1,OreDictionary.WILDCARD_VALUE),
           'S',obsidianStick);

      GameRegistry.addRecipe(new ItemStack(voidPickaxe),
              "RDR",
              " S ",
              " S ",
              'R',Blocks.obsidian,
              'D',new ItemStack(rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE),
              'S',obsidianStick);

      GameRegistry.addRecipe(new ItemStack(voidPickaxe),
              "RDR",
              " S ",
              " S ",
              'R',Blocks.obsidian,
              'D',new ItemStack(rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE),
              'S',obsidianStick);

      GameRegistry.addRecipe(new ItemStack(doubler),
              "GDG",
              " I ",
              " I ",
              'G',Items.gold_ingot,
              'D',new ItemStack(rubyCrystal,1,OreDictionary.WILDCARD_VALUE),
              'I',Items.iron_ingot);

      GameRegistry.addRecipe(new ItemStack(doubler),
              "GDG",
              " I ",
              " I ",
              'G',Items.gold_ingot,
              'D',new ItemStack(rubyCrystalT2,1,OreDictionary.WILDCARD_VALUE),
              'I',Items.iron_ingot);

      GameRegistry.addRecipe(new ItemStack(doubler),
              "GDG",
              " I ",
              " I ",
              'G',Items.gold_ingot,
              'D',new ItemStack(rubyCrystalT3,1,OreDictionary.WILDCARD_VALUE),
              'I',Items.iron_ingot);

      GameRegistry.addRecipe(new ItemStack(cobblestoneHeadpiece),
              "SSS",
              "S S",
              'S',new ItemStack(Blocks.stone));

      GameRegistry.addRecipe(new ItemStack(cobblestoneChestpiece),
              "S S",
              "SSS",
              "SSS",
              'S',new ItemStack(Blocks.stone));

      GameRegistry.addRecipe(new ItemStack(cobblestoneLeggings),
              "SSS",
              "S S",
              "S S",
              'S',new ItemStack(Blocks.stone));

      GameRegistry.addRecipe(new ItemStack(cobblestoneBoots),
              "S S",
              "S S",
              'S',new ItemStack(Blocks.stone));


      GameRegistry.addRecipe(new ItemStack(portableTeleporter),
              "RDR",
              "DCD",
              "RDR",
              'R',new ItemStack(Blocks.redstone_block),
              'D',new ItemStack(Items.diamond),
              'C',new ItemStack(Items.compass));






      GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald), new ItemStack(Items.diamond), new ItemStack(Items.diamond), new ItemStack(Items.diamond), new ItemStack(Items.blaze_rod));
   }





}//class

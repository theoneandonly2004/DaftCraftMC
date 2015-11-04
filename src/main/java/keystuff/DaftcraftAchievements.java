package keystuff;

import items.Registry.DaftcraftItems;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 18/08/14
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class DaftcraftAchievements
{
   public static Achievement firstCrystal;
   public static Achievement secondCrystal;
   public static Achievement summonHIM;
   public static Achievement egglauncher;

   public static void addAchievements()
   {

      firstCrystal=new Achievement("Achievement first steps","tier 1 ruby",0,0, DaftcraftItems.rubyCrystal,(AchievementList.openInventory));
      secondCrystal=new Achievement("Achievement more power","tier 2 ruby",1,1, DaftcraftItems.rubyCrystalT2,firstCrystal);
      summonHIM=new Achievement("Run for it you fool","he is summoned",4,1, DaftcraftItems.rubyCrystalT2,(Achievement)null).setSpecial();
      egglauncher=new Achievement("well this is daft","egg launcher",4,2, DaftcraftItems.blaster,(Achievement)null).setSpecial();


      AchievementPage.registerAchievementPage(new AchievementPage("daftcraft wall of fame",new Achievement[]{firstCrystal,secondCrystal,summonHIM,egglauncher}));

   }



}//class

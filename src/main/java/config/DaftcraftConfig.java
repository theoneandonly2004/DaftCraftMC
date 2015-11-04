package config;


import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 09/06/14
 * Time: 20:24
 * To change this template use File | Settings | File Templates.
 */
public class DaftcraftConfig
{
   public static Configuration config;
   public static boolean endOnly,randomoniumExplosion,summonorDisabled,portalDisabled,boomPotatoDisabled;
   public static boolean dragonDisabled,witherDisabled,applesDisabled;



   public static void init(File file)
   {
      if(config==null)
      {
       config=new Configuration(file);
      }

      try
      {
      config.load();
      endOnly=config.get(config.CATEGORY_GENERAL,"dragon summon in end only?",true).getBoolean(true);
      randomoniumExplosion=config.get(config.CATEGORY_GENERAL,"can randomonium explode?",true).getBoolean(true);
      summonorDisabled=config.get(config.CATEGORY_GENERAL,"disable summonor block?",false).getBoolean(false);
      portalDisabled=config.get(config.CATEGORY_GENERAL,"disable special end portal?", false).getBoolean(false);
      boomPotatoDisabled=config.get(config.CATEGORY_GENERAL,"disable boom potato?",false).getBoolean(false);
      dragonDisabled=config.get(config.CATEGORY_GENERAL,"disable wither spawn",false).getBoolean(false);
      witherDisabled=config.get(config.CATEGORY_GENERAL,"disable dragon spawn?",false).getBoolean(false);
      //applesDisabled=config.get(config.CATEGORY_GENERAL,"are apples good?",true).getBoolean(true);

      }
      catch(Exception ex)
      {

      }
      finally
      {
         if(config.hasChanged())
         {
            config.save();
         }

      }



   }

   @SubscribeEvent
   public void onConfigChange(ConfigChangedEvent.OnConfigChangedEvent event)
   {

   }

   public void loadConfiguration()
   {

   }

}//class

package client.gui;

import config.DaftcraftConfig;
import keystuff.myMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 06/07/14
 * Time: 03:19
 * To change this template use File | Settings | File Templates.
 */
public class ModGUIConfig extends GuiConfig {

   public ModGUIConfig(GuiScreen screen)
   {
      super(screen,new ConfigElement(DaftcraftConfig.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
              myMod.MODID,
              false,
              true,
              GuiConfig.getAbridgedConfigPath(DaftcraftConfig.config.toString()));
   }

}//class

package client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 06/07/14
 * Time: 03:15
 * To change this template use File | Settings | File Templates.
 */
 public class GUIFactory implements IModGuiFactory {

   @Override
   public void initialize(Minecraft minecraftInstance) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   @Override
   public Class<? extends GuiScreen> mainConfigGuiClass() {
      return ModGUIConfig.class;
   }

   @Override
   public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
      return null;  //To change body of implemented methods use File | Settings | File Templates.
   }

   @Override
   public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
      return null;  //To change body of implemented methods use File | Settings | File Templates.
   }
}//class

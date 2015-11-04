package proxies;

import blocks.DaftcraftBlocks;
import entities.EntityHerobrine;
import items.Registry.DaftcraftItems;
import models.herobrine;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
//import render.RenderVillageWarrior;
import render.renderHerobrine;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 09/06/14
 * Time: 18:19
 * To change this template use File | Settings | File Templates.
 */
public class ClientProxy extends CommonProxy
{
   @Override
   public void registerRenderingThings()
   {
      //RenderingRegistry.registerEntityRenderingHandler(EntityHerobrine.class, new renderHerobrine(new herobrine(), 0));
      // RenderingRegistry.registerEntityRenderingHandler(WarriorVillagerEntity.class,new RenderVillageWarrior(new warriorVillagerModel(),0));
      // RenderingRegistry.registerEntityRenderingHandler(FunEgg.class,new RenderSnowball(Items.egg));
      // RenderingRegistry.registerEntityRenderingHandler(PotatoGrenade.class,new RenderSnowball(Items.potato));
      // RenderingRegistry.registerEntityRenderingHandler(throwableTorch.class,new RenderSnowball(Items.arrow));

      DaftcraftItems.registerRender();
      DaftcraftBlocks.registerBlockRenders();



   }


}//class

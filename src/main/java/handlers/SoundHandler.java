package handlers;

import keystuff.myMod;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 02/06/14
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class SoundHandler
{
   public static void onEntityPlay(String name,World world,Entity entity,float volume ,float pitch){
      world.playSoundAtEntity(entity,(myMod.MODID +":" + name), (float)volume,(float) pitch);


}//class
}

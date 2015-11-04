package entities;


import keystuff.myMod;
import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tileEntities.TileEntityDigger;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 13/06/14
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
public class daftcraftEntities {
   public static void mainRegitry()
   {
      registerEntity();
      registerTileEntities();
   }

   public static void registerTileEntities()
   {
      GameRegistry.registerTileEntity(TileEntityDigger.class, "digger");
   }

   public static void registerEntity()
   {
      createEntity(EntityHerobrine.class,"herobrine",0x52CCDF,0x0008FF,false);
     // createEntity(WarriorVillagerEntity.class,"warrior villager",0x52CCDF,0x0008FF,true);

   }

   public static void createEntity(Class entityClass,String entityName, int solidColor,int spotColor,boolean createEgg)
   {
      int randomID= EntityRegistry.findGlobalUniqueEntityId();

      EntityRegistry.registerGlobalEntityID(entityClass,entityName,randomID);
      EntityRegistry.registerModEntity(entityClass,entityName,randomID, myMod.modInstance,128,1,true);

      if(createEgg)
      {
      createEgg(randomID,solidColor,spotColor);
      }

   }

   private static void createEgg(int randomID,int solidColor,int spotColor)
   {
      EntityList.entityEggs.put(Integer.valueOf(randomID),new EntityList.EntityEggInfo(randomID,solidColor,spotColor));
   }

   {

   }
}//class

package keystuff;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 31/05/14
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
public class daftcraftMaterials
{


      public static Item.ToolMaterial worthlessMaterial= EnumHelper.addToolMaterial("worthless tool material", 0, 100, 0, 0, 0);
      public static Item.ToolMaterial reinforcedGold= EnumHelper.addToolMaterial("reinforced gold",5,2000,8.0f,4.0f,5);

      public static ItemArmor.ArmorMaterial stoneMaterial=EnumHelper.addArmorMaterial("stone",null,40,new int[]{2,3,2,2},5);
      public static ItemArmor.ArmorMaterial mightyGold=EnumHelper.addArmorMaterial("mighty gold",null,10000,new int[]{4,9,7,4},30);






}//class

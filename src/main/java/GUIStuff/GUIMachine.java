package GUIStuff;


import keystuff.myMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import tileEntities.TileEntityDigger;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 23/10/14
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
@SideOnly(Side.CLIENT)
public class GUIMachine extends GuiContainer
{

   public GUIMachine(InventoryPlayer inventoryPlayer, TileEntityDigger digger)
   {
      super(new DiggerContainer(inventoryPlayer,digger));
      xSize=256;
      ySize=256;
   }

   //private static final ResourceLocation texture=new ResourceLocation(myMod.MODID, "textures/gui/machine.png");
   private static final ResourceLocation texture=new ResourceLocation("textures/gui/container/hopper.png");

   @Override
   protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int x, int y)
   {
      GL11.glColor4f(1,1,1,1);
      Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
      drawTexturedModalRect(guiLeft,guiTop,0,0,xSize,ySize);

   }

   @Override
   protected void drawGuiContainerForegroundLayer(int x, int y)
   {
      fontRendererObj.drawString("dug loot",8,6,0x40404040);
   }


  /* @Override
   public void initGui()
   {
      super.initGui();
      buttonList.clear();

      buttonList.add(new GuiButton(0,guiLeft+100,guiTop+14,60,20,"disable"));
   }    */

 /*  @Override
   protected void actionPerformed(GuiButton button)
   {
      if(button.id ==0)
      {
         System.out.println("you pushed the button push pushed the button");
      }
   }    */
}//class

package render;



import entities.EntityHerobrine;
import keystuff.myMod;
import models.herobrine;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class renderHerobrine extends RenderLiving
{
   private static final ResourceLocation mobTextures = new ResourceLocation(myMod.MODID +":textures/entity/herobrine.png");
   private static final String __OBFID = "CL_00000984";


   public renderHerobrine(RenderManager p_i46153_1_, ModelBase p_i46153_2_, float p_i46153_3_) {
      super(p_i46153_1_, p_i46153_2_, p_i46153_3_);
   }



   /**
    * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
    */
   protected ResourceLocation getEntityTexture(EntityHerobrine herobrine)
   {
      return mobTextures;
   }

   /**
    * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
    */
   protected ResourceLocation getEntityTexture(Entity herobrine)
   {
      return this.getEntityTexture((EntityHerobrine)herobrine);
   }
}
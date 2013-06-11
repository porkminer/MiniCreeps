package miniCreep;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBoomer extends ModelBase {

    
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer leg1;
    ModelRenderer leg2;
  
  public ModelBoomer()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 3, 3, 3);
      head.setRotationPoint(0F, 20F, 1F);
      head.setTextureSize(256, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 3, 6, 1);
      body.setRotationPoint(0F, 15F, 0F);
      body.setTextureSize(256, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 0F, -2F, 2, 3, 2);
      leg3.setRotationPoint(-3F, 21F, -2F);
      leg3.setTextureSize(256, 128);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 2, 3, 2);
      leg4.setRotationPoint(0F, 21F, -2F);
      leg4.setTextureSize(256, 128);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(0F, 0F, -2F, 2, 3, 2);
      leg1.setRotationPoint(-5F, 21F, 1F);
      leg1.setTextureSize(256, 128);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 2, 3, 2);
      leg2.setRotationPoint(0F, 21F, 1F);
      leg2.setTextureSize(256, 128);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    leg1.render(f5);
    leg2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par1Entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, par1Entity);
  }

}

package miniCreep;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDwarf extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer leg5;
    ModelRenderer leg6;
  
  public ModelDwarf()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -8F, 8, 8, 8);
      head.setRotationPoint(0F, 12F, -6F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 0, 26);
      body.addBox(-5F, -10F, -7F, 12, 24, 8);
      body.setRotationPoint(-1F, 11F, 3F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg1.setRotationPoint(-4F, 18F, 15F);
      leg1.setTextureSize(64, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg2.setRotationPoint(4F, 18F, 15F);
      leg2.setTextureSize(64, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg3.setRotationPoint(-4F, 18F, -5F);
      leg3.setTextureSize(64, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg4.setRotationPoint(4F, 18F, -5F);
      leg4.setTextureSize(64, 64);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      leg5 = new ModelRenderer(this, 0, 16);
      leg5.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg5.setRotationPoint(-4F, 18F, 5F);
      leg5.setTextureSize(64, 64);
      leg5.mirror = true;
      setRotation(leg5, 0F, 0F, 0F);
      leg6 = new ModelRenderer(this, 0, 16);
      leg6.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg6.setRotationPoint(4F, 18F, 5F);
      leg6.setTextureSize(64, 64);
      leg6.mirror = true;
      setRotation(leg6, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    leg5.render(f5);
    leg6.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.body.rotateAngleX = ((float)Math.PI / 2F);
    this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.leg5.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.leg6.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
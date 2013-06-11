package miniCreep;

import miniCreep.EntityBoomer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySpawnThing extends EntityThrowable {

    public EntitySpawnThing(World par1World, EntityLiving par2EntityLiving) {
        super(par1World, par2EntityLiving);
        // TODO Auto-generated constructor stub
        
    }
    
    
    
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
        }

        if (!this.worldObj.isRemote)
        {
            
                EntityBoomer boomer = new EntityBoomer(this.worldObj);
                /*
                
                boomer.initCreature();
                par3World.spawnEntityInWorld(boomer);
                */
                
                
                ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Spawning Item");
                //EntityLiving entityliving = (EntityLiving)boomer;
                boomer.setLocationAndAngles(this.posX, this.posY + 1, this.posZ, this.rotationYaw, 0.0F);
                //entityliving.rotationYawHead = entityliving.rotationYaw;
                //entityliving.renderYawOffset = entityliving.rotationYaw;
                //entityliving.initCreature();
                this.worldObj.spawnEntityInWorld(boomer);
                //entityliving.playLivingSound();
            
        }

        if (!this.worldObj.isRemote){
            this.setDead();
        }
        
    }
    
    
    
    
    
    
}

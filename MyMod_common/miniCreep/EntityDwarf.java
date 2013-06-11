package miniCreep;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.*;

public class EntityDwarf extends EntityAnimal {

    public EntityDwarf(World par1World) {
        super(par1World);
        this.getNavigator().setAvoidsWater(true);
        
        this.setSize(1.5F, 0.9F);
        this.isImmuneToFire = false;
        float var2 = 0.25F;
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1,  new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(2, new EntityAIMate(this, var2));
        this.tasks.addTask(3,  new EntityAIFollowParent(this, 0.28F));
        this.tasks.addTask(4,  new EntityAIWander(this, var2));
        this.tasks.addTask(5,  new EntityAIWatchClosest(this, EntityPlayer.class,6.0F));
        this.tasks.addTask(7,  new EntityAILookIdle(this));
        
    }

    public boolean isAIEnabled() {
        return true;
    }
    
    protected String getLivingSound() {
        return "mob.pig.say";
    }
    
    
    protected String getHurtSound() {
        return "mob.pig.say";
    }
    
    protected String getDeathSound() {
        return "mob.pig.death";
    }
    
    @Override
    public EntityAgeable createChild(EntityAgeable entityageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getMaxHealth() {
        // TODO Auto-generated method stub
        return 10;
    }

    
    
}

package miniCreep;

import java.util.Random;

import miniCreep.EntityMiniBoomer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBoomer extends EntityCreeper {

    World thisWorld;
    
    private int lastActiveTime;

    /**
     * The amount of time since the creeper was close enough to the player to ignite
     */
    private int timeSinceIgnited;
    private int fuseTime = 30;

    /** Explosion radius for this creeper. */
    private int explosionRadius = 3;
    
    
    public EntityBoomer(World par1World) {
        super(par1World);
        // TODO Auto-generated constructor stub
        this.experienceValue = 30;
        this.thisWorld = par1World;
    }



    public int getMaxHealth ()
    {
        return 1;
    }
    
    protected Entity findPlayerToAttack () {
        double d0 = 24.0D;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
        
    }

    public void onUpdate() {
        
        if (this.isEntityAlive())
        {
            this.lastActiveTime = this.timeSinceIgnited;
            int i = this.getCreeperState();

            if (i > 0 && this.timeSinceIgnited == 0)
            {
                this.playSound("random.fuse", 1.0F, 0.5F);
            }

            this.timeSinceIgnited += i;

            if (this.timeSinceIgnited < 0)
            {
                this.timeSinceIgnited = 0;
            }

            if (this.timeSinceIgnited >= this.fuseTime)
            {
                this.timeSinceIgnited = this.fuseTime;

                if (!this.worldObj.isRemote)
                {
                    boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

                    if (this.getPowered())
                    {
                        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(this.explosionRadius * 2), flag);
                        
                        this.spawnMiniBoomer(this.posX, this.posY, this.posZ);   
                        
                    }
                    else
                    {
                        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, flag);
                        this.spawnMiniBoomer(this.posX, this.posY, this.posZ);
                    }

                    this.setDead();
                }
            }
        }
        super.onUpdate();
    }
    
    private void spawnMiniBoomer(double posX, double posY, double posZ) {
        // TODO Auto-generated method stub
        EntityMiniBoomer miniboomers;
        Random randN = new Random();
        int n = randN.nextInt(10);
        for (int i = 0; i < n; i++) {
        miniboomers = new EntityMiniBoomer(this.worldObj);
        miniboomers.setLocationAndAngles(posX, posY, posZ, this.rotationYaw, 0.0F);
        miniboomers.initCreature();
        this.thisWorld.spawnEntityInWorld(miniboomers);
        miniboomers = null;
        }
        
    }



    public void onDeath(DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
        
    }








}
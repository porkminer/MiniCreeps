package miniCreep;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMiniBoomer extends EntityCreeper{
    
    /**
     * Time when this creeper was last in an active state (Messed up code here, probably causes creeper animation to go
     * weird)
     */
    private int lastActiveTime;

    /**
     * The amount of time since the creeper was close enough to the player to ignite
     */
    private int timeSinceIgnited;
    private int fuseTime = 30;
    protected String texture = "/myMod_Mod/resources/Model.png";
    /** Explosion radius for this creeper. */
    private int explosionRadius = 1;

    public EntityMiniBoomer(World par1World) {
        super(par1World);
        // TODO Auto-generated constructor stub
        
    }

    
    
    public void onUpdate()
    {
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
                    }
                    else
                    {
                        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, flag);
                    }

                    this.setDead();
                }
            }
        }

        super.onUpdate();
    }
    
    
    
    public int getMaxHealth ()
    {
        return 1;
    }
    
    protected Entity findPlayerToAttack () {
        double d0 = 24.0D;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
        
    }

    public void onDeath(DamageSource par1DamageSource) {
        //super.onDeath(par1DamageSource);
        
    }


}

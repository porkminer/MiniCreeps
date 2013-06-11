package miniCreep.Items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import miniCreep.EntityBoomer;
import miniCreep.EntitySpawnThing;
public class SpawnThing extends Item {

    public SpawnThing(int par1) {
        super(par1);
        // TODO Auto-generated constructor stub
        setMaxStackSize(16);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("spawnItem");
        
        
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
       
        if (!par2World.isRemote) {
       par2World.spawnEntityInWorld(new EntitySpawnThing(par2World, par3EntityPlayer));
       par2World.spawnEntityInWorld(new EntityEgg(par2World, par3EntityPlayer));
        
        
        
        
        
        
        
        
        }
        return par1ItemStack;   
    }
    
   // public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
   // {
   //            return true;
   //     
   //  }

}

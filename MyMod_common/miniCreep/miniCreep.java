package miniCreep;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.BiomeGenBase;
import miniCreep.CommonProxy.CommonProxy;
import miniCreep.Items.SpawnThing;
import miniCreep.client.ClientProxy;
import miniCreep.lib.Reference;
import miniCreep.EntityBoomer;
import miniCreep.EntityDwarf;
import miniCreep.EntityMiniBoomer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid = Reference.MOD_ID, name= Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class miniCreep {
    
    private final static Item spawnThing = new SpawnThing(5000);
    
    @Instance("miniCreep")
    public static miniCreep instance;
    @SidedProxy(clientSide="miniCreep.client.ClientProxy", serverSide="miniCreep.CommonProxy.CommonProxy")
    public static CommonProxy proxy;
    public static ClientProxy clientProxy = new ClientProxy();
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        
    }
    
    @Init
    public void init(FMLInitializationEvent event) {
        proxy.registerRenderers();
        EntityRegistry.registerModEntity(EntityDwarf.class,  "BigDwarf", 2,  this,  80,  3,  true);
        EntityRegistry.addSpawn(EntityDwarf.class,  5,  2,  6,  EnumCreatureType.creature,  BiomeGenBase.plains);
        EntityRegistry.registerModEntity(EntityBoomer.class, "Boomer", 0,  this,  64,  5,  true);
        EntityRegistry.registerModEntity(EntityMiniBoomer.class, "MiniBoomer", 1, this, 64, 5, true);
        EntityRegistry.addSpawn(EntityBoomer.class,  8, 4, 6, EnumCreatureType.monster, BiomeGenBase.hell, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.desertHills);
        LanguageRegistry.addName(spawnThing, "Spawn Item");
        GameRegistry.addShapelessRecipe(new ItemStack(spawnThing,1), new ItemStack(Block.dirt), new ItemStack(Block.dirt));
       // RenderingRegistry.registerEntityRenderingHandler(EntityDwarf.class, new RenderDwarf(new ModelDwarf(), 0.5F));
       // RenderingRegistry.registerEntityRenderingHandler(EntityBoomer.class, new RenderBoomer());
        clientProxy.registerRenderers();
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
     
        
        
    }

}

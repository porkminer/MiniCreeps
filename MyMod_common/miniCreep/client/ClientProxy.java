package miniCreep.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.model.ModelCreeper;
import net.minecraftforge.client.MinecraftForgeClient;
import miniCreep.*;
import miniCreep.CommonProxy.*;
import miniCreep.EntityBoomer;
import miniCreep.EntityDwarf;
import miniCreep.EntityMiniBoomer;
import miniCreep.ModelDwarf;
import miniCreep.RenderBoomer;
import miniCreep.RenderDwarf;
import miniCreep.CommonProxy.CommonProxy;

public class ClientProxy extends CommonProxy {
        
    public ClientProxy() {
        
    }
    @Override
    public void registerRenderers() {
        //this.registerRenderInformation();
        RenderingRegistry.registerEntityRenderingHandler(EntityDwarf.class, new RenderDwarf(new ModelDwarf(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMiniBoomer.class, new RenderBoomer());
        EntityRegistry.registerGlobalEntityID(EntityDwarf.class,  "BigDwarf",  EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
        EntityRegistry.registerGlobalEntityID(EntityBoomer.class, "Boomer", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
        EntityRegistry.registerGlobalEntityID(EntityBoomer.class, "MiniBoomer", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
    }
    
    public void registerRenderInformation() {
        
    }
}

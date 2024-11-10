package com.cosmo.sporenmore.server.entity.event;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.entity.EntityCrunch;
import com.cosmo.sporenmore.server.entity.entity.EntityDevourer;
import com.cosmo.sporenmore.server.entity.entity.SNMEntityHandler;
import com.cosmo.sporenmore.server.entity.entity.runts.EntityMaceRunt;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SporeNMore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SNMEntityHandler.CRUNCH.get(), EntityCrunch.createAttributes().build());
        event.put(SNMEntityHandler.CLAWFOX.get(), EntityCrunch.createAttributes().build());
        event.put(SNMEntityHandler.THE_DEVOURER.get(), EntityDevourer.createAttributes().build());
        event.put(SNMEntityHandler.MACE_RUNT.get(), EntityMaceRunt.createAttributes().build());
    }
}
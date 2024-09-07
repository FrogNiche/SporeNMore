package com.cosmo.sporenmore.server.entity.event;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.entity.EntityCrunch;
import com.cosmo.sporenmore.server.entity.entity.EntityTheDevourer;
import com.cosmo.sporenmore.server.entity.entity.SNMEntityHandler;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SporeNMore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SNMEntityHandler.CRUNCH.get(), EntityCrunch.createAttributes().build());
        event.put(SNMEntityHandler.CLAWFOX.get(), EntityCrunch.createAttributes().build());
        event.put(SNMEntityHandler.THE_DEVOURER.get(), EntityTheDevourer.createAttributes().build());
    }
}
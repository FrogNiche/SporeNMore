package com.cosmo.sporenmore.server.entity.event;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.SNMEntityHandler;
import com.cosmo.sporenmore.server.entity.crunch_team.CrunchEntity;
import com.cosmo.sporenmore.server.entity.crunch_team.EntityClawFox;
import com.cosmo.sporenmore.server.entity.crunch_team.EntityJetpackFox;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SporeNMore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SNMEntityHandler.CRUNCH.get(), CrunchEntity.createAttributes().build());
        event.put(SNMEntityHandler.JETPACK_FOX.get(), EntityJetpackFox.createAttributes().build());
      //  event.put(SNMEntityHandler.CLAW_FOX.get(), EntityClawFox.createAttributes().build());
    }
}
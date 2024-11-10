package com.cosmo.sporenmore.server.entity.event;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SporeNMore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CRUNCH_LAYER, CrunchModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CLAWFOX_LAYER, ClawFoxModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DEVOURER_LAYER, DevourerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MACE_RUNT_LAYER, MaceRuntModel::createBodyLayer);
    }
}
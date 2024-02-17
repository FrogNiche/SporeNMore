package com.cosmo.sporenmore.server.entity.event;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.client.CrunchModel;
import com.cosmo.sporenmore.server.entity.client.JetpackFoxModel;
import com.cosmo.sporenmore.server.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SporeNMore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CRUNCH_LAYER, CrunchModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.JF_LAYER, JetpackFoxModel::createBodyLayer);
    }
}
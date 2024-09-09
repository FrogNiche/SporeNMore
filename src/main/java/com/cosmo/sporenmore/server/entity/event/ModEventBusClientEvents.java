package com.cosmo.sporenmore.server.entity.event;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.ClawFoxModel;
import com.cosmo.sporenmore.client.models.entity.model.CrunchModel;
import com.cosmo.sporenmore.client.models.entity.model.DevourerModel;
import com.cosmo.sporenmore.client.models.entity.model.ModModelLayers;
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
        event.registerLayerDefinition(ModModelLayers.THE_DEVOURER_LAYER, DevourerModel::createBodyLayer);
    }
}
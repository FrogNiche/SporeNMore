package com.cosmo.sporenmore.server.entity.client;

import com.cosmo.sporenmore.SporeNMore;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation CRUNCH_LAYER = new ModelLayerLocation(
            new ResourceLocation(SporeNMore.MOD_ID, "crunch_layer"), "main");
    public static final ModelLayerLocation CLAWFOX_LAYER = new ModelLayerLocation(
            new ResourceLocation(SporeNMore.MOD_ID, "clawfox_layer"), "main");

    public static final ModelLayerLocation JETPACK_FOX_LAYER = new ModelLayerLocation(
            new ResourceLocation(SporeNMore.MOD_ID, "jetpack_fox_layer"), "main");

}
package com.cosmo.sporenmore.client.models.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.entity.EntityTallFox;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelTallFox extends GeoModel<EntityTallFox> {
    @Override
    public ResourceLocation getModelResource(EntityTallFox object) {
        return SporeNMore.modLoc("geo/entity/tall_fox.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityTallFox object) {
        return SporeNMore.modLoc("textures/entity/tex_tall_fox.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityTallFox animatable) {
        return SporeNMore.modLoc("animations/entity/tall_fox.animation.json");
    }
}

package com.cosmo.sporenmore.client.models.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.entity.EntityFatFox;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelFatFox extends GeoModel<EntityFatFox> {
    @Override
    public ResourceLocation getModelResource(EntityFatFox object) {
        return SporeNMore.modLoc("geo/entity/fat_fox.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFatFox object) {
        return SporeNMore.modLoc("textures/entity/tex_fat_fox.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFatFox animatable) {
        return SporeNMore.modLoc("animations/entity/fat_fox.animation.json");
    }
}

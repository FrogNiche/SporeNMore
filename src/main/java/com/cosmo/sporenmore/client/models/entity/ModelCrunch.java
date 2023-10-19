package com.cosmo.sporenmore.client.models.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.the_crunch.EntityCrunch;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelCrunch extends GeoModel<EntityCrunch> {
    @Override
    public ResourceLocation getModelResource(EntityCrunch object) {
        return SporeNMore.modLoc("geo/entity/entity_the_crunch.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityCrunch object) {
        return SporeNMore.modLoc("textures/entity/tex_crunch.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityCrunch animatable) {
        return SporeNMore.modLoc("animations/entity/entity_the_crunch.animation.json");
    }
}

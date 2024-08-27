package com.cosmo.sporenmore.client.models.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.entity.EntityLeGiant;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelGiant extends GeoModel<EntityLeGiant> {
    @Override
    public ResourceLocation getModelResource(EntityLeGiant object) {
        return SporeNMore.modLoc("geo/entity/entity_le_giant.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityLeGiant object) {
        return SporeNMore.modLoc("textures/entity/tex_giant.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityLeGiant animatable) {
        return SporeNMore.modLoc("animations/entity/entity_le_giant.animation.json");
    }
}

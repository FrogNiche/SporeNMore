package com.cosmo.sporenmore.client.models.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.spore_mobs.EntityBuldgingSporeFox;
import com.cosmo.sporenmore.server.entity.spore_mobs.EntityPoostle;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelPoostle extends GeoModel<EntityPoostle> {
    @Override
    public ResourceLocation getModelResource(EntityPoostle object) {
        return SporeNMore.modLoc("geo/entity/entity_poostle.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPoostle object) {
        return SporeNMore.modLoc("textures/entity/tex_poostle.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPoostle animatable) {
        return SporeNMore.modLoc("animations/entity/entity_poostle.animation.json");
    }
}

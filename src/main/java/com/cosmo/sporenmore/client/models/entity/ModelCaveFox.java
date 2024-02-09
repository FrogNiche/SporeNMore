package com.cosmo.sporenmore.client.models.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.nomal_foxes.EntityCaveFox;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelCaveFox extends GeoModel<EntityCaveFox> {
    @Override
    public ResourceLocation getModelResource(EntityCaveFox object) {
        return SporeNMore.modLoc("geo/entity/entity_cave_fox.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityCaveFox object) {
        return SporeNMore.modLoc("textures/entity/tex_cave_fox.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityCaveFox animatable) {
        return SporeNMore.modLoc("animations/entity/entity_cave_fox.animation.json");
    }
}

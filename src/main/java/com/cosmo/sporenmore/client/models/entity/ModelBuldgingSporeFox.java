package com.cosmo.sporenmore.client.models.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.spore_mobs.EntityBuldgingSporeFox;
import com.cosmo.sporenmore.server.entity.the_crunch.EntityCrunch;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelBuldgingSporeFox extends GeoModel<EntityBuldgingSporeFox> {
    @Override
    public ResourceLocation getModelResource(EntityBuldgingSporeFox object) {
        return SporeNMore.modLoc("geo/entity/entity_buldging_spore_fox.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityBuldgingSporeFox object) {
        return SporeNMore.modLoc("textures/entity/tex_buldging_spore_fox.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityBuldgingSporeFox animatable) {
        return SporeNMore.modLoc("animations/entity/entity_buldging_spore_fox.animation.json");
    }
}

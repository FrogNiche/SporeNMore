package com.cosmo.sporenmore.server.entity.spore_mobs.devourer;


import com.cosmo.sporenmore.SporeNMore;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DevourerModel extends GeoModel<EntityDevourer> {


    @Override
    public ResourceLocation getModelResource(EntityDevourer object) {
        return SporeNMore.modLoc("geo/entity/devourer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityDevourer object) {
        return SporeNMore.modLoc("textures/entity/devourer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityDevourer animatable) {
        return SporeNMore.modLoc("animations/entity/devourer.animation.json");
    }
}

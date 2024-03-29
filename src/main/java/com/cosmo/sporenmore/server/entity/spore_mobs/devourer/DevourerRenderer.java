package com.cosmo.sporenmore.server.entity.spore_mobs.devourer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DevourerRenderer extends GeoEntityRenderer<EntityDevourer> {
    public DevourerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DevourerModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));

    }

    @Override
    protected float getDeathMaxRotation(EntityDevourer entityLivingBaseIn) {
        return 0f;
    }
}

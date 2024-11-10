package com.cosmo.sporenmore.server.renderer.entity.layer;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.CrunchModel;
import com.cosmo.sporenmore.client.models.entity.model.DevourerModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrunchGlowLayer<T extends Entity, M extends CrunchModel<T>> extends EyesLayer<T, M> {
    private static final RenderType CRUNCH_GLOW =
            RenderType.entityShadow(new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/crunch_glow.png"));

    public CrunchGlowLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return CRUNCH_GLOW;
    }
}
package com.cosmo.sporenmore.server.renderer.entity.layers;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.TheDevourerModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DevourerGlowLayer<T extends Entity, M extends TheDevourerModel<T>> extends EyesLayer<T, M> {
    private static final RenderType DEVOURER_GLOW = RenderType.armorCutoutNoCull(new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/devourer_glow.png"));

    public DevourerGlowLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return DEVOURER_GLOW;
    }
}

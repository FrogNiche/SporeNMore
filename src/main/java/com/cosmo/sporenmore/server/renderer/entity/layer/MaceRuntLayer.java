package com.cosmo.sporenmore.server.renderer.entity.layer;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.DevourerModel;
import com.cosmo.sporenmore.client.models.entity.model.MaceRuntModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MaceRuntLayer<T extends Entity, M extends MaceRuntModel<T>> extends EyesLayer<T, M> {
    private static final RenderType MACE_RUNT_GLOW =
            RenderType.entityShadow(new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/mace_runt_glow.png"));

    public MaceRuntLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return MACE_RUNT_GLOW;
    }
}
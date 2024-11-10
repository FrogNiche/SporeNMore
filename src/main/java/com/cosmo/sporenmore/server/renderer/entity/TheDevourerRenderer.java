package com.cosmo.sporenmore.server.renderer.entity;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.DevourerModel;
import com.cosmo.sporenmore.client.models.entity.model.ModModelLayers;
import com.cosmo.sporenmore.server.entity.entity.EntityDevourer;
import com.cosmo.sporenmore.server.renderer.entity.layer.DevourerGlowLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.resources.ResourceLocation;


public class TheDevourerRenderer extends MobRenderer<EntityDevourer, DevourerModel<EntityDevourer>> {
    public TheDevourerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DevourerModel<>(pContext.bakeLayer(ModModelLayers.DEVOURER_LAYER)), 2f);
    }

    @Override
        public ResourceLocation getTextureLocation(EntityDevourer pEntity) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_devourer.png");
    }

    @Override
    public void render(EntityDevourer pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.addLayer(new DevourerGlowLayer<>(this));
    }

}
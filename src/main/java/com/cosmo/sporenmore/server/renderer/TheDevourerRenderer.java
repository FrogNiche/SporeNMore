package com.cosmo.sporenmore.server.renderer;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.TheDevourerModel;
import com.cosmo.sporenmore.client.models.entity.model.ModModelLayers;
import com.cosmo.sporenmore.server.entity.entity.EntityTheDevourer;
import com.cosmo.sporenmore.server.renderer.entity.layers.DevourerGlowLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.resources.ResourceLocation;


public class TheDevourerRenderer extends MobRenderer<EntityTheDevourer, TheDevourerModel<EntityTheDevourer>> {
    public TheDevourerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TheDevourerModel<>(pContext.bakeLayer(ModModelLayers.THE_DEVOURER_LAYER)), 2f);
    }

    @Override
        public ResourceLocation getTextureLocation(EntityTheDevourer pEntity) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_devourer.png");
    }

    @Override
    public void render(EntityTheDevourer pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.addLayer(new DevourerGlowLayer<>(this));
    }

}
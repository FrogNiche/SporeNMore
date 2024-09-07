package com.cosmo.sporenmore.server.renderer;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.ClawFoxModel;
import com.cosmo.sporenmore.client.models.entity.model.ModModelLayers;
import com.cosmo.sporenmore.server.entity.entity.EntityClawFox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class ClawFoxRenderer extends MobRenderer<EntityClawFox, ClawFoxModel<EntityClawFox>> {
    public ClawFoxRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ClawFoxModel<>(pContext.bakeLayer(ModModelLayers.CLAWFOX_LAYER)), 2f);
    }

    @Override
        public ResourceLocation getTextureLocation(EntityClawFox pEntity) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_clawfox.png");
    }

    @Override
    public void render(EntityClawFox pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
package com.cosmo.sporenmore.server.entity.client;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.examples.CrunchEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cosmo.sporenmore.server.entity.examples.CrunchEntity.Type.SNOW_CRUNCH;
import static com.cosmo.sporenmore.server.entity.examples.CrunchEntity.Type.SPORE_CRUNCH;

public class CrunchRenderer extends MobRenderer<CrunchEntity, CrunchModel<CrunchEntity>> {
    public CrunchRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrunchModel<>(pContext.bakeLayer(ModModelLayers.CRUNCH_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(CrunchEntity pEntity) {
        String s = ChatFormatting.stripFormatting(pEntity.getName().getString());
        if ("Spore".equals(s)) {
            return SPORE_CRUNCH.getTexture();
        }
        return pEntity.getTextureType().getTexture();
    }

    @Override
    public void render(CrunchEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
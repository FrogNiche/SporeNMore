package com.cosmo.sporenmore.server.entity.client;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.crunch_team.CrunchEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class CrunchRenderer extends MobRenderer<CrunchEntity, CrunchModel<CrunchEntity>> {
    public CrunchRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrunchModel<>(pContext.bakeLayer(ModModelLayers.CRUNCH_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(CrunchEntity pEntity) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_crunch.png");
    }

    @Override
    public void render(CrunchEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
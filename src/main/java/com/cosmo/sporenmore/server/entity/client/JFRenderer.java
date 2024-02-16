package com.cosmo.sporenmore.server.entity.client;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.crunch_team.CrunchEntity;
import com.cosmo.sporenmore.server.entity.crunch_team.EntityJetpackFox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cosmo.sporenmore.server.entity.crunch_team.CrunchEntity.Type.SPORE_CRUNCH;

public class JFRenderer extends MobRenderer<EntityJetpackFox, JFModel<EntityJetpackFox>> {
    public JFRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JFModel<>(pContext.bakeLayer(ModModelLayers.JF_LAYER)), 2f);
    }


    @Override
    public void render(EntityJetpackFox pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityJetpackFox p_114482_) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_jetpack_fox.png");
    }

}
package com.cosmo.sporenmore.server.entity.client;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.crunch_team.CrunchEntity;
import com.cosmo.sporenmore.server.entity.crunch_team.EntityClawFox;
import com.cosmo.sporenmore.server.entity.crunch_team.EntityJetpackFox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cosmo.sporenmore.server.entity.crunch_team.CrunchEntity.Type.SPORE_CRUNCH;

public class ClawFoxRenderer extends MobRenderer<EntityClawFox, ClawFoxModel<EntityClawFox>> {
    public ClawFoxRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ClawFoxModel<>(pContext.bakeLayer(ModModelLayers.CLAWFOX_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityClawFox p_114482_) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_claw_fox.png");
    }


    @Override
    public void render(EntityClawFox pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
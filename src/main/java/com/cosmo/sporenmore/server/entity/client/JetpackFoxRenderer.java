package com.cosmo.sporenmore.server.entity.client;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.crunch_team.EntityJetpackFox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JetpackFoxRenderer extends MobRenderer<EntityJetpackFox, JetpackFoxModel<EntityJetpackFox>> {
    public JetpackFoxRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JetpackFoxModel<>(pContext.bakeLayer(ModModelLayers.JETPACK_FOX_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityJetpackFox p_114482_) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_jetpack_fox.png");
    }
    @Override
    public void render(EntityJetpackFox pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
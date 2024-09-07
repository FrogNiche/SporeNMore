package com.cosmo.sporenmore.server.renderer;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.CrunchModel;
import com.cosmo.sporenmore.client.models.entity.model.ModModelLayers;
import com.cosmo.sporenmore.server.entity.entity.EntityCrunch;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class CrunchRenderer extends MobRenderer<EntityCrunch, CrunchModel<EntityCrunch>> {
    public CrunchRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrunchModel<>(pContext.bakeLayer(ModModelLayers.CRUNCH_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityCrunch pEntity) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_crunch.png");
    }

    @Override
    public void render(EntityCrunch pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
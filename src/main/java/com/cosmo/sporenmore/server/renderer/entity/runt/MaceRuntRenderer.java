package com.cosmo.sporenmore.server.renderer.entity.runt;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.models.entity.model.CrunchModel;
import com.cosmo.sporenmore.client.models.entity.model.MaceRuntModel;
import com.cosmo.sporenmore.client.models.entity.model.ModModelLayers;
import com.cosmo.sporenmore.server.entity.entity.EntityCrunch;
import com.cosmo.sporenmore.server.entity.entity.runts.EntityMaceRunt;
import com.cosmo.sporenmore.server.renderer.entity.layer.DevourerGlowLayer;
import com.cosmo.sporenmore.server.renderer.entity.layer.MaceRuntLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class MaceRuntRenderer extends MobRenderer<EntityMaceRunt, MaceRuntModel<EntityMaceRunt>> {
    public MaceRuntRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MaceRuntModel<>(pContext.bakeLayer(ModModelLayers.MACE_RUNT_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMaceRunt pEntity) {
        return new ResourceLocation(SporeNMore.MOD_ID, "textures/entity/tex_mace_runt.png");
    }

    @Override
    public void render(EntityMaceRunt pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.addLayer(new MaceRuntLayer<>(this));
    }

}
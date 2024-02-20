package com.cosmo.sporenmore.server.entity.client;

import com.cosmo.sporenmore.server.entity.animations.CrunchAnimations;
import com.cosmo.sporenmore.server.entity.crunch_team.CrunchEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class CrunchModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("sporenmore", "crunchmodel"), "main");
	private final ModelPart EntityCrunch;
	private final ModelPart Head;

	public CrunchModel(ModelPart root) {
		this.EntityCrunch = root.getChild("EntityCrunch");
		this.Head = EntityCrunch.getChild("Body").getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition EntityCrunch = partdefinition.addOrReplaceChild("EntityCrunch", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LeftLeg = EntityCrunch.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(112, 77).addBox(-8.5F, 0.0F, -8.0F, 17.0F, 14.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, -14.0F, 0.0F));

		PartDefinition RightLeg = EntityCrunch.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(96, 109).addBox(-8.5F, 0.0F, -8.0F, 17.0F, 14.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.5F, -14.0F, 0.0F));

		PartDefinition Body = EntityCrunch.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -14.25F, -0.5F));

		PartDefinition Body2 = Body.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 77).addBox(-18.0F, -21.75F, -4.5F, 36.0F, 28.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(92, 77).addBox(-6.0F, -0.75F, -6.5F, 12.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -5.0F));

		PartDefinition Skirt = Body2.addOrReplaceChild("Skirt", CubeListBuilder.create().texOffs(0, 124).addBox(-18.0F, 0.0F, 0.0F, 36.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.25F, -4.5F));

		PartDefinition Skirt2 = Body2.addOrReplaceChild("Skirt2", CubeListBuilder.create().texOffs(0, 125).addBox(-18.0F, 0.0F, 0.0F, 36.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.25F, 15.5F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-28.875F, -43.0F, -17.75F, 56.0F, 41.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offset(0.875F, -25.75F, 0.25F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(0, 23).addBox(-5.75F, -3.0F, -6.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.875F, -23.5F, -17.75F));

		PartDefinition Ear = Head.addOrReplaceChild("Ear", CubeListBuilder.create().texOffs(0, 77).mirror().addBox(-1.5F, -4.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 77).addBox(-17.5F, -4.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.875F, -43.0F, -3.75F));

		PartDefinition ClosedEyes = Head.addOrReplaceChild("ClosedEyes", CubeListBuilder.create().texOffs(144, 148).addBox(-28.875F, -26.0F, -17.75F, 56.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.95F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 133).addBox(0.0F, -4.0F, -3.0F, 5.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, -21.75F, 0.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(72, 125).addBox(-5.5F, -5.0F, -3.0F, 5.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-17.5F, -20.75F, 0.5F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -0.0317F, -8.451F, 9.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -7.0F, 9.5F, 1.309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(CrunchAnimations.CRUNCH_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((CrunchEntity) entity).idleAnimationState, CrunchAnimations.CRUNCH_IDLE, ageInTicks, 1f);
		this.animate(((CrunchEntity) entity).TummyScratchingAnimationState, CrunchAnimations.CRUNCH_EAR_SCRATCHING, ageInTicks, 1f);
		this.animate(((CrunchEntity) entity).attackAnimationState, CrunchAnimations.CRUNCH_STOMP, ageInTicks, 1f);
		this.animate(((CrunchEntity) entity).deathAnimationState, CrunchAnimations.CRUNCH_DEATH, ageInTicks, 1f);
	}



	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -10.0F, 20.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -15.0F, 35.0F);

		this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 120F);
		this.Head.xRot = pHeadPitch * ((float)Math.PI / 120F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		EntityCrunch.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return EntityCrunch;
	}

}
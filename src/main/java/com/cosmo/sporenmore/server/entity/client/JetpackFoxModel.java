package com.cosmo.sporenmore.server.entity.client;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.cosmo.sporenmore.server.entity.animations.JFAnimations;
import com.cosmo.sporenmore.server.entity.crunch_team.EntityJetpackFox;
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
public class JetpackFoxModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("sporenmore", "jetpackfoxmodel"), "main");
	private final ModelPart JetpackFox;
	private final ModelPart Head;
	public JetpackFoxModel(ModelPart root) {
		this.JetpackFox = root.getChild("JetpackFox");
		this.Head = JetpackFox.getChild("Body").getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition JetpackFox = partdefinition.addOrReplaceChild("JetpackFox", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 3.0F));

		PartDefinition LeftLeg = JetpackFox.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(40, 40).addBox(-2.5F, 0.0F, -2.5F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -7.0F, -2.5F));

		PartDefinition RightLeg = JetpackFox.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(24, 40).addBox(-1.5F, 0.0F, -2.5F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -7.0F, -2.5F));

		PartDefinition Body = JetpackFox.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -5.9F, -3.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(33, 17).addBox(-3.15F, -4.6333F, -3.75F, 6.0F, 2.0F, 3.5F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-5.5F, -4.1333F, -3.25F, 11.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-6.1F, -3.1333F, -0.25F, 12.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.6F, -9.5333F, -0.55F, 11.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(-5.6F, -11.5333F, 2.45F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(3.4F, -11.5333F, 2.45F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.5667F, -3.75F));

		PartDefinition BodyWithSkirt = Body.addOrReplaceChild("BodyWithSkirt", CubeListBuilder.create().texOffs(0, 27).addBox(-4.0F, -3.5F, -3.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(38, 13).addBox(-4.0F, 4.5F, -3.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.6F, 0.0F));

		PartDefinition JetPack = BodyWithSkirt.addOrReplaceChild("JetPack", CubeListBuilder.create().texOffs(28, 27).addBox(-4.0F, -1.25F, -0.5F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(38, 7).addBox(-3.0F, 7.75F, -1.5F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.25F, 3.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(10, 41).addBox(-2.4F, -0.3F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.6F, -6.8F, -0.5F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 41).addBox(0.4F, -0.3F, -2.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.6F, -6.8F, 0.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);


		this.animateWalk(JFAnimations.JF_FLYING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((EntityJetpackFox) entity).idleAnimationState, JFAnimations.JF_IDLE, ageInTicks, 1f);
	//	this.animate(((EntityJetpackFox) entity).TummyScratchingAnimationState, CrunchAnimations.CRUNCH_EAR_SCRATCHING, ageInTicks, 1f);
		this.animate(((EntityJetpackFox) entity).attackAnimationState, JFAnimations.JF_ATTACK, ageInTicks, 1f);
		// this.animate(((EntityJetpackFox) entity).deathAnimationState, CrunchAnimations.CRUNCH_DEATH, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -10.0F, 20.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -15.0F, 35.0F);

		this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 120F);
		this.Head.xRot = pHeadPitch * ((float)Math.PI / 120F);
	}



	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		JetpackFox.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return JetpackFox;
	}
}
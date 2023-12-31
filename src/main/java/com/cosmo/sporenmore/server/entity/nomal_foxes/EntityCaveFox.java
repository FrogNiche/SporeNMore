package com.cosmo.sporenmore.server.entity.nomal_foxes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityCaveFox extends Monster implements GeoEntity {

    public AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public static final AttributeSupplier makeAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.6d).build();


    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //make anonymous class so the entity will stop attacking when exploding
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.6f, true) {
        });
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true));

        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 10f));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.5d));

    }
    protected AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityCaveFox
            (EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,
                "attack", 5, this::attackPredicate));
        controllerRegistrar.add(new AnimationController<>(this,
                "controller", 5, this::predicate));
    }

    private PlayState predicate(AnimationState<EntityCaveFox> caveFoxAnimationState) {

        if (caveFoxAnimationState.isMoving()) {
            caveFoxAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.entity_cave_fox.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            caveFoxAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.entity_cave_fox.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;

    }

    protected <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> caveFoxAnimationState) {
        if (this.swinging && caveFoxAnimationState.getController().getAnimationState().equals(AnimationController.State.RUNNING)) {
            caveFoxAnimationState.getController().forceAnimationReset();
            caveFoxAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.entity_cave_fox.swipe",
                    Animation.LoopType.PLAY_ONCE));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public AnimatableInstanceCache getFactory() {
        return this.factory;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.FOX_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.FOX_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.FOX_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }
}
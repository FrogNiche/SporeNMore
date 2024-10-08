package com.cosmo.sporenmore.server.entity.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityFatFox extends Animal implements GeoEntity {
    public static final String CONTROLLER_NAME = "controller";
    protected AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    public EntityFatFox(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    public static final AttributeSupplier createAttributes(){
        return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.6d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.ARMOR, 5d).build();
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 20.0F){

        });
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this){



        });
        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
        this.goalSelector.addGoal(10, new RandomStrollGoal(this, 0.7d){

        });
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob animal) {
        return SNMEntityHandler.FAT_FOX.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,
                "controller", 5, this::predicate));
    }

    private PlayState predicate(AnimationState<EntityFatFox> tallFoxAnimationState) {

        if (tallFoxAnimationState.isMoving()) {
            tallFoxAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.fat_fox.bounce", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            tallFoxAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.fat_fox.idle", Animation.LoopType.LOOP));
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
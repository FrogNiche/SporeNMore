package com.cosmo.sporenmore.server.entity.spore_mobs;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityPoostle extends Animal implements GeoEntity, FlyingAnimal {
    public static AttributeSupplier createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH,
                6.0D).add(Attributes.FLYING_SPEED,
                (double)0.4F).add(Attributes.MOVEMENT_SPEED, (double)0.2F).build();
    }
    public AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    public EntityPoostle(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.moveControl = new FlyingMoveControl(this, 10, false);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
    }
    protected AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(2, new EntityPoostle.PoostleWanderGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new FollowMobGoal(this, 1.0D, 3.0F, 7.0F));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    @Override
    public boolean isFlying() {
        return !this.onGround;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,
                "controller", 5, this::predicate));

    }
    private PlayState predicate(AnimationState<EntityPoostle> poostleAnimationState) {

        if (poostleAnimationState.isMoving()) {
            poostleAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.entity_poostle.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            poostleAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.entity_poostle.walk", Animation.LoopType.LOOP));
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

    static class PoostleWanderGoal extends WaterAvoidingRandomFlyingGoal {
        public PoostleWanderGoal(PathfinderMob p_186224_, double p_186225_) {
            super(p_186224_, p_186225_);
        }
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

package com.cosmo.sporenmore.server.entity.the_crunch;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.sound.SNMSoundHandler;
import net.minecraft.util.Mth;
import com.cosmo.sporenmore.server.entity.CrunchType;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class EntityCrunch extends Monster implements GeoEntity {

    public AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(EntityCrunch.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(EntityCrunch.class, EntityDataSerializers.BOOLEAN);

    private int attackTimer;

    public EntityCrunch(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public static final AttributeSupplier makeAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.ARMOR, 15000)
                .add(Attributes.MOVEMENT_SPEED, 0.4d)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100d).build();


    }
  /* @Override
    public void aiStep() {
        super.aiStep();

        if (this.isAttacking()) {
            this.navigation.stop();
            this.attackTimer--;
        }



        if (this.attackTimer == 10 && !this.isDeadOrDying()) {
            this.performAttack();
        } else if (this.attackTimer == 0) {
            this.setAttacking(false);
        }
    }
  private void performAttack() {
      List<LivingEntity> list = this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.5D, 1.0D, 1.5D));

    for (LivingEntity entity : list) {
            if ((entity instanceof Player && entity.getUUID().equals(this.())) || (entity instanceof YetiEntity && Objects.equals(this.getOwnerUUID(), ((YetiEntity) entity).getOwnerUUID()))) {
                continue;
            }
            this.doHurtTarget(entity);

    }
*/


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //make anonymous class so the entity will stop attacking when exploding
     //   this.goalSelector.addGoal(2, new EntityCrunch.CrunchAttackGoal(this, 1.2D, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.6f, true) {
        });

        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 10f));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.5d));

    }

    protected AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TYPE, getInitialType().ordinal());
  //      this.entityData.define(ATTACKING, false);
    }
 /*   public void setAttacking(boolean isAttacking) {
        this.entityData.set(ATTACKING, isAttacking);
        this.attackTimer = isAttacking ? 24 : 0;
    }

   public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }
    */

    public void setTextureType(Type t) {
        this.entityData.set(TYPE, t.ordinal());
    }

    public Type getTextureType() {
        return Type.values()[entityData.get(TYPE)];
    }

    protected Type getInitialType() {
        return Type.values()[this.random.nextInt(Type.values().length)];
    }


        @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,
                "attack", 5, this::attackPredicate));
        controllerRegistrar.add(new AnimationController<>(this,
                "controller", 5, this::predicate));
    }

    private PlayState predicate(AnimationState<EntityCrunch> entityCrunchAnimationState) {

        if (entityCrunchAnimationState.isMoving()) {
            entityCrunchAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.entity_the_crunch.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            entityCrunchAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.entity_the_crunch.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;

    }

    private PlayState attackPredicate(AnimationState<EntityCrunch> event) {
        if (this.swinging && event.getController().getAnimationState() == AnimationController.State.RUNNING) {
            event.getController().forceAnimationReset();
            event.getController().setAnimation(RawAnimation.begin().then("animation.entity_the_crunch.attack",
                    Animation.LoopType.PLAY_ONCE));

            this.swinging = false;
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
        int i = Mth.nextInt(random, 0, SNMSoundHandler.CRUNCH_IDLES.size());
        if (i < SNMSoundHandler.CRUNCH_IDLES.size()) {
            return SNMSoundHandler.CRUNCH_IDLES.get(i).get();
        }
        return null;
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

    public static enum Type {
        NORMAL(SporeNMore.modLoc("textures/entity/tex_crunch.png")),

        WARPED(SporeNMore.modLoc("textures/entity/crunch_spore.png")),
        ;

        private final ResourceLocation texture;

        Type(ResourceLocation texture) {
            this.texture = texture;
        }

        public ResourceLocation getTexture() {
            return texture;
        }
    }
/*    static class CrunchAttackGoal extends MeleeAttackGoal {
        private final EntityCrunch crunch;

        public CrunchAttackGoal(EntityCrunch crunch, double speedModifier, boolean requiresLineOfSight) {
            super(crunch, speedModifier, requiresLineOfSight);
            this.crunch = crunch;
        }
        @Override
        protected void checkAndPerformAttack(LivingEntity entity, double distance) {
            double d0 = this.getAttackReachSqr(entity);
            if (distance <= d0 && this.crunch.attackTimer <= 0 && this.getTicksUntilNextAttack() <= 0) {
                this.resetAttackCooldown();
            }
        }

      @Override
        public void stop() {
            super.stop();
            this.crunch.setAttacking(false);
        }

        @Override
        protected void resetAttackCooldown() {
            double ticksUntilNextAttack = this.adjustedTickDelay(10);
            this.crunch.setAttacking(true);
        }
  */  }

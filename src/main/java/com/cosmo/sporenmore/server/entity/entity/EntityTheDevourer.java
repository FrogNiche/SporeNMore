package com.cosmo.sporenmore.server.entity.entity;

import com.cosmo.sporenmore.client.sound.SNMSoundHandler;
import com.cosmo.sporenmore.server.entity.ai.DevourerSmashGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;



public class EntityTheDevourer extends Monster {

    private static final EntityDataAccessor<Boolean> SMASHING =
            SynchedEntityData.defineId(EntityTheDevourer.class, EntityDataSerializers.BOOLEAN);

    public EntityTheDevourer(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    public final AnimationState smashAnimationState = new AnimationState();



    public int smashAnimationTimeout = 0;




    @Override
    public void tick() {
        super.tick();
        if(this.getLevel().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(20) + 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }


        if (this.isSmashing() && smashAnimationTimeout <= 0) {
            smashAnimationTimeout = 120; // Length in ticks of your animation
            smashAnimationState.start(this.tickCount);

        } else {
            --this.smashAnimationTimeout;
        }

    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 4F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }


    public void setSmashing(boolean attacking) {
        this.entityData.set(SMASHING, attacking);
    }



    public boolean isSmashing() {
        return this.entityData.get(SMASHING);
    }

 



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SMASHING, false);

    }



    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new DevourerSmashGoal(this, 1.0D, true));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
       }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5000D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.10D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.16f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 10f);
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {

    int i = Mth.nextInt(random, 0, SNMSoundHandler.DEVOURER_IDLE.size());
        if (i < SNMSoundHandler.DEVOURER_IDLE.size()) {
        return SNMSoundHandler.DEVOURER_IDLE.get(i).get();
    }
        return null;
  }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        int i = Mth.nextInt(random, 0, SNMSoundHandler.DEVOURER_HURT.size());
        if (i < SNMSoundHandler.DEVOURER_HURT.size()) {
            return SNMSoundHandler.DEVOURER_HURT.get(i).get();
        }
        return null;
    }
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
}
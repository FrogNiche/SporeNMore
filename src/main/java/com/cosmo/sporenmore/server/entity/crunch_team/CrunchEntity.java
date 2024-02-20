package com.cosmo.sporenmore.server.entity.crunch_team;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.ai.CrunchAttackGoal;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CrunchEntity extends Monster {
    public float targetStomp;

    public float stomp;
    public float oStomp;

    private boolean wasOnGround;
    protected ServerBossEvent bossBar = (ServerBossEvent) new ServerBossEvent(this.getDisplayName(),

            BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS).setDarkenScreen(false);
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(CrunchEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> STOMPING =
            SynchedEntityData.defineId(CrunchEntity.class, EntityDataSerializers.BOOLEAN);




  private static final EntityDataAccessor<Boolean> EAR_SCRATCHING =
            SynchedEntityData.defineId(CrunchEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(CrunchEntity.class, EntityDataSerializers.INT);

    @Override
    public boolean doHurtTarget(Entity opfer) {
        super.doHurtTarget(opfer);
        if (!this.entityData.get(ATTACKING) && this.attackAnimationTimeout <= 0 && this.random.nextInt(10) == 0) {
            this.entityData.set(ATTACKING, true);

            this.attackAnimationTimeout = 4 * 160;
        }
        if (!this.entityData.get(STOMPING) && this.stompAnimationTimeout <= 0 && this.random.nextInt(20) == 0) {
            this.entityData.set(STOMPING, true);

            this.stompAnimationTimeout = 2 * 20;
        }

     if (!this.entityData.get(EAR_SCRATCHING) && this.TummyScratchingAnimationTimeout <= 8 && this.random.nextInt(5) == 0) {
         this.entityData.set(EAR_SCRATCHING, true);

         this.TummyScratchingAnimationTimeout = 20 * 40;
     }
        return false;
    }

    public CrunchEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState TummyScratchingAnimationState = new AnimationState();
    private int TummyScratchingAnimationTimeout = 20;
    public final AnimationState attackAnimationState = new AnimationState();


    public final AnimationState deathAnimationState = new AnimationState();
    public int deathAnimationTimeout = 0;
    // public final AnimationState AnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public int stompAnimationTimeout = 0;

    protected boolean dead;



    @Override
    public void tickDeath() {
        ++this.deathTime;
        if (!dead)
            dead = true;
        if (this.deathTime >= 20 * 16 && !this.level.isClientSide() && !this.isRemoved()) {
            this.level.broadcastEntityEvent(this, (byte) 60);
            this.remove(RemovalReason.KILLED);
        }
    }
    @Override
    public void tick() {
        this.stomp += (this.targetStomp - this.stomp) * 0.5F;
        this.oStomp = this.stomp;
        super.tick();
        if (this.onGround && !this.wasOnGround) {
            int i = this.getTextureType().ordinal();

            // Forge: Don't spawn particles if it's handled by the implementation itself
            if (!spawnCustomParticles())
                for(int j = 0; j < i * 8; ++j) {
                    float f = this.random.nextFloat() * ((float)Math.PI * 2F);
                    float f1 = this.random.nextFloat() * 0.5F + 0.5F;
                    float f2 = Mth.sin(f) * (float)i * 0.5F * f1;
                    float f3 = Mth.cos(f) * (float)i * 0.5F * f1;
                    this.level.addParticle(this.getParticleType(), this.getX() + (double)f2, this.getY(), this.getZ() + (double)f3, 0.0D, 0.0D, 0.0D);
                }

        } else if (!this.onGround && this.wasOnGround) {
            this.targetStomp = 1.0F;
        }

        this.wasOnGround = this.onGround;
      //  this.decreaseSquish();

        if (this.getLevel().isClientSide()) {
            setupAnimationStates();
        }
        bossBar.setProgress(this.getHealth() / this.getMaxHealth());

    }

    protected ParticleOptions getParticleType() {
        return ParticleTypes.ITEM_SLIME;
    }
    protected boolean spawnCustomParticles() { return false; }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(20) + 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.TummyScratchingAnimationTimeout <= 0) {
            this.TummyScratchingAnimationTimeout = this.random.nextInt(120) + 400;
            this.TummyScratchingAnimationState.start(this.tickCount);
        } else {
            --this.TummyScratchingAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 20; // Length in ticks of your animation
            attackAnimationState.start(this.tickCount);

        } else {
            --this.attackAnimationTimeout;
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


    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }



    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

 



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);

        this.entityData.define(STOMPING, false);

 this.entityData.define(EAR_SCRATCHING, false);

        this.entityData.define(TYPE, getInitialType().ordinal());
    }

    public void setTextureType(Type t) {
        this.entityData.set(TYPE, t.ordinal());
    }

    public Type getTextureType() {
        return Type.values()[entityData.get(TYPE)];
    }

    protected Type getInitialType() {
        return Type.values()[this.random.nextInt(Type.values().length)];
    }

    public static enum Type {
        NORMAL(SporeNMore.modLoc("textures/entity/tex_crunch.png")),
        SNOW_CRUNCH(SporeNMore.modLoc("textures/entity/snow_crunch.png")),
        SPORE_CRUNCH(SporeNMore.modLoc("textures/entity/spore_crunch.png"));

        private final ResourceLocation texture;

        Type(ResourceLocation texture) {
            this.texture = texture;
        }

        public ResourceLocation getTexture() {
            return texture;
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new CrunchAttackGoal(this, 1.0D, true));

        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Items.COOKED_BEEF), false));


        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, true));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 150D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.16f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.HOGLIN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.RAVAGER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer p31483) {
        super.startSeenByPlayer(p31483);
        this.bossBar.addPlayer(p31483);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer p31488) {
        super.stopSeenByPlayer(p31488);
        this.bossBar.removePlayer(p31488);
    }

    public void setCustomName(@Nullable Component p31476) {
        super.setCustomName(p31476);
        this.bossBar.setName(this.getDisplayName());
    }
}
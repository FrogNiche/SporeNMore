package com.cosmo.sporenmore.server.entity.examples;
import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.SNMEntityHandler;
import com.cosmo.sporenmore.server.entity.ai.CrunchAttackGoal;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;

public class CrunchEntity extends Animal {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(CrunchEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> STOMPING =
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
        return false;
    }

    public CrunchEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();

    public final AnimationState stompAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public int stompAnimationTimeout = 0;



    @Override
    public void tick() {
        super.tick();

        if (this.getLevel().isClientSide()) {
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
            f = Math.min(pPartialTick * 6F, 1f);
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

        this.goalSelector.addGoal(1, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Items.COOKED_BEEF), false));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 200D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.16f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return SNMEntityHandler.CRUNCH.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.COOKED_BEEF);
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


}
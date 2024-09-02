package com.cosmo.sporenmore.server.entity.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.entity.CrunchEntity;
import com.cosmo.sporenmore.server.entity.entity.EntityClawFox;
import com.cosmo.sporenmore.server.entity.entity.EntityCaveFox;
import com.cosmo.sporenmore.server.entity.entity.EntityFatFox;
import com.cosmo.sporenmore.server.entity.entity.EntityTallFox;
import com.cosmo.sporenmore.server.entity.spore_mobs.EntityBuldgingSporeFox;
import com.cosmo.sporenmore.server.entity.spore_mobs.EntityPoostle;
import com.cosmo.sporenmore.server.entity.spore_mobs.devourer.EntityDevourer;
import com.cosmo.sporenmore.server.entity.entity.EntityLeGiant;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.ENTITY_TYPES;

public class SNMEntityHandler {

    public static final DeferredRegister<EntityType<?>> SNM_ENTITY = DeferredRegister.create(ENTITY_TYPES, SporeNMore.MOD_ID);

    public static final RegistryObject<EntityType<CrunchEntity>> CRUNCH = register("crunch",
            EntityType.Builder.of(CrunchEntity::new,
            MobCategory.MONSTER).sized(3.50f, 5f));
    public static final RegistryObject<EntityType<EntityDevourer>> DEVOURER = register("devourer", EntityType.Builder.of(EntityDevourer::new,
            MobCategory.MONSTER).sized(2f, 7f));


    public static final RegistryObject<EntityType<EntityLeGiant>> LE_GIANTE = register("le_giante", EntityType.Builder.of(EntityLeGiant::new,
            MobCategory.CREATURE));

    public static final RegistryObject<EntityType<EntityTallFox>> TALL_FOX = register("tall_fox", EntityType.Builder.of(EntityTallFox::new,
            MobCategory.CREATURE));

    public static final RegistryObject<EntityType<EntityFatFox>> FAT_FOX = register("fat_fox", EntityType.Builder.of(EntityFatFox::new,
            MobCategory.CREATURE));


    public static final RegistryObject<EntityType<EntityPoostle>> POOSTLE = register("poostle", EntityType.Builder.of(EntityPoostle::new,
            MobCategory.CREATURE));

    public static final RegistryObject<EntityType<EntityBuldgingSporeFox>> BULDGING_SPORE_FOX = register("buldging_spore_fox", EntityType.Builder.of(EntityBuldgingSporeFox::new,
            MobCategory.MONSTER));

    public static final RegistryObject<EntityType<EntityClawFox>> CLAWFOX = register("clawfox",
            EntityType.Builder.of(EntityClawFox::new,
                    MobCategory.MONSTER));

    public static final RegistryObject<EntityType<EntityCaveFox>> CAVE_FOX = register("cave_fox", EntityType.Builder.of(EntityCaveFox::new,
            MobCategory.MONSTER));

    public static final <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder){
        return SNM_ENTITY.register(name, () -> builder.build(SporeNMore.modLoc(name).toString()));
    }
}

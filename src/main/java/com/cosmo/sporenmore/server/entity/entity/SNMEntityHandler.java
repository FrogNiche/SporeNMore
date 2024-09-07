package com.cosmo.sporenmore.server.entity.entity;

import com.cosmo.sporenmore.SporeNMore;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.ENTITY_TYPES;

public class SNMEntityHandler {

    public static final DeferredRegister<EntityType<?>> SNM_ENTITY = DeferredRegister.create(ENTITY_TYPES, SporeNMore.MOD_ID);

    public static final RegistryObject<EntityType<EntityCrunch>> CRUNCH = register("crunch",
            EntityType.Builder.of(EntityCrunch::new,
            MobCategory.MONSTER).sized(3.50f, 5f));

    public static final RegistryObject<EntityType<EntityTheDevourer>> THE_DEVOURER = register("the_devourer",
            EntityType.Builder.of(EntityTheDevourer::new,
                    MobCategory.MONSTER).sized(3.50f, 5f));

    public static final RegistryObject<EntityType<EntityLeGiant>> LE_GIANTE = register("le_giante", EntityType.Builder.of(EntityLeGiant::new,
            MobCategory.CREATURE));

    public static final RegistryObject<EntityType<EntityTallFox>> TALL_FOX = register("tall_fox", EntityType.Builder.of(EntityTallFox::new,
            MobCategory.CREATURE));

    public static final RegistryObject<EntityType<EntityFatFox>> FAT_FOX = register("fat_fox", EntityType.Builder.of(EntityFatFox::new,
            MobCategory.CREATURE));

    public static final RegistryObject<EntityType<EntityClawFox>> CLAWFOX = register("clawfox",
            EntityType.Builder.of(EntityClawFox::new,
                    MobCategory.MONSTER));

    public static final <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder){
        return SNM_ENTITY.register(name, () -> builder.build(SporeNMore.modLoc(name).toString()));
    }
}

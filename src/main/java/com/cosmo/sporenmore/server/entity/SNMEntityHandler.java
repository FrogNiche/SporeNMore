package com.cosmo.sporenmore.server.entity;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.spore_mobs.EntityBuldgingSporeFox;
import com.cosmo.sporenmore.server.entity.the_crunch.EntityCrunch;
import com.cosmo.sporenmore.server.entity.the_crunch.EntityLeGiant;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SNMEntityHandler {

    public static final DeferredRegister<EntityType<?>> SNM_ENTITY = DeferredRegister.create(ForgeRegistries.
                    ENTITY_TYPES, SporeNMore.MOD_ID);

    public static final RegistryObject<EntityType<EntityCrunch>> THE_CRUNCH = register("the_crunch", EntityType.Builder.of(EntityCrunch::new,
            MobCategory.MONSTER));

    public static final RegistryObject<EntityType<EntityLeGiant>> LE_GIANTE = register("le_giante", EntityType.Builder.of(EntityLeGiant::new,
            MobCategory.CREATURE));



    public static final RegistryObject<EntityType<EntityBuldgingSporeFox>> BULDGING_SPORE_FOX = register("buldging_spore_fox", EntityType.Builder.of(EntityBuldgingSporeFox::new,
            MobCategory.MONSTER));

    public static final <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder){
        return SNM_ENTITY.register(name, () -> builder.build(SporeNMore.modLoc(name).toString()));
    }
}

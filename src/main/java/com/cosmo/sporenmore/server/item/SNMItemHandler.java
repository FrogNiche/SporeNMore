package com.cosmo.sporenmore.server.item;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.entity.SNMEntityHandler;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SNMItemHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SporeNMore.MOD_ID);
    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, SporeNMore.MOD_ID);

    // Spawn Eggs
    public static final RegistryObject<Item> CRUNCH_SPAWN_EGG = ITEMS.register("the_crunch_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.CRUNCH, 0xb05122, 0xcc6920,
                    new Item.Properties()));

    public static final RegistryObject<Item> GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.LE_GIANTE, 0xe27c21, 0xb05122,
                    new Item.Properties()));

    public static final RegistryObject<Item> CLAWFOX_SPAWN_EGG = ITEMS.register("clawfox_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.CLAWFOX, 0x1e1b19, 0xcc6920,
                    new Item.Properties()));


    public static final RegistryObject<Item> THE_DEVOURER_SPAWN_EGG = ITEMS.register("the_devourer_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.THE_DEVOURER, 0x7e3548, 0x127e5d,
                    new Item.Properties()));

public static final RegistryObject<Item> FUR = ITEMS.register("fur",
        () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> LOGO = ITEMS.register("logo",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> MONSTROUS_SHARD = ITEMS.register("monstrous_shard",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> DEVOURER_BANDAGE = ITEMS.register("devourer_bandage",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<AxeItem> SPORE_LANDER = ITEMS.register("spore_lander", () ->
            new AxeItem(Tiers.NETHERITE, 5.0F, -3.0F, (new Item.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        SPAWN_EGGS.register(eventBus);
    }
}

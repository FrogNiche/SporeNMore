package com.cosmo.sporenmore.server.item;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.SNMEntityHandler;
import com.cosmo.sporenmore.server.item.armour.armor.ModArmorMaterials;
import com.cosmo.sporenmore.server.item.armour.furry_hoodie.FurryHoodie;
import com.cosmo.sporenmore.server.item.belt.BeltItem;
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
            () -> new ForgeSpawnEggItem(SNMEntityHandler.THE_CRUNCH, 0x7e4b27, 0x9e6238,
                    new Item.Properties()));

    public static final RegistryObject<Item> BULDGING_SPORE_FOX_SPAWN_EGG = ITEMS.register("buldging_spore_fox_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.BULDGING_SPORE_FOX, 0x874056, 0x18050f,
                    new Item.Properties()));
    // Items
public static final RegistryObject<Item> FUR = ITEMS.register("fur",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BELT = ITEMS.register("belt",
            () -> new BeltItem(Tiers.NETHERITE, 3, -2.4F, (new Item.Properties()).fireResistant()));


    public static final RegistryObject<BundleItem> FUR_BUNDLE = ITEMS.register("fur_bundle",
            () -> new BundleItem(new Item.Properties()));

// Armor Items
    public static final RegistryObject<FurryHoodie> FURRY_HOODIE = ITEMS.register("furry_hoodie",
            () -> new FurryHoodie(ModArmorMaterials.SNM_ARMORS, ArmorItem.Type.HELMET,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        SPAWN_EGGS.register(eventBus);
    }
}

package com.cosmo.sporenmore.server.item;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.entity.SNMEntityHandler;
import com.cosmo.sporenmore.server.item.armour.armor.ModArmorMaterials;
import com.cosmo.sporenmore.server.item.armour.belt.SkirtArmour;
import com.cosmo.sporenmore.server.item.armour.furry_hoodie.FurryHoodie;
import com.cosmo.sporenmore.server.item.custom.ItemBoneHammer;
import com.cosmo.sporenmore.server.item.custom.ItemToothFangDagger;
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
            () -> new ForgeSpawnEggItem(SNMEntityHandler.THE_CRUNCH, 0xb05122, 0xcc6920,
                    new Item.Properties()));

    public static final RegistryObject<Item> GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.LE_GIANTE, 0xe27c21, 0xb05122,
                    new Item.Properties()));

    public static final RegistryObject<Item> FLYING_SPORED_FOX_SPAWN_EGG = ITEMS.register("flying_spore_fox_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.POOSTLE, 0xbfa999, 0x769663,
                    new Item.Properties()));

    public static final RegistryObject<Item> DEVOURER_SPAWN_EGG = ITEMS.register("devourer_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.DEVOURER, 0x7e3548, 0x127e5d,
                    new Item.Properties()));

    public static final RegistryObject<Item> CAVE_FOX_SPAWN_EGG = ITEMS.register("cave_fox_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.CAVE_FOX, 0xae642f, 0x472a17,
                    new Item.Properties()));


    public static final RegistryObject<Item> BULDGING_SPORE_FOX_SPAWN_EGG = ITEMS.register("buldging_spore_fox_spawn_egg",
            () -> new ForgeSpawnEggItem(SNMEntityHandler.BULDGING_SPORE_FOX, 0x874056, 0x18050f,
                    new Item.Properties()));
    // Items
public static final RegistryObject<Item> FUR = ITEMS.register("fur",
        () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> LOGO = ITEMS.register("logo",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> TOOTH = ITEMS.register("tooth",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));


    public static final RegistryObject<ItemToothFangDagger> TOOTH_DAGGER = ITEMS.register("tooth_dagger",
            () -> new ItemToothFangDagger(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<ItemBoneHammer> BONE_HAMMER = ITEMS.register("bone_hammer",
            () -> new ItemBoneHammer(new Item.Properties().rarity(Rarity.EPIC)));


    public static final RegistryObject<BundleItem> FUR_BUNDLE = ITEMS.register("fur_bundle",
            () -> new BundleItem(new Item.Properties()));

// Armor Items
    public static final RegistryObject<FurryHoodie> FURRY_HOODIE = ITEMS.register("furry_hoodie",
            () -> new FurryHoodie(ModArmorMaterials.SNM_ARMORS, ArmorItem.Type.HELMET,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<SkirtArmour> SKIRT = ITEMS.register("skirt",
            () -> new SkirtArmour(ModArmorMaterials.SNM_ARMORS, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        SPAWN_EGGS.register(eventBus);
    }
}

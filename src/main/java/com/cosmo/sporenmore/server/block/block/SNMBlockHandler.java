package com.cosmo.sporenmore.server.block.block;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.item.SNMItemHandler;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SNMBlockHandler {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SporeNMore.MOD_ID);


    public static final RegistryObject<Block> BLOCK_OF_FUR = registerBlock("block_of_fur",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(9f).noOcclusion()));

    public static final RegistryObject<Block> BLOCK_OF_TEETH = registerBlock("block_of_teeth",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(9f).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return SNMItemHandler.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
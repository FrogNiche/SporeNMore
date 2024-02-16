package com.cosmo.sporenmore.server.item.tab;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.server.item.SNMItemHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid =SporeNMore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SNMTab {
    public static CreativeModeTab SPORE_N_MORE;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        SPORE_N_MORE = event.registerCreativeModeTab(new ResourceLocation(SporeNMore.MOD_ID, "spore_n_more"),
                builder -> builder.icon(() -> new ItemStack(SNMItemHandler.BONE_HAMMER.get()))
                        .title(Component.translatable("creativemodetab.spore_n_more")));
    }
}
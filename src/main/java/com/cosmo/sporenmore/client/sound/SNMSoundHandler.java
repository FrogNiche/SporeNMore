package com.cosmo.sporenmore.client.sound;

import com.cosmo.sporenmore.SporeNMore;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SNMSoundHandler {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SporeNMore.MOD_ID);

// Crunch Idles
    public static final RegistryObject<SoundEvent> CRUNCH_SNIFF= registerSoundEvent("crunch.sniff");

    public static final RegistryObject<SoundEvent> CRUNCH_SNIFF_2= registerSoundEvent("crunch.sniff_2");

    public static final ImmutableList<Supplier<SoundEvent>> CRUNCH_IDLES = ImmutableList.of(
            CRUNCH_SNIFF::get,
            CRUNCH_SNIFF_2::get
                              );
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(SporeNMore.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

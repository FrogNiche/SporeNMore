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

  // Devourer Idles
  public static final RegistryObject<SoundEvent> DEVOURER_IDLE_1 = registerSoundEvent("devourer_idle_1");
    public static final RegistryObject<SoundEvent> DEVOURER_IDLE_2 = registerSoundEvent("devourer_idle_2");
    public static final RegistryObject<SoundEvent> DEVOURER_IDLE_3 = registerSoundEvent("devourer_idle_3");
    public static final RegistryObject<SoundEvent> DEVOURER_IDLE_4 = registerSoundEvent("devourer_idle_4");
    public static final RegistryObject<SoundEvent> DEVOURER_IDLE_5 = registerSoundEvent("devourer_idle_5");
    public static final RegistryObject<SoundEvent> DEVOURER_IDLE_6 = registerSoundEvent("devourer_idle_6");
    public static final RegistryObject<SoundEvent> DEVOURER_IDLE_7 = registerSoundEvent("devourer_idle_7");
    public static final RegistryObject<SoundEvent> DEVOURER_IDLE_8 = registerSoundEvent("devourer_idle_8");
    public static final RegistryObject<SoundEvent> DEVOURER_IDLE_9 = registerSoundEvent("devourer.idle.9");
    public static final ImmutableList<Supplier<SoundEvent>> DEVOURER_IDLE = ImmutableList.of(
            DEVOURER_IDLE_1::get,
            DEVOURER_IDLE_2::get,
            DEVOURER_IDLE_3::get,
            DEVOURER_IDLE_4::get,
            DEVOURER_IDLE_5::get,
            DEVOURER_IDLE_6::get,
            DEVOURER_IDLE_7::get,
            DEVOURER_IDLE_8::get,
            DEVOURER_IDLE_9::get
    );

    public static final RegistryObject<SoundEvent> DEVOURER_HURT_1 = registerSoundEvent("devourer.hurt.1");
    public static final RegistryObject<SoundEvent> DEVOURER_HURT_2 = registerSoundEvent("devourer.hurt.2");
    public static final RegistryObject<SoundEvent> DEVOURER_HURT_3 = registerSoundEvent("devourer.hurt.3");
    public static final RegistryObject<SoundEvent> DEVOURER_HURT_4 = registerSoundEvent("devourer.hurt.4");
    public static final RegistryObject<SoundEvent> DEVOURER_HURT_5 = registerSoundEvent("devourer.hurt.5");
    public static final ImmutableList<Supplier<SoundEvent>> DEVOURER_HURT = ImmutableList.of(
            DEVOURER_HURT_1::get,
            DEVOURER_HURT_2::get,
            DEVOURER_HURT_3::get,
            DEVOURER_HURT_4::get,
            DEVOURER_HURT_5::get
    );

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(SporeNMore.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

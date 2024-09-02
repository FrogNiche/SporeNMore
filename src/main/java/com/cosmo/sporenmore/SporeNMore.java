package com.cosmo.sporenmore;

import com.cosmo.sporenmore.client.models.entity.*;
import com.cosmo.sporenmore.client.particle.SNMParticleTypes;
import com.cosmo.sporenmore.client.sound.SNMSoundHandler;
import com.cosmo.sporenmore.server.block.SNMBlockHandler;
import com.cosmo.sporenmore.server.entity.entity.SNMEntityHandler;
import com.cosmo.sporenmore.server.entity.client.renderer.ClawFoxRenderer;
import com.cosmo.sporenmore.server.entity.client.renderer.CrunchRenderer;
import com.cosmo.sporenmore.server.entity.entity.EntityCaveFox;
import com.cosmo.sporenmore.server.entity.entity.EntityFatFox;
import com.cosmo.sporenmore.server.entity.entity.EntityTallFox;
import com.cosmo.sporenmore.server.entity.spore_mobs.EntityBuldgingSporeFox;
import com.cosmo.sporenmore.server.entity.spore_mobs.EntityPoostle;
import com.cosmo.sporenmore.server.entity.spore_mobs.devourer.DevourerRenderer;
import com.cosmo.sporenmore.server.entity.spore_mobs.devourer.EntityDevourer;
import com.cosmo.sporenmore.server.entity.entity.EntityLeGiant;
import com.cosmo.sporenmore.server.item.SNMItemHandler;
import com.cosmo.sporenmore.server.item.tab.SNMTab;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Mod(SporeNMore.MOD_ID)
public class SporeNMore {
    public static final String MOD_ID = "sporenmore";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation modLoc(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public SporeNMore() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        GeckoLib.initialize();
        SNMItemHandler.register(modEventBus);
        SNMSoundHandler.register(modEventBus);
        SNMBlockHandler.register(modEventBus);
        SNMEntityHandler.SNM_ENTITY.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        SNMParticleTypes.PARTICLE_TYPES.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerEntityAttributes);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(SNMEntityHandler.DEVOURER.get(), EntityDevourer.makeAttributes());
        event.put(SNMEntityHandler.LE_GIANTE.get(), EntityLeGiant.createAttributes());
        event.put(SNMEntityHandler.POOSTLE.get(), EntityPoostle.createAttributes());
        event.put(SNMEntityHandler.BULDGING_SPORE_FOX.get(), EntityBuldgingSporeFox.makeAttributes());
        event.put(SNMEntityHandler.CAVE_FOX.get(), EntityCaveFox.makeAttributes());
        event.put(SNMEntityHandler.TALL_FOX.get(), EntityTallFox.createAttributes());
        event.put(SNMEntityHandler.FAT_FOX.get(), EntityFatFox.createAttributes());
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    public static <T extends LivingEntity & GeoEntity> EntityRendererProvider<T> makeRenderer(GeoModel<T> model) {
        return m -> new HelperGeoRenderer<>(m, model);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(SNMEntityHandler.DEVOURER.get(), DevourerRenderer::new);
        EntityRenderers.register(SNMEntityHandler.CRUNCH.get(), CrunchRenderer::new);
        EntityRenderers.register(SNMEntityHandler.CLAWFOX.get(), ClawFoxRenderer::new);
        EntityRenderers.register(SNMEntityHandler.DECAYED.get(), DecayedRenderer::new);
        EntityRenderers.register(SNMEntityHandler.LE_GIANTE.get(), makeRenderer(new ModelGiant()));
        EntityRenderers.register(SNMEntityHandler.POOSTLE.get(), makeRenderer(new ModelPoostle()));
        EntityRenderers.register(SNMEntityHandler.BULDGING_SPORE_FOX.get(),
                makeRenderer(new ModelBuldgingSporeFox()));
        EntityRenderers.register(SNMEntityHandler.CAVE_FOX.get(),
                makeRenderer(new ModelCaveFox()));
        EntityRenderers.register(SNMEntityHandler.FAT_FOX.get(),
                makeRenderer(new ModelFatFox()));
        EntityRenderers.register(SNMEntityHandler.TALL_FOX.get(),
                makeRenderer(new ModelTallFox()));

    }

    public static class HelperGeoRenderer<T extends LivingEntity & GeoEntity> extends GeoEntityRenderer<T> {

        public HelperGeoRenderer(EntityRendererProvider.Context renderManager, GeoModel<T> modelProvider) {
            super(renderManager, modelProvider);
        }
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == SNMTab.SPORE_N_MORE) {
           event.accept(SNMItemHandler.FUR);
            event.accept(SNMItemHandler.DEVOURER_BANDAGE);
            event.accept(SNMItemHandler.MONSTROUS_SHARD);
          */event.accept(SNMItemHandler.BONE_HAMMER);
            event.accept(SNMItemHandler.TWINMILL_AXE);
            event.accept(SNMItemHandler.SKIRT);
            event.accept(SNMItemHandler.CRUNCH_SPAWN_EGG);
            event.accept(SNMItemHandler.CLAWFOX_SPAWN_EGG);
            event.accept(SNMItemHandler.GIANT_SPAWN_EGG);
            event.accept(SNMItemHandler.DEVOURER_SPAWN_EGG);
            event.accept(SNMItemHandler.CAVE_FOX_SPAWN_EGG);
            event.accept(SNMItemHandler.FLYING_SPORED_FOX_SPAWN_EGG);
            event.accept(SNMBlockHandler.BLOCK_OF_FUR);
            event.accept(SNMBlockHandler.RUGGED_STONE);
            event.accept(SNMBlockHandler.DIRT_ATLAS);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(SNMEntityHandler.CRUNCH.get(), CrunchRenderer::new);
            EntityRenderers.register(SNMEntityHandler.CLAWFOX.get(), ClawFoxRenderer::new);
            EntityRenderers.register(SNMEntityHandler.DEVOURER.get(), DevourerRenderer::new);

            EntityRenderers.register(SNMEntityHandler.CAVE_FOX.get(), makeRenderer(new ModelCaveFox()));
            EntityRenderers.register(SNMEntityHandler.LE_GIANTE.get(), makeRenderer(new ModelGiant()));
            EntityRenderers.register(SNMEntityHandler.POOSTLE.get(), makeRenderer(new ModelPoostle()));
            EntityRenderers.register(SNMEntityHandler.BULDGING_SPORE_FOX.get(), makeRenderer(new ModelBuldgingSporeFox()));
            EntityRenderers.register(SNMEntityHandler.TALL_FOX.get(), makeRenderer(new ModelTallFox()));
            EntityRenderers.register(SNMEntityHandler.FAT_FOX.get(), makeRenderer(new ModelFatFox()));

        }


        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }

    }
}

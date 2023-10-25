

package com.cosmo.sporenmore.client.init;

import com.cosmo.sporenmore.SporeNMore;
import com.cosmo.sporenmore.client.capability.IBeltUpdate;
import com.cosmo.sporenmore.server.item.belt.BeltItem;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SNMCapabilities {

    public static final Capability<IBeltUpdate> WHIP_UPDATE = CapabilityManager.get(new CapabilityToken<>() {
    });

    @SubscribeEvent
    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(IBeltUpdate.class);
    }

    @SubscribeEvent
    public void onItemAttach(final AttachCapabilitiesEvent<ItemStack> event) {
        if (!(event.getObject().getItem() instanceof BeltItem)) return;

        BeltUpdate beltUpdate = new BeltUpdate();
        LazyOptional<IBeltUpdate> optionalBeltUpdate = LazyOptional.of(() -> beltUpdate);

        ICapabilityProvider provider = new ICapabilityProvider() {
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
                if (capability == WHIP_UPDATE) {
                    return optionalBeltUpdate.cast();
                }

                return LazyOptional.empty();
            }
        };

        event.addCapability(new ResourceLocation(SporeNMore.MOD_ID, "belt_update"), provider);
        event.addListener(optionalBeltUpdate::invalidate);
    }

}

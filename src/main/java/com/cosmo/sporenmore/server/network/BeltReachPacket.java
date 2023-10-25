

package com.cosmo.sporenmore.server.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkEvent;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class BeltReachPacket {
    private final UUID playerUUID;
    private static final Random random = new Random();


    public BeltReachPacket(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public static void encode(BeltReachPacket message, FriendlyByteBuf buffer) {
        buffer.writeUUID(message.playerUUID);
    }

    public static BeltReachPacket decode(FriendlyByteBuf buffer) {
        return new BeltReachPacket(buffer.readUUID());
    }

    public static void handle(BeltReachPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Player player = context.get().getSender();

            // Change the value added here to adjust the reach of the charge attack of the whip, must also be changed in BeltReachPacket
            double reach = player.getAttribute(ForgeMod.REACH_DISTANCE.get()).getValue() + 1.0D;

            Vec3 eyePos = player.getEyePosition(1.0F);
            Vec3 lookVec = player.getViewVector(1.0F);
            Vec3 reachVec = eyePos.add(lookVec.multiply(reach, reach, reach));

            AABB playerBox = player.getBoundingBox().expandTowards(lookVec.scale(reach)).inflate(1.0D, 1.0D, 1.0D);
            EntityHitResult entityTraceResult = ProjectileUtil.getEntityHitResult(player, eyePos, reachVec, playerBox, (target) -> !target.isSpectator() && target.isAlive(), reach * reach);
            BlockHitResult blockTraceResult = player.getCommandSenderWorld().clip(new ClipContext(eyePos, reachVec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

            if (entityTraceResult != null) {
                double distance = eyePos.distanceToSqr(entityTraceResult.getLocation());
                if (distance < reach * reach && distance < eyePos.distanceToSqr(blockTraceResult.getLocation())) {
                    ((ServerPlayer) player).attackAnim = (int) player.getCurrentItemAttackStrengthDelay();

                    player.getCommandSenderWorld().playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F));

                    if (player != null && player.getServer() != null) {
                        ServerPlayer serverPlayer = player.getServer().getPlayerList().getPlayer(message.playerUUID);
                        Entity target = entityTraceResult.getEntity();

                        if (serverPlayer != null && target != null) {
                            if (serverPlayer.distanceToSqr(target) < (reach * reach) * serverPlayer.getAttackStrengthScale(0.0F)) {
                                serverPlayer.attack(target);
                                serverPlayer.getCommandSenderWorld().playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F));}
                        }
                    }

                }
            }
        });

        context.get().setPacketHandled(true);
    }
}

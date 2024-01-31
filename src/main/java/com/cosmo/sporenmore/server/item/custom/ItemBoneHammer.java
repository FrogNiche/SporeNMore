package com.cosmo.sporenmore.server.item.custom;

import com.cosmo.sporenmore.server.item.ToolItemHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBoneHammer extends ToolItemHelper {

    public ItemBoneHammer(Item.Properties properties) {
        super(10, 4f , Tiers.NETHERITE, BlockTags.MINEABLE_WITH_HOE, properties);
    }


    @Override
    public boolean isEnchantable(ItemStack p_77616_1_) {
        return true;
    }


    @Override
    public boolean hurtEnemy(ItemStack heldItemStack, LivingEntity entityHit, LivingEntity attacker) {
        if (!entityHit.level.isClientSide) {
            entityHit.playSound(SoundEvents.ANVIL_LAND, 0.3F, 0.5F);
        }
        return true;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND && player.getAttackStrengthScale(0.5F) == 1.0f) {

        }
        return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.literal("\u00A76Spore N' More's most powerful item"));
    }
}



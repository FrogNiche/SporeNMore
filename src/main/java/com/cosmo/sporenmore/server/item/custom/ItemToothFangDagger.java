package com.cosmo.sporenmore.server.item.custom;

import com.cosmo.sporenmore.server.item.ToolItemHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class ItemToothFangDagger extends ToolItemHelper {
    public ItemToothFangDagger(Item.Properties properties) {
        super(10, 4f , Tiers.NETHERITE, BlockTags.MINEABLE_WITH_HOE, properties);
    }

    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.SWEEPING_EDGE) return false;
        return enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.BREAKABLE;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (super.hurtEnemy(stack, target, attacker)) {
            target.addEffect(new MobEffectInstance(MobEffects.HARM, 600));
            return true;
        }
        return false;
    }

   /* @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        Item item = repair.getItem();
        return item instanceof SNMItemHandler.FUR;
    }
*/
   @Override
   public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
       tooltip.add(Component.literal("\u00A76Gives damage effect to anything that it hits"));
   }

}

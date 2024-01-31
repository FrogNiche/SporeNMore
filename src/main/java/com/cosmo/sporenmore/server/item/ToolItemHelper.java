package com.cosmo.sporenmore.server.item;


import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;

public abstract class ToolItemHelper extends DiggerItem {
    public ToolItemHelper(float attackDamageIn, float attackSpeedIn, Tier tier, TagKey<Block> effectiveBlocksIn, Properties builderIn) {
        super(attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, builderIn);
    }

}

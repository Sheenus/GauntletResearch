package com.sheenus.gauntletresearch.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface ICooldownReductionGear {
	
	int getCooldownReduction(final ItemStack stack);		
}

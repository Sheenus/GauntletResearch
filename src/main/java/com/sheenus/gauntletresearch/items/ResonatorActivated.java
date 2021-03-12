package com.sheenus.gauntletresearch.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ResonatorActivated extends ItemBase{
	
	public ResonatorActivated() {
		
		super ("resonator_activated", new String[] {"thaumium", "void_metal"});
	}
	
	public EnumRarity getRarity(final ItemStack itemstack) {
		return EnumRarity.RARE;
	}
}

package com.sheenus.gauntletresearch.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ComponentsActivated extends ItemBase {
	
	public ComponentsActivated() {
		
		super("components_activated", new String[] {"thaumium", "void_metal"});	
	}
	
	public EnumRarity getRarity(final ItemStack itemstack) {
		return EnumRarity.RARE;
	}
}

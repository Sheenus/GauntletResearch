package com.sheenus.gauntletresearch.util;

import com.sheenus.gauntletresearch.init.RegisterItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.items.casters.ItemCaster;
import thaumcraft.common.items.casters.ItemFocus;

@SideOnly(Side.CLIENT)
public class ColorHandler {
	
	public static void registerColorHandlers() {
		
		ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
		registerCustomGauntletColorHandler(itemColors);
	}
	/*
	 * The function used to do all the busy work for registerColorHandlers, by registering the color changes on each of the different custom caster models
	 */
	private static void registerCustomGauntletColorHandler(ItemColors itemColors) {
		
	// registers the colour changes on the gold casting gauntlet when foci are inserted
		final IItemColor goldCasterColourHandler = (stack, tintIndex) -> {
			
            final ItemCaster item = (ItemCaster)stack.getItem();
            final ItemFocus focus = item.getFocus(stack);
            return (tintIndex > 0 && focus != null) ? focus.getFocusColor(item.getFocusStack(stack)) : -1;
        };
        itemColors.registerItemColorHandler(goldCasterColourHandler, new Item[] { RegisterItems.GOLD_CASTER });
        
    // registers the colour changes on the thaumium casting gauntlet when foci are inserted
        final IItemColor thaumiumCasterColourHandler = (stack, tintIndex) -> {
			
            final ItemCaster item = (ItemCaster)stack.getItem();
            final ItemFocus focus = item.getFocus(stack);
            return (tintIndex > 0 && focus != null) ? focus.getFocusColor(item.getFocusStack(stack)) : -1;
        };
        itemColors.registerItemColorHandler(thaumiumCasterColourHandler, new Item[] { RegisterItems.THAUMIUM_CASTER });
        
    // registers the colour changes on the void metal casting gauntlet when foci are inserted
        final IItemColor voidMetalCasterColourHandler = (stack, tintIndex) -> {
			
            final ItemCaster item = (ItemCaster)stack.getItem();
            final ItemFocus focus = item.getFocus(stack);
            return (tintIndex > 0 && focus != null) ? focus.getFocusColor(item.getFocusStack(stack)) : -1;
        };
        itemColors.registerItemColorHandler(voidMetalCasterColourHandler, new Item[] { RegisterItems.VOID_METAL_CASTER });
	}
}

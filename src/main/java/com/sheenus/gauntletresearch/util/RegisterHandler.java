package com.sheenus.gauntletresearch.util;

import com.sheenus.gauntletresearch.init.RegisterItems;
import com.sheenus.gauntletresearch.init.RegisterRecipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public final class RegisterHandler {
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		
		RegisterItems.initItems((IForgeRegistry<Item>)event.getRegistry());
		RegisterItems.initOreDictEntries();
	}
	
	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		
		RegisterRecipes.initArcaneRecipes((IForgeRegistry<IRecipe>)event.getRegistry());
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerItemModelsOnClient(final RegistryEvent.Register<Item> event) {
		
		RegisterItems.initItemModels();
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerTooltipEvent (final ItemTooltipEvent event) {
		final int cooldownReduction = getFinalCooldownReduction(event.getItemStack());
		if (cooldownReduction > 0) {
			event.getToolTip().add(TextFormatting.DARK_PURPLE + I18n.translateToLocal("tooltip.cooldownreduction") + ": " + cooldownReduction + "%");
		}
		
	}
	
	public static int getFinalCooldownReduction (ItemStack stack) {
		int cooldownReduction = 0;
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("CooldownReduction")) {
			cooldownReduction = stack.getTagCompound().getInteger("CooldownReduction");
		}
		return cooldownReduction;
	}
}
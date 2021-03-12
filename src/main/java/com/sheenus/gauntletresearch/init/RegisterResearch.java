package com.sheenus.gauntletresearch.init;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ScanItem;
import thaumcraft.api.research.ScanOreDictionary;
import thaumcraft.api.research.ScanningManager;
import thaumcraft.common.config.ConfigResearch;
import thaumcraft.common.lib.research.ResearchManager;

public class RegisterResearch {

	private static final ResourceLocation ICON_BACKGROUND = new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png");
	
	public static void initResearch() {
		
		ThaumcraftApi.registerResearchLocation(new ResourceLocation("gauntletresearch", "research/gauntletresearch"));
		
		ScanningManager.addScannableThing(new ScanItem("!CASTERBASIC", new ItemStack(ItemsTC.casterBasic)));
		ScanningManager.addScannableThing(new ScanItem("!VISRESONATOR", new ItemStack(ItemsTC.visResonator)));
	}	
}

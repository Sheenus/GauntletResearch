package com.sheenus.gauntletresearch.init;

import java.util.ArrayList;
import java.util.List;

import com.sheenus.gauntletresearch.items.ComponentsActivated;
import com.sheenus.gauntletresearch.items.ComponentsBase;
import com.sheenus.gauntletresearch.items.ItemBase;
import com.sheenus.gauntletresearch.items.ResonatorActivated;
import com.sheenus.gauntletresearch.items.ResonatorBase;
import com.sheenus.gauntletresearch.items.casters.CustomCaster;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.items.ItemsTC;

public class RegisterItems {
	
	// item list instantiation, for initializing item registry entries (items added through ItemBase.java)
	public static final List<ItemBase> ITEM_LIST = new ArrayList<ItemBase>();
	
	// all the below items are added to ITEM_LIST through ItemBase.java, as they are all base items in this mod.
	public static final ItemBase GOLD_PLATE = new ItemBase("gold_plate");
	public static final ComponentsBase COMPONENTS = new ComponentsBase();
	public static final ComponentsActivated COMPONENTS_ACTIVATED = new ComponentsActivated();
	public static final ResonatorBase RESONATOR = new ResonatorBase();
	public static final CustomCaster GOLD_CASTER = new CustomCaster("gold_caster", 0, 5, 0, 0);
	public static final CustomCaster THAUMIUM_CASTER = new CustomCaster("thaumium_caster", 0, 10, 0, 0);
	public static final CustomCaster VOID_METAL_CASTER = new CustomCaster("void_metal_caster", 0, 5, 10, 1);
	public static final ResonatorActivated RESONATOR_ACTIVATED = new ResonatorActivated();
	
	public static void initItems(final IForgeRegistry<Item> iForgeRegistry) {
		
	iForgeRegistry.register(GOLD_PLATE);
	iForgeRegistry.register(COMPONENTS);
	iForgeRegistry.register(COMPONENTS_ACTIVATED);
	iForgeRegistry.register(RESONATOR);
	iForgeRegistry.register(RESONATOR_ACTIVATED);
	
	iForgeRegistry.register(GOLD_CASTER);
	iForgeRegistry.register(THAUMIUM_CASTER);
	iForgeRegistry.register(VOID_METAL_CASTER);

	}
	
	public static void initOreDictEntries() {
		OreDictionary.registerOre("plateGold", GOLD_PLATE);
		OreDictionary.registerOre("resonator", ItemsTC.visResonator);
		OreDictionary.registerOre("resonator", new ItemStack(RESONATOR, 1, 0));
		OreDictionary.registerOre("resonator", new ItemStack(RESONATOR_ACTIVATED, 1, 0));
		OreDictionary.registerOre("resonator", new ItemStack(RESONATOR_ACTIVATED, 1, 1));
		
	}
	
	@SideOnly(Side.CLIENT)
	// parent function for initItemModelTypes; sorts through ITEM_LIST
	public static void initItemModels() {
		for (ItemBase itemType : ITEM_LIST) {
			initItemModelTypes(itemType);
		}
	}
	
	@SideOnly(Side.CLIENT)
	// Sets the ResourceLocations for the different damage types of every item that has those variations.
	private static void initItemModelTypes(ItemBase itemType) {
		
		if (!itemType.getHasSubtypes()) {
			ModelResourceLocation customMRL = new ModelResourceLocation(itemType.getRegistryName(), (String)null);
			ModelLoader.setCustomModelResourceLocation(itemType, 0, customMRL);
			// System.out.println("set custom ModelResourceLocation for " + itemType.getName() + "at custom ModelResourceLocation " + customMRL.toString());
		}
		else {
			for (int meta = 0; meta < itemType.getItemTypes().length; ++meta) {
				ModelResourceLocation metaCustomMRL = itemType.getCustomModelResourceLocation(itemType.getItemTypes()[meta]);
				ModelLoader.setCustomModelResourceLocation(itemType, itemType.getItemTypesMeta()[meta], metaCustomMRL);
				// System.out.println("set custom ModelResourceLocation for " + itemType.getName() + "'s variant " + itemType.getItemTypes()[meta] + " at custom ModelResourceLocation " + metaCustomMRL.toString());
			}
		}
	}
}

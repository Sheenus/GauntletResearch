package com.sheenus.gauntletresearch.items.crafting;

import javax.annotation.Nonnull;

import com.sheenus.gauntletresearch.init.RegisterItems;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper.ShapedPrimer;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.IArcaneWorkbench;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;

// Factory class for creating the new caster's gauntlets in the arcane workbench.

public class CasterFactory {
	
	/**
	 * recipe factory for the gold caster gauntlets
	 */
	public static class GoldCasterRecipe extends ShapedArcaneRecipe {
		
		public GoldCasterRecipe(final ResourceLocation group, final String researchNeeded, final int visCost, final AspectList crystalsCost, final ItemStack result, final Object... recipe) {
			super(group, researchNeeded, visCost, crystalsCost, result, recipe); 
		}
		
		@Override
		@Nonnull
		public ItemStack getCraftingResult(@Nonnull InventoryCrafting craftingInv) { 
			
			// check that the crafting interface used is actually an arcane workbench
			if (!(craftingInv instanceof IArcaneWorkbench)) {
	            return ItemStack.EMPTY;
	        }
			
			ItemStack resultStack = new ItemStack(RegisterItems.GOLD_CASTER);
			
			int baseVisDiscount = 5; // the base stats for the component used (gold components)
			int baseCDReduction = 0;
			
			//create the compound NBT tag for the gauntlet
			NBTTagCompound casterNBTTag = setCasterNBTTag(baseVisDiscount, baseCDReduction, craftingInv);
			
			// apply the new NBT compound tag to the new item, and return the new item to the workbench for creation
			resultStack.setTagCompound(casterNBTTag); 
	        return resultStack;
		}
	}
		
	/**
	 * recipe factory for the thaumium caster gauntlets
	 */
	public static class ThaumiumCasterRecipe extends ShapedArcaneRecipe {
		
		public ThaumiumCasterRecipe(final ResourceLocation group, final String researchNeeded, final int visCost, final AspectList crystalsCost, final ItemStack result, final Object... recipe) {
			super(group, researchNeeded, visCost, crystalsCost, result, recipe); 
		}
		
		@Override
		@Nonnull
		public ItemStack getCraftingResult(@Nonnull InventoryCrafting craftingInv) { 
			
			// check that the crafting interface used is actually an arcane workbench
			if (!(craftingInv instanceof IArcaneWorkbench)) {
	            return ItemStack.EMPTY;
	        }
			
			ItemStack resultStack = new ItemStack(RegisterItems.THAUMIUM_CASTER);
			
			int baseVisDiscount = 10; // the base stats for the component used (thaumium components)
			int baseCDReduction = 0;
			
			//create the compound NBT tag for the gauntlet
			NBTTagCompound casterNBTTag = setCasterNBTTag(baseVisDiscount, baseCDReduction, craftingInv);
			
			// apply the new NBT compound tag to the new item, and return the new item to the workbench for creation
			resultStack.setTagCompound(casterNBTTag); 
	        return resultStack;
		}
	}
	
	/**
	 * recipe factory for the void metal caster gauntlets
	 */
	public static class VoidMetalCasterRecipe extends ShapedArcaneRecipe {
		
		public VoidMetalCasterRecipe(final ResourceLocation group, final String researchNeeded, final int visCost, final AspectList crystalsCost, final ItemStack result, final Object... recipe) {
			super(group, researchNeeded, visCost, crystalsCost, result, recipe); 
		}
		
		@Override
		@Nonnull
		public ItemStack getCraftingResult(@Nonnull InventoryCrafting craftingInv) { 
			
			// check that the crafting interface used is actually an arcane workbench
			if (!(craftingInv instanceof IArcaneWorkbench)) {
	            return ItemStack.EMPTY;
	        }
			
			ItemStack resultStack = new ItemStack(RegisterItems.VOID_METAL_CASTER);
			
			int baseVisDiscount = 5; // the base stats for the component used (thaumium components)
			int baseCDReduction = 10;
			
			//create the compound NBT tag for the gauntlet
			NBTTagCompound casterNBTTag = setCasterNBTTag(baseVisDiscount, baseCDReduction, craftingInv);
			casterNBTTag.setInteger("Warping", 1);
			
			// apply the new NBT compound tag to the new item, and return the new item to the workbench for creation
			resultStack.setTagCompound(casterNBTTag); 
	        return resultStack;
		}
	}


	/*
	 * HELPER FUNCTIONS
	 */
	
	// checks what kind of resonator is used for crafting the gauntlet-in-question, and returns an int specifiying which one, to send to setCasterNBTTag()
	private static int checkResonator(ItemStack resonator) {
		
		int returnInt;
		ItemStack goldResonator = new ItemStack(RegisterItems.RESONATOR, 1, 0);
		ItemStack thaumiumResonator = new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 0);
		ItemStack voidMetalResonator = new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 1);
		
		if (resonator.isItemEqual(voidMetalResonator)) { returnInt = 3; }
		else if (resonator.isItemEqual(thaumiumResonator)) { returnInt = 2; }
		else if (resonator.isItemEqual(goldResonator)) { returnInt = 1; }
		else  { returnInt = 0; }
		
		// System.out.println("checkResonator is returning :" + returnInt);		// debugging code
		return returnInt;
	}
	
	// checks the crafting table to see what kind of Resonator is used, and creates the appropriate compound NBT tag with the appropriate Vis Discount and Cooldown Reduction tags
	private static NBTTagCompound setCasterNBTTag(int baseVisDiscount, int baseCDReduction, InventoryCrafting craftingInv) {
		
		NBTTagCompound casterNBTTag = new NBTTagCompound();
		ItemStack resonatorUsed = craftingInv.getStackInSlot(4);
		
		
		
		switch (checkResonator(resonatorUsed)) {
			case 1: { // if its a gold resonator:
				int visDiscount = baseVisDiscount;
				int cooldownReduction = baseCDReduction + 5;
				//System.out.println("vis discount tag is : " + visDiscount[0] + "%.");				// debugging code
				//System.out.println("cooldown reduction tag is : " + cooldownReduction[0] + "%.");
				casterNBTTag.setInteger("VisDiscount", visDiscount);
				casterNBTTag.setInteger("CooldownReduction", cooldownReduction);
				break;
			}
			case 2: { // if its a thaumium resonator:
				int visDiscount = baseVisDiscount + 5;
				int cooldownReduction = baseCDReduction + 10;
				//System.out.println("vis discount tag is : " + visDiscount[0] + "%.");				//debugging code
				//System.out.println("cooldown reduction tag is : " + cooldownReduction[0] + "%.");
				casterNBTTag.setInteger("VisDiscount", visDiscount);
				casterNBTTag.setInteger("CooldownReduction", cooldownReduction);
				break;
			}
			case 3: { // if its a void metal resonator:
				int visDiscount = baseVisDiscount;
				int cooldownReduction = baseCDReduction + 20;
				//System.out.println("vis discount tag is : " + visDiscount[0] + "%.");				// debugging code
				//System.out.println("cooldown reduction tag is : " + cooldownReduction[0] + "%.");
				casterNBTTag.setInteger("VisDiscount", visDiscount);
				casterNBTTag.setInteger("CooldownReduction", cooldownReduction);
				break;
			}
			default: { // if its just a regular iron vis resonator:
				int visDiscount = baseVisDiscount;
				int cooldownReduction = baseCDReduction;
				//System.out.println("vis discount tag is : " + visDiscount[0] + "%.");				// debugging code
				//System.out.println("cooldown reduction tag is : " + cooldownReduction[0] + "%.");
				casterNBTTag.setInteger("VisDiscount", visDiscount);
				casterNBTTag.setInteger("CooldownReduction", cooldownReduction);
			}
		}
		
		return casterNBTTag;
	}
}

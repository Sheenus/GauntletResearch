package com.sheenus.gauntletresearch.init;

import com.sheenus.gauntletresearch.items.crafting.CasterFactory;
import com.sheenus.gauntletresearch.util.Reference;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.api.items.ItemsTC;

public class RegisterRecipes {
	
	static ResourceLocation gauntletGroup;
	/**
	 * initialize all the new Arcane Workbench recipes added
	 */
	public static void initArcaneRecipes(final IForgeRegistry<IRecipe> iForgeRegistry) {
		
	/*
	 * GAUNTLET COMPONENT RECIPES	
	 */
	// recipe for the Gold Gauntlet Components:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":gold_components_recipe"), 
											  	new ShapedArcaneRecipe(gauntletGroup, 
										  			"GOLDCASTERGAUNTLETS@3",
										  			100,
										  			new AspectList().add(Aspect.AIR, 4).add(Aspect.EARTH, 4).add(Aspect.WATER, 4).add(Aspect.FIRE, 4).add(Aspect.ORDER, 4).add(Aspect.ENTROPY, 4),
										  			new ItemStack(RegisterItems.COMPONENTS, 1, 0),
										  			new Object[] {" I ",
								  				  		  		  "GIG",
								  				  		  		  " G ",
					  				  		  		  'I', "plateIron",
					  				  		  		  'G', "plateGold"
											  		}
									  			)
									  		 );
		
	// recipe for the Thaumium Gauntlet Components:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":thaumium_components_recipe"), 
											  	new ShapedArcaneRecipe(gauntletGroup, 
										  			"THAUMIUMCASTERGAUNTLETS@2",
										  			150,
										  			new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
										  			new ItemStack(RegisterItems.COMPONENTS, 1, 1),
										  			new Object[] {" B ",
								  				  		  		  "TBT",
								  				  		  		  " T ",
					  				  		  		  'T', "plateThaumium",
					  				  		  		  'B', "plateBrass"
											  		}
									  			)
									  		 );
		
	// infusion recipe for Activated Thaumium Gauntlet Components:
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":activated_thaumium_components_recipe"), 
												new InfusionRecipe(
													"THAUMIUMCASTERGAUNTLETS@3",
													new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 0),
													4,
													new AspectList().add(Aspect.ORDER, 75).add(Aspect.AURA, 50).add(Aspect.MAGIC, 100).add(Aspect.TOOL, 75),
													new ItemStack(RegisterItems.COMPONENTS, 1, 1),
													new Object[] {
														new ItemStack(ItemsTC.salisMundus),
														new ItemStack(ItemsTC.salisMundus),
														new ItemStack(ItemsTC.salisMundus)
													}
												)
											);
		
	// recipe for the Void Metal Gauntlet Components:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":void_metal_components_recipe"), 
											  	  new ShapedArcaneRecipe(gauntletGroup, 
										  			  "VOIDCASTERGAUNTLETS@1",
										  			  200,
										  			  new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
										  			  new ItemStack(RegisterItems.COMPONENTS, 1, 2),
										  			  new Object[] {" B ",
								  				  		  		    "VBV",
								  				  		  		    " V ",
										  		  		  'V', "plateVoid",
										  		  		  'B', "plateBrass"
										  		 	 }
									  			  )
								  		     );
		
	// infusion recipe for the Activated Void Metal Gauntlet Components:
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":activated_void_metal_components_recipe"), 
												new InfusionRecipe(
													"VOIDCASTERGAUNTLETS@2",
													new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 1),
													5,
													new AspectList().add(Aspect.ORDER, 50).add(Aspect.AURA, 100).add(Aspect.MAGIC, 100).add(Aspect.TOOL, 75),
													new ItemStack(RegisterItems.COMPONENTS, 1, 2),
													new Object[] {
														new ItemStack(ItemsTC.salisMundus),
														new ItemStack(ItemsTC.salisMundus),
														new ItemStack(ItemsTC.salisMundus)
													}
												)
											);
		
	// recipe for the Gold Resonator:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":gold_resonator_recipe"), 
											  	  new ShapelessArcaneRecipe(gauntletGroup, 
										  			  "BETTERRESONATORS@2",
										  			  100,
										  			  new AspectList().add(Aspect.AIR, 4).add(Aspect.EARTH, 4).add(Aspect.WATER, 4).add(Aspect.FIRE, 4),
										  			  new ItemStack(RegisterItems.RESONATOR, 1, 0),
										  			  new Object[] {"plateGold",
										  					  		"gemQuartz"
										  		 	 }
									  			  )
								  		     );
		
	// recipe for the Thaumium Resonator:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":thaumium_resonator_recipe"), 
											  	  new ShapelessArcaneRecipe(gauntletGroup, 
										  			  "BETTERRESONATORS@2",
										  			  150,
										  			  new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
										  			  new ItemStack(RegisterItems.RESONATOR, 1, 1),
										  			  new Object[] {"plateThaumium",
										  					  		"gemQuartz"
										  		 	 }
									  			  )
								  		     );
		
	// infusion recipe for the activated Thaumium Resonator:
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":activated_thaumium_resonator_recipe"), 
												new InfusionRecipe(
													"BETTERRESONATORS@2",
													new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 0),
													5,
													new AspectList().add(Aspect.ORDER, 75).add(Aspect.AURA, 50).add(Aspect.MAGIC, 100),
													new ItemStack(RegisterItems.RESONATOR, 1, 1),
													new Object[] {
														new ItemStack(ItemsTC.salisMundus),
														new ItemStack(ItemsTC.salisMundus),
														new ItemStack(ItemsTC.salisMundus)
													}
												)
											);
	// recipe for the Void Metal Resonator:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":void_metal_resonator_recipe"), 
											  	  new ShapelessArcaneRecipe(gauntletGroup, 
										  			  "VOIDRESONATORS@1",
										  			  150,
										  			  new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
										  			  new ItemStack(RegisterItems.RESONATOR, 1, 2),
										  			  new Object[] {"plateVoid",
										  					  		"gemQuartz"
										  		 	 }
									  			  )
										     );
		
	// recipe for the activated Void Metal Resonator:
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":activated_void_metal_resonator_recipe"), 
												new InfusionRecipe(
													"VOIDRESONATORS@1",
													new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 1),
													6,
													new AspectList().add(Aspect.ORDER, 75).add(Aspect.AURA, 100).add(Aspect.MAGIC, 50),
													new ItemStack(RegisterItems.RESONATOR, 1, 2),
													new Object[] {
														new ItemStack(ItemsTC.salisMundus),
														new ItemStack(ItemsTC.salisMundus),
														new ItemStack(ItemsTC.salisMundus)
													}
												)
											);
	/*
	 * GAUNTLET RECIPES
	 */
	// recipe for the gold caster gauntlets:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":gold_caster_recipe"), 
											  	new CasterFactory.GoldCasterRecipe(gauntletGroup,
										  			"GOLDCASTERGAUNTLETS@3", 
									  				150, 
									  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
									  				new ItemStack (RegisterItems.GOLD_CASTER),
									  				new Object[] { "LCL", 
								  								   "LRL", 
								  								   "ETE", 
					  								   'C', new ItemStack(RegisterItems.COMPONENTS, 1, 0), 
					  								   'T', new ItemStack(ItemsTC.thaumometer), 
					  								   'R', "resonator",
					  								   'L', "leather", 
					  								   'E', new ItemStack(ItemsTC.fabric)
				  								   }
											  	)
										  	 );
		
	// recipe for the thaumium caster gauntlets:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":thaumium_caster_recipe"), 
			  	new CasterFactory.ThaumiumCasterRecipe(gauntletGroup,
		  			"THAUMIUMCASTERGAUNTLETS@4", 
	  				300, 
	  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
	  				new ItemStack(RegisterItems.THAUMIUM_CASTER),
	  				new Object[] { "LCL", 
  								   "LRL", 
  								   "ETE", 
						   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 0), 
						   'T', new ItemStack(ItemsTC.thaumometer), 
						   'R', "resonator",
						   'L', "leather", 
						   'E', new ItemStack(ItemsTC.fabric)
					   }
		  			)
				);
		
	//recipe for the void metal caster gauntlets:
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":void_metal_caster_recipe"), 
			  	new CasterFactory.VoidMetalCasterRecipe(gauntletGroup,
		  			"VOIDCASTERGAUNTLETS@3", 
	  				300, 
	  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
	  				new ItemStack(RegisterItems.VOID_METAL_CASTER),
	  				new Object[] { "LCL", 
  								   "LRL", 
  								   "ETE", 
						   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 1), 
						   'T', new ItemStack(ItemsTC.thaumometer), 
						   'R', "resonator",
						   'L', "leather", 
						   'E', new ItemStack(ItemsTC.fabric)
					   }
		  			)
				);
		
	/*
	 * FAKE CRAFTING RECIPES (for obscuring hidden research and clarifying recipes in the thaumonomicon)
	 */
		NBTTagCompound casterNBTTag = new NBTTagCompound();	//temporary variable to hold the compound NBT tag for the fake casters
		
		ItemStack fakeGoldCaster = new ItemStack(RegisterItems.GOLD_CASTER);
		casterNBTTag.setInteger("VisDiscount", 5);
		fakeGoldCaster.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_gold_caster_recipe"),
				new CasterFactory.GoldCasterRecipe(gauntletGroup,
			  			"GOLDCASTERGAUNTLETS@3", 
		  				150, 
		  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
		  				fakeGoldCaster,
		  				new Object[] { "LCL", 
	  								   "LRL", 
	  								   "ETE", 
							   'C', new ItemStack(RegisterItems.COMPONENTS, 1, 0), 
							   'T', new ItemStack(ItemsTC.thaumometer), 
							   'R', new ItemStack(ItemsTC.visResonator),
							   'L', "leather", 
							   'E', new ItemStack(ItemsTC.fabric)
						   }
				  	)
				);
		
		ItemStack fakeGoldCasterGoldRes = new ItemStack(RegisterItems.GOLD_CASTER);
		casterNBTTag.setInteger("VisDiscount", 5);
		casterNBTTag.setInteger("CooldownReduction", 5);
		fakeGoldCasterGoldRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_gold_caster_gold_resonator_recipe"),
				new CasterFactory.GoldCasterRecipe(gauntletGroup,
			  			"GOLDCASTERGAUNTLETS@3", 
		  				150, 
		  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
		  				fakeGoldCasterGoldRes,
		  				new Object[] { "LCL", 
	  								   "LRL", 
	  								   "ETE", 
							   'C', new ItemStack(RegisterItems.COMPONENTS, 1, 0), 
							   'T', new ItemStack(ItemsTC.thaumometer), 
							   'R', new ItemStack(RegisterItems.RESONATOR, 1, 0),
							   'L', "leather", 
							   'E', new ItemStack(ItemsTC.fabric)
						   }
				  	)
				);
		
		ItemStack fakeGoldCasterThaumRes = new ItemStack(RegisterItems.GOLD_CASTER);
		casterNBTTag.setInteger("VisDiscount", 10);
		casterNBTTag.setInteger("CooldownReduction", 10);
		fakeGoldCasterThaumRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_gold_caster_thaumium_resonator_recipe"),
				new CasterFactory.GoldCasterRecipe(gauntletGroup,
			  			"GOLDCASTERGAUNTLETS@3", 
		  				150, 
		  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
		  				fakeGoldCasterThaumRes,
		  				new Object[] { "LCL", 
	  								   "LRL", 
	  								   "ETE", 
							   'C', new ItemStack(RegisterItems.COMPONENTS, 1, 0), 
							   'T', new ItemStack(ItemsTC.thaumometer), 
							   'R', new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 0),
							   'L', "leather", 
							   'E', new ItemStack(ItemsTC.fabric)
						   }
				  	)
				);
		
		ItemStack fakeGoldCasterVoidRes = new ItemStack(RegisterItems.GOLD_CASTER);
		casterNBTTag.setInteger("VisDiscount", 5);
		casterNBTTag.setInteger("CooldownReduction", 20);
		fakeGoldCasterVoidRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_gold_caster_void_metal_resonator_recipe"),
				new CasterFactory.GoldCasterRecipe(gauntletGroup,
			  			"GOLDCASTERGAUNTLETS@3", 
		  				150, 
		  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
		  				fakeGoldCasterVoidRes,
		  				new Object[] { "LCL", 
	  								   "LRL", 
	  								   "ETE", 
							   'C', new ItemStack(RegisterItems.COMPONENTS, 1, 0), 
							   'T', new ItemStack(ItemsTC.thaumometer), 
							   'R', new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 1),
							   'L', "leather", 
							   'E', new ItemStack(ItemsTC.fabric)
						   }
				  	)
				);
		
		ItemStack fakeThaumiumCaster = new ItemStack(RegisterItems.THAUMIUM_CASTER);
		casterNBTTag.setInteger("VisDiscount", 10);
		casterNBTTag.setInteger("CooldownReduction", 0);
		fakeThaumiumCaster.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_thaumium_caster_recipe"),
				new CasterFactory.GoldCasterRecipe(gauntletGroup,
			  			"THAUMIUMCASTERGAUNTLETS@4", 
		  				300, 
		  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
		  				fakeThaumiumCaster,
		  				new Object[] { "LCL", 
	  								   "LRL", 
	  								   "ETE", 
							   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 0), 
							   'T', new ItemStack(ItemsTC.thaumometer), 
							   'R', new ItemStack(ItemsTC.visResonator),
							   'L', "leather", 
							   'E', new ItemStack(ItemsTC.fabric)
						   }
				  	)
				);
		
		ItemStack fakeThaumiumCasterGoldRes = new ItemStack(RegisterItems.THAUMIUM_CASTER);
		casterNBTTag.setInteger("VisDiscount", 10);
		casterNBTTag.setInteger("CooldownReduction", 5);
		fakeThaumiumCasterGoldRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_thaumium_caster_gold_resonator_recipe"),
				new CasterFactory.GoldCasterRecipe(gauntletGroup,
			  			"THAUMIUMCASTERGAUNTLETS@4", 
		  				300, 
		  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
		  				fakeThaumiumCasterGoldRes,
		  				new Object[] { "LCL", 
	  								   "LRL", 
	  								   "ETE", 
							   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 0), 
							   'T', new ItemStack(ItemsTC.thaumometer), 
							   'R', new ItemStack(RegisterItems.RESONATOR, 1, 0),
							   'L', "leather", 
							   'E', new ItemStack(ItemsTC.fabric)
						   }
				  	)
				);
		
		ItemStack fakeThaumiumCasterThaumRes = new ItemStack(RegisterItems.THAUMIUM_CASTER);
		casterNBTTag.setInteger("VisDiscount", 15);
		casterNBTTag.setInteger("CooldownReduction", 10);
		fakeThaumiumCasterThaumRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_thaumium_caster_thaumium_resonator_recipe"),
				new CasterFactory.GoldCasterRecipe(gauntletGroup,
			  			"THAUMIUMCASTERGAUNTLETS@4", 
		  				300, 
		  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
		  				fakeThaumiumCasterThaumRes,
		  				new Object[] { "LCL", 
	  								   "LRL", 
	  								   "ETE", 
							   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 0), 
							   'T', new ItemStack(ItemsTC.thaumometer), 
							   'R', new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 0),
							   'L', "leather", 
							   'E', new ItemStack(ItemsTC.fabric)
						   }
				  	)
				);
		
		ItemStack fakeThaumiumCasterVoidRes = new ItemStack(RegisterItems.THAUMIUM_CASTER);
		casterNBTTag.setInteger("VisDiscount", 10);
		casterNBTTag.setInteger("CooldownReduction", 20);
		fakeThaumiumCasterVoidRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_thaumium_caster_void_metal_resonator_recipe"),
				new CasterFactory.GoldCasterRecipe(gauntletGroup,
			  			"THAUMIUMCASTERGAUNTLETS@4", 
		  				300, 
		  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
		  				fakeThaumiumCasterVoidRes,
		  				new Object[] { "LCL", 
	  								   "LRL", 
	  								   "ETE", 
							   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 0), 
							   'T', new ItemStack(ItemsTC.thaumometer), 
							   'R', new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 1),
							   'L', "leather", 
							   'E', new ItemStack(ItemsTC.fabric)
						   }
				  	)
				);
		
		ItemStack fakeVoidCaster = new ItemStack(RegisterItems.VOID_METAL_CASTER);
		casterNBTTag.setInteger("VisDiscount", 5);
		casterNBTTag.setInteger("CooldownReduction", 10);
		casterNBTTag.setInteger("Warping", 1);
		fakeVoidCaster.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_void_metal_caster_recipe"), 
			  	new CasterFactory.VoidMetalCasterRecipe(gauntletGroup,
		  			"VOIDCASTERGAUNTLETS@3", 
	  				300, 
	  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
	  				fakeVoidCaster,
	  				new Object[] { "LCL", 
  								   "LRL", 
  								   "ETE", 
						   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 1), 
						   'T', new ItemStack(ItemsTC.thaumometer), 
						   'R', new ItemStack(ItemsTC.visResonator),
						   'L', "leather", 
						   'E', new ItemStack(ItemsTC.fabric)
					   }
		  			)
				);
		
		ItemStack fakeVoidCasterGoldRes = new ItemStack(RegisterItems.VOID_METAL_CASTER);
		casterNBTTag.setInteger("VisDiscount", 5);
		casterNBTTag.setInteger("CooldownReduction", 15);
		casterNBTTag.setInteger("Warping", 1);
		fakeVoidCasterGoldRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_void_metal_caster_gold_resonator_recipe"), 
			  	new CasterFactory.VoidMetalCasterRecipe(gauntletGroup,
		  			"VOIDCASTERGAUNTLETS@3", 
	  				300, 
	  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
	  				fakeVoidCasterGoldRes,
	  				new Object[] { "LCL", 
  								   "LRL", 
  								   "ETE", 
						   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 1), 
						   'T', new ItemStack(ItemsTC.thaumometer), 
						   'R', new ItemStack(RegisterItems.RESONATOR, 1, 0),
						   'L', "leather", 
						   'E', new ItemStack(ItemsTC.fabric)
					   }
		  			)
				);
		
		ItemStack fakeVoidCasterThaumRes = new ItemStack(RegisterItems.VOID_METAL_CASTER);
		casterNBTTag.setInteger("VisDiscount", 10);
		casterNBTTag.setInteger("CooldownReduction", 20);
		casterNBTTag.setInteger("Warping", 1);
		fakeVoidCasterThaumRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_void_metal_caster_thaumium_resonator_recipe"), 
			  	new CasterFactory.VoidMetalCasterRecipe(gauntletGroup,
		  			"VOIDCASTERGAUNTLETS@3", 
	  				300, 
	  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
	  				fakeVoidCasterThaumRes,
	  				new Object[] { "LCL", 
  								   "LRL", 
  								   "ETE", 
						   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 1), 
						   'T', new ItemStack(ItemsTC.thaumometer), 
						   'R', new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 0),
						   'L', "leather", 
						   'E', new ItemStack(ItemsTC.fabric)
					   }
		  			)
				);
		
		ItemStack fakeVoidCasterVoidRes = new ItemStack(RegisterItems.VOID_METAL_CASTER);
		casterNBTTag.setInteger("VisDiscount", 5);
		casterNBTTag.setInteger("CooldownReduction", 30);
		casterNBTTag.setInteger("Warping", 1);
		fakeVoidCasterVoidRes.setTagCompound(casterNBTTag);
		ThaumcraftApi.addFakeCraftingRecipe(new ResourceLocation(Reference.MOD_ID + ":fake_void_metal_caster_void_metal_resonator_recipe"), 
			  	new CasterFactory.VoidMetalCasterRecipe(gauntletGroup,
		  			"VOIDCASTERGAUNTLETS@3", 
	  				300, 
	  				new AspectList().add(Aspect.AIR, 8).add(Aspect.EARTH, 8).add(Aspect.WATER, 8).add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENTROPY, 8),
	  				fakeVoidCasterVoidRes,
	  				new Object[] { "LCL", 
  								   "LRL", 
  								   "ETE", 
						   'C', new ItemStack(RegisterItems.COMPONENTS_ACTIVATED, 1, 1), 
						   'T', new ItemStack(ItemsTC.thaumometer), 
						   'R', new ItemStack(RegisterItems.RESONATOR_ACTIVATED, 1, 1),
						   'L', "leather", 
						   'E', new ItemStack(ItemsTC.fabric)
					   }
		  			)
				);
		
	}
}

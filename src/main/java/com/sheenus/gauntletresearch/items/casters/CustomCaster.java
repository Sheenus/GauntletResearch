package com.sheenus.gauntletresearch.items.casters;

import com.google.common.collect.Multimap;
import com.sheenus.gauntletresearch.init.RegisterItems;
import com.sheenus.gauntletresearch.items.ICooldownReductionGear;
import com.sheenus.gauntletresearch.util.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.relauncher.Side;
import thaumcraft.api.casters.FocusEngine;
import thaumcraft.api.casters.FocusPackage;
import thaumcraft.api.casters.IFocusBlockPicker;
import thaumcraft.api.casters.IFocusElement;
import thaumcraft.api.items.IVisDiscountGear;
import thaumcraft.api.items.IWarpingGear;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.casters.CasterManager;
import thaumcraft.common.items.casters.ItemCaster;
import thaumcraft.common.items.casters.ItemFocus;

public class CustomCaster extends ItemCaster implements IVisDiscountGear, ICooldownReductionGear, IWarpingGear {
	
	protected int VISDISCOUNT;
	protected int CDREDUCTION;
	protected int WARPING;
	
	public CustomCaster (String name, int area, int visDisc, int cdRed, int warping) {
		super(name, area);
		this.VISDISCOUNT = visDisc;
		this.CDREDUCTION = cdRed;
		this.WARPING = warping;
	}
	
	public String getName() {
		return this.BASE_NAME;
	}
	
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> items) {
		if (tab == ConfigItems.TABTC || tab == CreativeTabs.SEARCH) {
			ItemStack caster = new ItemStack(this);
			NBTTagCompound casterNBTTag = new NBTTagCompound();
			
			casterNBTTag.setInteger("VisDiscount", this.VISDISCOUNT);
			casterNBTTag.setInteger("CooldownReduction", this.CDREDUCTION);
			casterNBTTag.setInteger("Warping", this.WARPING);
			
			caster.setTagCompound(casterNBTTag);
			
			items.add(caster);
		}
	}
		
	@Override
	public int getVisDiscount(ItemStack stack, EntityPlayer player) {
		
		if (stack.getTagCompound().hasKey("VisDiscount")) {
			int discount = stack.getTagCompound().getInteger("VisDiscount");
			return discount;
		}
		else return 0;
	}

	@Override
	public int getCooldownReduction(ItemStack stack) {
		
		if (stack.getTagCompound().hasKey("CooldownReduction")) {
			int reduction = stack.getTagCompound().getInteger("CooldownReduction");
			return reduction;
		}
		else return 0;
	}
	
	@Override
	public int getWarp(ItemStack stack, EntityPlayer player) {
		if (stack.getTagCompound().hasKey("Warping")) {
			int warping = stack.getTagCompound().getInteger("Warping");
			return warping;
		}
		else return 0;
	}
	
	// A modified onItemRightClick function for the casters to take advantage of the cooldown reduction mechanic this mod adds.
	
	 public ActionResult<ItemStack> onItemRightClick(final World world, final EntityPlayer player, final EnumHand hand) {
        final ItemStack focusStack = this.getFocusStack(player.getHeldItem(hand));
        final ItemFocus focus = this.getFocus(player.getHeldItem(hand));
        if (focus == null || CasterManager.isOnCooldown((EntityLivingBase)player)) {
        	return (ActionResult<ItemStack>)super.onItemRightClick(world, player, hand);
        }
        CustomCasterManager.setCooldown((EntityLivingBase)player, (int)(focus.getActivationTime(focusStack) * getCooldownModifier(player)));
        final FocusPackage core = ItemFocus.getPackage(focusStack);
        if (player.isSneaking()) {
            for (final IFocusElement fe : core.nodes) {
                if (fe instanceof IFocusBlockPicker && player.isSneaking()) {
                    return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.PASS, (Object)player.getHeldItem(hand));
                }
            }
        }
        if (world.isRemote) {
            return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.SUCCESS, (Object)player.getHeldItem(hand));
        }
        if (this.consumeVis(player.getHeldItem(hand), player, focus.getVisCost(focusStack), false, false)) {
            FocusEngine.castFocusPackage((EntityLivingBase)player, core);
            player.swingArm(hand);
            return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.SUCCESS, (Object)player.getHeldItem(hand));
        }
        return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.FAIL, (Object)player.getHeldItem(hand));
     }
	 
	 public float getConsumptionModifier(final ItemStack is, final EntityPlayer player, final boolean crafting) {
	        float consumptionModifier = 1.0f;
	        if (player != null) 
	        	{ consumptionModifier -= CustomCasterManager.getTotalVisDiscount(player); }
	        return Math.max(consumptionModifier, 0.1f);
	 }
	        
     public float getCooldownModifier (final EntityPlayer player) {
    	 	float cooldownModifier = 1.0f;
        	if (player != null) 
        		{ cooldownModifier -= CustomCasterManager.getTotalCooldownReduction(player); }
        	return Math.max(cooldownModifier, 0.1f);       		
	 }
}

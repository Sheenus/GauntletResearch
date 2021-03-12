package com.sheenus.gauntletresearch.items.casters;

import java.util.HashMap;

import com.sheenus.gauntletresearch.items.ICooldownReductionGear;

import baubles.api.BaublesApi;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import thaumcraft.api.items.IVisDiscountGear;
import thaumcraft.api.potions.PotionVisExhaust;
import thaumcraft.common.items.casters.CasterManager;
import thaumcraft.common.items.casters.ItemCaster;
import thaumcraft.common.lib.potions.PotionInfectiousVisExhaust;

public class CustomCasterManager extends CasterManager {
	
	//player cooldown hashmaps; one for the virtual server and one for the virtual client.
	static HashMap<Integer,Long> cooldownServer = new HashMap<Integer, Long>();
    static HashMap<Integer,Long> cooldownClient = new HashMap<Integer, Long>();
    
    /*
     * calculates the total vis discount from all pieces of gear a player has equipped (including main-hand and off-hand items, something ol' Az forgot to do), as well as factor in if the player has Flux flu/flux Phage.
     */
    public static float getTotalVisDiscount(final EntityPlayer player) {
        int totalDiscount = 0;
    // check that the function is being performed on a player (other entities aren't special enough to get the reduction!)
        if (player == null) { return (float)totalDiscount; }
    // check the baubles for IVisDiscountGear
        final IInventory baubles = BaublesApi.getBaubles(player);
        for (int a = 0; a < baubles.getSizeInventory(); ++a) {
            if (baubles.getStackInSlot(a) != null && baubles.getStackInSlot(a).getItem() instanceof IVisDiscountGear) {
                totalDiscount += ((IVisDiscountGear)baubles.getStackInSlot(a).getItem()).getVisDiscount(baubles.getStackInSlot(a), player);
            }
        }
    // check armor for IVisDiscountGear
        for (int a = 0; a < 4; ++a) {
            if (((ItemStack)player.inventory.armorInventory.get(a)).getItem() instanceof IVisDiscountGear) {
                totalDiscount += ((IVisDiscountGear)((ItemStack)player.inventory.armorInventory.get(a)).getItem()).getVisDiscount((ItemStack)player.inventory.armorInventory.get(a), player);
            }
        }
     // check main hand and off-hand for relevant IVisDiscountGear (basically just the gauntlets), and apply the highest value
        int MHDiscount = 0;
        int OHDiscount = 0;
        
        if ((player.inventory.mainInventory.get(player.inventory.currentItem).getItem() instanceof IVisDiscountGear) && (player.inventory.mainInventory.get(player.inventory.currentItem).getItem() instanceof ItemCaster)) {
        	MHDiscount = ((IVisDiscountGear)player.inventory.mainInventory.get(player.inventory.currentItem).getItem()).getVisDiscount(player.inventory.mainInventory.get(player.inventory.currentItem), player);
        }
        
        if ((player.inventory.offHandInventory.get(0).getItem() instanceof IVisDiscountGear) && (player.inventory.offHandInventory.get(0).getItem() instanceof ItemCaster)) {
        	OHDiscount = ((IVisDiscountGear)player.inventory.offHandInventory.get(0).getItem()).getVisDiscount(player.inventory.offHandInventory.get(0), player);
        }
        totalDiscount += Math.max(MHDiscount, OHDiscount);  
    // checks to see if the player has Flux Flu or Flux Phage
        if (player.isPotionActive(PotionVisExhaust.instance) || player.isPotionActive(PotionInfectiousVisExhaust.instance)) {
            int level1 = 0;
            int level2 = 0;
            if (player.isPotionActive(PotionVisExhaust.instance)) {
                level1 = player.getActivePotionEffect(PotionVisExhaust.instance).getAmplifier();
            }
            if (player.isPotionActive(PotionInfectiousVisExhaust.instance)) {
                level2 = player.getActivePotionEffect(PotionInfectiousVisExhaust.instance).getAmplifier();
            }
            totalDiscount -= (Math.max(level1, level2) + 1) * 10;
        }
     // return the calculated total cooldown reduction, converting to a decimal value (for later calculation)
        return totalDiscount / 100.0f;
    }
    
    /*
     *  calculates the total cooldown reduction from all pieces of gear a player has equipped; including main-hand and off-hand items.
     */
    public static float getTotalCooldownReduction(final EntityPlayer player) {
    	int totalReduction = 0;
    	// check that the function is being performed on a player (other entities aren't special enough to get the reduction!)
    	if (player == null) { return (float)totalReduction; }
    	// check the baubles for ICooldownReductionGear
    	final IInventory baubles = BaublesApi.getBaubles(player);
        for (int a = 0; a < baubles.getSizeInventory(); ++a) {
            if (baubles.getStackInSlot(a) != null && baubles.getStackInSlot(a).getItem() instanceof ICooldownReductionGear) {
                totalReduction += ((ICooldownReductionGear)baubles.getStackInSlot(a).getItem()).getCooldownReduction(baubles.getStackInSlot(a));
            }
        }
    // check armor for ICooldownReductionGear
        for (int a = 0; a < 4; ++a) {
            if (((ItemStack)player.inventory.armorInventory.get(a)).getItem() instanceof ICooldownReductionGear) {
                totalReduction += ((ICooldownReductionGear)((ItemStack)player.inventory.armorInventory.get(a)).getItem()).getCooldownReduction(player.inventory.armorInventory.get(a));
            }
        }        
     // check main hand and off-hand for relevant ICooldownReductionGear (basically just the gauntlets), and apply the highest value
        int MHReduction = 0;
        int OHReduction = 0;
        
        if ((player.inventory.mainInventory.get(player.inventory.currentItem).getItem() instanceof ICooldownReductionGear) && (player.inventory.mainInventory.get(player.inventory.currentItem).getItem() instanceof ItemCaster)) {
        	MHReduction = ((ICooldownReductionGear)player.inventory.mainInventory.get(player.inventory.currentItem).getItem()).getCooldownReduction(player.inventory.mainInventory.get(player.inventory.currentItem));
        }
        
        if ((player.inventory.offHandInventory.get(0).getItem() instanceof IVisDiscountGear) && (player.inventory.offHandInventory.get(0).getItem() instanceof ItemCaster)) {
        	OHReduction = ((ICooldownReductionGear)player.inventory.offHandInventory.get(0).getItem()).getCooldownReduction(player.inventory.offHandInventory.get(0));
        }
        totalReduction += Math.max(MHReduction, OHReduction);
    // return the calculated total cooldown reduction, converting to a decimal value (for later calculation)
    	return totalReduction / 100.0f;
    }
    
    // sets the cooldown for the gauntlets (and adds the player to the regular gauntlet hashmap to prevent gauntlet dual-wielding)
    public static void setCooldown(final EntityLivingBase player, final int cooldown) {
    	
        if (player.world.isRemote) { 
        	
        	cooldownClient.put(player.getEntityId(), System.currentTimeMillis() + cooldown * 50); 
        }
        else { 
        	cooldownServer.put(player.getEntityId(), System.currentTimeMillis() + cooldown * 50); 
        }
        CasterManager.setCooldown(player, cooldown);
    }
    
    public static float getCooldown(final EntityLivingBase player) {
    	
    	
    	float oldGauntletsCooldownTime = CasterManager.getCooldown(player);
    	float newGauntletsCooldownTime;
    	
        if (player.world.isRemote && cooldownClient.containsKey(player.getEntityId())) {
        	newGauntletsCooldownTime = cooldownClient.get(player.getEntityId()) - System.currentTimeMillis();
        }
        else if (!player.world.isRemote && cooldownServer.containsKey(player.getEntityId())) {
        	newGauntletsCooldownTime = cooldownServer.get(player.getEntityId()) - System.currentTimeMillis();
        }
        else newGauntletsCooldownTime = 0.0f;
        
        float cooldown = ( newGauntletsCooldownTime > oldGauntletsCooldownTime ? newGauntletsCooldownTime : oldGauntletsCooldownTime );
        System.out.println("current cooldown for " + player.getName().toString() + " is " + cooldown + "sec.");
        return cooldown;
    }

	public static boolean isOnCooldown(final EntityLivingBase player) {
		
		float cooldown = getCooldown(player);
		// System.out.println("current cooldown for " + player.getName().toString() + " is " + cooldown + "sec.");
		return cooldown > 0.0f;
	} 
}
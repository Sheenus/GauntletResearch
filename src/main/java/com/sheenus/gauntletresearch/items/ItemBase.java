package com.sheenus.gauntletresearch.items;

import com.sheenus.gauntletresearch.init.RegisterItems;
import com.sheenus.gauntletresearch.util.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import thaumcraft.common.config.ConfigItems;

public class ItemBase extends Item {
	
	protected String NAME;
	protected String[] TYPES;
	protected int[] TYPES_META;
	
	public ItemBase(String name, String... types ) {
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(ConfigItems.TABTC);
		this.setHasSubtypes(types.length > 1);
		
		this.NAME = name;
		
		// System.out.println("The state of " + NAME + "'s hasSubtypes value is" + this.getHasSubtypes());
		
		if (types.length == 0) {
			this.TYPES = new String[] { name };
		}
		else {
			this.TYPES = types;
		}
		
		this.TYPES_META = new int[this.TYPES.length];
        for (int meta = 0; meta < this.TYPES.length; ++meta) {
            this.TYPES_META[meta] = meta;
		}
		
		RegisterItems.ITEM_LIST.add(this);
	}
	
	@Override
	public String getUnlocalizedName(final ItemStack item) {
        if (this.hasSubtypes && item.getMetadata() < this.TYPES.length && this.TYPES[item.getMetadata()] != this.NAME) {
            return String.format(super.getUnlocalizedName() + ".%s", this.TYPES[item.getMetadata()]);
        }
        else return super.getUnlocalizedName(item);
	}
	
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> items) {
        if (tab == ConfigItems.TABTC || tab == CreativeTabs.SEARCH) {
            if (!this.getHasSubtypes()) {
                super.getSubItems(tab, (NonNullList)items);
            }
            else {
                for (int meta = 0; meta < this.TYPES.length; ++meta) {
                    items.add(new ItemStack((Item)this, 1, meta));
                }
            }
        }
    }
	
	public String getName() {
		return this.NAME;
	}
	
	public String[] getItemTypes() {
		return this.TYPES;
	}
	
	public int[] getItemTypesMeta() {
		return this.TYPES_META;
	}
	
	// creates a custom model ResourceLocation based in the target object.
	public ModelResourceLocation getCustomModelResourceLocation(final String variant) {
		
		if (variant.equals(this.NAME)) {
			return new ModelResourceLocation(Reference.MOD_ID + ":" + this.NAME);
		}
		else return new ModelResourceLocation(Reference.MOD_ID + ":" + this.NAME, variant);
	}
}

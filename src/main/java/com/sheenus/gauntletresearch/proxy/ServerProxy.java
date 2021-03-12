package com.sheenus.gauntletresearch.proxy;

import com.sheenus.gauntletresearch.init.RegisterResearch;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerProxy implements IProxy {
	
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        
    }

    @Override
    public void init(FMLInitializationEvent e) {
    	RegisterResearch.initResearch();    
    	
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
    	
    }

	@Override
	public void serverStarting(FMLServerStartingEvent event) {
		
		//event.registerServerCommand(new CommandStructureCapture());
	}

	@Override
	public EntityPlayer getPlayerEntityFromContext(MessageContext context) {
		
		return context.getServerHandler().player;
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		
	}
}

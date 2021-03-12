package com.sheenus.gauntletresearch.proxy;

import com.sheenus.gauntletresearch.init.RegisterResearch;
import com.sheenus.gauntletresearch.util.ColorHandler;
import com.sheenus.gauntletresearch.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MouseHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import thaumcraft.common.lib.research.ResearchManager;


@EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
public class ClientProxy implements IProxy {
	
	// mouse helper
    public static MouseHelper mouseHelperAI = new MouseHelper();
	
	@Override
    public void preInit(FMLPreInitializationEvent event) {
		
		// DEBUG
        //System.out.println("Pre-initialization event on Client side");
        
        Minecraft.getMinecraft().mouseHelper = ClientProxy.mouseHelperAI;

    }

    @Override
    public void init(FMLInitializationEvent event) {
        ColorHandler.registerColorHandlers();
        RegisterResearch.initResearch();
    	
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
    }

	@Override
	public void serverStarting(FMLServerStartingEvent event) {
	}

	@Override
	public EntityPlayer getPlayerEntityFromContext(MessageContext context) {
		
		// need to make sure we return right player object, so need to check context for being on the right side:
		
		return (context.side.isClient() ? Minecraft.getMinecraft().player : context.getServerHandler().player);
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}

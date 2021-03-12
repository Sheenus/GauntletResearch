package com.sheenus.gauntletresearch;

import javax.swing.text.Utilities;

import com.sheenus.gauntletresearch.proxy.IProxy;
import com.sheenus.gauntletresearch.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, 
	name = Reference.NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, 
	dependencies = Reference.DEPENDANCY)
public class Main {

	@Instance
	public static Main instance = new Main();
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		
		//debug
		// System.out.println("preInit() " + event.getModMetadata().name);	
		
		proxy.preInit(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		// DEBUG
        // System.out.println("init()");
		
		proxy.init(event);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
		proxy.postInit(event);
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		
		//debug
		// System.out.println("Server starting");
		
		proxy.serverStarting(event);
	}
}

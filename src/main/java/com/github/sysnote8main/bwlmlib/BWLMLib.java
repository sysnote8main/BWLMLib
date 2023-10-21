package com.github.sysnote8main.bwlmlib;

import com.github.sysnote8main.bwlmlib.manager.ItemManager;
import com.github.sysnote8main.bwlmlib.proxy.CommonProxy;
import com.github.sysnote8main.bwlmlib.util.MyLog;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.modid, version = Tags.version, name = Tags.modname, acceptedMinecraftVersions = "[1.12.2]")
public class BWLMLib {
    @SidedProxy(clientSide = "com.github.sysnote8main.bwlmlib.proxy.ClientProxy", serverSide = "com.github.sysnote8main.bwlmlib.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc. (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        // register to the event bus so that we can listen to events
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerTileEntity();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        ItemManager.register(event.getRegistry());
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ItemManager.registerModels();
    }
}

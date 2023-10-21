package com.github.sysnote8main.bwlmlib.proxy;

import com.github.sysnote8main.bwlmlib.manager.TileEntityManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {
    @Override
    public World getClientWorld() {
        return FMLClientHandler.instance().getClient().world;
    }

    @Override
    public void registerTileEntity() {
        TileEntityManager.ClientTileEntityRegister();
    }
}

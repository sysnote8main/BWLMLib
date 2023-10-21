package com.github.sysnote8main.bwlmlib.proxy;

import net.minecraft.world.World;
import com.github.sysnote8main.bwlmlib.manager.TileEntityManager;

public class CommonProxy {
    public World getClientWorld() {
        return null;
    }
    public void registerTileEntity() {
        TileEntityManager.TileEntityRegister();
    }
}

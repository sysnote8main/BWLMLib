package com.github.sysnote8main.bwlmlib.manager;

public class TileEntityManager {
    public static void TileEntityRegister() {
        // Common Tile Entity
        // GameRegistry.registerTileEntity
    }
    public static void ClientTileEntityRegister() {
        // Call common tile entity register
        TileEntityRegister();
        // Client only Render
        // ClientRegistry.registerTileEntity
    }
}

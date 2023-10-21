package com.github.sysnote8main.bwlmlib.manager;

import com.github.sysnote8main.bwlmlib.item.HeartShard;
import com.github.sysnote8main.bwlmlib.item.ItemBase;
import com.github.sysnote8main.bwlmlib.item.TestItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static final List<ItemBase> items = new ArrayList<>();
    static {
        // Items add to list
        items.add(new TestItem());
        items.add(new HeartShard());
    }
    public static void register(IForgeRegistry<Item> registry) {
        // Register items
        for (ItemBase item : items) {
            registry.register(item);
        }
    }

    public static void registerModels() {
        // Register item models
        for (ItemBase item : items) {
            item.ModelRegister();
        }
    }
}
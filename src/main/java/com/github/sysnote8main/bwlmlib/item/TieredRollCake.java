package com.github.sysnote8main.bwlmlib.item;

import com.github.sysnote8main.bwlmlib.api.ItemId;
import com.github.sysnote8main.bwlmlib.util.MainConfig;
import net.blacklab.lmr.entity.littlemaid.EntityLittleMaid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TieredRollCake {
    public static class LittleHappyRollCake extends MaidItemBase {
        public LittleHappyRollCake() {
            super(ItemId.RollCake.LittleHappy);
        }

        @Override
        public boolean onSugarInteract(World world, EntityPlayer player, ItemStack stack, EntityLittleMaid maid) {
            maid.addMaidExperience(MainConfig.ExpBoxTier.tier1);
            return true;
        }
    }
    public static class HappyRollCake extends MaidItemBase {
        public HappyRollCake() {
            super(ItemId.RollCake.Happy);
        }

        @Override
        public boolean onSugarInteract(World world, EntityPlayer player, ItemStack stack, EntityLittleMaid maid) {
            maid.addMaidExperience(MainConfig.ExpBoxTier.tier2);
            return true;
        }
    }
    public static class SuperHappyRollCake extends MaidItemBase {
        public SuperHappyRollCake() {
            super(ItemId.RollCake.SuperHappy);
        }
        @Override
        public boolean onSugarInteract(World world, EntityPlayer player, ItemStack stack, EntityLittleMaid maid) {
            maid.addMaidExperience(MainConfig.ExpBoxTier.tier3);
            return true;
        }
    }
    public static class HyperHappyRollCake extends MaidItemBase {
        public HyperHappyRollCake() {
            super(ItemId.RollCake.HyperHappy);
        }
        @Override
        public boolean onSugarInteract(World world, EntityPlayer player, ItemStack stack, EntityLittleMaid maid) {
            maid.addMaidExperience(MainConfig.ExpBoxTier.tier4);
            return true;
        }
    }
    public static class UltraHappyRollCake extends MaidItemBase {
        public UltraHappyRollCake() {
            super(ItemId.RollCake.UltraHappy);
        }
        @Override
        public boolean onSugarInteract(World world, EntityPlayer player, ItemStack stack, EntityLittleMaid maid) {
            maid.addMaidExperience(MainConfig.ExpBoxTier.tier5);
            return true;
        }
    }
}

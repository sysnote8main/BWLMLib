package com.github.sysnote8main.bwlmlib.item;

import com.github.sysnote8main.bwlmlib.api.ItemId;
import net.blacklab.lmr.api.item.IItemSpecialSugar;
import net.blacklab.lmr.entity.littlemaid.EntityLittleMaid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HeartShard extends ItemBase implements IItemSpecialSugar {
    public HeartShard() {
        super(ItemId.Heart_Shard);
    }

    @Override
    public boolean onSugarInteract(World world, EntityPlayer player, ItemStack stack, EntityLittleMaid maid) {
        float prevHP = maid.getHealth();
        maid.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(maid.getMaxHealth()+2f);
        maid.setHealth(prevHP);
        return true;
    }
}

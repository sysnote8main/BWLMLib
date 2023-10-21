package com.github.sysnote8main.bwlmlib.mixin;

import com.github.sysnote8main.bwlmlib.util.MainConfig;
import net.blacklab.lmr.entity.littlemaid.EntityLittleMaid;
import net.blacklab.lmr.entity.littlemaid.controller.LMExperienceController;
import net.minecraft.client.main.Main;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.UUID;

@Mixin(LMExperienceController.class)
public class LMExpControllerMixin {

    @Shadow protected EntityLittleMaid theMaid;

    @Shadow @Final private static String uuidString;

    @Shadow @Final public static UUID NX_EXP_HP_BOOSTER;

    /**
     * @author sysnote8
     * @reason To change modify amount from config.
     */
    @Overwrite
    public void onLevelUp(int level) {
        double modifyamount = 0;
        double prevamount = 0;
        if (level > MainConfig.HealthModifier.tier1_level) {
            modifyamount += (double) (Math.min(level, MainConfig.HealthModifier.tier2_level) - MainConfig.HealthModifier.tier1_level) / MainConfig.HealthModifier.tier1_divisor;
        }
        if (level > MainConfig.HealthModifier.tier2_level) {
            modifyamount += MathHelper.floor((Math.min(level, MainConfig.HealthModifier.tier3_level)-MainConfig.HealthModifier.tier2_level)/MainConfig.HealthModifier.tier2_divisor);
        }
        if (level > MainConfig.HealthModifier.tier3_level) {
            modifyamount += MathHelper.floor((Math.min(level, MainConfig.HealthModifier.tier4_level)-MainConfig.HealthModifier.tier3_level)/MainConfig.HealthModifier.tier3_divisor);
        }
        if (level > MainConfig.HealthModifier.tier4_level) {
            modifyamount += (double) (Math.min(level, MainConfig.HealthModifier.tier_level_max) - MainConfig.HealthModifier.tier4_level) / MainConfig.HealthModifier.tier4_divisor;
        }
        IAttributeInstance maxHPattr = theMaid.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
        AttributeModifier existedMod = maxHPattr.getModifier(NX_EXP_HP_BOOSTER);
        if (existedMod != null) {
            prevamount = existedMod.getAmount();
        }
        if (modifyamount != 0 || prevamount < modifyamount) {
            // Modifier書き換え
            float prevHP = theMaid.getHealth();
            AttributeModifier maxHPmod = new AttributeModifier(NX_EXP_HP_BOOSTER, uuidString, modifyamount, 0);
            if (existedMod != null) {
                maxHPattr.removeModifier(existedMod);
            }
            maxHPattr.applyModifier(maxHPmod);
            theMaid.setHealth(prevHP);
        }
    }
}

package com.nekomaster1000.secondchanceforge;

import com.nekomaster1000.secondchanceforge.config.SecondChanceConfig;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = SecondChanceForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SecondChanceEvents {

    // Called when an entity takes damage
    @SubscribeEvent
    public void onEntityDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntityLiving();
        DamageSource source = event.getSource();

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if (SecondChanceConfig.CONFIG.secondChanceEnabled.get() && (source.isExplosion() || source.getDamageType().equals("mob")) && player.getHealth() <= event.getAmount() && player.getHealth() >= 13.5F) {
                if (SecondChanceConfig.CONFIG.secondChanceSound.get()) {
                    player.getEntityWorld().playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SecondChanceSoundEvents.CLASSIC_HURT.get(), SoundCategory.PLAYERS, 2.0F, 1.0F);
                }
                event.setAmount(player.getHealth() - 1.0F);
            }
        }
    }

}

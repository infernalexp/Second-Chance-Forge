package com.nekomaster1000.secondchanceforge;

import com.nekomaster1000.secondchanceforge.config.SecondChanceConfig;

import com.nekomaster1000.secondchanceforge.config.gui.ConfigScreen;
import net.minecraftforge.fml.ExtensionPoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SecondChanceForge.MOD_ID)
public class SecondChanceForge {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "secondchanceforge";

    public SecondChanceForge() {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new SecondChanceEvents());

        SecondChanceSoundEvents.register(modEventBus);

        // Registering Configs
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, SecondChanceConfig.CONFIG_SPEC);

        // Registering Config GUI Extension Point
        modLoadingContext.registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () -> (mc, screen) -> new ConfigScreen());
    }
}
package org.infernalstudios.secondchanceforge;

import net.minecraftforge.client.ConfigScreenHandler;
import org.infernalstudios.secondchanceforge.config.gui.ConfigScreen;
import net.minecraftforge.fml.ModLoadingContext;

public class SecondChanceClient {

	public static void init() {
		// Registering Config GUI Extension Point
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory(((minecraft, screen) -> new ConfigScreen())));
	}

}

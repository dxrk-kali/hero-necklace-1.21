package net.arsic.heronecklace;

import net.arsic.heronecklace.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeroNecklace implements ModInitializer {
	public static final String MOD_ID = "heronecklace";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}

}
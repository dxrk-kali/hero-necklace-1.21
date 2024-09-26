package net.arsic.heronecklace.effect;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.arsic.heronecklace.HeroNecklace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModEffects implements ModInitializer {

    // Logger for logging info in the console
    public static final Logger LOGGER = LoggerFactory.getLogger(HeroNecklace.MOD_ID);

    // Declare your SapphireEffect as a public static variable
    public static StatusEffect SAPPHIRE_EFFECT;
    public static StatusEffect AMETHYST_EFFECT;
    public static StatusEffect RUBY_EFFECT;
    public static StatusEffect PINKSPINEL_EFFECT;

    // Static block to register your effect into the STATUS_EFFECT registry
    public static void registerModEffects() {
        // Register the Sapphire Effect
        SAPPHIRE_EFFECT = Registry.register(
                Registries.STATUS_EFFECT,
                Identifier.of(HeroNecklace.MOD_ID, "sapphire_effect"),
                new SapphireEffect()
        );
        //Register the Amethyst Effect
        AMETHYST_EFFECT = Registry.register(
                Registries.STATUS_EFFECT,
                Identifier.of(HeroNecklace.MOD_ID, "amethyst_effect"),
                new AmethystEffect()
        );
        //Register the Pink Spinel Effect
        PINKSPINEL_EFFECT = Registry.register(
                Registries.STATUS_EFFECT,
                Identifier.of(HeroNecklace.MOD_ID, "pinkspinel_effect"),
                new PinkSpinelEffect()
        );
        //Register the Pink Spinel Effect
        RUBY_EFFECT = Registry.register(
                Registries.STATUS_EFFECT,
                Identifier.of(HeroNecklace.MOD_ID, "ruby_effect"),
                new RubyEffect()
        );
        LOGGER.info("Custom Effects Loaded!");
    }
    @Override
    public void onInitialize() {
        // Initialization logic (if you have other setup to do, like item registrations)
        LOGGER.info("Custom status effects have been registered!");
    }
}
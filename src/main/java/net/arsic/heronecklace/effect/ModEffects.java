package net.arsic.heronecklace.effect;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.arsic.heronecklace.HeroNecklace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModEffects implements ModInitializer {

    // Logger for logging info in the console
    public static final Logger LOGGER = LoggerFactory.getLogger(HeroNecklace.MOD_ID);

    // Declare your SapphireEffect as a public static variable
    public static RegistryEntry.Reference<StatusEffect> SAPPHIRE_EFFECT;
    public static RegistryEntry.Reference<StatusEffect> AMETHYST_EFFECT;
    public static RegistryEntry.Reference<StatusEffect> RUBY_EFFECT;
    public static RegistryEntry.Reference<StatusEffect> PINKSPINEL_EFFECT;

    // Static block to register your effect into the STATUS_EFFECT registry
    public static void registerModEffects() {
        // Register the Sapphire Effect
        SAPPHIRE_EFFECT = Registry.registerReference(
                Registries.STATUS_EFFECT,
                Identifier.of(HeroNecklace.MOD_ID, "sapphire_effect"),
                new SapphireEffect()
        );
        //Register the Amethyst Effect
        AMETHYST_EFFECT = Registry.registerReference(
                Registries.STATUS_EFFECT,
                Identifier.of(HeroNecklace.MOD_ID, "amethyst_effect"),
                new AmethystEffect()
        );
        //Register the Pink Spinel Effect
        PINKSPINEL_EFFECT = Registry.registerReference(
                Registries.STATUS_EFFECT,
                Identifier.of(HeroNecklace.MOD_ID, "pinkspinel_effect"),
                new PinkSpinelEffect()
        );
        //Register the Pink Spinel Effect
        RUBY_EFFECT = Registry.registerReference(
                Registries.STATUS_EFFECT,
                Identifier.of(HeroNecklace.MOD_ID, "ruby_effect"),
                new RubyEffect()
        );
        LOGGER.info("Custom Effects Loaded!");
    }

    public static void checkAllPlayersBadOmen(){
    		// Register the player tick event to check for players' effects in real-time
		ServerTickEvents.START_SERVER_TICK.register(server -> {
			// For each player on the server
            // Custom method to check for Bad Omen
            server.getPlayerManager().getPlayerList().forEach(ModEffects::checkForBadOmen);
		});
    }

    public static void checkForBadOmen(PlayerEntity player) {
        if (player.hasStatusEffect(StatusEffects.BAD_OMEN)) {
            var badOmenEffect = player.getStatusEffect(StatusEffects.BAD_OMEN);
            if (badOmenEffect != null) {
                int amplifier = badOmenEffect.getAmplifier(); // Get the amplifier (level)

                switch (amplifier) {
                    case 0:
                        // Bad Omen I
                        //LOGGER.info(player.getName().getString() + " has Bad Omen I");
                        break;
                        // Apply custom logic for Bad Omen I
                    case 1:
                        // Bad Omen II
                        //LOGGER.info(player.getName().getString() + " has Bad Omen II");
                        //player.addStatusEffect(new StatusEffectInstance(ModEffects.SAPPHIRE_EFFECT, 42000, 0));
                        player.getServer().getPlayerManager().getPlayerList().forEach(p -> {
                            if (!p.hasStatusEffect(ModEffects.SAPPHIRE_EFFECT)) {
                                p.addStatusEffect(new StatusEffectInstance(ModEffects.SAPPHIRE_EFFECT, 54000, 0)); //45 minutes to get your drops
                                //LOGGER.info("Applied Sapphire Effect to player: " + p.getName().getString());
                            }
                        });
                        break;
                        // Apply custom logic for Bad Omen II
                    case 2:
                        // Bad Omen III
                        //LOGGER.info(player.getName().getString() + " has Bad Omen III");
                        player.getServer().getPlayerManager().getPlayerList().forEach(p -> {
                            if (!p.hasStatusEffect(ModEffects.AMETHYST_EFFECT)) {
                                p.addStatusEffect(new StatusEffectInstance(ModEffects.AMETHYST_EFFECT, 54000, 0)); //45 minutes to get your drops
                                //LOGGER.info("Applied Amethyst Effect to player: " + p.getName().getString());
                            }
                        });
                        break;
                        // Apply custom logic for Bad Omen III
                    case 3:
                        // Bad Omen IV
                        //LOGGER.info(player.getName().getString() + " has Bad Omen IV");
                        player.getServer().getPlayerManager().getPlayerList().forEach(p -> {
                            if (!p.hasStatusEffect(ModEffects.PINKSPINEL_EFFECT)) {
                                p.addStatusEffect(new StatusEffectInstance(ModEffects.PINKSPINEL_EFFECT, 54000, 0)); //45 minutes to get your drops
                                //LOGGER.info("Applied PinkSpinel Effect to player: " + p.getName().getString());
                            }
                        });
                        break;
                        // Apply custom logic for Bad Omen IV
                    case 4:
                        // Bad Omen V
                        //LOGGER.info(player.getName().getString() + " has Bad Omen V");
                        player.getServer().getPlayerManager().getPlayerList().forEach(p -> {
                            if (!p.hasStatusEffect(ModEffects.RUBY_EFFECT)) {
                                p.addStatusEffect(new StatusEffectInstance(ModEffects.RUBY_EFFECT, 54000, 0)); //45 minutes to get your drops
                                //LOGGER.info("Applied Ruby Effect to player: " + p.getName().getString());
                            }
                        });
                        break;
                        // Apply custom logic for Bad Omen V
                    default:
                        // If there are any unexpected levels, log it
                        //LOGGER.info(player.getName().getString() + " has an unknown level of Bad Omen");
                }
            }
        }
    }

    @Override
    public void onInitialize() {
        // Initialization logic (if you have other setup to do, like item registrations)
        LOGGER.info("Custom status effects have been registered!");
    }
}

/**
 * Make it so loot tables in the Bad Omen events have chance to drop new tiers of emeralds for other necklace designs
 * HOTV = Hero of the Village
 * each then giving an emplified hero of the village buff
 * Tier 1 (Base Emerald + trim): Already in mod. (10% Pillager, 40% Ravager) - Bad Omen 1
 //ToDo: Tier 3 HOTV (Sapphire):    8% Pillager,   35% Ravager,     16% Evoker. - Bad Omen 2
 * ToDo: Tier 5 HOTV (Amethyst):    7% Pillager,   30% Ravager,     12% Evoker - Bad Omen 3
 * ToDo: Tier 7 HOTV (PinkSpinel):  4% Pillager,   25% Ravager,     8% Evoker. - Bad Omen 4
 * ToDo: Tier 10 HOTV (Ruby):       5% Pillager,   15% Ravager,     6% Evoker. - Bad Omen 5
 */
package net.arsic.heronecklace;

import net.arsic.heronecklace.effect.ModEffects;
import net.arsic.heronecklace.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeroNecklace implements ModInitializer {
	public static final String MOD_ID = "heronecklace";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		modifyBaseLootTables();
		ModEffects.registerModEffects();
	}

	public static void modifyBaseLootTables() {
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if(source.isBuiltin() && (EntityType.PILLAGER.getLootTableId().equals(key))) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(0.10f)) //10% chance drop from base Pillagers
						.with(ItemEntry.builder(ModItems.TRIMMEDEMERALD))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
				tableBuilder.pool(poolBuilder.build());
			}
			if(source.isBuiltin() && (EntityType.RAVAGER.getLootTableId().equals(key))) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(0.40f)) //40% chance drop from Ravagers
						.with(ItemEntry.builder(ModItems.TRIMMEDEMERALD))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
				tableBuilder.pool(poolBuilder.build());
			}
		});
	}

	/**
	 * Make it so loot tables in the Bad Omen events have chance to drop new tiers of emeralds for other necklace designs
	 * HOTV = Hero of the Village
	 * each then giving an emplified hero of the village buff
	 * Tier 1 (Base Emerald + trim): Already in mod. (10% Pillager, 40% Ravager) - Bad Omen 1
//	 * ToDo: Tier 3 HOTV (Sapphire): 8% Pillager, 35% Ravager, 16% Sorcerer. - Bad Omen 2
	 * ToDo: Tier 5 HOTV (Amethyst): 7% Pillager, 30% Ravager, 12% Sorcerer - Bad Omen 3
	 * ToDo: Tier 7 HOTV (PinkSpinel): 4% Pillager, 25% Ravager, 8% Sorcerer. - Bad Omen 4,5
	 * ToDo: Tier 10 HOTV (Ruby): 5% Pillager, 15% Ravager, 6% Sorcerer. - Bad Omen 6
	 */

	/**
	 * Core Loot Table Swap Logic:
	 * Check the players Status effect, if it is Omen 1/2/3/4/5/6 then swap to the appropriate loot table.
	 *
	 * Or Create custom status effects which correlate to each tier of drop and as the status effect, for the duration of it the player can get thje associated drop.
	 */

	/**
	 * Modifies the Bad Omen 2 event loot tables.
	 * Has Chance to drop HOTV Tier 3 Gem.
	 */
	public static void modifyBadOmenTwo() {

	}

	/**
	 * Modifies the Bad Omen 3 event loot tables.
	 * Has Chance to drop HOTV Tier 5 Gem.
	 */
	public static void modifyBadOmenThree() {

	}
	/**
	 * Modifies the Bad Omen 4,5 event loot tables.
	 * Has Chance to drop HOTV Tier 7 Gem.
	 */

	public static void modifyBadOmenFourandFive() {

	}

	/**
	 * Modifies the Bad Omen 6 event loot tables.
	 * Has Chance to drop HOTV Tier 10 Gem.
	 */
	public static void modifyBadOmenSix() {

	}
}
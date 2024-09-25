package net.arsic.heronecklace;

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
		modifyLootTables();
	}

	public static void modifyLootTables() {
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
}
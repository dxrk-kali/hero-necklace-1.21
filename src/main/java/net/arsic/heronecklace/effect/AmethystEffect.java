package net.arsic.heronecklace.effect;

import net.arsic.heronecklace.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class AmethystEffect extends StatusEffect {
    protected AmethystEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.BENEFICIAL, 0xe9b8b3);
    }

    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we need to check if the player has a bad omen status effect and if it is level 3
        return true;
    }

    // Called when the effect is applied. This is what we will need to apply
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(entity, amplifier);
    }

//    public static void amethystEffectLootTable() {
//        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
//            if(source.isBuiltin() && (EntityType.SHEEP.getLootTableId().equals(key))) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(0.99f)) //10% chance drop from base Pillagers
//                        .with(ItemEntry.builder(ModItems.PINKSPINEL))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
//                tableBuilder.pool(poolBuilder.build());
//            }
//            if(source.isBuiltin() && (EntityType.COW.getLootTableId().equals(key))) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(0.40f)) //40% chance drop from Ravagers
//                        .with(ItemEntry.builder(ModItems.TRIMMEDEMERALD))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
//                tableBuilder.pool(poolBuilder.build());
//            }
//        });
//    }
}
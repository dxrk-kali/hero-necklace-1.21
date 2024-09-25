package net.arsic.heronecklace.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Multimap;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.UUID;

public class HeroNecklaceTrinketItem extends TrinketItem {

    public HeroNecklaceTrinketItem(Settings settings) {
        super(settings);
    }
}

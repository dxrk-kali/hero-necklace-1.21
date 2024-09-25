package net.arsic.heronecklace.tag;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final TagKey<Item> CHEST_NECKLACE = TagKey.of(RegistryKeys.ITEM, Identifier.of("trinkets", "chest/necklace"));
}

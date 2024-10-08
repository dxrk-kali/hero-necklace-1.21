package net.arsic.heronecklace.item;

import net.arsic.heronecklace.HeroNecklace;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

// Where all Items are registered
public class ModItems {

    // Register the Hero Necklace as a TrinketItem
    public static final Item HNECKLACE = registerItem("hero_necklace", new HeroNecklaceTrinketItem(new Item.Settings().maxCount(1)));
    public static final Item SHNECKLACE = registerItem("shero_necklace", new HeroNecklaceTrinketItem(new Item.Settings().maxCount(1)));
    public static final Item AHNECKLACE = registerItem("ahero_necklace", new HeroNecklaceTrinketItem(new Item.Settings().maxCount(1)));
    public static final Item PHNECKLACE = registerItem("phero_necklace", new HeroNecklaceTrinketItem(new Item.Settings().maxCount(1)));
    public static final Item RHECKLACE = registerItem("rhero_necklace", new HeroNecklaceTrinketItem(new Item.Settings().maxCount(1)));

    // Add new emerald type for crafting into the hero_necklace
    public static final Item TRIMMEDEMERALD = registerItem("hero_trimmed_emerald", new Item(new Item.Settings()));
    public static final Item SAPPHIREGEM = registerItem("hero_trimmed_sapphire", new Item(new Item.Settings()));
    public static final Item AMETHYSTGEM = registerItem("hero_trimmed_amethyst", new Item(new Item.Settings()));
    public static final Item PINKSPINEL = registerItem("hero_trimmed_pinkspinel", new Item(new Item.Settings()));
    public static final Item RUBYGEM = registerItem("hero_trimmed_ruby", new Item(new Item.Settings()));

    // Method to register item to an item group tab
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        // Hero Necklace Variants
        entries.add(HNECKLACE);
        entries.add(SHNECKLACE);
        entries.add(AHNECKLACE);
        entries.add(PHNECKLACE);
        entries.add(RHECKLACE);

        // Gem Variants
        entries.add(TRIMMEDEMERALD);
        entries.add(SAPPHIREGEM);
        entries.add(AMETHYSTGEM);
        entries.add(PINKSPINEL);
        entries.add(RUBYGEM);
    }

    // Method to register the item in the Minecraft registry
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HeroNecklace.MOD_ID, name), item);
    }

    // Method to register mod items
    public static void registerModItems() {
        HeroNecklace.LOGGER.info("Registering Mod Items for " + HeroNecklace.MOD_ID);

        // Add the item to the Ingredients tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}

package net.arsic.heronecklace.item;

import net.arsic.heronecklace.HeroNecklace;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModItems {

    // Register the Hero Necklace as a TrinketItem
    public static final Item HNECKLACE = registerItem("hero_necklace", new HeroNecklaceTrinketItem(new Item.Settings().maxCount(1)));

    // Method to register item to an item group tab
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(HNECKLACE);
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

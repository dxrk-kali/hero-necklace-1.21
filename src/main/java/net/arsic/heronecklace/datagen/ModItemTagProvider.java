package net.arsic.heronecklace.datagen;

import net.arsic.heronecklace.item.ModItems;
import net.arsic.heronecklace.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Get the tag builder for the chest/necklace slot in Trinkets
        var necklaceTagBuilder = getOrCreateTagBuilder(ModTags.CHEST_NECKLACE);

        // Add the Hero Necklace to the chest/necklace trinket slot tag
        necklaceTagBuilder.add(ModItems.HNECKLACE);
    }
}

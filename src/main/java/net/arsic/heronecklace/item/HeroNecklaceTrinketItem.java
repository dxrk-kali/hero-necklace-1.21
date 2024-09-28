package net.arsic.heronecklace.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class HeroNecklaceTrinketItem extends TrinketItem {

    public HeroNecklaceTrinketItem(Settings settings) {
        super(settings);
    }

//    @Override
//    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
//        // Check if the entity is a player and if we're on the server-side
//        if (entity instanceof PlayerEntity player && !player.getWorld().isClient) {
//            // Print the slot type and slot group to debug
//            //System.out.println("Slot Type: " + slot.inventory().getSlotType().toString());
//            //System.out.println("Slot Group: " + slot.inventory().getSlotType().getGroup());
//
//            // Check if the item is equipped in the chest/necklace slot
//            if (slot.inventory().getSlotType().getGroup().equals("chest")) {
//                // Debugging: Log when both conditions match
//                //System.out.println("Hero Necklace equipped in chest/necklace slot");
//
//                // Apply the Hero of the Village effect if not already active
//                if (!player.hasStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE)) {
//                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 600, 0, true, false));
//                    //System.out.println("Hero of the Village effect applied to player: " + player.getName().getString());
//                }
//            } else {
//                // Debugging: Log if the item is not in the chest/necklace slot
//                System.out.println("Hero Necklace not in chest/necklace slot");
//            }
//        }
//    }
        @Override
        public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
            // Check if the entity is a player and if we're on the server-side
            if (entity instanceof PlayerEntity player && !player.getWorld().isClient) {

                // Check if the item is equipped in the chest/necklace slot
                if (slot.inventory().getSlotType().getGroup().equals("chest")) {
                    // Determine the amplifier level based on the necklace type
                    int amplifier = 0; // Default HOTV level

                    // Check which necklace is equipped and set the amplifier accordingly
                    if (stack.isOf(ModItems.HNECKLACE)) {
                        amplifier = 0; // Basic Hero Necklace: HOTV I
                    } else if (stack.isOf(ModItems.SHNECKLACE)) {
                        amplifier = 1; // Sapphire Necklace: HOTV II
                    } else if (stack.isOf(ModItems.AHNECKLACE)) {
                        amplifier = 2; // Amethyst Necklace: HOTV III
                    } else if (stack.isOf(ModItems.PHNECKLACE)) {
                        amplifier = 3; // Pink Spinel Necklace: HOTV IV
                    } else if (stack.isOf(ModItems.RHECKLACE)) {
                        amplifier = 4; // Ruby Necklace: HOTV V
                    }

                    // Apply the Hero of the Village effect if not already active or with a lower amplifier
                    StatusEffectInstance currentEffect = player.getStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE);
                    if (currentEffect == null || currentEffect.getAmplifier() < amplifier) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 600, amplifier, true, false));
                        System.out.println("Applied Hero of the Village effect with amplifier " + amplifier + " to player: " + player.getName().getString());
                    }
                } else {
                    // Debugging: Log if the item is not in the chest/necklace slot
                    System.out.println("Hero Necklace not in chest/necklace slot");
                }
            }
        }
}


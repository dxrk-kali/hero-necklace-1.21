package net.arsic.heronecklace.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.arsic.heronecklace.HeroNecklace;


public class SapphireEffect extends StatusEffect {
    protected SapphireEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.BENEFICIAL, 0xe9b8b3);
    }

    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we need to check if the player has a bad omen status effect and if it is level 2
        return true;
    }

    // Called when the effect is applied.
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(entity, amplifier);
    }
}
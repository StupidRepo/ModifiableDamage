package com.stupidrepo.modifiable_damage.mixins;

import com.stupidrepo.modifiable_damage.MDConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(LivingEntity.class)
public abstract class DamageMixins {
    @ModifyArgs(
            method = "damage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"
            )
    )
    private void modifyDamageAmount(Args args) {
        if(!isPlayer((LivingEntity)(Object)this)) return;

        DamageSource source = args.get(0);
//        if(!willBeModified(source)) return;

        float amount = args.get(1);
        float prevAmount = amount;

        amount = (float) modifyAmount(amount, source);

//        ModifiableDamage.logger.info("Modified amount: " + amount + " (from " + prevAmount + ") (source: " + source.getName() + ")");

        args.set(1, amount);
    }

    @Unique
    private double modifyAmount(float amount, DamageSource source) {
        if (source.isOf(DamageTypes.DROWN)) {
            return amount * MDConfig.drownMultiplier;
        } else if (source.isOf(DamageTypes.ON_FIRE) || source.isOf(DamageTypes.IN_FIRE)) {
            return amount * MDConfig.burnMultiplier;
        } else if (source.isOf(DamageTypes.HOT_FLOOR)) {
            return amount * MDConfig.magmaMultiplier;
        } else if (source.isOf(DamageTypes.LAVA)) {
            return amount * MDConfig.lavaMultiplier;
        } else if (source.isOf(DamageTypes.FALL)) {
            return amount * MDConfig.fallMultiplier;
        } else if (source.isOf(DamageTypes.FREEZE)) {
            return amount * MDConfig.freezeMultiplier;
        } else if (source.isOf(DamageTypes.STARVE)) {
            return amount * MDConfig.starveMultiplier;
        }

        return amount * MDConfig.generalMultiplier;
    }

    @Unique
    private boolean willBeModified(DamageSource source) {
        return source.isOf(
                DamageTypes.DROWN)
                || source.isOf(DamageTypes.ON_FIRE)
                || source.isOf(DamageTypes.IN_FIRE)
                || source.isOf(DamageTypes.LAVA)
                || source.isOf(DamageTypes.HOT_FLOOR)
                || source.isOf(DamageTypes.FALL)
                || source.isOf(DamageTypes.FREEZE)
                || source.isOf(DamageTypes.STARVE);
    }

    @Unique
    private boolean isPlayer(Entity entity) {
        return entity instanceof PlayerEntity || entity instanceof ServerPlayerEntity;
    }
}
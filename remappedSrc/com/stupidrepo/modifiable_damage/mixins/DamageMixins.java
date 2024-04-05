package com.stupidrepo.modifiable_damage.mixins;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(PlayerEntity.class)
public class DamageMixins {
    @Inject(method = "")
}

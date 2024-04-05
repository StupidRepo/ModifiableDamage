package com.stupidrepo.modifiable_damage;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModifiableDamage implements ModInitializer {
    public static final Logger logger = LogManager.getLogger(ModifiableDamage.class);

    @Override
    public void onInitialize() {
        MidnightConfig.init("modifiable_damage", MDConfig.class);
    }
}

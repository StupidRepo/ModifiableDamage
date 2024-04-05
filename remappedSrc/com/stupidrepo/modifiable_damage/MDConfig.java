package com.stupidrepo.modifiable_damage;

import eu.midnightdust.lib.config.MidnightConfig;

public class MDConfig extends MidnightConfig {
    // Drowning
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double drownMultiplier = 1.0D;

    // Fire Damage
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double burnMultiplier = 1.0D;

    // Fall Damage
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double fallMultiplier = 1.0D;

    // Freezing
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double freezeMultiplier = 1.0D;
}

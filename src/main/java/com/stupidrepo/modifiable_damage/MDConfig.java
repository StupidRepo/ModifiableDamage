package com.stupidrepo.modifiable_damage;

import eu.midnightdust.lib.config.MidnightConfig;

public class MDConfig extends MidnightConfig {
    // Comments
    @Comment(category = "supportme", centered = true) public static String kofi;
    @Comment(category = "multipliers", centered = true) public static String wannasupport;

    // General
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double generalMultiplier = 1.0D;
    @Comment(category = "multipliers") public static String spacer1;

    // Drowning
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double drownMultiplier = 1.0D;
    @Comment(category = "multipliers") public static String spacer2;

    // Fire Damage
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double burnMultiplier = 1.0D;
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double magmaMultiplier = 1.0D;
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double lavaMultiplier = 1.0D;
    @Comment(category = "multipliers") public static String spacer3;


    // Fall Damage
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double fallMultiplier = 1.0D;
    @Comment(category = "multipliers") public static String spacer4;

    // Freezing
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double freezeMultiplier = 1.0D;
    @Comment(category = "multipliers") public static String spacer5;

    // Starving
    @Entry(category = "multipliers", isSlider = true, min = 0.1, max = 3) public static double starveMultiplier = 1.0D;
}

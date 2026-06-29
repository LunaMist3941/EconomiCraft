package io.github.lunamist3941.economicraft.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class EconomyConfig {

    public static ModConfigSpec.IntValue STARTING_BALANCE;

    public static void register(ModConfigSpec.Builder builder) {

        builder.push("economy");

        STARTING_BALANCE = builder
                .comment("Starting balance for new players.")
                .defineInRange("startingBalance", 0, 0, Integer.MAX_VALUE);

        builder.pop();
    }

    private EconomyConfig() {
    }
}
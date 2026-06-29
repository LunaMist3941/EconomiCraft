package io.github.lunamist3941.economicraft.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class BankConfig {

    public static ModConfigSpec.BooleanValue ENABLED;

    public static void register(ModConfigSpec.Builder builder) {

        builder.push("bank");

        ENABLED = builder
                .comment("Enable the bank system.")
                .define("enabled", true);

        builder.pop();
    }

    private BankConfig() {
    }
}
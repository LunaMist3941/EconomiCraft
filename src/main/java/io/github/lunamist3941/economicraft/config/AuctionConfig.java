package io.github.lunamist3941.economicraft.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class AuctionConfig {

    public static ModConfigSpec.BooleanValue ENABLED;

    public static void register(ModConfigSpec.Builder builder) {

        builder.push("auction");

        ENABLED = builder
                .comment("Enable the auction system.")
                .define("enabled", true);

        builder.pop();
    }

    private AuctionConfig() {
    }
}
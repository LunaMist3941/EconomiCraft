package io.github.lunamist3941.economicraft.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class ShopConfig {

    public static ModConfigSpec.BooleanValue ENABLED;

    public static void register(ModConfigSpec.Builder builder) {

        builder.push("shop");

        ENABLED = builder
                .comment("Enable the shop system.")
                .define("enabled", true);

        builder.pop();
    }

    private ShopConfig() {
    }
}
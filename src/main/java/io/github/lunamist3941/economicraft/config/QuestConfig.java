package io.github.lunamist3941.economicraft.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class QuestConfig {

    public static ModConfigSpec.BooleanValue ENABLED;

    public static void register(ModConfigSpec.Builder builder) {

        builder.push("quest");

        ENABLED = builder
                .comment("Enable the quest system.")
                .define("enabled", true);

        builder.pop();
    }

    private QuestConfig() {
    }
}
package io.github.lunamist3941.economicraft.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class EconomiCraftConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    static {
        ShopConfig.register(BUILDER);
        BankConfig.register(BUILDER);
        AuctionConfig.register(BUILDER);
        QuestConfig.register(BUILDER);
        EconomyConfig.register(BUILDER);
    }

    public static final ModConfigSpec SPEC = BUILDER.build();

    private EconomiCraftConfig() {
    }
}
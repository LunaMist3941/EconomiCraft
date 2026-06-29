package io.github.lunamist3941.economicraft;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(EconomiCraft.MODID)
public class EconomiCraft {


    public static final String MODID = "economicraft";
    public static final Logger LOGGER = LogUtils.getLogger();

    // MODの初期化処理
    public EconomiCraft(IEventBus modEventBus) {
        LOGGER.info("Loading EconomiCraft...");
    }
}
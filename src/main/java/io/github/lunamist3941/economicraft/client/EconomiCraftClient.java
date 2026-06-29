package io.github.lunamist3941.economicraft.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import io.github.lunamist3941.economicraft.EconomiCraft;

@Mod(value = EconomiCraft.MODID, dist = Dist.CLIENT)

@EventBusSubscriber(modid = EconomiCraft.MODID, value = Dist.CLIENT)
public class EconomiCraftClient {
    public EconomiCraftClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

}

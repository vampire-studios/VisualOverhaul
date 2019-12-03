package io.github.vampirestudios.visualoverhaul;

import io.github.vampirestudios.visualoverhaul.hooks.HookRegistry;
import io.github.vampirestudios.visualoverhaul.hooks.ModHook;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VisualOverhaul implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger();
    private static final HookRegistry HOOK_REGISTRY = new HookRegistry();

    @Override
    public void onInitialize() {
        long startInitTime = System.currentTimeMillis();
        LOGGER.info("[VO]: Starting initialization.");

        //TODO: init logic

        this.registerHooks();
        HOOK_REGISTRY.applyHooks();
        LOGGER.info("[VO]: Initialization done. (Took {}ms.)", System.currentTimeMillis() - startInitTime);
    }

    private void registerHooks() {
        HOOK_REGISTRY.register(new ModHook("galacricraft-rewoven") {
            @Override
            public void applyHook() {
                LOGGER.info("I see you there Galacticraft.");
            }
        });
    }
}

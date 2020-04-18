package io.github.vampirestudios.visualoverhaul.hooks;

import net.fabricmc.loader.api.FabricLoader;

import java.util.HashMap;
import java.util.Map;

public class HookRegistry {
    private Map<String, ModHook> registeredHooks = new HashMap<>();

    /**
     * IMPORTANT: add mod id and version to fabric.mod.json in the suggests section.
     * @param hook the hook that is gonna be registered
     */
    public void register(ModHook hook) {
        if(!this.registeredHooks.containsKey(hook.modid)) {
            this.registeredHooks.put(hook.modid, hook);
        }
    }

    public void applyHooks() {
        for (ModHook hook : registeredHooks.values()) {
            if(FabricLoader.getInstance().isModLoaded(hook.modid)) {
                hook.applyHook();
            }
        }
    }
}

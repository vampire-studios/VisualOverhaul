package io.github.vampirestudios.visualoverhaul.hooks;

public abstract class ModHook {

    public String modid;

    public ModHook(String modid) {
        this.modid = modid;
    }

    public abstract void applyHook();
}

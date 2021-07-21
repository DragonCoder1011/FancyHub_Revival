package dev.fancyhub;

import org.bukkit.plugin.java.JavaPlugin;

public class FancyHub extends JavaPlugin {

    private static FancyHubInit init;

    public void onEnable() {
        init = new FancyHubInit(this);
        init.init();
    }

    public void onDisable() {

    }

    public static FancyHub getInstance() {
        return FancyHub.getPlugin(FancyHub.class);
    }

    public static FancyHubInit getInit() {
        return init;
    }
}

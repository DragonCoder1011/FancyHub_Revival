package dev.fancyhub;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.event.Listener;

import java.lang.reflect.Field;

public class FancyHubInit {

    private FancyHub plugin;

    public FancyHubInit(FancyHub plugin) {
        this.plugin = plugin;
    }

    public void init() {
        registerConfig();
        registerOtherFiles();
        registerCommands();
        registerListeners();
        registerTasks();
    }

    private void registerConfig() {
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveDefaultConfig();
    }

    private void registerOtherFiles() {

    }

    private void registerCommands() {

    }

    private void registerListeners() {
        addListener();
    }

    private void registerTasks() {

    }

    private void addCommand(String cmd, BukkitCommand bc) {
        try {
            Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            commandMap.register(cmd, bc);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void addListener(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, plugin);
        }
    }
}

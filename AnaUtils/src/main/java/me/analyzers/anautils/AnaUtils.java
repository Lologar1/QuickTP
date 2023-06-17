package me.analyzers.anautils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnaUtils extends JavaPlugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        plugin.saveDefaultConfig();
        System.out.println(ChatColor.GREEN + "Analyzers' Utilities Loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "Analyzers' Utilities Disabled!");
    }

    public static Plugin getPlugin() {
        plugin.saveConfig();
        return plugin;
    }
}

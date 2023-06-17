package me.analyzers.quicktp;

import me.analyzers.quicktp.events.OnPlaceBlocks;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuickTP extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("QuickTeleport by Analyzers loaded!");
        this.getCommand("quicktp").setExecutor(new me.analyzers.quicktp.commands.QuickTP());
        this.getCommand("rep").setExecutor(new me.analyzers.quicktp.commands.Rep());
        getServer().getPluginManager().registerEvents(new OnPlaceBlocks(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("QuickTP disabled!");
    }
}

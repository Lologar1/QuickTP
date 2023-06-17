package me.analyzers.quicktp.commands;

import me.analyzers.anautils.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Rep implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player) || args.length < 1){
            sender.sendMessage(Color.RED + "Please provide one valid numerical argument (0 or 1)");
            return true;
        }
        Player player = (Player) sender;
        if(args[0].equals("1")){
            player.getInventory().addItem(new ItemBuilder(Material.REPEATER).setAmount(1).setDisplayName(ChatColor.GREEN + "Redstone Repeater").addLore(ChatColor.GRAY + "Powered & locked repeater").setPDC("power", "true").build());
        }else if(args[0].equals("0")){
            player.getInventory().addItem(new ItemBuilder(Material.REPEATER).setAmount(1).setDisplayName(ChatColor.RED + "Redstone Repeater").addLore(ChatColor.GRAY + "Locked repeater").setPDC("power", "false").build());
        }else{
            sender.sendMessage(Color.RED + "Please provide one valid numerical argument (0 or 1)");
            return true;
        }
        return true;
    }
}

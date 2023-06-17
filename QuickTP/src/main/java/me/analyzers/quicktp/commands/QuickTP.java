package me.analyzers.quicktp.commands;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
public class QuickTP implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("Sender must be a player!");
        }
        Player player = (Player) sender;
        if(args.length < 1){
            player.sendMessage(Color.RED + "Must provide at least one valid numerical argument!");
        }
        int distance = Integer.parseInt(args[0]);
        Vector direction = player.getLocation().getDirection();
        Location newLocation = player.getLocation().add(direction.multiply(distance));
        player.teleport(newLocation);
        return true;
    }
}

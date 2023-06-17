package me.analyzers.quicktp.events;

import me.analyzers.anautils.utils.PDCUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Repeater;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class OnPlaceBlocks implements Listener {
    @EventHandler
    public void OnPlaceBlocks(BlockPlaceEvent e){
        Player player = e.getPlayer();
        Block block = e.getBlockPlaced();
        BlockState state = block.getState();
        BlockData data = state.getBlockData();
        Location loc = e.getBlock().getLocation();
        if(block.getType().equals(Material.REPEATER)){
            ItemStack rep = player.getInventory().getItemInMainHand();
            if(PDCUtils.has(rep, "power") && PDCUtils.get(rep, "power").equals("true")){
                Repeater repeater = (Repeater) data;
                repeater.setPowered(true);
                repeater.setLocked(true);
                repeater.setDelay(1);
                state.setBlockData(repeater);
                state.update(true);
                block.setBlockData(data);
                loc.getBlock().setType(Material.REPEATER);
                loc.getBlock().setBlockData(data);
            }else if(PDCUtils.has(rep, "power") && PDCUtils.get(rep, "power").equals("false")){
                Repeater repeater = (Repeater) data;
                repeater.setPowered(false);
                repeater.setLocked(true);
                repeater.setDelay(1);
                state.setBlockData(repeater);
                state.update(true);
                block.setBlockData(data);
                loc.getBlock().setType(Material.REPEATER);
                loc.getBlock().setBlockData(data);
            }
        }
    }
}

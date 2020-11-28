package me.bluenitrox.school.listener;

import me.bluenitrox.school.commands.Build;
import me.bluenitrox.school.managers.PlayerBreakBlockManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BreakBlockEvent implements Listener {

    public int dropBonus;
    public ArrayList<String> allowedWorldToBuild = new ArrayList<>();
    public String plotworld = "plotworld";

    public static ConcurrentHashMap<String, Integer> minen = new ConcurrentHashMap<>();

    public BreakBlockEvent() {
        allowedWorldToBuild.add("plotworld");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        dropBonus = 1;
        Player p = e.getPlayer();
        if(Build.build.contains(p)) {
            return;
        }
        if(p.getWorld().getName().equalsIgnoreCase(plotworld)) return;

        if((PlayerBreakBlockManager.breakBlock(p, e.getBlock().getLocation(), dropBonus))) {

        }else {
            e.setCancelled(true);
            e.setExpToDrop(0);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(Build.build.contains(p)){
            return;
        }
        if (!allowedWorldToBuild.contains(p.getLocation().getWorld().getName())) {
            e.setCancelled(true);
        }
    }
}

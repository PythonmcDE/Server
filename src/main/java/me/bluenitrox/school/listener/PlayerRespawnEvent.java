package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.all.Erhalt;
import me.bluenitrox.school.managers.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerRespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(final org.bukkit.event.player.PlayerRespawnEvent e){
        Player p = (Player)e.getPlayer();
        spawntp(p);
        erhaltItems(p);
    }

    private void spawntp(Player p){
        new BukkitRunnable(){
            @Override
            public void run() {
                p.teleport(new LocationManager("spawn").getLocation());

            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 2);
    }

    private void erhaltItems(Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (Erhalt.items.containsKey(p)) {
                    for (int i = 0; i < Erhalt.items.get(p).size(); i++) {
                        ArrayList<ItemStack> array = Erhalt.items.get(p);
                        p.getInventory().addItem(array.get(i));
                    }
                }
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20);
    }
}

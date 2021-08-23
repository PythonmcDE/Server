package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.all.Erhalt;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.warzone.CombatAPI;
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
    public void onRespawn(final org.bukkit.event.player.PlayerRespawnEvent e) {
        Player p = (Player) e.getPlayer();
        spawntp(p);
        erhaltItems(p);
        CombatAPI.fight.remove(p);
        CombatAPI.fightwarzone.remove(p);
    }

    private void spawntp(Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                p.teleport(new LocationManager("Spawn").getLocation());

            }
        }.runTaskLater(SchoolMode.getInstance(), 2);
    }

    private void erhaltItems(Player p) {
        new BukkitRunnable() {

            @Override
            public void run() {
                if (Erhalt.items != null) {
                    if (Erhalt.items.containsKey(p.getUniqueId())) {
                        for (int i = 0; i < Erhalt.items.size(); i++) {
                            ItemStack item = Erhalt.items.get(p.getUniqueId());
                            p.getInventory().addItem(item);
                            Erhalt.items.remove(p.getUniqueId());
                        }
                    }
                }
            }
        }.runTaskLater(SchoolMode.getInstance(), 20);
    }
}

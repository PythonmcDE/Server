package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.all.Erhalt;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
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
                p.getInventory().clear();
                p.teleport(new LocationManager("Spawn").getLocation());

            }
        }.runTaskLater(SchoolMode.getInstance(), 2);
    }

    public static void erhaltItems(Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (Erhalt.isUserExists(p.getUniqueId())) {
                    for(int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                        String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                        ItemStack item = Erhalt.decodeItem(itemstring);
                        p.getInventory().addItem(item);
                        Erhalt.deleteItem(itemstring);
                    }
                    new BukkitRunnable(){

                        @Override
                        public void run() {
                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                    p.getInventory().addItem(item);
                                    Erhalt.deleteItem(itemstring);
                                    new BukkitRunnable(){

                                        @Override
                                        public void run() {
                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                    p.getInventory().addItem(item);
                                                    Erhalt.deleteItem(itemstring);
                                                    new BukkitRunnable(){

                                                        @Override
                                                        public void run() {
                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                    p.getInventory().addItem(item);
                                                                    Erhalt.deleteItem(itemstring);
                                                                    new BukkitRunnable(){

                                                                        @Override
                                                                        public void run() {
                                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                                    p.getInventory().addItem(item);
                                                                                    Erhalt.deleteItem(itemstring);
                                                                                    new BukkitRunnable(){

                                                                                        @Override
                                                                                        public void run() {
                                                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                                                    p.getInventory().addItem(item);
                                                                                                    Erhalt.deleteItem(itemstring);
                                                                                                    new BukkitRunnable(){

                                                                                                        @Override
                                                                                                        public void run() {
                                                                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                                                                    p.getInventory().addItem(item);
                                                                                                                    Erhalt.deleteItem(itemstring);
                                                                                                                    new BukkitRunnable(){

                                                                                                                        @Override
                                                                                                                        public void run() {
                                                                                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                                                                                    p.getInventory().addItem(item);
                                                                                                                                    Erhalt.deleteItem(itemstring);
                                                                                                                                    new BukkitRunnable(){

                                                                                                                                        @Override
                                                                                                                                        public void run() {
                                                                                                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                                                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                                                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                                                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                                                                                                    p.getInventory().addItem(item);
                                                                                                                                                    Erhalt.deleteItem(itemstring);
                                                                                                                                                    new BukkitRunnable(){

                                                                                                                                                        @Override
                                                                                                                                                        public void run() {
                                                                                                                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                                                                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                                                                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                                                                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                                                                                                                    p.getInventory().addItem(item);
                                                                                                                                                                    Erhalt.deleteItem(itemstring);
                                                                                                                                                                    new BukkitRunnable(){

                                                                                                                                                                        @Override
                                                                                                                                                                        public void run() {
                                                                                                                                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                                                                                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                                                                                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                                                                                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                                                                                                                                    p.getInventory().addItem(item);
                                                                                                                                                                                    Erhalt.deleteItem(itemstring);
                                                                                                                                                                                    new BukkitRunnable(){

                                                                                                                                                                                        @Override
                                                                                                                                                                                        public void run() {
                                                                                                                                                                                            if (Erhalt.isUserExists(p.getUniqueId())) {
                                                                                                                                                                                                for (int i = 0; i < Erhalt.isUserExistsFetch(p.getUniqueId()); i++) {
                                                                                                                                                                                                    String itemstring = Erhalt.getItemErhalt(p.getUniqueId());
                                                                                                                                                                                                    ItemStack item = Erhalt.decodeItem(itemstring);
                                                                                                                                                                                                    p.getInventory().addItem(item);
                                                                                                                                                                                                    Erhalt.deleteItem(itemstring);
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                                                }
                                                                            }
                                                                        }
                                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                                }
                                                            }
                                                        }
                                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                                }
                                            }
                                        }
                                    }.runTaskLater(SchoolMode.getInstance(), 10);
                                }
                            }
                        }
                    }.runTaskLater(SchoolMode.getInstance(), 10);
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast dein(e) Item(s) erhalten auf dem/den §f§lErhalt §7verzaubert war.");
                }
            }
        }.runTaskLater(SchoolMode.getInstance(), 20*3);
    }
}

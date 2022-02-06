package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.all.Erhalt;
import me.bluenitrox.school.enchants.sword.Kopfgeld;
import me.bluenitrox.school.enchants.sword.Schatzmeister;
import me.bluenitrox.school.features.StatsAPI;
import me.bluenitrox.school.managers.KopfgeldManager;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.utils.ArmorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class PlayerDeathEvent implements Listener {

    public static ArrayList<ItemStack> playerinv;

    @EventHandler
    public void onDeath(final org.bukkit.event.entity.PlayerDeathEvent e) {
        Player p = (Player)e.getEntity();
        Player k = (Player)e.getEntity().getKiller();
        StatsAPI api = new StatsAPI();
        e.setDeathMessage(null);
        KopfgeldManager km = new KopfgeldManager();
        km.onKill(e);
        if(k != null) {
            if(k.getWorld().getName().equalsIgnoreCase(WorldManager.warzone)) {
                api.updateDeathsDatabase(p.getUniqueId(), 1, false);
                api.updateKillsDatabase(k.getUniqueId(), 1, false);
                playerinv = new ArrayList<>();
                for(int i = 0; i < p.getInventory().getSize(); i++) {
                    if (p.getInventory().getItem(i) != null) {
                        playerinv.add(p.getInventory().getItem(i));
                    }
                }
                if(p.getInventory().getHelmet() != null){
                    playerinv.add(p.getInventory().getHelmet());
                }
                if(p.getInventory().getChestplate() != null){
                    playerinv.add(p.getInventory().getChestplate());
                }
                if(p.getInventory().getLeggings() != null){
                    playerinv.add(p.getInventory().getLeggings());
                }
                if(p.getInventory().getBoots() != null){
                    playerinv.add(p.getInventory().getBoots());
                }
                e.setKeepInventory(true);
                Erhalt.giveItem(k,p, playerinv);
                if(Erhalt.itemserhalt != null){
                    for(int i = 0; i< Erhalt.itemserhalt.size();i++){
                        p.getInventory().remove(Erhalt.itemserhalt.get(i));
                        Erhalt.itemserhalt.remove(i);
                        Bukkit.broadcastMessage("item removed");
                    }
                    ArmorUtil.setArmorNull(p);
                }
                Schatzmeister.giveInventorySchatzmeister(k, p.getInventory(), p, e);
                Kopfgeld.giveHead(k, p);
                playerinv.clear();
            }
        }
        new BukkitRunnable(){
            @Override
            public void run() {
                p.spigot().respawn();
            }
        }.runTaskLater(SchoolMode.getInstance(), 20);
    }

}

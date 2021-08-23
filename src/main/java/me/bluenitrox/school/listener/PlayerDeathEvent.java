package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.all.Erhalt;
import me.bluenitrox.school.enchants.sword.Kopfgeld;
import me.bluenitrox.school.enchants.sword.Schatzmeister;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;

public class PlayerDeathEvent implements Listener {

    @EventHandler
    public void onDeath(final org.bukkit.event.entity.PlayerDeathEvent e) {
        Player p = (Player)e.getEntity();
        Player k = (Player)e.getEntity().getKiller();
        WorldManager wm = new WorldManager();
        e.setDeathMessage(null);
        p.spigot().respawn();
        if(k != null) {
            if(k.getWorld().getName().equalsIgnoreCase(wm.warzone)) {
                Erhalt.giveItem(p);
                Schatzmeister.giveInventorySchatzmeister(k, p.getInventory(), p, e);
                Kopfgeld.giveHead(k, p);
            }
        }
    }

}

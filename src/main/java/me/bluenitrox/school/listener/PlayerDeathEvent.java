package me.bluenitrox.school.listener;

import me.bluenitrox.school.enchants.all.Erhalt;
import me.bluenitrox.school.enchants.sword.Kopfgeld;
import me.bluenitrox.school.enchants.sword.Schatzmeister;
import me.bluenitrox.school.managers.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;

public class PlayerDeathEvent implements Listener {

    @EventHandler
    public void onDeath(final org.bukkit.event.entity.PlayerDeathEvent e) throws IOException {
        Player p = (Player)e.getEntity();
        Player k = (Player)e.getEntity().getKiller();
        WorldManager wm = new WorldManager();
        e.setDeathMessage(null);
        if(k != null) {
            if(p.getWorld().getName().equalsIgnoreCase(wm.warzone)) {
                Schatzmeister.giveInventorySchatzmeister(k, p.getInventory(), p, e);
                Kopfgeld.giveHead(k, p);
                Erhalt.giveItem(p);
            }
        }
    }

}

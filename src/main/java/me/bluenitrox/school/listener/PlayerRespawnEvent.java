package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.all.Erhalt;
import me.bluenitrox.school.managers.LocationManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

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

    private void erhaltItems(Player p){
        if(Erhalt.items.containsKey(p)){
            for(int i = 0; i< Erhalt.items.size(); i++){
                ItemStack[] itemss = Erhalt.items.get(p.getUniqueId());
                p.getInventory().addItem(itemss);
            }
        }
    }
}

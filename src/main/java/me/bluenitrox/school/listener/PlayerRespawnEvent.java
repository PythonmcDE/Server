package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.LocationManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(final org.bukkit.event.player.PlayerRespawnEvent e){
        Player p = (Player)e.getPlayer();
        new BukkitRunnable(){
            @Override
            public void run() {
                p.teleport(new LocationManager("spawn").getLocation());

            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 15);
    }

}

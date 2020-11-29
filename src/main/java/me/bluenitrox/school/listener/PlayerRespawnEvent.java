package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.LocationManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerRespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(final org.bukkit.event.player.PlayerRespawnEvent e){
        Player p = (Player)e.getPlayer();
        p.teleport(new LocationManager("spawn").getLocation());
    }

}

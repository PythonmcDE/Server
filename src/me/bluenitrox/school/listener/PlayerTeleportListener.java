package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.haendler.NPCAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerTeleportListener implements Listener {

    @EventHandler
    public void onChange(final org.bukkit.event.player.PlayerTeleportEvent e){
        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.PLUGIN) || e.getCause().equals(PlayerTeleportEvent.TeleportCause.COMMAND)){
            NPCAPI.updateNPCs(e.getPlayer());
        }
    }

}

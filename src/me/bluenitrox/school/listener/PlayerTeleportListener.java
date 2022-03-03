package me.bluenitrox.school.listener;

import me.bluenitrox.school.haendler.NPCAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleportListener implements Listener {

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e){
        if(e.getCause()== PlayerTeleportEvent.TeleportCause.COMMAND){
            NPCAPI.updateNPCs(e.getPlayer());
        }
        if(e.getCause()== PlayerTeleportEvent.TeleportCause.PLUGIN){
            NPCAPI.updateNPCs(e.getPlayer());
        }
    }


}

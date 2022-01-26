package me.bluenitrox.school.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityCreatePortalEvent implements Listener {

    @EventHandler
    public void portal(final org.bukkit.event.entity.EntityCreatePortalEvent e){
        e.setCancelled(true);
    }

}

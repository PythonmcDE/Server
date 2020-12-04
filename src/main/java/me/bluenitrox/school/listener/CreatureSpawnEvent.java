package me.bluenitrox.school.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CreatureSpawnEvent implements Listener {

    @EventHandler
    public void onCreatureSpawn(final org.bukkit.event.entity.CreatureSpawnEvent e){
        if(e.getEntity().getType() == EntityType.ENDERMITE){
            e.setCancelled(true);
        }
        if(e.getSpawnReason() != org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason.SPAWNER){
            e.setCancelled(true);
        }
    }

}

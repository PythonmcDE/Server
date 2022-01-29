package me.bluenitrox.school.listener;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.features.StatsAPI;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityDeathEvent implements Listener {

    @EventHandler
    public void onDeath(final org.bukkit.event.entity.EntityDeathEvent e){
        Entity entity = e.getEntity();
        if(e.getEntity().getKiller() != null){
            Player killer = e.getEntity().getKiller();
            StatsAPI api = new StatsAPI();

            api.updateMob(killer.getUniqueId(), 1, false);
        }
        DungeonManager.entityDeathItemAdd(e);
    }

}

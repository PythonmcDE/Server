package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.WorldManager;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ProjectileLaunchEvent implements Listener {

    @EventHandler
    public void onLounch(final org.bukkit.event.entity.ProjectileLaunchEvent e){
        if(e.getEntityType() == EntityType.ARROW){
            return;
        }
        if(e.getEntityType() == EntityType.EGG || e.getEntityType() == EntityType.SNOWBALL){
            e.setCancelled(true);
            return;
        }
        if(e.getEntityType() == EntityType.ENDER_PEARL){
            WorldManager wm = new WorldManager();
            if(!e.getEntity().getWorld().equals(wm.spawn)){
                e.setCancelled(true);
                return;
            }
        }
    }

}

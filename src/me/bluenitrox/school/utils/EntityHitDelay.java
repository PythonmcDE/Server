package me.bluenitrox.school.utils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.HashMap;

public class EntityHitDelay {

    private HashMap<Player, Long> entityhit = new HashMap();
    private HashMap<Player, Entity> actuallentity = new HashMap();

    public void onEntityHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player)event.getDamager();
            if (!getActuallEntity().containsKey(player)) {
                getActuallEntity().put(player, event.getEntity());
            }

            if (getEntityhit().containsKey(player)) {
                if (!getActuallEntity().containsValue(event.getEntity()) && System.currentTimeMillis() - (Long)getEntityhit().get(player) <= 350L) {
                    event.setCancelled(true);
                } else {
                    getActuallEntity().replace(player, event.getEntity());
                    if (!getEntityhit().containsKey(player)) {
                        getEntityhit().put(player, System.currentTimeMillis());
                    } else {
                        getEntityhit().replace(player, System.currentTimeMillis());
                    }
                }
            } else {
                getEntityhit().put(player, System.currentTimeMillis());
            }

        }
    }

    private HashMap<Player, Long> getEntityhit() {
        return entityhit;
    }

    private HashMap<Player, Entity> getActuallEntity() {
        return actuallentity;
    }

}

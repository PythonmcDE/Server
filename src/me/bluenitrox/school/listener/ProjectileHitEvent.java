package me.bluenitrox.school.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashSet;

public class ProjectileHitEvent implements Listener {

    @EventHandler
    public void onHit(org.bukkit.event.entity.ProjectileHitEvent e){
        Player p = (Player) e.getEntity().getShooter();
        if(e.getEntity().getType() == EntityType.SNOWBALL){
            Block block = p.getTargetBlock((HashSet<Byte>) null, 100);
            block.setType(Material.AIR);

        }


    }

}

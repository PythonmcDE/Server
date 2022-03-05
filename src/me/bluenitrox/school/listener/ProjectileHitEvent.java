package me.bluenitrox.school.listener;

import me.bluenitrox.school.commands.Mine;
import me.bluenitrox.school.enchants.pickaxe.Duplizierung;
import me.bluenitrox.school.managers.PlayerBreakBlockManager;
import me.bluenitrox.school.mine.manager.MinenManager;
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
        if(e.getEntity().getType() == EntityType.SNOWBALL){
            Player p = (Player) e.getEntity().getShooter();
            Block block = e.getEntity().getLocation().getBlock();
            int id = block.getTypeId();
            for (double i = 0.2D; i < 4.0D; i += 0.2D) {
                if (id == 0) {
                    block = e.getEntity().getLocation().add(e.getEntity().getVelocity().normalize().multiply(i)).getBlock();
                    id = block.getTypeId();
                }
            }
            if(MinenManager.isAllowedtoMine(p, block.getLocation())) {
                MinenManager.updateMinenMapTrue(block.getLocation(), p, MinenManager.getMineByLocation(block.getLocation()));
                BreakBlockEvent.addItemToInv(p, block, Duplizierung.Dupliauslöser(p)); // Break block & add to inv
            }
        }
    }

}

package me.bluenitrox.school.listener;

import me.bluenitrox.school.utils.Antidupe;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;

public class InventoryOpenEvent implements Listener {

    @EventHandler
    public void onOpen(final org.bukkit.event.inventory.InventoryOpenEvent e){
        if(e.getInventory().getType() == InventoryType.CHEST){
            Antidupe.checkChest(e.getInventory(), (Player) e.getPlayer());
            return;
        }
    }

}

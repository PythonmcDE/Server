package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerDropItemEvent implements Listener {

    @EventHandler
    public void onDrop(final org.bukkit.event.player.PlayerDropItemEvent e){
        if(e.getItemDrop().getItemStack().getItemMeta() != null){
            if(e.getItemDrop().getItemStack().getItemMeta().getLore() != null){
                if(e.getItemDrop().getItemStack().getItemMeta().getLore().contains("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!")){
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(MessageManager.PREFIX + "§7Du kannst dieses Item §cnicht §7wegwerfen.");
                    e.getPlayer().setItemInHand(new ItemBuilder(Material.AIR).build());
                }
            }
        }
    }

}

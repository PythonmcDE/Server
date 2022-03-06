package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerDropItemEvent implements Listener {

    @EventHandler
    public void onDrop(final org.bukkit.event.player.PlayerDropItemEvent e){
        if(e.getItemDrop().getItemStack().getItemMeta() != null){
            if(e.getItemDrop().getItemStack().getItemMeta().getLore() != null){
                if(e.getItemDrop().getItemStack().getItemMeta().getLore().contains("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!")){
                    e.setCancelled(true);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            e.getPlayer().setItemInHand(new ItemBuilder(Material.AIR).build());
                        }
                    }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 2);
                }
            }
        }
    }

}

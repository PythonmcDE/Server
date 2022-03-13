package me.bluenitrox.school.seasonpass.listener;

import me.bluenitrox.school.seasonpass.SeasonpassInventorys;
import me.bluenitrox.school.seasonpass.SeasonpassManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if(event.getClickedInventory() == null) return;
        if(event.getClickedInventory().getName().equalsIgnoreCase("§b» §6Seasonpass §8(§7Season 1§8)")) {
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getItemMeta() == null) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            SeasonpassInventorys inventorys = new SeasonpassInventorys(player);
            if (event.getCurrentItem().getType() == Material.CHEST) {
                player.openInventory(inventorys.itemPage());
            } else if (event.getCurrentItem().getType() == Material.ENDER_CHEST) {
                SeasonpassManager seasonpassManager = new SeasonpassManager();
                if (seasonpassManager.hasGoldPass(player.getUniqueId())) {
                    player.openInventory(inventorys.bonusBank());
                }
            }
        } else if(event.getClickedInventory().getName().equalsIgnoreCase("§b» §6Seasonpass Bonusbank")) {
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getItemMeta() == null) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            event.setCancelled(true);
        }
    }

}

package me.bluenitrox.school.listener;

import me.bluenitrox.school.ah.AhListener;
import me.bluenitrox.school.boost.BoostInv;
import me.bluenitrox.school.commands.Mine;
import me.bluenitrox.school.features.CaseAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener {

    @EventHandler
    public void onClick(final org.bukkit.event.inventory.InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if(CaseAPI.opencase != null) {
            if (CaseAPI.opencase.contains(p)) {
                e.setCancelled(true);
                return;
            }
        }
        caseClick(e);
        AhListener.onClickAuctionhouse(e);
        BoostInv.inventoryClick(e, p);
        Mine.onMinenClick(e);
    }

    private void caseClick(org.bukkit.event.inventory.InventoryClickEvent e){
        if(e.getClickedInventory() == null){
            return;
        }
        if(e.getClickedInventory().getName() == null && e.getCurrentItem() != null){
            return;
        }
        if((e.getClickedInventory().getName().equalsIgnoreCase(CaseAPI.daily)
                || e.getClickedInventory().getName().equalsIgnoreCase(CaseAPI.gewöhnlich)
                || e.getClickedInventory().getName().equalsIgnoreCase(CaseAPI.selten)
                || e.getClickedInventory().getName().equalsIgnoreCase(CaseAPI.episch)
                || e.getClickedInventory().getName().equalsIgnoreCase(CaseAPI.legendär)
                || e.getClickedInventory().getName().equalsIgnoreCase(CaseAPI.mysthische)
                || e.getClickedInventory().getName().equalsIgnoreCase(CaseAPI.tier)) && e.getCurrentItem() != null){
            e.setCancelled(true);
        }else if(e.getClickedInventory().getName().equalsIgnoreCase("§e§lCase Gewinn")){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ") || e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lDein Gewinn")){
                e.setCancelled(true);
            }
        }
    }

}

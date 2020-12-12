package me.bluenitrox.school.listener;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.crafting.Enchanter;
import me.bluenitrox.school.features.CaseAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryCloseEvent implements Listener {

    @EventHandler
    public void onClose(final org.bukkit.event.inventory.InventoryCloseEvent e){
        Player p = (Player)e.getPlayer();
        if(e.getInventory().getName().equalsIgnoreCase("§e§lCase Gewinn")){
            if(e.getInventory().getItem(13) != null){
                if(!CaseAPI.caseöffnen.contains(p)) {
                    p.getInventory().addItem(e.getInventory().getItem(13));
                    TTA_Methods.sendActionBar(p, "§7» §aDeine Items wurden in dein Inventar gelegt.", 20 * 5);
                }
            }
        }
        Enchanter.onInventoryClose(e);
    }

}

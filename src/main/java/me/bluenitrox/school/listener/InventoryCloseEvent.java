package me.bluenitrox.school.listener;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.crafting.Enchanter;
import me.bluenitrox.school.enchants.CraftAPI;
import me.bluenitrox.school.features.CaseAPI;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
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
                    e.getInventory().setItem(13, new ItemBuilder(Material.AIR).build());
                    TTA_Methods.sendActionBar(p, "§7» §aDeine Items wurden in dein Inventar gelegt.", 20 * 5);
                }
            }
        }
        CraftAPI.onClose(e);
        Enchanter.onInventoryClose(e);
    }

}

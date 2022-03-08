package me.bluenitrox.school.listener;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.crafting.Enchanter;
import me.bluenitrox.school.crafting.WerkbankGUIRegister;
import me.bluenitrox.school.enchants.function.CraftAPI;
import me.bluenitrox.school.features.cases.CaseAPI;
import me.bluenitrox.school.haendler.commands.Schmied;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.warzone.chests.ChestsFuctions;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryCloseEvent implements Listener {

    @EventHandler
    public void onClose(final org.bukkit.event.inventory.InventoryCloseEvent e){
        Player p = (Player)e.getPlayer();
        WerkbankGUIRegister gui = new WerkbankGUIRegister();
        ChestsFuctions cf = new ChestsFuctions();
        cf.closeChest(e);
        if(e.getInventory().getName().equalsIgnoreCase("§8» §e§lCase Gewinn")){
            if(e.getInventory().getItem(13) != null){
                if(!CaseAPI.caseöffnen.contains(p)) {
                    p.getInventory().addItem(e.getInventory().getItem(13));
                    e.getInventory().setItem(13, new ItemBuilder(Material.AIR).build());
                    TTA_Methods.sendActionBar(p, "§7» §aDeine Items wurden in dein Inventar gelegt.", 20 * 5);
                }
            }
        }
        gui.onClose(e);
        Schmied.onClose(e);
        CraftAPI.onClose(e);
        Enchanter.onInventoryClose(e);
    }

}

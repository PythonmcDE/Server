package me.bluenitrox.school.plots;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class PlotInventory {

    private UUID uuid;
    public PlotInventory(UUID uuid) {
        this.uuid = uuid;
    }

    public Inventory inventory() {
        Player player = Bukkit.getPlayer(uuid);
        String guiname = "§8» §6§lPlot Einstellungen";
        Inventory inventory = Bukkit.createInventory(null, 9*3, guiname);

        return inventory;
        //remove this
    }
}

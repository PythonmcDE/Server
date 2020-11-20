package me.bluenitrox.school.features;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitAPI {

    private final String guiname = "§f§lKit Menu";

    public void openKitMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6,guiname);

        setKitContent(inv);

        p.openInventory(inv);
    }

    private void setKitContent(Inventory inv){
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();

        /*TODO
            inv.setItem(Slot, Item);
            für jedes item
            Kit Menu bitte genau so machen wie auf euer Screenshot
            ACHTE AUF RECHTSCHREIBUNG UND RICHTIGE BENENNUNG!!
         */
    }

}

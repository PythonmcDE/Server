package me.bluenitrox.school.utils;

import me.bluenitrox.school.crafting.Enchanter;
import me.bluenitrox.school.enchants.CraftAPI;
import me.bluenitrox.school.enchants.Enchant;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class UpdateUtils {

    public static void updateEnchanter(Player all){
        if(all.getOpenInventory().getItem(22).getType() == Material.BOOK){
            all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §aVerzaubere das Item").setLore("§6§l▶ §7Klicke hier um ein Random Buch zu verzaubern,", "§6§l▶ §7dies kostet dich §6" + Enchanter.levelneeded +" Level §7und §615 Tsd §7Gems.").build("isInInv"));
        }else {
            all.getOpenInventory().setItem(25,new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cUngültige Verzauberung").setLore("§8● §7Entweder liegt kein Item auf dem freien Slot,", "§8● §7oder dieses kann nicht verzaubert werden.").build("isInInv"));
        }
        all.updateInventory();
    }

    public static void updateCraft(Player all){
        if (all.getOpenInventory().getItem(CraftAPI.slot1) != null && all.getOpenInventory().getItem(CraftAPI.slot2) != null) {
            if (all.getOpenInventory().getItem(CraftAPI.slot2).getItemMeta() != null) {
                if (all.getOpenInventory().getItem(CraftAPI.slot2).getItemMeta().getLore() != null) {
                    String[] preis = all.getOpenInventory().getItem(CraftAPI.slot2).getItemMeta().getLore().get(0).split(" ");
                    float price = CraftAPI.getPrice(preis[1]);
                    int level = CraftAPI.getLevel(preis[1]);
                    all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §7Item Verzaubern").setLore("§8● §7Kosten:§6§l " + level + " Vanilla Level", "§8● §7Gem-Kosten:§6§l " + price + " Gems").build());
                }
            }
        } else {
            all.getOpenInventory().setItem(25, new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cUngültige Kombination").setLore("§8● §7Diese Verzauberung ist leider nicht möglich.").build());
        }
        all.updateInventory();
    }
}

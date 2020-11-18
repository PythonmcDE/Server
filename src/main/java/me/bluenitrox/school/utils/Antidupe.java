package me.bluenitrox.school.utils;

import me.bluenitrox.school.listener.InventoryCloseEvent;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Antidupe {

    public static int nextItemID;
    public static ArrayList<String> ids = new ArrayList<>();

    public static ItemStack addID(ItemStack i){
        NBTTags nbt = new NBTTags(i);
        nbt.setNBTTag("antidupe", nextItemID + "");
        nextItemID++;
        return i;
    }

    public static void checkInventory(Inventory inv){
        for(int i = 0; i <= 35; i++) {
            if(inv.getItem(i) != null) {
                if (inv.getItem(i).getItemMeta() != null) {
                    NBTTags nbt = new NBTTags(inv.getItem(i));
                    if (nbt.getNBTTag("antidupe") != null) {
                        if (ids.contains(nbt.getNBTTag("antidupe").toString())) {
                            inv.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                    .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                    "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());
                        }
                        ids.add(nbt.getNBTTag("antidupe").toString());
                    }
                }
            }
        }
        ids.clear();
    }

    public static void checkChest(Inventory inv){
        for(int i = 0; i <= 54; i++){
            if(inv.getItem(i) != null){
                if (inv.getItem(i).getItemMeta() != null) {
                    NBTTags nbt = new NBTTags(inv.getItem(i));
                    if (nbt.getNBTTag("antidupe") != null) {
                        if (ids.contains(nbt.getNBTTag("antidupe").toString())) {
                            inv.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                    .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                            "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());
                        }
                        ids.add(nbt.getNBTTag("antidupe").toString());
                    }
                }
            }
        }
    }

}

package me.bluenitrox.school.utils;

import me.bluenitrox.school.listener.InventoryCloseEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Antidupe {

    public static int nextItemID;
    public static ArrayList<Integer> ids;

    public static ItemStack addID(ItemStack i){
        NBTTags nbt = new NBTTags(i);
        nbt.setNBTTag("antidupe", nextItemID + "");
        nextItemID++;
        return i;
    }

    public static void checkInventory(Inventory inv,Player p){
        ids = new ArrayList<>();
        for(int i = 0; i <= 35; i++) {
            if(inv.getItem(i) != null){
                if (inv.getItem(i).getItemMeta() != null) {
                    if(NBTTags.hasTag("antidupe", inv.getItem(i))) {
                        NBTTags nbt = new NBTTags(inv.getItem(i));
                        String[] test = nbt.getNBTTag("antidupe").toString().split("\"");
                        int id = Integer.parseInt(test[1]);
                        if (ids != null) {
                            if (ids.contains(id)) {
                                inv.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                        .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                                "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());
                            }
                        }
                        ids.add(id);
                    }
                }
            }
        }
        ids.clear();
    }

    public static void checkAllInventorys(Inventory inv, Player p){
        for(int i = 0; i < 36; i++) {
            if(inv.getItem(i) != null){
                if (inv.getItem(i).getItemMeta() != null) {
                    if(NBTTags.hasTag("antidupe", inv.getItem(i))) {
                        NBTTags nbt = new NBTTags(inv.getItem(i));
                        String[] test = nbt.getNBTTag("antidupe").toString().split("\"");
                        int id = Integer.parseInt(test[1]);
                        if (ids != null) {
                            if (ids.contains(id)) {
                                inv.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                        .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                                "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());
                            }
                        }
                        ids.add(id);
                    }
                }
            }
        }
    }

    public static void checkChest(Inventory inv, Player p){
        ids = new ArrayList<>();
        for(int i = 0; i <= inv.getSize() - 1; i++){
            if(inv.getItem(i) != null){
                if (inv.getItem(i).getItemMeta() != null) {
                    if(NBTTags.hasTag("antidupe", inv.getItem(i))) {
                        NBTTags nbt = new NBTTags(inv.getItem(i));
                        String[] test = nbt.getNBTTag("antidupe").toString().split("\"");
                        int id = Integer.parseInt(test[1]);
                        if (ids != null) {
                            if (ids.contains(id)) {
                                inv.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                        .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                                "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());
                            }
                        }
                        ids.add(id);
                    }
                }
            }
        }
        Inventory invzwei = p.getInventory();
        for(int i = 0; i < invzwei.getSize() -1; i++) {
            if (invzwei.getItem(i) != null) {
                if (invzwei.getItem(i).getItemMeta() != null) {
                    if (NBTTags.hasTag("antidupe", invzwei.getItem(i))) {
                        NBTTags nbt = new NBTTags(invzwei.getItem(i));
                        String[] test = nbt.getNBTTag("antidupe").toString().split("\"");
                        int id = Integer.parseInt(test[1]);
                        if (ids.contains(id)) {
                            invzwei.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                    .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                            "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());
                        }
                        ids.add(id);
                    }
                }
            }
        }
        ids.clear();
    }
}

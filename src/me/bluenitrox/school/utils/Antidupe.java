package me.bluenitrox.school.utils;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Antidupe {

    public static int nextItemID;
    public static ArrayList<Integer> ids;

    public static ItemStack addID(ItemStack i){
        NBTTags nbt = new NBTTags(i);
        nbt.setNBTTag("antidupe", nextItemID + "");
        ItemMeta itemMeta = i.getItemMeta();
        List<String> strings = itemMeta.getLore();
        if(strings != null) {
            strings.add("DupeID + " + nextItemID);
        }
        itemMeta.setLore(strings);
        i.setItemMeta(itemMeta);
        nextItemID++;
        return i;
    }

    public static void checkInventory(Inventory inv,Player p){
        ids = new ArrayList<>();
        ids.add(1);
        for(int i = 0; i <= 35; i++) {
            if(inv.getItem(i) != null){
                if (inv.getItem(i).getItemMeta() != null) {
                    if(NBTTags.hasTag("antidupe", inv.getItem(i))) {
                        NBTTags nbt = new NBTTags(inv.getItem(i));
                        String[] test = nbt.getNBTTag("antidupe").toString().split("\"");
                        int id = Integer.parseInt(test[1]);
                        if (ids != null) {
                            if (ids.contains(id)) {
                                Bukkit.broadcastMessage("ausgelöste id: §6" + id);
                                /*inv.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                        .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                                "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());*/
                                duperantimation(p);
                                for(Player all : Bukkit.getOnlinePlayers()){
                                    if(all.hasPermission(PermissionsManager.ALLPERMS)){
                                        all.sendMessage(MessageManager.PREFIX + "§7Der Spieler " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + p.getDisplayName() + "§7 wurde gerade als Duplizierer markiert.");
                                    }
                                }
                            }
                        }
                        ids.add(id);
                    }
                }
            }
        }
        ids.clear();
    }

    private static void duperantimation(Player p){
        TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊§7▊▊▊▊▊▊▊▊▊ §a10% loaded", 20, 20, 20);
        for(int i = 0; i <= 9; i++) {
            p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
        }
        new BukkitRunnable(){
            @Override
            public void run() {
                TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊§7▊▊▊▊▊▊▊▊ §a20% loaded", 20, 20, 20);
                for(int i = 0; i <= 9; i++) {
                    p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                }
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊§7▊▊▊▊▊▊▊ §a30% loaded", 20, 20, 20);
                        for(int i = 0; i <= 9; i++) {
                            p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                        }
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊▊§7▊▊▊▊▊▊ §a40% loaded", 20, 20, 20);
                                for(int i = 0; i <= 9; i++) {
                                    p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                                }
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊▊▊§7▊▊▊▊▊ §a50% loaded", 20, 20, 20);
                                        for(int i = 0; i <= 9; i++) {
                                            p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                                        }
                                        new BukkitRunnable(){
                                            @Override
                                            public void run() {
                                                TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊▊▊▊§7▊▊▊▊ §a60% loaded", 20, 20, 20);
                                                for(int i = 0; i <= 9; i++) {
                                                    p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                                                }
                                                new BukkitRunnable(){
                                                    @Override
                                                    public void run() {
                                                        TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊▊▊▊▊§7▊▊▊ §a70% loaded", 20, 20, 20);
                                                        for(int i = 0; i <= 9; i++) {
                                                            p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                                                        }
                                                        new BukkitRunnable(){
                                                            @Override
                                                            public void run() {
                                                                TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊▊▊▊▊▊§7▊▊ §a80% loaded", 20, 20, 20);
                                                                for(int i = 0; i <= 9; i++) {
                                                                    p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                                                                }
                                                                new BukkitRunnable(){
                                                                    @Override
                                                                    public void run() {
                                                                        TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊▊▊▊▊▊§7▊ §a90% loaded", 20, 20, 20);
                                                                        for(int i = 0; i <= 9; i++) {
                                                                            p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                                                                        }
                                                                        new BukkitRunnable(){
                                                                            @Override
                                                                            public void run() {
                                                                                TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊▊▊▊▊▊▊§7▊ §a99% loaded", 20, 20, 20);
                                                                                for(int i = 0; i <= 9; i++) {
                                                                                    p.playSound(p.getLocation(), Sound.GHAST_CHARGE, 1L, 1L);
                                                                                }
                                                                                new BukkitRunnable(){
                                                                                    @Override
                                                                                    public void run() {
                                                                                        TTA_Methods.sendTitle(p, "§4§lDuplizierung erkannt!", 20, 20, 20, "§a▊▊▊▊▊▊▊▊▊▊ §a100% loaded", 20, 20, 20);
                                                                                        for(int i = 0; i <= 9; i++) {
                                                                                            p.playSound(p.getLocation(), Sound.GHAST_SCREAM, 1L, 1L);
                                                                                        }
                                                                                        new BukkitRunnable(){
                                                                                            @Override
                                                                                            public void run() {
                                                                                                if(new LocationManager("duperloc").getLocation() != null) {
                                                                                                    p.teleport(new LocationManager("duperloc").getLocation());
                                                                                                }
                                                                                                p.sendMessage(MessageManager.PREFIX + "§7Du wurdest als §4Duplizierer §7erkannt. Ein §4Admin §7wird sich dein anliegen anschauen. Mit §6/spawn §7kommst du zurück!");
                                                                                            }
                                                                                        }.runTaskLater(SchoolMode.getInstance(), 20*5);
                                                                                    }
                                                                                }.runTaskLater(SchoolMode.getInstance(), 20*2);
                                                                            }
                                                                        }.runTaskLater(SchoolMode.getInstance(), 20*2);
                                                                    }
                                                                }.runTaskLater(SchoolMode.getInstance(), 20*2);
                                                            }
                                                        }.runTaskLater(SchoolMode.getInstance(), 20*2);
                                                    }
                                                }.runTaskLater(SchoolMode.getInstance(), 20*2);
                                            }
                                        }.runTaskLater(SchoolMode.getInstance(), 20*2);
                                    }
                                }.runTaskLater(SchoolMode.getInstance(), 20*2);
                            }
                        }.runTaskLater(SchoolMode.getInstance(), 20*2);
                    }
                }.runTaskLater(SchoolMode.getInstance(), 20*2);
            }
        }.runTaskLater(SchoolMode.getInstance(), 20*2);
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
                                Bukkit.broadcastMessage("ausgelöste id: §6" + id);
                                /*inv.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                        .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                                "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());*/
                                duperantimation(p);
                                for(Player all : Bukkit.getOnlinePlayers()){
                                    if(all.hasPermission(PermissionsManager.ALLPERMS)){
                                        all.sendMessage(MessageManager.PREFIX + "§7Der Spieler " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + p.getDisplayName() + "§7 wurde gerade als Duplizierer markiert.");
                                    }
                                }
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
                                Bukkit.broadcastMessage("ausgelöste id: §6" + id);
                                /*inv.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                        .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                                "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());*/
                                duperantimation(p);
                                for(Player all : Bukkit.getOnlinePlayers()){
                                    if(all.hasPermission(PermissionsManager.ALLPERMS)){
                                        all.sendMessage(MessageManager.PREFIX + "§7Der Spieler " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + p.getDisplayName() + "§7 wurde gerade als Duplizierer markiert.");
                                    }
                                }
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
                            Bukkit.broadcastMessage("ausgelöste id: §6" + id);
                            /*invzwei.setItem(i, new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§cNetter Versuch zu Duplizieren §4<3")
                                    .setLore("§b» §7Du wurdest nun als §bDuplizierer §7markiert.",
                                            "§b» §7Ein §4Admin §7wird sich dein Anliegen bald genau anschauen.").build());*/
                            duperantimation(p);
                            for(Player all : Bukkit.getOnlinePlayers()){
                                if(all.hasPermission(PermissionsManager.ALLPERMS)){
                                    all.sendMessage(MessageManager.PREFIX + "§7Der Spieler " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + p.getDisplayName() + "§7 wurde gerade als Duplizierer markiert.");
                                }
                            }
                        }
                        ids.add(id);
                    }
                }
            }
        }
        ids.clear();
    }
}

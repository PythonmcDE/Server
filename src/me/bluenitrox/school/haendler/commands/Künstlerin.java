package me.bluenitrox.school.haendler.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class Künstlerin {
    public static String GUI_NAME = "§e§lHändler §8: §7§lKünstlerin";

    public static void onCommand(Player cs) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 15).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack nr1 = new ItemBuilder(Material.WOOL).setDisplayname("§7Weiße Wolle").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack nr2 = new ItemBuilder(Material.STAINED_CLAY).setDisplayname("§7Gebrannter Ton").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack nr3 = new ItemBuilder(Material.GLASS).setDisplayname("§7Glas").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack nr4 = new ItemBuilder(Material.SLIME_BLOCK).setDisplayname("§7Schleimblock").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack nr5 = new ItemBuilder(Material.SPONGE).setDisplayname("§7Schwamm").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack nr6 = new ItemBuilder(Material.INK_SACK, (short) 1).setDisplayname("§7Roter Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr7 = new ItemBuilder(Material.INK_SACK, (short) 2).setDisplayname("§7Kaktusgrün").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr8 = new ItemBuilder(Material.INK_SACK, (short) 5).setDisplayname("§7Violetter Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr9 = new ItemBuilder(Material.INK_SACK, (short) 6).setDisplayname("§7Türkiser Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr10 = new ItemBuilder(Material.INK_SACK, (short) 7).setDisplayname("§7Hellgrauer Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr11 = new ItemBuilder(Material.INK_SACK, (short) 8).setDisplayname("§7Grauer Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr12 = new ItemBuilder(Material.INK_SACK, (short) 9).setDisplayname("§7Rosa Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr13 = new ItemBuilder(Material.INK_SACK, (short) 10).setDisplayname("§7Hellgrüner Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr14 = new ItemBuilder(Material.INK_SACK, (short) 11).setDisplayname("§7Gelber Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr15 = new ItemBuilder(Material.INK_SACK, (short) 14).setDisplayname("§7Oranger Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr16 = new ItemBuilder(Material.INK_SACK, (short) 13).setDisplayname("§7Magenta Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr17 = new ItemBuilder(Material.INK_SACK, (short) 12).setDisplayname("§7Hellblauer Farbstoff").setLore("§8» §7Kaufen:§6 20 Gems").build();
        ItemStack nr18 = new ItemBuilder(Material.INK_SACK).setDisplayname("§7Tintenbeutel").setLore("§8» §7Kaufen:§6 20 Gems").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 9; i<= 36; i++){
            inv.setItem(i, glasblack);
        }
        for(int i = 36; i<=44;i++){
            inv.setItem(i,glas);
        }

        inv.setItem(4,sign);
        inv.setItem(9,nr1);
        inv.setItem(10,nr2);
        inv.setItem(11,nr3);
        inv.setItem(12,nr4);
        inv.setItem(13,nr5);
        inv.setItem(14,nr6);
        inv.setItem(15,nr7);
        inv.setItem(16,nr8);
        inv.setItem(17,nr9);
        inv.setItem(18,nr10);
        inv.setItem(19,nr11);
        inv.setItem(20,nr12);
        inv.setItem(21,nr13);
        inv.setItem(22,nr14);
        inv.setItem(23,nr15);
        inv.setItem(24,nr16);
        inv.setItem(25,nr17);
        inv.setItem(26,nr18);

        p.openInventory(inv);

        return;
    }

}
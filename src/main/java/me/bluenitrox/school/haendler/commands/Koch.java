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


public class Koch {
    public static String GUI_NAME = "§e§lHändler §8: §7§lKoch";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack nr1 = new ItemBuilder(Material.CAKE).setDisplayname("§7Kuchen").setLore("§8» §7Kaufen:§6 250 Gems").build();
        ItemStack nr2 = new ItemBuilder(Material.EGG).setDisplayname("§7Ei").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack nr3 = new ItemBuilder(Material.GRILLED_PORK).setDisplayname("§7Gebratenes Schweinefleisch").setLore("§8» §7Kaufen:§6 200 Gems", "§8» §7Verkaufen:§6 40 Gems").build();
        ItemStack nr4 = new ItemBuilder(Material.COOKED_BEEF).setDisplayname("§7Steak").setLore("§8» §7Kaufen:§6 200 Gems", "§8» §7Verkaufen:§6 40 Gems").build();
        ItemStack nr5 = new ItemBuilder(Material.COOKED_MUTTON).setDisplayname("§7Gebratenes Hammelfleisch").setLore("§8» §7Kaufen:§6 200 Gems", "§8» §7Verkaufen:§6 40 Gems").build();
        ItemStack nr6 = new ItemBuilder(Material.COOKED_CHICKEN).setDisplayname("§7Gebratenes Hühnchen").setLore("§8» §7Kaufen:§6 200 Gems", "§8» §7Verkaufen:§6 40 Gems").build();
        ItemStack nr7 = new ItemBuilder(Material.COOKED_RABBIT).setDisplayname("§7Gebratenes Kaninchen").setLore("§8» §7Kaufen:§6 200 Gems", "§8» §7Verkaufen:§6 40 Gems").build();
        ItemStack nr8 = new ItemBuilder(Material.APPLE).setDisplayname("§7Apfel").setLore("§8» §7Kaufen:§6 40 Gems").build();
        ItemStack nr9 = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldener Apfel").setLore("§8» §7Kaufen:§6 4000 Gems", "§8» §7Verkaufen:§6 800 Gems").build();
        ItemStack nr10 = new ItemBuilder(Material.PORK).setDisplayname("§7Rohes Schweinefleisch").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack nr11 = new ItemBuilder(Material.RAW_BEEF).setDisplayname("§7Rohes Rindfleisch").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack nr12 = new ItemBuilder(Material.MUTTON).setDisplayname("§7Rohes Hammelfleisch").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack nr13 = new ItemBuilder(Material.RABBIT).setDisplayname("§7Rohes Kaninchen").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack nr14 = new ItemBuilder(Material.RAW_CHICKEN).setDisplayname("§7Rohes Hühnchen").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
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

        p.openInventory(inv);

        return;
    }

}
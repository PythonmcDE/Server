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


public class Landwirt {
    public static String GUI_NAME = "§e§lHändler §8: §7§lLandwirt";

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

        ItemStack nr1 = new ItemBuilder(Material.MELON).setDisplayname("§7Melone").setLore("§8» §7Kaufen:§6 80 Gems").build();
        ItemStack nr2 = new ItemBuilder(Material.POTATO_ITEM).setDisplayname("§7Kartoffel").setLore("§8» §7Kaufen:§6 80 Gems", "§8» §7Verkaufen:§6 16 Gems" ).build();
        ItemStack nr3 = new ItemBuilder(Material.CARROT_ITEM).setDisplayname("§7Karotte").setLore("§8» §7Kaufen:§6 80 Gems", "§8» §7Verkaufen:§6 16 Gems" ).build();
        ItemStack nr4 = new ItemBuilder(Material.PUMPKIN_SEEDS).setDisplayname("§7Kürbiskern").setLore("§8» §7Kaufen:§6 40 Gems", "§8» §7Verkaufen:§6 8 Gems" ).build();
        ItemStack nr5 = new ItemBuilder(Material.MELON_SEEDS).setDisplayname("§7Melonenkern").setLore("§8» §7Kaufen:§6 40 Gems", "§8» §7Verkaufen:§6 8 Gems" ).build();
        ItemStack nr6 = new ItemBuilder(Material.SEEDS).setDisplayname("§7Weizenkern").setLore("§8» §7Kaufen:§6 40 Gems", "§8» §7Verkaufen:§6 8 Gems" ).build();
        ItemStack nr7 = new ItemBuilder(Material.INK_SACK, (short) 3).setDisplayname("§7Kakaokern").setLore("§8» §7Kaufen:§6 40 Gems", "§8» §7Verkaufen:§6 8 Gems" ).build();
        ItemStack nr8 = new ItemBuilder(Material.WHEAT).setDisplayname("§7Weizen").setLore("§8» §7Kaufen:§6 200 Gems", "§8» §7Verkaufen:§6 40 Gems" ).build();
        ItemStack nr9 = new ItemBuilder(Material.SUGAR_CANE).setDisplayname("§7Zuckerrohr").setLore("§8» §7Kaufen:§6 200 Gems", "§8» §7Verkaufen:§6 40 Gems" ).build();
        ItemStack nr10 = new ItemBuilder(Material.GRASS).setDisplayname("§7Grasblock").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack nr11 = new ItemBuilder(Material.DIRT, (short) 2).setDisplayname("§7Podsol").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack nr12 = new ItemBuilder(Material.MYCEL).setDisplayname("§7Myzel").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack nr13 = new ItemBuilder(Material.DIRT, (short) 1).setDisplayname("§7Grobe Erde").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack nr14 = new ItemBuilder(Material.DIRT).setDisplayname("§7Erde").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack nr15 = new ItemBuilder(Material.CACTUS).setDisplayname("§7Kaktus").setLore("§8» §7Kaufen:§6 1000 Gems", "§8» §7Verkaufen:§6 200 Gems").build();
        ItemStack nr16 = new ItemBuilder(Material.MELON_BLOCK).setDisplayname("§7Melonenblock").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 600 Gems").build();
        ItemStack nr17 = new ItemBuilder(Material.PUMPKIN).setDisplayname("§7Kürbis").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 600 Gems").build();

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

        p.openInventory(inv);

        return;
    }

}
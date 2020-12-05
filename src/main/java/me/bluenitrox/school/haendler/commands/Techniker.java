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


public class Techniker {

    public static String GUI_NAME = "§e§lHändler §8: §7§lTechniker";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack nr1 = new ItemBuilder(Material.REDSTONE).setDisplayname("§7Redstone").setLore("§8» §7Kaufen:§6 1750 Gems", "§8» §7Verkaufen:§6 350 Gems").build();
        ItemStack nr2 = new ItemBuilder(Material.DISPENSER).setDisplayname("§7Werfer").setLore("§8» §7Kaufen:§6 1000 Gems").build();
        ItemStack nr3 = new ItemBuilder(Material.PISTON_BASE).setDisplayname("§7Kolben").setLore("§8» §7Kaufen:§6 1000 Gems").build();
        ItemStack nr4 = new ItemBuilder(Material.DROPPER).setDisplayname("§7Spender").setLore("§8» §7Kaufen:§6 1500 Gems").build();
        ItemStack nr5 = new ItemBuilder(Material.PISTON_STICKY_BASE).setDisplayname("§7Klebriger Kolben").setLore("§8» §7Kaufen:§6 1500 Gems").build();
        ItemStack nr6 = new ItemBuilder(Material.REDSTONE_TORCH_ON).setDisplayname("§7Redstone-Fackel").setLore("§8» §7Kaufen:§6 500 Gems").build();
        ItemStack nr7 = new ItemBuilder(Material.REDSTONE_LAMP_OFF).setDisplayname("§7Redstone-Lampe").setLore("§8» §7Kaufen:§6 1500 Gems").build();
        ItemStack nr8 = new ItemBuilder(Material.DAYLIGHT_DETECTOR).setDisplayname("§7Tageslichtsensor").setLore("§8» §7Kaufen:§6 1500 Gems").build();
        ItemStack nr9 = new ItemBuilder(Material.HOPPER).setDisplayname("§7Trichter").setLore("§8» §7Kaufen:§6 2500 Gems").build();
        ItemStack nr10 = new ItemBuilder(Material.DIODE).setDisplayname("§7Redstone-Verstärker").setLore("§8» §7Kaufen:§6 1000 Gems").build();
        ItemStack nr11 = new ItemBuilder(Material.REDSTONE_COMPARATOR).setDisplayname("§7Redstone-Komperator").setLore("§8» §7Kaufen:§6 1000 Gems").build();
        ItemStack nr12 = new ItemBuilder(Material.POWERED_RAIL).setDisplayname("§7Antriebsschiene").setLore("§8» §7Kaufen:§6 2000 Gems").build();
        ItemStack nr13 = new ItemBuilder(Material.DETECTOR_RAIL).setDisplayname("§7Sensorschiene").setLore("§8» §7Kaufen:§6 2000 Gems").build();
        ItemStack nr14 = new ItemBuilder(Material.RAILS).setDisplayname("§7Schiene").setLore("§8» §7Kaufen:§6 2000 Gems").build();
        ItemStack nr15 = new ItemBuilder(Material.ACTIVATOR_RAIL).setDisplayname("§7Aktivierungsschiene").setLore("§8» §7Kaufen:§6 2000 Gems").build();
        ItemStack nr16 = new ItemBuilder(Material.MINECART).setDisplayname("§7Lore").setLore("§8» §7Kaufen:§6 3000 Gems").build();
        ItemStack nr17 = new ItemBuilder(Material.STORAGE_MINECART).setDisplayname("§7Güterlore").setLore("§8» §7Kaufen:§6 4000 Gems").build();
        ItemStack nr18 = new ItemBuilder(Material.TRIPWIRE_HOOK).setDisplayname("§7Haken").setLore("§8» §7Kaufen:§6 800 Gems").build();
        ItemStack nr19 = new ItemBuilder(Material.WOOD_PLATE).setDisplayname("§7Holzdruckplatte").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack nr20 = new ItemBuilder(Material.STONE_PLATE).setDisplayname("§7Steindruckplatte").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack nr21 = new ItemBuilder(Material.GOLD_PLATE).setDisplayname("§7Steindruckplatte").setLore("§8» §7Kaufen:§6 2000 Gems").build();
        ItemStack nr22 = new ItemBuilder(Material.IRON_PLATE).setDisplayname("§7Eisendruckplatte").setLore("§8» §7Kaufen:§6 4000 Gems").build();
        ItemStack nr23 = new ItemBuilder(Material.TRAP_DOOR).setDisplayname("§7Holzfalltür").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack nr24 = new ItemBuilder(Material.IRON_TRAPDOOR).setDisplayname("§7Eisenfalltür").setLore("§8» §7Kaufen:§6 2000 Gems").build();


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
        inv.setItem(23,nr15);
        inv.setItem(24,nr16);
        inv.setItem(25,nr17);
        inv.setItem(26,nr18);
        inv.setItem(27,nr19);
        inv.setItem(28,nr20);
        inv.setItem(29,nr21);
        inv.setItem(30,nr22);
        inv.setItem(31,nr23);
        inv.setItem(32,nr24);

        p.openInventory(inv);

        return;
    }

}
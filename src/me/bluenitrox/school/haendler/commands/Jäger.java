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


public class Jäger {
    public static String GUI_NAME = "§e§lHändler §8: §7§lJäger";

    public static void onInteract(Player cs) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack nr1 = new ItemBuilder(Material.RABBIT_FOOT).setDisplayname("§7Hasenpfote").setLore("§8» §7Kaufen:§6 600 Gems", "§8» §7Verkaufen:§6 100 Gems").build();
        ItemStack nr2 = new ItemBuilder(Material.RABBIT_HIDE).setDisplayname("§7Kaninchenfell").setLore("§8» §7Kaufen:§6 600 Gems", "§8» §7Verkaufen:§6 100 Gems").build();
        ItemStack nr3 = new ItemBuilder(Material.FEATHER).setDisplayname("§7Feder").setLore("§8» §7Kaufen:§6 1200 Gems", "§8» §7Verkaufen:§6 200 Gems").build();
        ItemStack nr4 = new ItemBuilder(Material.LEATHER).setDisplayname("§7Leder").setLore("§8» §7Kaufen:§6 1200 Gems", "§8» §7Verkaufen:§6 200 Gems").build();
        ItemStack nr5 = new ItemBuilder(Material.STRING).setDisplayname("§7Faden").setLore("§8» §7Kaufen:§6 1500 Gems", "§8» §7Verkaufen:§6 250 Gems").build();
        ItemStack nr6 = new ItemBuilder(Material.SPIDER_EYE).setDisplayname("§7Spinnenauge").setLore("§8» §7Kaufen:§6 1500 Gems", "§8» §7Verkaufen:§6 250 Gems").build();
        ItemStack nr7 = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§7Verrottetes Fleisch").setLore("§8» §7Kaufen:§6 1800 Gems", "§8» §7Verkaufen:§6 300 Gems").build();
        ItemStack nr8 = new ItemBuilder(Material.BONE).setDisplayname("§7Knochen").setLore("§8» §7Kaufen:§6 1800 Gems", "§8» §7Verkaufen:§6 300 Gems").build();
        ItemStack nr9 = new ItemBuilder(Material.ARROW).setDisplayname("§7Pfeil").setLore("§8» §7Kaufen:§6 5000 Gems", "§8» §7Verkaufen:§6 50 Gems").build();
        ItemStack nr10 = new ItemBuilder(Material.PRISMARINE_SHARD).setDisplayname("§7Prismarinscherbe").setLore("§8» §7Kaufen:§6 1800 Gems", "§8» §7Verkaufen:§6 300 Gems").build();
        ItemStack nr11 = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§7Prismarinkristalle").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 500 Gems").build();
        ItemStack nr12 = new ItemBuilder(Material.BLAZE_ROD).setDisplayname("§7Lohenrute").setLore("§8» §7Kaufen:§6 4800 Gems", "§8» §7Verkaufen:§6 800 Gems").build();
        ItemStack nr13 = new ItemBuilder(Material.SULPHUR).setDisplayname("§7Schwarzpulver").setLore("§8» §7Kaufen:§6 6000 Gems", "§8» §7Verkaufen:§6 1200 Gems").build();
        ItemStack nr14 = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperle").setLore("§8» §7Kaufen:§6 10000 Gems", "§8» §7Verkaufen:§6 2000 Gems").build();
        ItemStack nr15 = new ItemBuilder(Material.GHAST_TEAR).setDisplayname("§7Ghastträne").setLore("§8» §7Kaufen:§6 3000 Gems").build();
        ItemStack nr16 = new ItemBuilder(Material.WEB).setDisplayname("§7Spinnennetz").setLore("§8» §7Kaufen:§6 3000 Gems").build();

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

        p.openInventory(inv);

        return;
    }

}

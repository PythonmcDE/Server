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


public class Magier {
    public static String GUI_NAME = "§1§lMagier";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack nr1 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Schweine Spawner").setLore("§8» §7Kaufen:§6 50000 Gems","§7Drops:","§8● §b1-3 Vanilla XP, 1 School XP","§8● §bRohes Schweinefleisch").build();
        ItemStack nr2 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Kaninchen Spawner").setLore("§8» §7Kaufen:§6 75000 Gems","§7Drops:","§8● §b1-3 Vanilla XP, 1 School XP","§8● §bKaninchenfell, Rohes Kaaninchen, Hasenpfote").build();
        ItemStack nr3 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Hühnchen Spawner").setLore("§8» §7Kaufen:§6 100000 Gems","§7Drops:","§8● §b1-3 Vanilla XP, 1 School XP","§8● §bFeder, Rohes Hühnchenfleisch").build();
        ItemStack nr4 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Schaf Spawner").setLore("§8» §7Kaufen:§6 200000 Gems","§7Drops:","§8● §b1-3 Vanilla XP, 1 School XP","§8● §bWeiße Wolle, Rohes Hammelfleisch").build();
        ItemStack nr5 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Kuh Spawner").setLore("§8» §7Kaufen:§6 300000 Gems","§7Drops:","§8● §b1-3 Vanilla XP, 1 School XP","§8● §bLeder, Rohes Rindfleisch").build();
        ItemStack nr6 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Spinnen Spawner").setLore("§8» §7Kaufen:§6 400000 Gems","§7Drops:","§8● §b5 Vanilla XP, 3 School XP","§8● §bSpinnenauge, Faden").build();
        ItemStack nr7 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Zombie Spawner").setLore("§8» §7Kaufen:§6 500000 Gems","§7Drops:","§8● §b5 Vanilla XP, 3 School XP","§8● §bVerrottetes Fleisch").build();
        ItemStack nr8 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Hexen Spawner").setLore("§8» §7Kaufen:§6 600000 Gems","§7Drops:","§8● §b5 Vanilla XP, 3 School XP","§8● §bSpinnenauge, Glowstone, Schwarzpulver, Heiltrank","§8● §bZucker, Redstone, Glasflaschen, Feuerresistenztrank").build();
        ItemStack nr9 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Skelett Spawner").setLore("§8» §7Kaufen:§6 700000 Gems","§7Drops:","§8● §b5-8 Vanilla XP, 3 School XP","§8● §bKnochen, Pfeile").build();
        ItemStack nr10 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Eisengolem Spawner").setLore("§8» §7Kaufen:§6 800000 Gems","§7Drops:","§8● §b10 School XP","§8● §bRosen, Eisen").build();
        ItemStack nr11 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Wächter Spawner").setLore("§8» §7Kaufen:§6 900000 Gems","§7Drops:","§8● §b10 Vanilla XP, 5 School XP","§8● §bPrismarin Kristalle/Scherben, Fische").build();
        ItemStack nr12 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Blaze Spawner").setLore("§8» §7Kaufen:§6 1000000 Gems","§7Drops:","§8● §b10 Vanilla XP, 5 School XP","§8● §bLohenruten").build();
        ItemStack nr13 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Creeper Spawner").setLore("§8» §7Kaufen:§6 1500000 Mio Gems","§7Drops:","§8● §b5 Vanilla XP, 5 School XP","§8● §bSchwarzpulver").build();
        ItemStack nr14 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Enderman Spawner").setLore("§8» §7Kaufen:§6 2000000 Gems","§7Drops:","§8● §b5 Vanilla XP, 10 School XP","§8● §bEnderperlen").build();
        ItemStack nr15 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§8» §6Zombie-Pigman Spawner").setLore("§8» §7Kaufen:§6 12000000 Gems","§7Drops:","§8● §b20 Vanilla XP, 10 School XP","§8● §bVerrotetes Fleisch, Goldnuggets, GOldbarren").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 36; i<=45;i++){
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

        p.openInventory(inv);

        return;
    }

}
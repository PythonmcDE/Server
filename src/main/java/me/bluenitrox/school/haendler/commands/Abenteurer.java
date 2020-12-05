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

public class Abenteurer {
    public static String GUI_NAME = "§e§lHändler §8: §7§lAbenteurer";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack netherrack = new ItemBuilder(Material.NETHERRACK).setDisplayname("§7Netherstein").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack netherziegel = new ItemBuilder(Material.NETHER_BRICK).setDisplayname("§7Netherziegel").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack seelensand = new ItemBuilder(Material.SOUL_SAND).setDisplayname("§7Seelensand").setLore("§8» §7Kaufen:§6 1000 Gems").build();
        ItemStack glowdust = new ItemBuilder(Material.GLOWSTONE_DUST).setDisplayname("§7Glowstonestaub").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack netherwart = new ItemBuilder(Material.NETHER_STALK).setDisplayname("§7Netherwarze").setLore("§8» §7Kaufen:§6 1000 Gems", "§8» §7Verkaufen:§6 200 Gems").build();
        ItemStack quarz = new ItemBuilder(Material.QUARTZ).setDisplayname("§7Netherquarz").setLore("§8» §7Kaufen:§6 1100 Gems", "§8» §7Verkaufen:§6 220 Gems").build();
        ItemStack lava = new ItemBuilder(Material.LAVA_BUCKET).setDisplayname("§7Lava Eimer").setLore("§8» §7Kaufen:§6 1000 Gems").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 36; i<=44;i++){
            inv.setItem(i,glas);
        }

        inv.setItem(4,sign);
        inv.setItem(9,netherrack);
        inv.setItem(10,netherziegel);
        inv.setItem(11,seelensand);
        inv.setItem(12,glowdust);
        inv.setItem(13,netherwart);
        inv.setItem(14,quarz);
        inv.setItem(15,lava);

        p.openInventory(inv);

        return;
    }

}

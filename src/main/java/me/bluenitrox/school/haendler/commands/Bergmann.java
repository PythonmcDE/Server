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

public class Bergmann {
    public static String GUI_NAME = "§e§lHändler §8: §7§lBergmann";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack stein = new ItemBuilder(Material.STONE).setDisplayname("§7Stein").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack feuerstein = new ItemBuilder(Material.FLINT).setDisplayname("§7Feuerstein").setLore("§8» §7Kaufen:§6 600 Gems", "§8» §7Verkaufen:§6 120 Gems").build();
        ItemStack kohle = new ItemBuilder(Material.COAL).setDisplayname("§7Kohle").setLore("§8» §7Kaufen:§6 400 Gems", "§8» §7Verkaufen:§6 80 Gems").build();
        ItemStack holzkohle = new ItemBuilder(Material.COAL, (short)1).setDisplayname("§7Holzkohle").setLore("§8» §7Kaufen:§6 400 Gems", "§8» §7Verkaufen:§6 80 Gems").build();
        ItemStack eisenbarren = new ItemBuilder(Material.IRON_INGOT).setDisplayname("§7Eisenbarren").setLore("§8» §7Kaufen:§6 800 Gems", "§8» §7Verkaufen:§6 160 Gems").build();
        ItemStack lapislazuli = new ItemBuilder(Material.INK_SACK).setDisplayname("§7Lapislazuli").setLore("§8» §7Kaufen:§6 1400 Gems", "§8» §7Verkaufen:§6 280 Gems").build();
        ItemStack goldbarren = new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§7Goldbarren").setLore("§8» §7Kaufen:§6 2500 Gems", "§8» §7Verkaufen:§6 500 Gems").build();
        ItemStack diamant = new ItemBuilder(Material.DIAMOND).setDisplayname("§7Diamant").setLore("§8» §7Kaufen:§6 4000 Gems", "§8» §7Verkaufen:§6 800 Gems").build();
        ItemStack smaragd = new ItemBuilder(Material.EMERALD).setDisplayname("§7Smaragd").setLore("§8» §7Kaufen:§6 6000 Gems", "§8» §7Verkaufen:§6 1200 Gems").build();
        ItemStack kohleerz = new ItemBuilder(Material.COAL_ORE).setDisplayname("§7Kohleerz §8(§6Dekoration§8)").setLore("§8» §7Kaufen:§6 400 Gems","§8» §7Dieser Block dient nur als Dekoration und kann","§8» §7nicht zum Erlangen von Resourcen verwendet werden.").build();
        ItemStack eisenerz = new ItemBuilder(Material.IRON_ORE).setDisplayname("§7Eisenerz §8(§6Dekoration§8)").setLore("§8» §7Kaufen:§6 400 Gems","§8» §7Dieser Block dient nur als Dekoration und kann","§8» §7nicht zum Erlangen von Resourcen verwendet werden.").build();
        ItemStack quarzerz = new ItemBuilder(Material.QUARTZ_ORE).setDisplayname("§7Quarzerz §8(§6Dekoration§8)").setLore("§8» §7Kaufen:§6 400 Gems","§8» §7Dieser Block dient nur als Dekoration und kann","§8» §7nicht zum Erlangen von Resourcen verwendet werden.").build();
        ItemStack lapiszerz = new ItemBuilder(Material.LAPIS_ORE).setDisplayname("§7Lapiserz §8(§6Dekoration§8)").setLore("§8» §7Kaufen:§6 800 Gems","§8» §7Dieser Block dient nur als Dekoration und kann","§8» §7nicht zum Erlangen von Resourcen verwendet werden.").build();
        ItemStack redstoneerz = new ItemBuilder(Material.REDSTONE_ORE).setDisplayname("§7Redstone-Erz §8(§6Dekoration§8)").setLore("§8» §7Kaufen:§6 1400 Gems","§8» §7Dieser Block dient nur als Dekoration und kann","§8» §7nicht zum Erlangen von Resourcen verwendet werden.").build();
        ItemStack golderz = new ItemBuilder(Material.GOLD_ORE).setDisplayname("§7Golderz §8(§6Dekoration§8)").setLore("§8» §7Kaufen:§6 2500 Gems","§8» §7Dieser Block dient nur als Dekoration und kann","§8» §7nicht zum Erlangen von Resourcen verwendet werden.").build();
        ItemStack diamonderz = new ItemBuilder(Material.DIAMOND_ORE).setDisplayname("§7Diamanterz §8(§6Dekoration§8)").setLore("§8» §7Kaufen:§6 4000 Gems","§8» §7Dieser Block dient nur als Dekoration und kann","§8» §7nicht zum Erlangen von Resourcen verwendet werden.").build();
        ItemStack smaragderz = new ItemBuilder(Material.EMERALD_ORE).setDisplayname("§7Smaragderz §8(§6Dekoration§8)").setLore("§8» §7Kaufen:§6 6000 Gems","§8» §7Dieser Block dient nur als Dekoration und kann","§8» §7nicht zum Erlangen von Resourcen verwendet werden.").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 36; i<=44;i++){
            inv.setItem(i,glas);
        }

        inv.setItem(4,sign);
        inv.setItem(9,stein);
        inv.setItem(10,feuerstein);
        inv.setItem(11,kohle);
        inv.setItem(12,holzkohle);
        inv.setItem(13,eisenbarren);
        inv.setItem(14,lapislazuli);
        inv.setItem(15,goldbarren);
        inv.setItem(16,diamant);
        inv.setItem(17,smaragd);
        inv.setItem(18,kohleerz);
        inv.setItem(19,eisenerz);
        inv.setItem(20,quarzerz);
        inv.setItem(21,lapiszerz);
        inv.setItem(22,redstoneerz);
        inv.setItem(23,golderz);
        inv.setItem(24,diamonderz);
        inv.setItem(25,smaragderz);


        p.openInventory(inv);

        return;
    }

}
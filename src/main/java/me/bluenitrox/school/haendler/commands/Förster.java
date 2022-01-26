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

public class Förster {
    public static String GUI_NAME = "§e§lHändler §8: §7§lFörster";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack eichenholz = new ItemBuilder(Material.WOOD).setDisplayname("§7Eichenholzbretter").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack fichtenholz = new ItemBuilder(Material.WOOD,(short)1).setDisplayname("§7Fichtenholzbretter").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack birkenholz = new ItemBuilder(Material.WOOD,(short)2).setDisplayname("§7Birkenholzbretter").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack tropenholz = new ItemBuilder(Material.WOOD,(short)3).setDisplayname("§7Tropenholzbretter").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack akazienholz = new ItemBuilder(Material.WOOD,(short)4).setDisplayname("§7Akazienholzbretter").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack schwarzeichenholz = new ItemBuilder(Material.WOOD,(short)5).setDisplayname("§7Schwarzeichenholzbretter").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack eiche = new ItemBuilder(Material.LOG).setDisplayname("§7Eichenholz").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 600 Gems").build();
        ItemStack fichte = new ItemBuilder(Material.LOG, (short) 1).setDisplayname("§7Fichtenholz").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 600 Gems").build();
        ItemStack birke = new ItemBuilder(Material.LOG, (short) 2).setDisplayname("§7Birkenholz").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 600 Gems").build();
        ItemStack trope = new ItemBuilder(Material.LOG, (short) 3).setDisplayname("§7Tropenholz").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 600 Gems").build();
        ItemStack akazie = new ItemBuilder(Material.LOG_2).setDisplayname("§7Akazienholz").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 600 Gems").build();
        ItemStack schwarzeiche = new ItemBuilder(Material.LOG_2).setDisplayname("§7Schwarzeichenholz").setLore("§8» §7Kaufen:§6 3000 Gems", "§8» §7Verkaufen:§6 600 Gems").build();


        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 36; i<=44;i++){
            inv.setItem(i,glas);
        }

        inv.setItem(4,sign);
        inv.setItem(9,eichenholz);
        inv.setItem(10,fichtenholz);
        inv.setItem(11,birkenholz);
        inv.setItem(12,tropenholz);
        inv.setItem(13,akazienholz);
        inv.setItem(14,schwarzeichenholz);
        inv.setItem(15,eiche);
        inv.setItem(16,fichte);
        inv.setItem(17,birke);
        inv.setItem(18,trope);
        inv.setItem(19,akazie);
        inv.setItem(20,schwarzeiche);


        p.openInventory(inv);

        return;
    }

}
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


public class Bauarbeiter {
    public static String GUI_NAME = "§e§lHändler §8: §7§lBauarbeiter";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lHändler").setLore("§6§l▶ §7Bei §9§lHändlern §7kannst du bestimmt", "§6§l▶ Items §aerwerben §7oder auch §averkaufen§7.").build();

        ItemStack water = new ItemBuilder(Material.WATER_BUCKET).setDisplayname("§7Wassereimer").setLore("§8» §7Kaufen:§6 1000 Gems").build();
        ItemStack leine = new ItemBuilder(Material.LEASH).setDisplayname("§7Leine").setLore("§8» §7Kaufen:§6 1000 Gems").build();
        ItemStack trichter = new ItemBuilder(Material.CAULDRON_ITEM).setDisplayname("§7Kessel").setLore("§8» §7Kaufen:§6 3000 Gems").build();
        ItemStack amboss = new ItemBuilder(Material.ANVIL).setDisplayname("§7Amboss").setLore("§8» §7Kaufen:§6 8000 Gems").build();
        ItemStack enchanter = new ItemBuilder(Material.ENCHANTMENT_TABLE).setDisplayname("§7Zaubertisch").setLore("§8» §7Kaufen:§6 8000 Gems").build();
        ItemStack braustahnd = new ItemBuilder(Material.BREWING_STAND_ITEM).setDisplayname("§7Braustand").setLore("§8» §7Kaufen:§6 8000 Gems").build();
        ItemStack sand = new ItemBuilder(Material.SAND).setDisplayname("§7Sand").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack redsand = new ItemBuilder(Material.SAND,(short)1).setDisplayname("§7Roter Sand").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack kies = new ItemBuilder(Material.GRAVEL).setDisplayname("§7Kies").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack bruchstein = new ItemBuilder(Material.COBBLESTONE).setDisplayname("§7Bruchstein").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack andesit = new ItemBuilder(Material.STONE, (short)5).setDisplayname("§7Andesit").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack diorit = new ItemBuilder(Material.STONE, (short)3).setDisplayname("§7Diorit").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack granit = new ItemBuilder(Material.STONE, (short)1).setDisplayname("§7Granit").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack ziegelstein = new ItemBuilder(Material.BRICK).setDisplayname("§7Ziegelstein").setLore("§8» §7Kaufen:§6 100 Gems", "§8» §7Verkaufen:§6 20 Gems").build();
        ItemStack obsidian = new ItemBuilder(Material.OBSIDIAN).setDisplayname("§7Obsidian").setLore("§8» §7Kaufen:§6 1000 Gems").build();
        ItemStack ton = new ItemBuilder(Material.CLAY).setDisplayname("§7Ton").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack endstone = new ItemBuilder(Material.ENDER_STONE).setDisplayname("§7Endstein").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack prismarin = new ItemBuilder(Material.PRISMARINE).setDisplayname("§7Prismarin").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack prismarinziegel = new ItemBuilder(Material.PRISMARINE, (short)1).setDisplayname("§7Prismarinziegel").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack prismarindunkel = new ItemBuilder(Material.PRISMARINE, (short)2).setDisplayname("§7Dunkler Prismarin").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack schnee = new ItemBuilder(Material.SNOW).setDisplayname("§7Schnee").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack eis = new ItemBuilder(Material.ICE).setDisplayname("§7Eis").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack packeis = new ItemBuilder(Material.PACKED_ICE).setDisplayname("§7Packeis").setLore("§8» §7Kaufen:§6 200 Gems").build();
        ItemStack seelaterne = new ItemBuilder(Material.SEA_LANTERN).setDisplayname("§7Seelaterne").setLore("§8» §7Kaufen:§6 4000 Gems").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 36; i<=44;i++){
            inv.setItem(i,glas);
        }

        inv.setItem(4,sign);
        inv.setItem(9,water);
        inv.setItem(10,leine);
        inv.setItem(11,trichter);
        inv.setItem(12,amboss);
        inv.setItem(13,enchanter);
        inv.setItem(14,braustahnd);
        inv.setItem(15,sand);
        inv.setItem(16,redsand);
        inv.setItem(17,kies);
        inv.setItem(18,bruchstein);
        inv.setItem(19,andesit);
        inv.setItem(20,diorit);
        inv.setItem(21,granit);
        inv.setItem(22,ziegelstein);
        inv.setItem(23,obsidian);
        inv.setItem(24,ton);
        inv.setItem(25,endstone);
        inv.setItem(26,prismarin);
        inv.setItem(27,prismarinziegel);
        inv.setItem(28,prismarindunkel);
        inv.setItem(29,schnee);
        inv.setItem(30,eis);
        inv.setItem(31,packeis);
        inv.setItem(32,seelaterne);

        p.openInventory(inv);

        return;
    }

}
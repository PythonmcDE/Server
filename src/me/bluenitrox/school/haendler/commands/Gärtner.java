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

public class Gärtner {
    public static String GUI_NAME = "§e§lHändler §8: §7§lGärtner";

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

        ItemStack redpilz = new ItemBuilder(Material.RED_MUSHROOM).setDisplayname("§7Roter Pilz").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack braunpilz = new ItemBuilder(Material.BROWN_MUSHROOM).setDisplayname("§7Brauner Pilz").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack orangetulpe = new ItemBuilder(Material.RED_ROSE,(short)5).setDisplayname("§7Orange Tulpe").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack weißetulpe = new ItemBuilder(Material.RED_ROSE,(short)6).setDisplayname("§7Weiße Tulpe").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack rosatulpe = new ItemBuilder(Material.RED_ROSE,(short)7).setDisplayname("§7Rosa Tulpe").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack rotetulpe = new ItemBuilder(Material.RED_ROSE,(short)4).setDisplayname("§7Rote Tulpe").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack mohn = new ItemBuilder(Material.RED_ROSE).setDisplayname("§7Mohn").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack löwenzahn = new ItemBuilder(Material.YELLOW_FLOWER).setDisplayname("§7Löhwenzahn").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack margerite = new ItemBuilder(Material.RED_ROSE, (short) 8).setDisplayname("§7Margerite").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack sternlauch = new ItemBuilder(Material.RED_ROSE, (short) 2).setDisplayname("§7Sternlauch").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack orchidee = new ItemBuilder(Material.RED_ROSE, (short) 1).setDisplayname("§7Blaue Orchidee").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack porzellan = new ItemBuilder(Material.RED_ROSE, (short) 3).setDisplayname("§7Porzellansternchen").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack sunblueme = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§7Sonnenblume").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack flieder = new ItemBuilder(Material.DOUBLE_PLANT, (short) 1).setDisplayname("§7Flieder").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack pfingstrose = new ItemBuilder(Material.DOUBLE_PLANT, (short) 5).setDisplayname("§7Pfingstrose").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack rosenstrauch = new ItemBuilder(Material.DOUBLE_PLANT, (short) 4).setDisplayname("§7Rosenstrauch").setLore("§8» §7Kaufen:§6 50 Gems").build();
        ItemStack deadbush = new ItemBuilder(Material.DEAD_BUSH).setDisplayname("§7Toter Busch").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack schwarzsapling = new ItemBuilder(Material.SAPLING, (short) 5).setDisplayname("§7Schwarzeichensetzling").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack akaziensapling = new ItemBuilder(Material.SAPLING, (short) 4).setDisplayname("§7Akaziensetzling").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack tropensapling = new ItemBuilder(Material.SAPLING, (short) 3).setDisplayname("§7Tropensetzling").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack birkensapling = new ItemBuilder(Material.SAPLING, (short) 2).setDisplayname("§7Birkensetzling").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack fichtensapling = new ItemBuilder(Material.SAPLING, (short) 1).setDisplayname("§7Fichtensetzling").setLore("§8» §7Kaufen:§6 100 Gems").build();
        ItemStack eichensapling = new ItemBuilder(Material.SAPLING).setDisplayname("§7Eichensetzling").setLore("§8» §7Kaufen:§6 100 Gems").build();

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
        inv.setItem(9,redpilz);
        inv.setItem(10,braunpilz);
        inv.setItem(11,orangetulpe);
        inv.setItem(12,weißetulpe);
        inv.setItem(13,rosatulpe);
        inv.setItem(14,rotetulpe);
        inv.setItem(15,mohn);
        inv.setItem(16,löwenzahn);
        inv.setItem(17,margerite);
        inv.setItem(18,sternlauch);
        inv.setItem(19,orchidee);
        inv.setItem(20,porzellan);
        inv.setItem(21,sunblueme);
        inv.setItem(22,flieder);
        inv.setItem(23,pfingstrose);
        inv.setItem(24,rosenstrauch);
        inv.setItem(25,deadbush);
        inv.setItem(26,schwarzsapling);
        inv.setItem(27,akaziensapling);
        inv.setItem(28,tropensapling);
        inv.setItem(29,birkensapling);
        inv.setItem(30,fichtensapling);
        inv.setItem(31,eichensapling);

        p.openInventory(inv);

        return;
    }

}
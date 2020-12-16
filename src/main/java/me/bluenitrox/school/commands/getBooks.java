package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class getBooks implements CommandExecutor {

    private static String guiname = "§6§lBücher";

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] strings) {
        Player p = (Player)cs;
        if(p.hasPermission(PermissionsManager.ALLPERMS)){
            Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

            ItemStack is = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Tank + "I").build();
            ItemStack is1 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Heilzauber + "I").build();
            ItemStack is2 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Magieschild + "I").build();
            ItemStack is3 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Widerstand + "I").build();
            ItemStack is4 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Stacheln + "I").build();
            ItemStack is5 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Überladung + "I").build();
            ItemStack is6 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.ObsidianSchild + "I").build();
            ItemStack is7 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Eis + "I").build();
            ItemStack is8 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Fluch + "I").build();
            ItemStack is9 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Kopfgeld + "I").build();
            ItemStack is10 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Assassine + "I").build();
            ItemStack is11 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Vampir + "I").build();
            ItemStack is12 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Kobra + "I").build();
            ItemStack is13 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Tank + "I").build();
            ItemStack is14 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Energieentzug + "I").build();
            ItemStack is15 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.AntiVenom + "I").build();
            ItemStack is16 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Wilderei + "I").build();
            ItemStack is17 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Jäger + "I").build();
            ItemStack is18 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Entdecker + "I").build();
            ItemStack is19 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.schatzmeister + "I").build();
            ItemStack is20 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Blackout + "I").build();
            ItemStack is21 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Dynamite + "I").build();
            ItemStack is22 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Tod + "I").build();
            ItemStack is23 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Fesseln + "I").build();
            ItemStack is24 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Elektrisiert + "I").build();
            ItemStack is25 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Strahlen + "I").build();
            ItemStack is26 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Feuerwerk + "I").build();
            ItemStack is27 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Rausch + "I").build();
            ItemStack is28 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Zorn + "I").build();
            ItemStack is29 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Laser + "I").build();
            ItemStack is30 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Duplizierung + "I").build();
            ItemStack is31 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Erfahrung + "I").build();
            ItemStack is32 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Großerfang + "I").build();
            ItemStack is33 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Ausgrabung + "I").build();
            ItemStack is34 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Fischerglück + "I").build();
            ItemStack is35 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Goldhaken + "I").build();

            for(int i = 0; i<= 8; i++){
                inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
            }
            for(int i = 45; i<= 53; i++){
                inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
            }

            inv.setItem(9,is9);
            inv.setItem(10,is10);
            inv.setItem(11,is11);
            inv.setItem(12,is12);
            inv.setItem(13,is13);
            inv.setItem(14,is14);
            inv.setItem(15,is15);
            inv.setItem(16,is16);
            inv.setItem(17,is17);
            inv.setItem(18,is18);
            inv.setItem(19,is19);
            inv.setItem(20,is20);
            inv.setItem(21,is21);
            inv.setItem(22,is22);
            inv.setItem(23,is23);
            inv.setItem(24,is24);
            inv.setItem(25,is25);
            inv.setItem(26,is26);
            inv.setItem(27,is27);
            inv.setItem(28,is28);
            inv.setItem(29,is29);
            inv.setItem(30,is30);
            inv.setItem(31,is31);
            inv.setItem(32,is32);
            inv.setItem(33,is33);
            inv.setItem(34,is34);
            inv.setItem(35,is35);
            inv.setItem(35,is9);
            inv.setItem(36,is8);
            inv.setItem(37,is7);
            inv.setItem(38,is6);
            inv.setItem(39,is5);
            inv.setItem(40,is4);
            inv.setItem(41,is3);
            inv.setItem(42,is2);
            inv.setItem(43,is1);
            inv.setItem(44,is);

            p.openInventory(inv);
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }

    public static void onClick(final InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase(guiname) && e.getCurrentItem() != null){
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.ENCHANTED_BOOK){
                e.getWhoClicked().getInventory().addItem(Antidupe.addID(e.getCurrentItem()));
                Player p = (Player)e.getWhoClicked();
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1L, 1L);
            }
        }
    }
}

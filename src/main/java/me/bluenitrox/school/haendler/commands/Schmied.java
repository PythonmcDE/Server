package me.bluenitrox.school.haendler.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Schmied {

    public static String GUI_NAME = "§7§lSchmied";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*3, GUI_NAME);


        ItemStack slime = new ItemBuilder(Material.SLIME_BALL).setDisplayname("§a§lReparieren").setLore("§b» §aJetzt §7Reparieren für 15.000$").build();
        inv.setItem(16, slime);
        ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 15).setDisplayname(" ").build();


        for (int i = 0; i != 9; i++) {
            inv.setItem(i, glass);
        }
        for (int i = 19; i != 27; i++) {
            inv.setItem(i, glass);
        }

        inv.setItem(9, glass);
        inv.setItem(10, glass);
        inv.setItem(11, glass);
        inv.setItem(12, glass);
        inv.setItem(14, glass);
        inv.setItem(15, glass);
        inv.setItem(17, glass);
        inv.setItem(18, glass);

        p.openInventory(inv);

        return;
    }

    public static void onClickSchmied(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory().getName().equals(Schmied.GUI_NAME) && e.getCurrentItem() != null){
            p.updateInventory();
            if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE){
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getType() == Material.SLIME_BALL){
                e.setCancelled(true);
                if(MoneyManager.getMoney(p.getUniqueId()) >= 15000) {
                    if(e.getClickedInventory().getItem(13).getItemMeta().getDisplayName() != null) {

                    }

                    if (e.getClickedInventory().getItem(13) != null) {
                        if (e.getClickedInventory().getItem(13).getDurability() != 0) {

                            MoneyManager.updateMoney(p.getUniqueId(), 15000, true, false);
                            e.getClickedInventory().getItem(13).setDurability((short) 0);


                            p.getInventory().addItem(e.getClickedInventory().getItem(13));

                            ItemStack air = new ItemStack(Material.AIR);
                            e.getClickedInventory().setItem(13, air);

                            p.closeInventory();
                            p.playSound(p.getLocation(), Sound.ANVIL_USE, 1L , 1L);
                        }
                    }
                }
            }
        }
    }

}
